-- user 테이블
create table users
(
    user_id  int auto_increment primary key,
    email    varchar(50) unique,
    password varchar(255),
    type     varchar(10) not null comment 'member, unknown, manager'
);

-- 유저 정보 테이블
create table user_detail
(
    user_id     int primary key,
    user_name   varchar(20) not null,
    age         int         not null,
    gender      varchar(2)  not null,
    user_legion varchar(10),
    created_at  timestamp   not null default current_timestamp,
    foreign key (user_id) references users (user_id)
);

-- 성향 테이블 (= 구 ex. 부산진구)
create table kind
(
    kind_id    int auto_increment primary key,
    kind_name  varchar(50) not null,
    kind_text  text        not null,
    created_at timestamp   not null default current_timestamp
);

-- 섹션 카테고리
create table section_category
(
    section_category_id   int auto_increment primary key,
    section_category_name varchar(255)
);

-- 섹션 테이블 (ex. 학교, 극장, 병원 등)
create table section
(
    section_id   int auto_increment primary key,
    section_name varchar(50),
    created_at   timestamp not null default current_timestamp
);

-- 섹션 카테고리와 섹션 매치 테이블
create table section_category_section
(
    section_category_id int,
    section_id int,
    primary key (section_category_id, section_id),
    foreign key (section_category_id) references section_category (section_category_id),
    foreign key (section_id) references section (section_id)
);

-- 질문 테이블
create table question
(
    question_id   int auto_increment primary key,
    question_text text      not null,
    parent_id     int,
    tip           text,
    created_at    timestamp not null default current_timestamp,
    foreign key (parent_id) references question (question_id)
);

-- 응답 테이블
create table answer
(
    answer_id   int auto_increment primary key,
    question_id int,
    answer_text varchar(255),
    created_at  timestamp not null default current_timestamp,
    foreign key (question_id) references question (question_id)
);

-- 해당 응답을 하면 여러 섹션에 점수를 부여
CREATE TABLE answer_section
(
    answer_section_id INT AUTO_INCREMENT PRIMARY KEY,
    answer_id         INT,
    section_id        INT,
    score             INT,
    FOREIGN KEY (answer_id) REFERENCES answer (answer_id),
    FOREIGN KEY (section_id) REFERENCES section (section_id)
);

-- 유저 성향 테스트 결과
create table user_kind
(
    user_kind_id int auto_increment primary key,
    user_id      int,
    kind_id      int,
    created_at   timestamp not null default current_timestamp,
    foreign key (user_id) references users (user_id),
    foreign key (kind_id) references kind (kind_id)
);

-- 사용자의 응답 정보를 저장
create table user_answer
(
    user_answer_id int auto_increment primary key,
    user_id        int,
    answer_id      int,
    user_kind_id   int,
    created_at     timestamp not null default current_timestamp,
    foreign key (user_id) references users (user_id),
    foreign key (answer_id) references answer (answer_id),
    foreign key (user_kind_id) references user_kind (user_kind_id) ON DELETE CASCADE
);

-- 데이터 파싱을 통해 산정한 섹션별 성향 랭크
create table kind_rank
(
    kind_score_id int auto_increment primary key,
    kind_id       int,
    section_id    int,
    rank          int,
    created_at    timestamp not null default current_timestamp,
    foreign key (kind_id) references kind (kind_id),
    foreign key (section_id) references section (section_id),
    CONSTRAINT unique_kind_section UNIQUE (kind_id, section_id)
);