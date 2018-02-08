--liquibase formatted sql
--changeset dima:dima_04_update_additional_information_table

ALTER TABLE my_schema.additional_information ALTER COLUMN ai_address SET NOT NULL ;
ALTER TABLE my_schema.additional_information ALTER COLUMN ai_age SET NOT NULL ;
ALTER TABLE my_schema.additional_information ALTER COLUMN ai_sex SET NOT NULL ;

--rollback SELECT 1;

