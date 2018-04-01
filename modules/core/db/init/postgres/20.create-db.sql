-- begin CONTRACTSYSTEM_CONTRACT
alter table CONTRACTSYSTEM_CONTRACT add constraint FK_CONTRACTSYSTEM_CONTRACT_DOCUMENT foreign key (DOCUMENT_ID) references SYS_FILE(ID)^
alter table CONTRACTSYSTEM_CONTRACT add constraint FK_CONTRACTSYSTEM_CONTRACT_CONTRACTOR foreign key (CONTRACTOR_ID) references CONTRACTSYSTEM_CONTRACTOR(ID)^
create index IDX_CONTRACTSYSTEM_CONTRACT_DOCUMENT on CONTRACTSYSTEM_CONTRACT (DOCUMENT_ID)^
create index IDX_CONTRACTSYSTEM_CONTRACT_CONTRACTOR on CONTRACTSYSTEM_CONTRACT (CONTRACTOR_ID)^
-- end CONTRACTSYSTEM_CONTRACT
-- begin CONTRACTSYSTEM_CONTRACTOR
create unique index IDX_CONTRACTSYSTEM_CONTRACTOR_UK_EMAIL on CONTRACTSYSTEM_CONTRACTOR (EMAIL) where DELETE_TS is null ^
-- end CONTRACTSYSTEM_CONTRACTOR
-- begin CONTRACTSYSTEM_WEBDAV_CONTRACT
alter table CONTRACTSYSTEM_WEBDAV_CONTRACT add constraint FK_CONTRACTSYSTEM_WEBDAV_CONTRACT_CONTRACTOR foreign key (CONTRACTOR_ID) references CONTRACTSYSTEM_CONTRACTOR(ID)^
alter table CONTRACTSYSTEM_WEBDAV_CONTRACT add constraint FK_CONTRACTSYSTEM_WEBDAV_CONTRACT_DOCUMENT foreign key (DOCUMENT_ID) references WEBDAV_WEBDAV_DOCUMENT(ID)^
-- end CONTRACTSYSTEM_WEBDAV_CONTRACT
-- begin CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV
alter table CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV add constraint FK_CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV_FILE foreign key (FILE_ID) references SYS_FILE(ID)^
-- end CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV
-- begin CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR
alter table CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR add constraint FK_CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR_FILE foreign key (FILE_ID) references SYS_FILE(ID)^
-- end CONTRACTSYSTEM_CONTRACT_WITH_SIMPLE_FILE_DESCRIPTOR

-- begin CONTRACTSYSTEM_MANY
alter table CONTRACTSYSTEM_MANY add constraint FK_MAN_ENTITY_MANY_FD foreign key (ENTITY_MANY_ID) references CONTRACTSYSTEM_ENTITY_MANY_FD(ID)^
alter table CONTRACTSYSTEM_MANY add constraint FK_MAN_FILE_DESCRIPTOR foreign key (FILE_DESCRIPTOR_ID) references SYS_FILE(ID)^
-- end CONTRACTSYSTEM_MANY