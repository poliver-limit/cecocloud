
create table tlic_config (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    filcpv varchar(1000),
    filprv varchar(1000),
    sinact boolean not null,
    empresa_id int8 not null,
    primary key (id)
);

create table tlic_cpv (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(10) not null,
    descripcio varchar(255) not null,
    licitacio_id int8 not null,
    primary key (id)
);

create table tlic_document (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(5) not null,
    hash varchar(30) not null,
    nom varchar(200) not null,
    tipus int4 not null,
    uri varchar(255) not null,
    licitacio_id int8 not null,
    primary key (id)
);

create table tlic_licitacio (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(200) not null,
    datact timestamp not null,
    datlim timestamp,
    destac boolean not null,
    esborr boolean not null,
    expest varchar(4) not null,
    expeds varchar(100) not null,
    expid varchar(100) not null,
    nota varchar(2000) not null,
    prctip varchar(3) not null,
    prctds varchar(1000) not null,
    impnot numeric(17, 2) not null,
    imptot numeric(17, 2) not null,
    mon varchar(3) not null,
    paicod varchar(2),
    paides varchar(200),
    prvcod varchar(5),
    prvdes varchar(200),
    prjsub varchar(4),
    prjsds varchar(1000),
    terexn int4,
    terexu varchar(3),
    prjtip varchar(4) not null,
    prjtds varchar(1000) not null,
    prjtit varchar(2000) not null,
    resum varchar(500) not null,
    unidi3 varchar(9),
    uninom varchar(200) not null,
    unitip varchar(2) not null,
    unitds varchar(100) not null,
    urgtip varchar(2) not null,
    urgtds varchar(1000) not null,
    uri varchar(255) not null,
    url varchar(200) not null,
    empresa_id int8 not null,
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
