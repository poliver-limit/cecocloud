create table tcec_cit (
   cit_ptv_cod varchar2(4 char) not null,
    cit_seq number(10,0) not null,
    cit_emp_cod varchar2(4 char) not null,
    cit_idf_cod varchar2(4 char) not null,
    cit_usucre varchar2(255 char),
    cit_datcre timestamp,
    cit_usumod varchar2(255 char),
    cit_datmod timestamp,
    cit_anudat timestamp,
    cit_cod varchar2(34 char) not null,
    cit_dat timestamp not null,
    cit_nom varchar2(100 char) not null,
    cit_lng varchar2(100 char) not null,
    cit_tel varchar2(15 char) not null,
    cit_eml varchar2(100 char),
    constraint rcec_cit_pk primary key (cit_idf_cod, cit_emp_cod, cit_ptv_cod, cit_seq)
);

create table tcec_fes (
   fes_gfe_cod varchar2(4 char) not null,
    fes_seq number(10,0) not null,
    fes_idf_cod varchar2(4 char) not null,
    fes_usucre varchar2(255 char),
    fes_datcre timestamp,
    fes_usumod varchar2(255 char),
    fes_datmod timestamp,
    fes_any number(10,0),
    fes_diames date not null,
    fes_nom varchar2(255 char) not null,
    constraint rcec_fes_pk primary key (fes_idf_cod, fes_gfe_cod, fes_seq)
);

create table tcec_gfe (
   gfe_cod varchar2(4 char) not null,
    gfe_idf_cod varchar2(4 char) not null,
    gfe_usucre varchar2(255 char),
    gfe_datcre timestamp,
    gfe_usumod varchar2(255 char),
    gfe_datmod timestamp,
    gfe_nom varchar2(100 char) not null,
    constraint rcec_gfe_pk primary key (gfe_idf_cod, gfe_cod)
);

create table tcec_hor (
   hor_cod varchar2(4 char) not null,
    hor_idf_cod varchar2(4 char) not null,
    hor_usucre varchar2(255 char),
    hor_datcre timestamp,
    hor_usumod varchar2(255 char),
    hor_datmod timestamp,
    hor_datfin date not null,
    hor_datini date not null,
    hor_nom varchar2(100 char) not null,
    constraint rcec_hor_pk primary key (hor_idf_cod, hor_cod)
);

create table tcec_hpv (
   hpv_hor_cod varchar2(4 char) not null,
    hpv_ptv_cod varchar2(4 char) not null,
    hpv_emp_cod varchar2(4 char) not null,
    hpv_idf_cod varchar2(4 char) not null,
    hpv_usucre varchar2(255 char),
    hpv_datcre timestamp,
    hpv_usumod varchar2(255 char),
    hpv_datmod timestamp,
    constraint rcec_hpv_pk primary key (hpv_idf_cod, hpv_emp_cod, hpv_hor_cod, hpv_ptv_cod)
);

create table tcec_ihr (
   ihr_hor_cod varchar2(4 char) not null,
    ihr_seq number(10,0) not null,
    ihr_idf_cod varchar2(4 char) not null,
    ihr_usucre varchar2(255 char),
    ihr_datcre timestamp,
    ihr_usumod varchar2(255 char),
    ihr_datmod timestamp,
    ihr_diaset number(10,0) not null,
    ihr_horfi date not null,
    ihr_horini date not null,
    constraint rcec_ihr_pk primary key (ihr_idf_cod, ihr_hor_cod, ihr_seq)
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
   foreign key (fes_idf_cod, fes_gfe_cod) 
   references tcec_gfe;

alter table tcec_hpv 
   add constraint rcec_hpv_hor_fk 
   foreign key (hpv_idf_cod, hpv_hor_cod) 
   references tcec_hor;

alter table tcec_hpv 
   add constraint rcec_hpv_ptv_fk 
   foreign key (hpv_idf_cod, hpv_emp_cod, hpv_ptv_cod) 
   references tges_ptv (ptv_idf_cod, ptv_emp_cod, ptv_cod);

alter table tcec_ihr 
   add constraint rcec_ihr_hor_fk 
   foreign key (ihr_idf_cod, ihr_hor_cod) 
   references tcec_hor;
