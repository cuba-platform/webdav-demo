-- begin CONTRACTSYSTEM_CONTRACT
create table CONTRACTSYSTEM_CONTRACT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DOCUMENT_ID uuid not null,
    CONTRACTOR_ID uuid,
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_CONTRACT
-- begin CONTRACTSYSTEM_CONTRACTOR
create table CONTRACTSYSTEM_CONTRACTOR (
    ID uuid,
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
-- begin CONTRACTSYSTEM_WEBDAV_CONTRACT
create table CONTRACTSYSTEM_WEBDAV_CONTRACT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    CONTRACTOR_ID uuid,
    DOCUMENT_ID uuid,
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_WEBDAV_CONTRACT
-- begin CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV
create table CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    FILE_ID uuid,
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV
-- begin CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR
create table CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    FILE_ID uuid,
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR

-- begin SEC_USER
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'contractsystem$ContractUser' where DTYPE is null ^
-- end SEC_USER

-- begin CONTRACTSYSTEM_ENTITY_MANY_FD
create table CONTRACTSYSTEM_ENTITY_MANY_FD (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end CONTRACTSYSTEM_ENTITY_MANY_FD
-- begin CONTRACTSYSTEM_MANY
create table CONTRACTSYSTEM_MANY (
    ENTITY_MANY_ID uuid,
    FILE_DESCRIPTOR_ID uuid,
    primary key (ENTITY_MANY_ID, FILE_DESCRIPTOR_ID)
)^
-- end CONTRACTSYSTEM_MANY
