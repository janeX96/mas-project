drop table if exists eorder;
create table eorder(
                     id long primary key auto_increment,
                     sub_date_time timestamp not null,
                     finish_date_time timestamp,
                     status varchar(11) not null
)