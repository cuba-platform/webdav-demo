alter table CONTRACTSYSTEM_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR add constraint FK_CONTRACTSYSTEM_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR_DOCUMENT foreign key (DOCUMENT_ID) references WEBDAV_WEBDAV_DOCUMENT(ID);
