create table venue (
                          id bigint auto_increment primary key,
                          name varchar(255) not null,
                          address varchar(255) not null,
                          total_capacity bigint not null
);

create table event(
                      id bigint auto_increment primary key,
                      name varchar(255) not null,
                      venue_id bigint not null,
                      total_capacity bigint not null ,
                      left_capacity bigint not null ,
                      constraint fr_key_constraint foreign key (venue_id) references venue(id) on delete cascade
);