create table CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV (
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
    FILE_ID varchar(36),
    --
    primary key (ID)
);
