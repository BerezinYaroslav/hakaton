create table address
(
    address   varchar(100) primary key,
    flats     int,
    entrances int,
    floors    varchar(200)
);

create table client
(
    client  varchar(50) primary key,
    address varchar(100) references address (address) on delete set null,
    gender  varchar(1),
    age     varchar(10)
);

create table channel_package
(
    name          varchar(100) primary key,
    channel_count int
);

create table channel
(
    id      int,
    package varchar(100) references channel_package (name) on delete set null
);

create table stat
(
    client      varchar(50) references client (client),
    device      varchar(50),
    time_ch     timestamp,
    channel_id  int,
    epg_name    varchar(200),
    time_epg    timestamp,
    time_to_epg timestamp,
    duration    int,
    category    varchar(50),
    subcategory varchar(50)
);