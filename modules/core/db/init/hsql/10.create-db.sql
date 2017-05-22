-- begin CONTRACTSYSTEM_CONTRACT
create table CONTRACTSYSTEM_CONTRACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CONTRACTOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_CONTRACT
-- begin CONTRACTSYSTEM_CONTRACTOR
create table CONTRACTSYSTEM_CONTRACTOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_CONTRACTOR
-- begin CONTRACTSYSTEM_CONTRACT_WEBDAV_FILE_DESCRIPTOR_LINK
create table CONTRACTSYSTEM_CONTRACT_WEBDAV_FILE_DESCRIPTOR_LINK (
    CONTRACT_ID varchar(36) not null,
    WEBDAV_FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (CONTRACT_ID, WEBDAV_FILE_DESCRIPTOR_ID)
)^
-- end CONTRACTSYSTEM_CONTRACT_WEBDAV_FILE_DESCRIPTOR_LINK
-- begin SEC_USER
alter table SEC_USER add column WEBDAV_PASSWORD varchar(255) ^
update SEC_USER set WEBDAV_PASSWORD = '' where WEBDAV_PASSWORD is null ^
alter table SEC_USER alter column WEBDAV_PASSWORD set not null ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'contractsystem$ContractUser' where DTYPE is null ^
-- end SEC_USER
