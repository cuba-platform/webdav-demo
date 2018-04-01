-- update CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV set NUMBER_ = <default_value> where NUMBER_ is null ;
alter table CONTRACTSYSTEM_CONTRACT_FD_WITH_DISABLED_WEBDAV alter column NUMBER_ set not null ;
