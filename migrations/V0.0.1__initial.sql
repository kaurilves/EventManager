create extension if not exists "uuid-ossp";

drop schema if exists hometask cascade;
create schema if not exists hometask;

create table hometask.events(
    id uuid default uuid_generate_v4() primary key,
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone not null default now(),
    name varchar(150) not null,
    address varchar(250) not null,
    event_date timestamp with time zone not null,
    additional_info text
);

create table hometask.payment_types(
    id uuid default uuid_generate_v4() primary key,
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone not null default now(),
    name varchar(50) unique not null
);
insert into hometask.payment_types(name) values('Cash');
insert into hometask.payment_types(name) values('Bank transfer');

create table hometask.companies(
    id uuid default uuid_generate_v4() primary key,
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone not null default now(),
    company_legal_name varchar(255) not null,
    reg_code bigint not null,
    participants_count integer not null default 1,
    payment_type uuid not null references hometask.payment_types(id),
    event_id uuid not null references hometask.events(id),
    additional_info text
);

create table hometask.persons(
    id uuid default uuid_generate_v4() primary key,
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone not null default now(),
    id_code bigint not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    payment_type uuid not null references hometask.payment_types(id),
    event_id uuid not null references hometask.events(id),
    additional_info text
);