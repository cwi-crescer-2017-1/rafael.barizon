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

  function calc_acumulo(idConc in numeric) return  APOSTA.VALOR%type as
    acumuladoRetorno APOSTA.VALOR%type;
    acum numeric;
  begin
    select PREMIO_SENA, CONCURSO.ACUMULOU
    into acumuladoRetorno, acum
    from CONCURSO
    where IDCONCURSO = idConc;
    if(acum = 0) then
      return 0;
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

  procedure atualizaAcertadores (pConcurso in integer) as
  begin
  null;
  end;

begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;