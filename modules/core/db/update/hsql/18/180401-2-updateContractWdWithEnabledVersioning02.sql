alter table CONTRACTSYSTEM_CONTRACT_WD_WITH_ENABLED_VERSIONING add constraint FK_CONTRACTSYSTEM_CONTRACT_WD_WITH_ENABLED_VERSIONING_CONTRACTOR foreign key (CONTRACTOR_ID) references SEC_USER(ID);
create index IDX_CONTRACTSYSTEM_CONTRACT_WD_WITH_ENABLED_VERSIONING_CONTRACTOR on CONTRACTSYSTEM_CONTRACT_WD_WITH_ENABLED_VERSIONING (CONTRACTOR_ID);
