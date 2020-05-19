create table tcec_cit (
   cit_ptv_cod varchar(4) not null,
    cit_seq int4 not null,
    cit_emp_cod varchar(4) not null,
    cit_idf_cod varchar(4) not null,
    cit_usucre varchar(255),
    cit_datcre timestamp,
    cit_usumod varchar(255),
    cit_datmod timestamp,
    cit_anudat timestamp,
    cit_cod varchar(34) not null,
    cit_dat timestamp not null,
    cit_eml varchar(100),
    cit_lng varchar(100) not null,
    cit_nom varchar(100) not null,
    cit_tel varchar(15) not null,
    constraint rcec_cit_pk primary key (cit_ptv_cod, cit_seq, cit_emp_cod, cit_idf_cod)
);

create table tcec_fes (
   fes_gfe_cod varchar(4) not null,
    fes_seq int4 not null,
    fes_idf_cod varchar(4) not null,
    fes_usucre varchar(255),
    fes_datcre timestamp,
    fes_usumod varchar(255),
    fes_datmod timestamp,
    fes_any int4,
    fes_diames date not null,
    fes_nom varchar(255) not null,
    constraint rcec_fes_pk primary key (fes_gfe_cod, fes_seq, fes_idf_cod)
);

create table tcec_gfe (
   gfe_cod varchar(4) not null,
    gfe_idf_cod varchar(4) not null,
    gfe_usucre varchar(255),
    gfe_datcre timestamp,
    gfe_usumod varchar(255),
    gfe_datmod timestamp,
    gfe_nom varchar(100) not null,
    constraint rcec_gfe_pk primary key (gfe_cod, gfe_idf_cod)
);

create table tcec_hor (
   hor_cod varchar(4) not null,
    hor_idf_cod varchar(4) not null,
    hor_usucre varchar(255),
    hor_datcre timestamp,
    hor_usumod varchar(255),
    hor_datmod timestamp,
    hor_datfin date not null,
    hor_datini date not null,
    hor_nom varchar(100) not null,
    constraint rcec_hor_pk primary key (hor_cod, hor_idf_cod)
);

create table tcec_hpv (
   hpv_hor_cod varchar(4) not null,
    hpv_ptv_cod varchar(4) not null,
    hpv_emp_cod varchar(4) not null,
    hpv_idf_cod varchar(4) not null,
    hpv_usucre varchar(255),
    hpv_datcre timestamp,
    hpv_usumod varchar(255),
    hpv_datmod timestamp,
    constraint rcec_hpv_pk primary key (hpv_hor_cod, hpv_ptv_cod, hpv_emp_cod, hpv_idf_cod)
);

create table tcec_ihr (
   ihr_hor_cod varchar(4) not null,
    ihr_seq int4 not null,
    ihr_idf_cod varchar(4) not null,
    ihr_usucre varchar(255),
    ihr_datcre timestamp,
    ihr_usumod varchar(255),
    ihr_datmod timestamp,
    ihr_diaset int4 not null,
    ihr_horfi time not null,
    ihr_horini time not null,
    constraint rcec_ihr_pk primary key (ihr_hor_cod, ihr_seq, ihr_idf_cod)
);

create index icec_cit_ptv_fk on tcec_cit (cit_idf_cod, cit_emp_cod, cit_ptv_cod);
create index icec_fes_fgr_fk on tcec_fes (fes_idf_cod, fes_gfe_cod);
create index icec_gfe_idf_fk on tcec_gfe (gfe_idf_cod);
create index icec_hor_idf_fk on tcec_hor (hor_idf_cod);
create index icec_hpv_ptv_fk on tcec_hpv (hpv_idf_cod, hpv_emp_cod, hpv_ptv_cod);
create index icec_hpv_hor_fk on tcec_hpv (hpv_idf_cod, hpv_hor_cod);
create index icec_ihr_hor_fk on tcec_ihr (ihr_idf_cod, ihr_hor_cod);

alter table tcec_cit 
   add constraint rcec_cit_ptv_fk 
   foreign key (cit_idf_cod, cit_emp_cod, cit_ptv_cod) 
   references tges_ptv (ptv_idf_cod, ptv_emp_cod, ptv_cod);

alter table tcec_fes 
   add constraint rcec_fes_gfe_fk 
   foreign key (fes_gfe_cod, fes_idf_cod) 
   references tcec_gfe;

alter table tcec_hpv 
   add constraint rcec_hpv_hor_fk 
   foreign key (hpv_hor_cod, hpv_idf_cod) 
   references tcec_hor;

alter table tcec_hpv 
   add constraint rcec_hpv_ptv_fk 
   foreign key (hpv_idf_cod, hpv_emp_cod, hpv_ptv_cod) 
   references tges_ptv (ptv_idf_cod, ptv_emp_cod, ptv_cod);

alter table tcec_ihr 
   add constraint rcec_ihr_hor_fk 
   foreign key (ihr_hor_cod, ihr_idf_cod) 
   references tcec_hor;

alter table tges_ptv
	add column ptv_citact varchar(1),
	add column ptv_citintmin int4,
	add column ptv_citnumpla int4,
	add column ptv_gfe_cod varchar(4);

alter table tges_ptv 
   add constraint rges_ptv_gfe_fk 
   foreign key (ptv_idf_cod, ptv_gfe_cod) 
   references tcec_gfe;