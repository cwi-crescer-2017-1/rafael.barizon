create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin

        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);

        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin

       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;

    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
            
    begin
       defineRateioPremio(pPremio);

       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );

       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  function ultimo_concurso return CONCURSO.IDCONCURSO%type as
    idC CONCURSO.IDCONCURSO%type;
  begin
    select max(IDCONCURSO)
    into idC
    from concurso;
    return idC;
  end;  
  function calc_premio_bruto(idConc in numeric) return APOSTA.VALOR%type as
    valorTotal APOSTA.VALOR%type;
  begin
    select sum(valor)
    into valorTotal
    from APOSTA
    where IDCONCURSO = idConc;
    valorTotal := valorTotal * 0.453;
    return valorTotal;
  end;

  function calc_acumulo(idConc in numeric) return  CONCURSO.PREMIO_SENA%type as
    acumuladoRetorno CONCURSO.PREMIO_SENA%type;
    acumFinalZeroOuCinco CONCURSO.PREMIO_SENA%type;
    acum numeric;
  begin
    select PREMIO_SENA
    into acumuladoRetorno
    from CONCURSO
    where IDCONCURSO = idConc;
    
    select CONCURSO.ACUMULOU
    into acum
    from CONCURSO
    where IDCONCURSO = idConc;
    if(acum = 0) then
      return 0;
    end if;
    -- ADICIONADO ISSO PARA CASO DE FINAIS 0 ou 5 
    -- ID que veio eh do concurso anterior por isso pega e diminui 4 e pega todos os 5 anteriores ao novo concurso final 0, 1, 2, 3, 4 ou 5, 6, 7, 8 ,9 
    if (REMAINDER( (idConc+1), 5 ) = 0) then
    select sum(ACUMULADO_PROXIMO_05) into acumFinalZeroOuCinco from concurso where IDCONCURSO >= idConc-4;
    acumuladoRetorno := acumuladoRetorno + acumFinalZeroOuCinco;
    end if;
    return acumuladoRetorno;
  end;
  
  function gerarDataSorteio(idCAnterior in numeric) return CONCURSO.DATA_SORTEIO%type as
    vDataProx CONCURSO.DATA_SORTEIO%type;
    vDataAnt integer;
  begin
    select (1 + trunc(DATA_SORTEIO) - trunc (DATA_SORTEIO, 'IW')), DATA_SORTEIO
    into vDataAnt, vDataProx
    from CONCURSO
    where IDCONCURSO = idCAnterior;
    if( vDataAnt = 6 ) then
      vDataProx:= vDataProx +4;
    else
      vDataProx:= vDataProx +3;
    end if;
    return vDataProx;
  end;

  procedure geraProximoConcurso as
    vIdUltimoConc CONCURSO.IDCONCURSO%type;
    vPremioBruto APOSTA.VALOR%type;
    vPremio APOSTA.VALOR%type;
    vDataProxSorteio CONCURSO.DATA_SORTEIO%type;
   begin
      vIdUltimoConc := ultimo_concurso;
      vPremioBruto := calc_premio_bruto(vIdUltimoConc);
      vPremio := vPremioBruto + calc_acumulo(vIdUltimoConc);
      vDataProxSorteio := gerarDataSorteio(vIdUltimoConc);
      salvaConcurso((vIdUltimoConc+1), vDataProxSorteio, vPremio);
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  function get_premio(idConc in numeric, tipo in numeric, qtdGanhadores in numeric) return CONCURSO.PREMIO_SENA%TYPE as
    vRetorno CONCURSO.PREMIO_SENA%TYPE;
  begin
    if(tipo = 1) then
      select PREMIO_SENA into vRetorno from CONCURSO where IDCONCURSO = idConc;
    elsif (tipo = 2) then
      select PREMIO_QUINA into vRetorno from CONCURSO where IDCONCURSO = idConc;
    elsif (tipo = 3) then
      select PREMIO_QUADRA into vRetorno from CONCURSO where IDCONCURSO = idConc;
    end if;  
    vRetorno := vRetorno / qtdGanhadores;
    return vRetorno;
  end;

  procedure atualizaAcertadores (pConcurso in integer) as
    cursor c_ganhadores(idConc in number) is
      select idaposta, acertos 
        from (
          select nu.idaposta AS idaposta, count(  case when  nu.numero = co.primeira_dezena
                                        or nu.numero = co.segunda_dezena
                                        or nu.numero = co.terceira_dezena
                                        or nu.numero = co.quarta_dezena
                                        or nu.numero = co.quinta_dezena
                                        or nu.numero = co.sexta_dezena then 1 end) as acertos
          from numero_aposta nu
          join aposta apo on apo.idaposta = nu.idaposta
          join concurso co on co.idconcurso = apo.idconcurso 
          where co.idconcurso = idConc
          group by nu.idaposta
          order by acertos desc) 
        where acertos > 3;
  vIdConcurso CONCURSO.IDCONCURSO%type;
  vGanhadoresSena numeric;
  vGanhadoresQuina numeric;
  vGanhadoresQuadra numeric;
  vPremioSena CONCURSO.PREMIO_SENA%type;
  vPremioQuina CONCURSO.PREMIO_QUINA%type;
  vPremioQuadra CONCURSO.PREMIO_QUADRA%type;
  begin
  vIdConcurso := pConcurso;
  vGanhadoresSena := 0;
  vGanhadoresQuina := 0;
  vGanhadoresQuadra := 0;
  vPremioSena := 0.0;
  vPremioQuina := 0.0;
  vPremioQuadra := 0.0;
  -- SELECIONA TODOS GANHADORES DO CONCURSO DESEJADO
    -- SETAR QUANTIADE DE GANHADORES DE CADA PREMIO
    for ganhador in c_ganhadores(vIdConcurso) loop
      if (ganhador.acertos = 6) then
        vGanhadoresSena := vGanhadoresSena + 1;
      elsif (ganhador.acertos = 5) then
        vGanhadoresQuina := vGanhadoresQuina + 1;
      elsif (ganhador.acertos = 4) then
        vGanhadoresQuadra := vGanhadoresQuadra + 1;
      end if;
    end loop;
    -- SETAR VALORES DE CADA PREMIO INDIVIDUAL
    if (vGanhadoresSena > 0) then
      vPremioSena := get_premio(vIdConcurso, 1 , vGanhadoresSena);
    end if;
     if (vGanhadoresQuina > 0) then
      vPremioQuina := get_premio(vIdConcurso, 2 , vGanhadoresQuina) ;
    end if;
     if (vGanhadoresQuadra > 0) then
      vPremioQuadra := get_premio(vIdConcurso, 3, vGanhadoresQuadra);
    end if;
    
    -- CRIAR APOSTAS PREMIADA
    for ganhador in c_ganhadores(vIdConcurso) loop
      insert into aposta_premiada (IDAPOSTA_PREMIADA, IDAPOSTA, ACERTOS, VALOR)
      values (SQAPOSTA_PREMIADA.NEXTVAL,
              ganhador.IDAPOSTA, 
              ganhador.acertos, 
              CASE 
                WHEN ganhador.acertos = 6 then vPremioSena
                WHEN ganhador.acertos = 5 then vPremioQuina
                WHEN ganhador.acertos = 4 then vPremioQuadra
              END); 
    end loop;
    -- SETA SE ACUMULOU OU NAO
    if(vGanhadoresSena = 0) then
     update concurso set ACUMULOU = 1 where idconcurso = vIdConcurso;
    end if;
  end;

begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;