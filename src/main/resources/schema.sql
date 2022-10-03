DROP TABLE IF EXISTS userstory CASCADE;

CREATE TABLE userstory
(
    id              identity NOT NULL PRIMARY KEY,
    story_title     varchar(100),
    user_story      varchar(400),
    acceptance_criteria    varchar(400),
    business_value real,
    estimation integer,
    status varchar(20)

);


