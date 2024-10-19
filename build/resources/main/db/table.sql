create table users(
	user_id int auto_increment primary key,
    email varchar(50) unique,
    password varchar(255),
    type varchar(10) not null comment 'member, unknown, manager'
);
create table user_detail(
	user_id int primary key,
    user_name varchar(20) not null,
    age int not null,
    gender varchar(2) not null,
    user_legion varchar(10),
    created_at timestamp not null default current_timestamp,
    foreign key(user_id) references users(user_id)
);
create table kind (
	kind_id int auto_increment primary key,
    kind_name varchar(50) not null,
    kind_text text not null,
    created_at timestamp not null default current_timestamp
);

create table section (
	section_id int auto_increment primary key,
    section_name varchar(50),
    created_at timestamp not null default current_timestamp
);
create table question (
	question_id int auto_increment primary key,
    question_text text not null,
    parent_id int,
    section_id int,
    tip text,
    created_at timestamp not null default current_timestamp,
    foreign key(parent_id) references question (question_id),
    foreign key(section_id) references section (section_id)
);

create table answer(
	answer_id int auto_increment primary key,
    question_id int,
    section_id int,
    answer_text varchar(255),
    score int,
    created_at timestamp not null default current_timestamp,
    foreign key(question_id) references question (question_id),
    foreign key(section_id) references section (section_id)
);

create table user_answer (
	user_answer_id int auto_increment primary key,
    user_id int,
    answer_id int,
    created_at timestamp not null default current_timestamp,
    foreign key(user_id) references users (user_id),
    foreign key(answer_id) references answer (answer_id)
);

create table user_kind (
	user_kind_id int auto_increment primary key,
    user_id int,
    kind_id int,
    created_at timestamp not null default current_timestamp,
    foreign key(user_id) references users (user_id),
    foreign key(kind_id) references kind (kind_id)
);

create table kind_rank (
    kind_score_id int auto_increment primary key,
    kind_id int,
    section_id int,
    rank int,
    created_at timestamp not null default current_timestamp,
    foreign key(kind_id) references kind (kind_id),
    foreign key(section_id) references section (section_id)
);