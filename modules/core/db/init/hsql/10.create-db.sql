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
    DOCUMENT_ID varchar(36) not null,
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

-- begin SEC_USER
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'contractsystem$ContractUser' where DTYPE is null ^
-- end SEC_USER
-- begin CONTRACTSYSTEM_WEBDAV_CONTRACT
create table CONTRACTSYSTEM_WEBDAV_CONTRACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    CONTRACTOR_ID varchar(36),
    DOCUMENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_WEBDAV_CONTRACT
