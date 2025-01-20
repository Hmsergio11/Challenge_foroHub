
create table topicos(

                        id bigint not null auto_increment,
                        idDelUsuario varchar(100) not null ,
                        mensaje varchar(100) not null,
                        nombreDelCurso varchar(100) not null,
                        titulo varchar(100) not null,


                        primary key(id)

);