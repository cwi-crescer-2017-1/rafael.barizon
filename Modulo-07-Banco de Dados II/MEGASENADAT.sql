
-- function f_cadastrar_concurso (numConcurso, dataSorteio, ValorBrutoPremio)
-- function f_countNumerosAcertados (idAposta) - usa o numero_aposta que contem os numeros apostados
-- procedure insert_ganhador - aposta_premiada (idaposta_premiada, idaposta, acertos, valor)
create or replace package pck_megasena as
  procedure gerarProximoConcurso;
end;

create or replace package body pck_megasena as
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
  
  function premio_tipo(premio_bruto in numeric, tipo_premio in numeric) return CONCURSO.PREMIO_SENA%type as
    valorTotalTipo CONCURSO.PREMIO_SENA%type;
  begin
    if (tipo_premio = 1) then
        valorTotalTipo := premio_bruto * 0.35;
    elsif (tipo_premio = 2) then
        valorTotalTipo := premio_bruto * 0.19;
    elsif (tipo_premio = 3) then
        valorTotalTipo := premio_bruto * 0.19;
    elsif (tipo_premio = 4) then
        valorTotalTipo := premio_bruto * 0.22;
    elsif (tipo_premio = 5) then
        valorTotalTipo := premio_bruto * 0.05;
    end if;
    return valorTotalTipo;
  end;
  
  function gerarDataSorteio(idCAnterior in numeric) return CONCURSO.DATA_SORTEIO%type as
    vDataProx CONCURSO.DATA_SORTEIO%type;
    vDataAnt integer;
  begin
    select (1 + trunc(DATA_SORTEIO) - trunc (DATA_SORTEIO, 'IW'))
    into vDataAnt
    from CONCURSO
    where IDCONCURSO = idCAnterior;
    
    
    --6 = sabado
    --3 = quarta
    
    return vDataProx;
  end;
  procedure gerarProximoConcurso is
    vIdAnterior CONCURSO.IDCONCURSO%type;
    vPSENA CONCURSO.PREMIO_SENA%type;
    vPQUINA CONCURSO.PREMIO_QUINA%type;
    vPQUADRA CONCURSO.PREMIO_QUADRA%type;
    vAcumuladoProx CONCURSO.ACUMULADO_PROXIMO_05%type;
    vAcumuladoFinal CONCURSO.ACUMULADO_FINAL_ANO%type;
    vPremioBruto APOSTA.VALOR%type;
    vDataSorteio CONCURSO.DATA_SORTEIO%type;
  begin
    vIdAnterior := ultimo_concurso;
    vPremioBruto := calc_premio_bruto(vIdAnterior);
    vPSENA := premio_tipo(vPremioBruto, 1);
    vPQUINA := premio_tipo(vPremioBruto, 2);
    vPQUADRA := premio_tipo(vPremioBruto, 3);
    vAcumuladoProx := premio_tipo(vPremioBruto, 4);
    vAcumuladoFinal := premio_tipo(vPremioBruto, 5);
    vDataSorteio := sysdate+7;
    
  end gerar_concurso;
end pck_megasena;
/*Seguindo a definição da Megasena, é possível, a partir da arrecadação atual gerar o próximo concurso. Com
isso, codifique o procedimento [ ] de forma que permita gerar um novo registro de concurso.
Requisitos
? Para gerar o novo concurso o IDConcurso deve ser o incremento de 1 sobre o último;
? O valor do prêmio bruto representa 45,3% da arrecadação;
? Deve ser verificado se o concurso anterior acumulou, se acumulou deve ser somado este valor.
Como referência pode ser utilizada a package PCK_MEGASENA que possui uma procedure que recebe
como o parâmetro o prêmio bruto e distribuí os valores.*/

select * from aposta;
select * from aposta_premiada;
select * from cidade;
select * from concurso;
select * from numero_aposta;
select * from REGRA_RATEIO_PREMIO;

1 + TRUNC (dt)
  - TRUNC (dt, 'IW')
  
select (1 + trunc(DATA_SORTEIO) - trunc (DATA_SORTEIO, 'IW'))
    from concurso


--