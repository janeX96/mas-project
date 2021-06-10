drop table if exists packer;
create table packer(
                     id long primary key auto_increment,
                     first_name varchar(30) not null,
                     last_name varchar(40) not null,
                     birth_date date not null,
                     hire_date date not null
)