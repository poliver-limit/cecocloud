create table marcatge (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    data timestamp not null,
    latitud float8,
    longitud float8,
    origen int4 not null,
    operariemp_id int8 not null,
    primary key (id)
);

alter table marcatge 
   add constraint marcatge_operariemp_fk 
   foreign key (operariemp_id) 
   references operari_empresa;
