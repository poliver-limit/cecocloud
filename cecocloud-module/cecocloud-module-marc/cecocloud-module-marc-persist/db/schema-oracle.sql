create table marcatge (
   id number(19,0) not null,
    created_by varchar2(64 char) not null,
    created_date timestamp not null,
    lastmod_by varchar2(64 char),
    lastmod_date timestamp,
    version number(19,0) not null,
    data timestamp not null,
    latitud number(12,8),
    longitud number(12,8),
    origen number(10,0) not null,
    operariemp_id number(19,0) not null,
    primary key (id)
);

alter table marcatge 
   add constraint marcatge_operariemp_fk 
   foreign key (operariemp_id) 
   references operari_empresa;
