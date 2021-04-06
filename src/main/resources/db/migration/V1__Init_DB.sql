create table correct_answer
(
    id             bigserial not null,
    correct_answer varchar(2048),
    primary key (id)
);
create table question
(
    id       bigserial not null,
    question varchar(2048),
    primary key (id)
);
create table role
(
    id   bigserial not null,
    name varchar(255),
    primary key (id)
);
create table test_questions
(
    id bigserial not null,
    primary key (id)
);
create table test_questions_test_options
(
    test_questions_id int8 not null,
    test_options      varchar(2048)
);
create table users_roles
(
    user_id int8 not null,
    role_id int8 not null
);
create table usr
(
    id         bigserial not null,
    email      varchar(255) not null,
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255) not null,
    primary key (id)
);

alter table if exists usr add constraint usr_email unique (email);
alter table if exists test_questions_test_options add constraint options_question_fk foreign key (test_questions_id) references test_questions;
alter table if exists users_roles add constraint user_roles_role_fk foreign key (role_id) references role;
alter table if exists users_roles add constraint users_roles_usr foreign key (user_id) references usr;