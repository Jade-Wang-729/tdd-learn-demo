create table if not exists cards(
    id varchar(19) primary key,
    pin varchar(6) not null,
    card_status varchar(64) not null
);
