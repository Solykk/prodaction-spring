--liquibase formatted sql
--changeset dima:dima_03_inser_data_in_ta_cacheable_tables

INSERT INTO my_schema.areas(ar_code, ar_description, ar_count)
  VALUES
    ('GAME', 'Game Area', 100) ,
    ('MUSIC', 'Music Area', 120) ,
    ('VIDEO', 'Video Area', 140) ,
    ('PHOTO', 'Photo Area', 167) ,
    ('POST', 'Post Area', 211) ;

INSERT INTO my_schema.statuses(st_code, st_description)
VALUES
  ('JUNIOR', 'Junior Status') ,
  ('MIDDLE', 'Middle Status') ,
  ('SENIOR', 'Senior Status') ;

--rollback DELETE FROM my_schema.statuses;
--rollback DELETE FROM my_schema.areas;