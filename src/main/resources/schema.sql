drop table if exists address, client cascade;


create table address
(
    address   nvarchar(100) primary key,
    flats     int,
    entrances int,
    floors    nvarchar(200)
);

create table client
(
    client  nvarchar(50) primary key,
    address nvarchar(100) references address (address) on delete set null,
    gender  nvarchar(1),
    age     nvarchar(10)
);