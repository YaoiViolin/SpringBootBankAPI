
create table role (
                      id int primary key,
                      user_role varchar(20)
);

create table users (
    id identity primary key,
    username VARCHAR(20) not null,
    password varchar(30) not null,
    user_role_id int references role(id)
);
create unique index on users (username);

create table account (
    id identity primary key ,
    number varchar(10) not null,
    balance decimal(15,2),
    client_id bigint not null references users (id)
);
create unique index on account (number);

create table card (
    id identity primary key ,
    number varchar(20),
    account_id bigint not null references account (id)
);
create unique index on card (number);

