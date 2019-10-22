-- apply changes
create table account (
  gid                           varchar(32) not null,
  name                          varchar(50),
  balance                       decimal(65,2),
  idcard                        varchar(18),
  cardno                        varchar(50),
  create_at                     datetime(6) not null,
  create_by                     varchar(50) not null,
  modify_at                     datetime(6) not null,
  modify_by                     varchar(50) not null,
  constraint pk_account primary key (gid)
);

create table trans_record (
  gid                           varchar(32) not null,
  trade_no                      varchar(50),
  source_gid                    varchar(32),
  target_gid                    varchar(32),
  amount                        decimal(65,2),
  status                        integer(10),
  remark                        varchar(50),
  create_at                     datetime(6) not null,
  create_by                     varchar(50) not null,
  modify_at                     datetime(6) not null,
  modify_by                     varchar(50) not null,
  constraint pk_trans_record primary key (gid)
);

