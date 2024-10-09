create table users
(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(500) not null,
    enabled  boolean not null
);
create table authorities
(
    username  varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);
create unique index ix_auth_username on authorities (username, authority);


INSERT
IGNORE INTO users VALUES ('user', '{noop}EazyBytes@12345', '1');
INSERT
IGNORE INTO authorities VALUES ('user', 'read');

INSERT
IGNORE INTO users VALUES ('admin', '{bcrypt}$2a$12$9RbTyFkznZaMk5sU3MDuJe5vewdUd.jI/hYq5GUY80NBzgcvHWeNW', '1');
INSERT
IGNORE INTO authorities VALUES ('admin', 'admin');