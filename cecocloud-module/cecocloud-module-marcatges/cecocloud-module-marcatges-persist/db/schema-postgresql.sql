create table cpktest (
   codi varchar(16) not null,
    empresa_id int8 not null,
    usuari_id int8 not null,
    version int8 not null,
    descripcio varchar(100),
    primary key (codi, empresa_id, usuari_id)
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

alter table cpktest 
   add constraint cpktest_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table cpktest 
   add constraint cpktest_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

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
