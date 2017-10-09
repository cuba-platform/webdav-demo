-- alter table CONTRACTSYSTEM_CONTRACT add column DOCUMENT_ID varchar(36) ^
-- update CONTRACTSYSTEM_CONTRACT set DOCUMENT_ID = <default_value> ;
-- alter table CONTRACTSYSTEM_CONTRACT alter column DOCUMENT_ID set not null ;
alter table CONTRACTSYSTEM_CONTRACT add column DOCUMENT_ID varchar(36) not null ;
