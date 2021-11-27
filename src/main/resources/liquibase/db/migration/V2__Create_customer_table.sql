create table if not exists Customers
(
    id         int(11) unsigned auto_increment
        primary key,
    first_name varchar(15)      null,
    last_name  varchar(15)      null,
    tel_number varchar(15)      null,
    car_id     int(11) unsigned null,
    constraint `customer's car`
        foreign key (car_id) references Cars (id)
            on update cascade on delete set null
);