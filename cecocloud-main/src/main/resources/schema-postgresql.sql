create sequence hibernate_sequence start 1 increment 1;

create table companyia (
   id int8 not null,
    version int8 not null,
    codi varchar(30) not null,
    nom varchar(30) not null,
    primary key (id)
);

create table empresa (
   id int8 not null,
    version int8 not null,
    activa boolean not null,
    codi varchar(30) not null,
    identificador_codi varchar(4) not null,
    nif varchar(12) not null,
    nom varchar(30) not null,
    companyia_id int8,
    primary key (id)
);

create table marcatge (
   id int8 not null,
    version int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    data timestamp not null,
    latitud float8,
    longitud float8,
    origen int4 not null,
    operari_id int8 not null,
    primary key (id)
);

create table operari (
   id int8 not null,
    version int8 not null,
    codi varchar(6) not null,
    data_fi timestamp,
    data_inici timestamp not null,
    empresa_id int8,
    usuari_id int8,
    primary key (id)
);

create table usuari (
   id int8 not null,
    version int8 not null,
    actiu boolean,
    codi varchar(64) not null,
    contrasenya varchar(255),
    email varchar(100) not null,
    imatge_url varchar(255),
    nom varchar(100) not null,
    validat boolean,
    primary key (id)
);

create table usuari_rols (
   usuari_id int8 not null,
    rol varchar(10)
);

alter table usuari 
   add constraint usuari_codi_uk unique (codi);

alter table usuari 
   add constraint usuari_email_uk unique (email);

alter table empresa 
   add constraint empresa_companyia_fk 
   foreign key (companyia_id) 
   references companyia;

alter table marcatge 
   add constraint marcatge_operari_fk 
   foreign key (operari_id) 
   references operari;

alter table operari 
   add constraint operari_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table operari 
   add constraint operari_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_rols 
   add constraint usurol_usuari_fk 
   foreign key (usuari_id) 
   references usuari; 

create table acl_sid(
    id bigserial not null primary key,
    principal boolean not null,
    sid varchar(100) not null,
    constraint aclsid_uk unique(sid,principal)
);

create table acl_class(
    id bigserial not null primary key,
    class varchar(100) not null,
    constraint aclclass_uk unique(class)
);

create table acl_object_identity(
    id bigserial primary key,
    object_id_class bigint not null,
    object_id_identity varchar(36) not null,
    parent_object bigint,
    owner_sid bigint,
    entries_inheriting boolean not null,
    constraint acloid_uk unique(object_id_class,object_id_identity),
    constraint acloid_acloid_fk_1 foreign key(parent_object)references acl_object_identity(id),
    constraint acloid_aclclass_fk_2 foreign key(object_id_class)references acl_class(id),
    constraint acloid_aclsid_fk_3 foreign key(owner_sid)references acl_sid(id)
);

create table acl_entry(
    id bigserial primary key,
    acl_object_identity bigint not null,
    ace_order int not null,
    sid bigint not null,
    mask integer not null,
    granting boolean not null,
    audit_success boolean not null,
    audit_failure boolean not null,
    constraint aclentry_uk unique(acl_object_identity,ace_order),
    constraint aclentry_acloid_fk foreign key(acl_object_identity) references acl_object_identity(id),
    constraint aclentry_aclsid_fk foreign key(sid) references acl_sid(id)
);
