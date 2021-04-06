insert into usr(email, first_name, last_name, password)
values ('admin@mail.ru', 'Bilbo', 'Baggins', '$2y$12$D4/91PzC5w6pNMFsCAMWQO4bW568J.PcnL.TIgkqiBehy1EbpdCx.');

insert into role(name)
values ('ROLE_ADMIN');

insert into users_roles (user_id, role_id)
values (1, 1)