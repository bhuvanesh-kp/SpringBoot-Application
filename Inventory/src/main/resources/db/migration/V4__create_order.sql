create table `order`(
    id bigint primary key ,
    total decimal(10, 2) not null ,
    quantity bigint not null ,
    placed_at timestamp default current_timestamp ,
    customer_id bigint ,
    event_id bigint ,
    constraint fr_order_id foreign key (customer_id) references customer(id) on delete set null ,
    constraint fr_order_event foreign key (event_id) references event(id) on delete set null
);