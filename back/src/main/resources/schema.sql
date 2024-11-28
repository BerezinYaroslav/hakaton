drop table if exists address, client, channel_package, channel cascade;


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

create table channel_package
(
    name          nvarchar(100) primary key,
    channel_count int
);

create table channel
(
    id      int,
    package nvarchar(100) references channel_package (name) on delete set null
);