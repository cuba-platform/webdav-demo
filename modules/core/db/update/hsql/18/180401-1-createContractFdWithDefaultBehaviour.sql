create table CONTRACTSYSTEM_CONTRACT_FD_WITH_DEFAULT_BEHAVIOUR (
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
    CONTRACTOR_ID varchar(36),
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
);
