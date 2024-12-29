create table c_security_permission
(
    created          timestamp(6) not null,
    modified         timestamp(6),
    id               varchar(36)  not null,
    created_by       varchar(100) not null,
    modified_by      varchar(100),
    permission_label varchar(100) not null,
    permission_value varchar(100) not null,
    primary key (id)
);
create table c_security_role
(
    created     timestamp(6) not null,
    modified    timestamp(6),
    name        varchar(15)  not null unique,
    id          varchar(36)  not null,
    created_by  varchar(100) not null,
    description varchar(100),
    modified_by varchar(100),
    user_type   varchar(255) not null check (user_type in ('ADMIN', 'MEMBER')),
    primary key (id)
);
create table c_security_role_permission
(
    id_permission VARCHAR(36) not null,
    id_role       VARCHAR(36) not null,
    primary key (id_permission, id_role)
);
create table c_security_user
(
    active      boolean      not null,
    created     timestamp(6) not null,
    modified    timestamp(6),
    phone       varchar(15)  not null,
    id          varchar(36)  not null,
    id_role     varchar(36)  not null,
    email       varchar(50)  not null,
    username    varchar(50)  not null,
    created_by  varchar(100) not null,
    modified_by varchar(100),
    primary key (id)
);
create table c_security_user_password
(
    created       timestamp(6) not null,
    modified      timestamp(6),
    id_user       varchar(36)  not null,
    created_by    varchar(100) not null,
    modified_by   varchar(100),
    user_password varchar(255) not null,
    primary key (id_user)
);
create table member
(
    created         timestamp(6) not null,
    modified        timestamp(6),
    id              varchar(36)  not null,
    id_user         varchar(36)  not null unique,
    first_name      varchar(50)  not null,
    last_name       varchar(50)  not null,
    created_by      varchar(100) not null,
    modified_by     varchar(100),
    address         varchar(255),
    img_profile_url varchar(255),
    primary key (id)
);
create table order_products
(
    id_order   varchar(36) not null,
    id_product varchar(36) not null
);
create table payment
(
    amount         numeric(38, 2),
    payment_method smallint check (payment_method between 0 and 3),
    payment_type   smallint check (payment_type between 0 and 1),
    created        timestamp(6) not null,
    modified       timestamp(6),
    id             varchar(36)  not null,
    id_order       varchar(36)  not null unique,
    created_by     varchar(100) not null,
    modified_by    varchar(100),
    primary key (id)
);
create table product
(
    price               numeric(38, 2),
    created             timestamp(6) not null,
    modified            timestamp(6),
    id                  varchar(36)  not null,
    id_product_category varchar(36)  not null,
    created_by          varchar(100) not null,
    modified_by         varchar(100),
    description         varchar(255),
    name                varchar(255),
    primary key (id)
);
create table product_category
(
    created     timestamp(6) not null,
    modified    timestamp(6),
    id          varchar(36)  not null,
    created_by  varchar(100) not null,
    modified_by varchar(100),
    description varchar(255),
    name        varchar(255),
    primary key (id)
);
create table t_order
(
    order_status smallint check (order_status between 0 and 4),
    created      timestamp(6) not null,
    modified     timestamp(6),
    id           varchar(36)  not null,
    user_id      varchar(36),
    created_by   varchar(100) not null,
    modified_by  varchar(100),
    primary key (id)
);
alter table if exists c_security_role_permission
    add constraint FKnqcv2qdac1phe20qqnyi6n1n
    foreign key (id_permission)
    references c_security_permission;
alter table if exists c_security_role_permission
    add constraint FKg9os4isbs19ssfahravousxes
    foreign key (id_role)
    references c_security_role;
alter table if exists c_security_user
    add constraint FKe5ychpyk27l8vj47v36mrn0s1
    foreign key (id_role)
    references c_security_role;
alter table if exists c_security_user_password
    add constraint FK80arji7i1u0styufcy8b91it5
    foreign key (id_user)
    references c_security_user;
alter table if exists member
    add constraint FKothgssjhv3mgcxwd2dvhp6y6e
    foreign key (id_user)
    references c_security_user;
alter table if exists order_products
    add constraint FKnxkyb5u37scbltishlxv3s6kg
    foreign key (id_product)
    references product;
alter table if exists order_products
    add constraint FK8kfokfsi4t00iq1r3iudf8fbs
    foreign key (id_order)
    references t_order;
alter table if exists payment
    add constraint FKpbhwy06s9d0vql020ku56fk5r
    foreign key (id_order)
    references t_order;
alter table if exists product
    add constraint FKaym5xd86w6d803rgywi633we9
    foreign key (id_product_category)
    references product_category;
alter table if exists t_order
    add constraint FK8amx0rlf5k4b9y5lkx7febhkp
    foreign key (user_id)
    references c_security_user;