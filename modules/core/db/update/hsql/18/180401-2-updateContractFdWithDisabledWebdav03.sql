alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV add constraint FK_CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV_DOCUMENT foreign key (DOCUMENT_ID) references SYS_FILE(ID);
