-- alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add column NUMBER_ varchar(255) ^
-- update CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV set NUMBER_ = <default_value> ;
-- alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV alter column NUMBER_ set not null ;
alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add column NUMBER_ varchar(255) ;
-- alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add column CONTRACTOR_ID varchar(36) ^
-- update CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV set CONTRACTOR_ID = <default_value> ;
-- alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV alter column CONTRACTOR_ID set not null ;
alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add column CONTRACTOR_ID varchar(36) not null ;
-- alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add column DOCUMENT_ID varchar(36) ^
-- update CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV set DOCUMENT_ID = <default_value> ;
-- alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV alter column DOCUMENT_ID set not null ;
alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add column DOCUMENT_ID varchar(36) not null ;
