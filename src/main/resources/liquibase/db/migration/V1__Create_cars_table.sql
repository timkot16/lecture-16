create table if not exists Cars
(
    id       int(11) unsigned auto_increment
        primary key,
    model    varchar(15) null,
    vin_code varchar(17) null,
    year     int(4)      not null,
    number   varchar(7)  null
);