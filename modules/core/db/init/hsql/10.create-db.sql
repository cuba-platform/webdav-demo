-- begin SEC_USER
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'webdavdemo$ContractUser' where DTYPE is null ^
-- end SEC_USER
-- begin WEBDAV_DEMO_CONTRACT_FD_WITH_ENABLED_WEBDAV_ENABLED_VERSIONING
create table WEBDAV_DEMO_CONTRACT_FD_WITH_ENABLED_WEBDAV_ENABLED_VERSIONING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_FD_WITH_ENABLED_WEBDAV_ENABLED_VERSIONING
-- begin WEBDAV_DEMO_CONTRACT_FD_WITH_DISABLED_WEBDAV
create table WEBDAV_DEMO_CONTRACT_FD_WITH_DISABLED_WEBDAV (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_FD_WITH_DISABLED_WEBDAV
-- begin WEBDAV_DEMO_CONTRACT_FD_WITH_DEFAULT_BEHAVIOUR
create table WEBDAV_DEMO_CONTRACT_FD_WITH_DEFAULT_BEHAVIOUR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_FD_WITH_DEFAULT_BEHAVIOUR
-- begin WEBDAV_DEMO_CONTRACT_FD_WITH_ENABLED_WEBDAV_DISABLED_VERSIONING
create table WEBDAV_DEMO_CONTRACT_FD_WITH_ENABLED_WEBDAV_DISABLED_VERSIONING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_FD_WITH_ENABLED_WEBDAV_DISABLED_VERSIONING
-- begin WEBDAV_DEMO_CONTRACT_WD_WITH_ENABLED_VERSIONING
create table WEBDAV_DEMO_CONTRACT_WD_WITH_ENABLED_VERSIONING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_WD_WITH_ENABLED_VERSIONING
-- begin WEBDAV_DEMO_CONTRACT_WD_WITH_DISABLED_VERSIONING
create table WEBDAV_DEMO_CONTRACT_WD_WITH_DISABLED_VERSIONING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_WD_WITH_DISABLED_VERSIONING
-- begin WEBDAV_DEMO_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR
create table WEBDAV_DEMO_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    CONTRACTOR_ID varchar(36) not null,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end WEBDAV_DEMO_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR
