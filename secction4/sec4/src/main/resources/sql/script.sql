use athifiz;

create table users(
	username varchar(50) not null primary key,
    password varchar(50) not null,
    enabled boolean not null
);

create table authorities(
	username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

alter table users
modify column password varchar(80);

create unique index ix_auth_username
on authorities (username, authority);


insert into users
values ("user", "{noop}user", '1');

insert into authorities
values ("user", "read");

insert into users
values ("admin", "{bcrypt}$2a$12$6t4YUzcqxZjIIDfxhQmF9eizKMyKtlmD2T0ExpnDdHD.pisH.RR6W", '1');

insert into authorities
values ("admin", "admin");

create table customer (
	id int not null auto_increment,
    email varchar(45) not null,
    pwd varchar(200) not null,
    role varchar(45) not null,
    primary key (id)
);


insert into customer(email, pwd, role)
values
    ('happy@example.com', '{noop}happy', 'read'),
    ('admin@example.com', '{bcrypt}$2a$12$6t4YUzcqxZjIIDfxhQmF9eizKMyKtlmD2T0ExpnDdHD.pisH.RR6W', 'admin');







