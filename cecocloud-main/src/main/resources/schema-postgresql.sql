create sequence hibernate_sequence start 1 increment 1;

create table agrupacio (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(8) not null,
    descripcio varchar(100) not null,
    modul varchar(4) not null,
    pare_id int8 not null,
    primary key (id)
);

create table agrupacio_ident (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    agrupacio_id int8 not null,
    identificador_id int8 not null,
    primary key (id)
);

create table empresa (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    activa boolean not null,
    codi varchar(4) not null,
    nif varchar(12) not null,
    nom varchar(30) not null,
    tipus int4 not null,
    identificador_id int8 not null,
    primary key (id)
);

create table funcionalitat (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(8) not null,
    descripcio varchar(100) not null,
    modul varchar(4) not null,
    pare_id int8 not null,
    primary key (id)
);

create table funcionalitat_ident (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    funcionalitat_id int8 not null,
    identificador_id int8 not null,
    primary key (id)
);

create table funcionalitat_perfil (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    permis varchar(20) not null,
    funcionalitat_id int8 not null,
    perfil_id int8 not null,
    primary key (id)
);

create table funcionalitat_recurs (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    principal boolean not null,
    resource_classname varchar(100) not null,
    funcionalitat_id int8 not null,
    primary key (id)
);

create table identificador (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(255),
    data_fi timestamp not null,
    data_inici timestamp not null,
    descripcio varchar(40) not null,
    llicencia varchar(2000) not null,
    llicencia_ok boolean not null,
    num_empreses int4 not null,
    num_operaris int4 not null,
    num_usuaris int4 not null,
    propietari_id int8 not null,
    primary key (id)
);

create table perfil (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(10) not null,
    descripcio varchar(100) not null,
    identificador_id int8 not null,
    primary key (id)
);

create table perfil_usuidentemp (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    perfil_id int8 not null,
    usuidentemp_id int8 not null,
    primary key (id)
);

create table usuari (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean not null,
    codi varchar(64) not null,
    contrasenya varchar(255),
    email varchar(100) not null,
    imatge_url varchar(255),
    llinatges varchar(100) not null,
    nom varchar(100) not null,
    validat boolean not null,
    primary key (id)
);

create table usuari_authority (
   usuari_id int8 not null,
    rol varchar(10)
);

create table usuari_ident (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    identificador_id int8 not null,
    usuari_id int8 not null,
    primary key (id)
);

create table usuari_ident_empresa (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    empresa_id int8 not null,
    usuident_id int8 not null,
    primary key (id)
);

alter table agrupacio 
   add constraint agrupacio_uk unique (codi, modul);

alter table agrupacio_ident 
   add constraint agrupident_uk unique (agrupacio_id, identificador_id);

alter table empresa 
   add constraint empresa_uk unique (identificador_id, codi);

alter table funcionalitat 
   add constraint funcionalitat_uk unique (codi, modul);

alter table funcionalitat_ident 
   add constraint funcident_uk unique (funcionalitat_id, identificador_id);

alter table funcionalitat_perfil 
   add constraint funcperf_uk unique (funcionalitat_id, perfil_id);

alter table funcionalitat_recurs 
   add constraint funcrecu_uk unique (funcionalitat_id, resource_classname);

alter table perfil 
   add constraint perfil_uk unique (identificador_id, codi);

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_uk unique (perfil_id, usuidentemp_id);

alter table usuari 
   add constraint usuari_codi_uk unique (codi);

alter table usuari 
   add constraint usuari_email_uk unique (email);

alter table usuari_ident 
   add constraint usuident_uk unique (usuari_id, identificador_id);

alter table usuari_ident_empresa 
   add constraint usuidentemp_uk unique (usuident_id, empresa_id);

alter table agrupacio 
   add constraint agrupacio_pare_fk 
   foreign key (pare_id) 
   references agrupacio;

alter table agrupacio_ident 
   add constraint agrupident_agrupacio_fk 
   foreign key (agrupacio_id) 
   references agrupacio;

alter table agrupacio_ident 
   add constraint agrupident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table empresa 
   add constraint empresa_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table funcionalitat 
   add constraint funcionalitat_pare_fk 
   foreign key (pare_id) 
   references funcionalitat;

alter table funcionalitat_ident 
   add constraint funcident_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table funcionalitat_ident 
   add constraint funcident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table funcionalitat_perfil 
   add constraint funcperf_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table funcionalitat_perfil 
   add constraint funcperf_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table funcionalitat_recurs 
   add constraint funcrecu_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table identificador 
   add constraint identificador_propietari_fk 
   foreign key (propietari_id) 
   references usuari;

alter table perfil 
   add constraint perfil_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_usuidentemp_fk 
   foreign key (usuidentemp_id) 
   references usuari_ident_empresa;

alter table usuari_authority 
   add constraint usuaut_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_ident 
   add constraint usuident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table usuari_ident 
   add constraint usuident_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_ident_empresa 
   add constraint usuidentemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table usuari_ident_empresa 
   add constraint usuidentemp_usuidf_fk 
   foreign key (usuident_id) 
   references usuari_ident;

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
