create extension if not exists "uuid-ossp";

drop schema if exists hometask cascade;
create schema if not exists hometask;

create table hometask.events(
    id uuid default uuid_generate_v4() primary key,

    name varchar(150) not null,
    address varchar(250) not null,
    event_date timestamp with time zone not null,
    additional_info text
);

create table hometask.payment_types(
    id uuid default uuid_generate_v4() primary key,
    name varchar(50) unique not null
);
insert into hometask.payment_types(name) values('Cash');
insert into hometask.payment_types(name) values('Bank transfer');


create table hometask.persons(
    id uuid default uuid_generate_v4() primary key,
    id_number bigint not null,
    name varchar(255) not null,
    person_type varchar(255) not null
    );

create table hometask.participants(
    id uuid default uuid_generate_v4() primary key,
    eventId uuid not null references hometask.payment_types(id),
    personId uuid not null references hometask.persons(id),
    payment_type uuid not null references hometask.payment_types(id),
    participants_count integer not null default 1,
    additional_info text
);

