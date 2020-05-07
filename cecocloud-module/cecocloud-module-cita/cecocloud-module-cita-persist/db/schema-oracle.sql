create table tcec_cit (
   cit_cod varchar2(10 char) not null,
    cit_ptv_cod varchar2(4 char) not null,
    cit_emp_cod varchar2(4 char) not null,
    cit_idf_cod varchar2(4 char) not null,
    cit_usucre varchar2(255 char),
    cit_datcre timestamp,
    cit_usumod varchar2(255 char),
    cit_datmod timestamp,
    cit_data date not null,
    primary key (cit_cod, cit_ptv_cod, cit_emp_cod, cit_idf_cod)
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
    fes_diames date,
    fes_nom varchar2(255 char) not null,
    primary key (fes_gfe_cod, fes_seq, fes_idf_cod)
);

create table tcec_gfe (
   gfe_cod varchar2(4 char) not null,
    gfe_idf_cod varchar2(4 char) not null,
    gfe_usucre varchar2(255 char),
    gfe_datcre timestamp,
    gfe_usumod varchar2(255 char),
    gfe_datmod timestamp,
    gfe_nom varchar2(100 char) not null,
    primary key (gfe_cod, gfe_idf_cod)
);

create table tcec_hor (
   hor_cod varchar2(4 char) not null,
    hor_idf_cod varchar2(4 char) not null,
    hor_usucre varchar2(255 char),
    hor_datcre timestamp,
    hor_usumod varchar2(255 char),
    hor_datmod timestamp,
    hor_nom varchar2(100 char) not null,
    primary key (hor_cod, hor_idf_cod)
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
    primary key (hpv_hor_cod, hpv_ptv_cod, hpv_emp_cod, hpv_idf_cod)
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
    primary key (ihr_hor_cod, ihr_seq, ihr_idf_cod)
);

create index icec_cit_idf_fk on tcec_cit (cit_idf_cod);

alter table tcec_cit 
   add constraint ircec_cit_pk unique (cit_idf_cod, cit_ptv_cod, cit_cod);
create index icec_fes_idf_fk on tcec_fes (fes_idf_cod);
create index icec_fes_fgr_fk on tcec_fes (fes_idf_cod, fes_gfe_cod);

alter table tcec_fes 
   add constraint ircec_fes_pk unique (fes_idf_cod, fes_seq);
create index icec_gfe_idf_fk on tcec_gfe (gfe_idf_cod);
create index icec_hor_idf_fk on tcec_hor (hor_idf_cod);
create index icec_hpv_idf_fk on tcec_hpv (hpv_idf_cod);
create index icec_hpv_emp_fk on tcec_hpv (hpv_idf_cod, hpv_emp_cod);
create index icec_hpv_ptv_fk on tcec_hpv (hpv_idf_cod, hpv_emp_cod, hpv_ptv_cod);
create index icec_hpv_hor_fk on tcec_hpv (hpv_idf_cod, hpv_hor_cod);
create index icec_ihr_idf_fk on tcec_ihr (ihr_idf_cod);
create index icec_ihr_hor_fk on tcec_ihr (ihr_idf_cod, ihr_hor_cod);

alter table tcec_ihr 
   add constraint ircec_ihr_pk unique (ihr_idf_cod, ihr_seq);

alter table tcec_cit 
   add constraint rges_cit_idf_fk 
   foreign key (cit_idf_cod) 
   references tges_idf;

alter table tcec_cit 
   add constraint cit_emp_cod_fk 
   foreign key (cit_emp_cod, cit_idf_cod) 
   references tges_emp;

alter table tcec_cit 
   add constraint cit_ptv_cod_fk 
   foreign key (cit_emp_cod, cit_ptv_cod, cit_idf_cod) 
   references tges_ptv;

alter table tcec_fes 
   add constraint rges_fes_idf_fk 
   foreign key (fes_idf_cod) 
   references tges_idf;

alter table tcec_fes 
   add constraint fes_gfe_cod_fk 
   foreign key (fes_gfe_cod, fes_idf_cod) 
   references tcec_gfe;

alter table tcec_gfe 
   add constraint rges_gfe_idf_fk 
   foreign key (gfe_idf_cod) 
   references tges_idf;

alter table tcec_hor 
   add constraint rges_hor_idf_fk 
   foreign key (hor_idf_cod) 
   references tges_idf;

alter table tcec_hpv 
   add constraint rges_hpv_idf_fk 
   foreign key (hpv_idf_cod) 
   references tges_idf;

alter table tcec_hpv 
   add constraint hpv_emp_cod_fk 
   foreign key (hpv_emp_cod, hpv_idf_cod) 
   references tges_emp;

alter table tcec_hpv 
   add constraint hpv_hor_cod_fk 
   foreign key (hpv_hor_cod, hpv_idf_cod) 
   references tcec_hor;

alter table tcec_hpv 
   add constraint hpv_ptv_cod_fk 
   foreign key (hpv_emp_cod, hpv_ptv_cod, hpv_idf_cod) 
   references tges_ptv;

alter table tcec_ihr 
   add constraint rges_ihr_idf_fk 
   foreign key (ihr_idf_cod) 
   references tges_idf;

alter table tcec_ihr 
   add constraint ihr_hor_cod_fk 
   foreign key (ihr_hor_cod, ihr_idf_cod) 
   references tcec_hor;