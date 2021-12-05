drop table if exists employee;
drop table if exists hibernate_sequence;

create table employee (
   id integer not null auto_increment,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
) engine=InnoDB;

create table hibernate_sequence (
       next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values ( 1 );