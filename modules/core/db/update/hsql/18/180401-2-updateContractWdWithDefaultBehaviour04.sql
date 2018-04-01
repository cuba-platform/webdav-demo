-- update CONTRACTSYSTEM_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR set NUMBER_ = <default_value> where NUMBER_ is null ;
alter table CONTRACTSYSTEM_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR alter column NUMBER_ set not null ;
