Create tablespace REDESOCIAL
datafile 'C:\oraclexe\app\oracle\oradata\XE\redesocial.dbf'
size 100m
autoextend on
next 100m
maxsize 2048m;


create user social identified by social default tablespace redesocial;

grant connect, resource, create view to social;

