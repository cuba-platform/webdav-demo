alter table CONTRACTSYSTEM_CONTRACT_WD_WITH_DISABLED_VERSIONING add constraint FK_CONTRACTSYSTEM_CONTRACT_WD_WITH_DISABLED_VERSIONING_CONTRACTOR foreign key (CONTRACTOR_ID) references SEC_USER(ID);
create index IDX_CONTRACTSYSTEM_CONTRACT_WD_WITH_DISABLED_VERSIONING_CONTRACTOR on CONTRACTSYSTEM_CONTRACT_WD_WITH_DISABLED_VERSIONING (CONTRACTOR_ID);
