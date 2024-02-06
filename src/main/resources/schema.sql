create schema if not exists deleteservice;

create table if not exists users
(
    id                bigserial primary key,
    username          varchar(255) not null,
    registration_date timestamp
);

create table if not exists cars
(
    id                      bigserial primary key,
    brand                   varchar(255) not null,
    start_exploitation_date timestamp
);

create table if not exists documents
(
    id            bigserial primary key,
    number        bigint not null,
    issuance_date timestamp
);

create index if not exists users_registration_date_idx on users (registration_date);
create index if not exists cars_start_exploitation_date_idx on cars (start_exploitation_date);
create index if not exists documents_registration_date_idx on documents (issuance_date);
