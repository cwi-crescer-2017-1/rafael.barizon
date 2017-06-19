/*
Exercício 1

Auditoria Loteria

Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. A auditoria deve 
monitorar tanto as apostas quanto os números de cada aposta.

*/
select * from aposta;



create or replace trigger TR_Auditoria_Lot
    after insert or update on APOSTA
    for each row
Declare
  v_idaposta   Integer;
  v_idconcurso   Integer;
  v_idconcurso_novo   Integer;
  v_DATA_HORA   DATE;
  v_DATA_HORA_Nova   DATE;
  v_operacao char(1);
Begin
  if INSERTING then
     v_operacao         := 'I';
     v_idaposta         := :new.idaposta;
     v_idconcurso_novo  := :new.idconcurso; 
     v_idconcurso       := null; 
     v_DATA_HORA_Nova   := :new.data_hora;
     v_DATA_HORA        := null;
  elsif UPDATING then
     v_operacao         := 'U';
     v_idaposta         := :old.idaposta;  -- MANTEVE-SE O "OLD" PORQUE O ID NÃO DEVE SER ALTERADO
     v_idconcurso       := :old.idconcurso; 
     v_idconcurso_novo  := :new.idconcurso; 
     v_DATA_HORA        := :old.data_hora;
     v_DATA_HORA_Nova   := :new.data_hora;
  end if;
  Insert into LogAposta 
                (IDLOGAPOSTA,         IDAPOSTA,   IDCONCURSO,   IDConcurso_Novo,   OPERACAO,    DATA,    DATA_HORA,   Data_Hora_Nova  , usuario)
        values  (sqlogaposta.nextval, v_idaposta, v_idconcurso, v_idconcurso_novo, v_operacao , sysdate, v_DATA_HORA, v_DATA_HORA_Nova, user);
End TR_Auditoria_Lot;




create or replace trigger TR_Auditoria_Lot_NumAposta
    after insert or update on numero_aposta
    for each row
Declare
  v_IDNumero_Aposta   Integer;
  v_idaposta   Integer;
  v_IDAposta_Nova   Integer;
  v_NUMERO   Integer;
  v_NUMERO_novo   Integer;
  v_operacao char(1);
Begin
  if INSERTING then
     v_operacao         := 'I';
     v_IDNumero_Aposta   := :new.idnumero_aposta;
     v_idaposta   := null;
     v_IDAposta_Nova         := :new.idaposta;
     v_NUMERO   := null;
     v_NUMERO_novo   := :new.numero;
  elsif UPDATING then
     v_operacao         := 'U';
     v_IDNumero_Aposta   := :old.idnumero_aposta;
     v_idaposta   := :old.idaposta;
     v_IDAposta_Nova         := :new.idaposta;
     v_NUMERO   := :old.idaposta;
     v_NUMERO_novo   := :new.numero;
  end if;
  Insert into LogNumeroAposta 
                (IDLogNumeroAposta,         IDNumero_Aposta,   IDAposta,    IDAposta_Nova,  NUMERO,     NUMERO_Novo,    Operacao,   Data,    Usuario)
        values  (sqLogNumeroAposta.nextval, v_IDNumero_Aposta, v_idaposta,  v_IDAposta_Nova,v_NUMERO ,  v_NUMERO_novo,  v_operacao, sysdate, user);
End TR_Auditoria_Lot_NumAposta;

