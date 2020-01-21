create table users (
    id serial primary key,
    username varchar(255),
    email varchar(255)
);

insert into users (username, email) values
('thjo', 'thjo@somewhere.no'),
('ola', 'ola@somewhere.no'),
('bola', 'bola@somewhere.no');
