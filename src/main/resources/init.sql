alter table comment
    drop foreign key FKihmv7q173gqi1xqgtsvw4s96m;
alter table comment
    drop foreign key FK8kcum44fvpupyw6f5baccx25c;
alter table item
    drop foreign key FK1rysna9so6qhvewuv59vest5f;
alter table item
    drop foreign key FKh4epdoqikj4sfedlxcc9dwwnl;
alter table item_images
    drop foreign key FKbblr4qy805jfsx4aiy1uww0mb;
alter table order_info
    drop foreign key FKaqunpnslcpdu5kq4bqfmxb3jk;
alter table order_info
    drop foreign key FKr03nihk9hdy36c9ckypjqb5v5;
alter table wallet
    drop foreign key FKbs4ogwiknsup4rpw8d47qw9dx;

drop table if exists comment;
drop table if exists item;
drop table if exists item_category;
drop table if exists item_images;
drop table if exists order_info;
drop table if exists user;
drop table if exists wallet;

create table comment
(
    id      integer not null auto_increment,
    msg     varchar(255),
    item_id integer,
    user_id integer,
    primary key (id)
) engine = InnoDB;

create table item
(
    id            integer not null auto_increment,
    auto_delivery varchar(255),
    info          varchar(255),
    is_del        boolean default false,
    origin_price  decimal(19, 2),
    postage       decimal(19, 2),
    price         decimal(19, 2),
    primary_img   varchar(255),
    star          integer,
    state         integer,
    subtitle      varchar(255),
    title         varchar(255),
    type          integer,
    category_id   integer,
    user_id       integer,
    primary key (id)
) engine = InnoDB;

create table item_category
(
    id   integer     not null auto_increment,
    name varchar(12) not null,
    primary key (id)
) engine = InnoDB;

create table item_images
(
    id      integer not null auto_increment,
    url     varchar(255),
    item_id integer,
    primary key (id)
) engine = InnoDB;

create table order_info
(
    id          integer not null auto_increment,
    create_time bigint,
    type        integer,
    buyer_id    integer,
    item_id     integer,
    primary key (id)
) engine = InnoDB;

create table user
(
    id           integer     not null auto_increment,
    create_time  bigint,
    dis_like_num integer,
    last_address varchar(255),
    last_login   bigint,
    like_num     integer,
    mail         varchar(32) not null,
    nick         varchar(16) not null,
    password     varchar(32) not null,
    privilege    integer,
    sell_address varchar(255),
    tel          varchar(11) not null,
    token        varchar(255),
    primary key (id)
) engine = InnoDB;

create table wallet
(
    id      integer not null auto_increment,
    balance decimal(19, 2),
    type    integer,
    user_id integer,
    primary key (id)
) engine = InnoDB;

alter table item_category
    add constraint UK_ptp2vsy48po6d9fl9ma80xula unique (name);
alter table user
    add constraint UK_nbfia2ok6c7at4i0er6uyskkx unique (tel);
alter table user
    add constraint UK_mtqx5podr73c7h25y9qqu96x2 unique (token);
alter table comment
    add constraint FKihmv7q173gqi1xqgtsvw4s96m foreign key (item_id) references item (id);
alter table comment
    add constraint FK8kcum44fvpupyw6f5baccx25c foreign key (user_id) references user (id);
alter table item
    add constraint FK1rysna9so6qhvewuv59vest5f foreign key (category_id) references item_category (id);
alter table item
    add constraint FKh4epdoqikj4sfedlxcc9dwwnl foreign key (user_id) references user (id);
alter table item_images
    add constraint FKbblr4qy805jfsx4aiy1uww0mb foreign key (item_id) references item (id);
alter table order_info
    add constraint FKaqunpnslcpdu5kq4bqfmxb3jk foreign key (buyer_id) references user (id);
alter table order_info
    add constraint FKr03nihk9hdy36c9ckypjqb5v5 foreign key (item_id) references item (id);
alter table wallet
    add constraint FKbs4ogwiknsup4rpw8d47qw9dx foreign key (user_id) references user (id);
