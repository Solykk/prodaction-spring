--liquibase formatted sql
--changeset dima:dima_00_create_schema

CREATE SCHEMA IF NOT EXISTS my_schema;

--rollback DROP SCHEMA IF EXISTS production_test.my_schema;