drop table if exists instrument;
create table instrument(
                     id long primary key auto_increment,
                     prize double not null,
                     count int not null,
                     name varchar(20) not null,
                     producer varchar(20) not null,
                     electronic boolean not null
)