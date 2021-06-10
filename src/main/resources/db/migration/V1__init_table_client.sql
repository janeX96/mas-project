drop table if exists client;
create table client(
                     id long primary key auto_increment,
                     first_name varchar(30) not null,
                     last_name varchar(40) not null,
                     address varchar(70) not null,
                     phone_number varchar(9) not null,
                     birth_date date not null
)