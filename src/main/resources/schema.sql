create table users (
  user_id int not null AUTO_INCREMENT,
  user_name varchar(50) not null,
  password varchar(100) not null,
  primary key ( user_id ),
  constraint un1_users unique (user_name)
);