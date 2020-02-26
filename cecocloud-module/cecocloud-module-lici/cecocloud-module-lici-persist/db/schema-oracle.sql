create table tlic_config (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    filcpv varchar2(1000 char),
    filprv varchar2(1000 char),
    sinact number(1,0) not null,
    empresa_id number(19,0) not null,
    primary key (id)
);

create table tlic_cpv (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(10 char) not null,
    descripcio varchar2(255 char) not null,
    licitacio_id number(19,0) not null,
    primary key (id)
);

create table tlic_document (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(5 char) not null,
    hash varchar2(30 char) not null,
    nom varchar2(200 char) not null,
    tipus number(10,0) not null,
    uri varchar2(255 char) not null,
    licitacio_id number(19,0) not null,
    primary key (id)
);

create table tlic_licitacio (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    codi varchar2(200 char) not null,
    datact timestamp not null,
    datlim timestamp,
    destac number(1,0) not null,
    esborr number(1,0) not null,
    expest varchar2(4 char) not null,
    expeds varchar2(100 char) not null,
    expid varchar2(100 char) not null,
    nota varchar2(2000 char),
    prctip varchar2(3 char) not null,
    prctds varchar2(1000 char) not null,
    impnot number(17,2) not null,
    imptot number(17,2) not null,
    mon varchar2(3 char) not null,
    paicod varchar2(2 char),
    paides varchar2(200 char),
    prvcod varchar2(5 char),
    prvdes varchar2(200 char),
    prjsub varchar2(4 char),
    prjsds varchar2(1000 char),
    terexn number(10,0),
    terexu varchar2(3 char),
    prjtip varchar2(4 char) not null,
    prjtds varchar2(1000 char) not null,
    prjtit varchar2(2000 char) not null,
    resum varchar2(500 char) not null,
    unidi3 varchar2(9 char),
    uninom varchar2(200 char) not null,
    unitip varchar2(2 char) not null,
    unitds varchar2(100 char) not null,
    urgtip varchar2(2 char) not null,
    urgtds varchar2(1000 char) not null,
    uri varchar2(255 char) not null,
    url varchar2(200 char) not null,
    empresa_id number(19,0) not null,
    primary key (id)
);

alter table tlic_config 
   add constraint configuracio_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table tlic_cpv 
   add constraint cpv_licitacio_fk 
   foreign key (licitacio_id) 
   references tlic_licitacio;

alter table tlic_document 
   add constraint document_licitacio_fk 
   foreign key (licitacio_id) 
   references tlic_licitacio;

alter table tlic_licitacio 
   add constraint licitacio_empresa_fk 
   foreign key (empresa_id) 
   references empresa;
