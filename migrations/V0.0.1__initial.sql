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

insert into hometask.events(name, address, event_date, additional_info) values('Juhtimis konverents', 'Tallinn, Narva mnt 95', '2022-08-02T10:00:00.000Z', 'Territooriumile sissepääs Tallinna Lauluväljaku mereväravast.');
insert into hometask.events(name, address, event_date, additional_info) values('Comedy Estonia', 'Tallinn, Marati 5', '2022-07-02T19:00:00.000Z', 'Botik baari kohvikus ainult sularaha makse');
insert into hometask.events(name, address, event_date, additional_info) values('OktooberFest Tallinn', 'Tallinn, Paldiski maantee 104b', '2022-08-07T18:00:00.000Z', 'Saab palju nalja ja palju kalja');
insert into hometask.events(name, address, event_date, additional_info) values('Logistika aastakonverents 2022', 'Tallinn, Aida 4', '2022-11-22T10:00:00.000Z', 'Selle aastane logistikakonverents toimub Pärnu Kontserdimajas. Üritus on kahe päevane 22.nov ja 23.nov. Mõlemal päeval ürituse algus 10:00 ja oreinteeruv lõpp 15:00');

create table hometask.payment_types(
    id uuid default uuid_generate_v4() primary key,
    name varchar(50) unique not null
);
insert into hometask.payment_types(name) values('Cash');
insert into hometask.payment_types(name) values('Bank transfer');



create table hometask.participants(
    id uuid default uuid_generate_v4() primary key,
    name varchar(255) not null,
    id_number bigint not null,
    event_id uuid not null references hometask.events(id),
    payment_type uuid not null references hometask.payment_types(id),
    participants_count integer not null default 1,
    additional_info text,
    person_type varchar(255) not null
);

--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('Kaur Ilves', 38904022237, 'ab32bc7f-0446-4010-90c4-528a987ac025', 'b0ddc8e9-ef0b-43d7-821b-ee4599399d74', 1, 'Hilineb 30 minutit', 'PRIVATEPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('OÜ Roadlink', 12345678, ab32bc7f-0446-4010-90c4-528a987ac025, b0ddc8e9-ef0b-43d7-821b-ee4599399d74, 10, 'Osalejad lubada üritusele ettevõtte nime alusel', 'LEGALPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('Liisa Selli', 49102112238, d32bc7f-0446-4010-90c4-528a987ac025, b0ddc8e9-ef0b-43d7-821b-ee4599399d74, 1 null, 'LEGALPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('Kaur Ilves', 38904022237, 132f53dd-5a18-4160-9d2a-658a3a7f64bf, 5abcbb27-7284-4789-ba54-a43e22788c2e, 1, null, 'PRIVATEPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('Liisa Selli', 49102112238, 132f53dd-5a18-4160-9d2a-658a3a7f64bf, b0ddc8e9-ef0b-43d7-821b-ee4599399d74, 1, null, 'PRIVATEPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('OÜ Stonewolf', 14567323, 1c0d0b7f-13cd-4478-99ac-7a0031faef2d, b0ddc8e9-ef0b-43d7-821b-ee4599399d74, 3, null, 'LEGALPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('Kaur Ilves', 38904022237, 1c0d0b7f-13cd-4478-99ac-7a0031faef2d, 5abcbb27-7284-4789-ba54-a43e22788c2e, 1, null, 'PRIVATEPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('Liisa Selli', 49102112238, 1c0d0b7f-13cd-4478-99ac-7a0031faef2d, b0ddc8e9-ef0b-43d7-821b-ee4599399d74, 1, null, 'PRIVATEPERSON');
--insert into hometask.participants(name, id_number, event_id, payment_type, participants_count, additional_info, person_type) values ('OÜ Roadlink', 12345678, 1c0d0b7f-13cd-4478-99ac-7a0031faef2d, b0ddc8e9-ef0b-43d7-821b-ee4599399d74, 5, 'Osalejate arv võib veel muutuda', 'LEGALPERSON');
