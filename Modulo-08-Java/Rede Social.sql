select * from postcontents;
--select * from usersocial
select * from userprofile
insert into userprofile(birthday, gender, name, id_user) values('123', 1, 'ralph', 100)
select * from relationship
insert into POSTcontents(id, content, id_user, number_of_likes, publish_date) 
                  values(6, 'NANA', 150, 0, SYSDATE);
insert into POSTcontents(id, content, id_user, number_of_likes, publish_date) 
                  values(7, 'TATA', 150, 0, SYSDATE);
insert into POSTcontents(id, content, id_user, number_of_likes, publish_date) 
                  values(8, 'BABA', 150, 0, SYSDATE);
                  commit;
                  
                  --delete from relationship where id_user = 100 or id_user_relationship = 100
                  update relationship set relationship_status = 2 where id_user = 1050;