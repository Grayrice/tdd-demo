drop table if exists `question`;
create table question
(
    id          bigint auto_increment primary key,
    question_id text not null,
    title       text not null,
    detail      text

);