create table tcit_cit (
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

create table tcit_fes (
   fes_fgr_cod varchar2(4 char) not null,
    fes_seq number(10,0) not null,
    fes_idf_cod varchar2(4 char) not null,
    fes_usucre varchar2(255 char),
    fes_datcre timestamp,
    fes_usumod varchar2(255 char),
    fes_datmod timestamp,
    any number(10,0),
    diaMes date,
    fes_nom varchar2(255 char) not null,
    primary key (fes_fgr_cod, fes_seq, fes_idf_cod)
);

create table tcit_fgr (
   fgr_cod varchar2(4 char) not null,
    fgr_idf_cod varchar2(4 char) not null,
    fgr_usucre varchar2(255 char),
    fgr_datcre timestamp,
    fgr_usumod varchar2(255 char),
    fgr_datmod timestamp,
    fgr_nom varchar2(100 char) not null,
    primary key (fgr_cod, fgr_idf_cod)
);

create table tcit_hoi (
   hoi_hor_cod varchar2(4 char) not null,
    hoi_seq number(10,0) not null,
    hoi_idf_cod varchar2(4 char) not null,
    hoi_usucre varchar2(255 char),
    hoi_datcre timestamp,
    hoi_usumod varchar2(255 char),
    hoi_datmod timestamp,
    hoi_diaset number(10,0) not null,
    hoi_horfi date not null,
    hoi_horini date not null,
    primary key (hoi_hor_cod, hoi_seq, hoi_idf_cod)
);

create table tcit_hor (
   hor_cod varchar2(4 char) not null,
    hor_idf_cod varchar2(4 char) not null,
    hor_usucre varchar2(255 char),
    hor_datcre timestamp,
    hor_usumod varchar2(255 char),
    hor_datmod timestamp,
    hor_nom varchar2(100 char) not null,
    primary key (hor_cod, hor_idf_cod)
);

create table tcit_pvh (
   pvh_hor_cod varchar2(4 char) not null,
    pvh_ptv_cod varchar2(4 char) not null,
    pvh_emp_cod varchar2(4 char) not null,
    pvh_idf_cod varchar2(4 char) not null,
    pvh_usucre varchar2(255 char),
    pvh_datcre timestamp,
    pvh_usumod varchar2(255 char),
    pvh_datmod timestamp,
    primary key (pvh_hor_cod, pvh_ptv_cod, pvh_emp_cod, pvh_idf_cod)
);

create index icit_cit_idf_fk on tcit_cit (cit_idf_cod);

alter table tcit_cit 
   add constraint ircit_cit_pk unique (cit_idf_cod, cit_ptv_cod, cit_cod);
create index icit_fes_idf_fk on tcit_fes (fes_idf_cod);
create index icit_fes_fgr_fk on tcit_fes (fes_idf_cod, fes_fgr_cod);

alter table tcit_fes 
   add constraint ircit_fes_pk unique (fes_idf_cod, fes_seq);
create index icit_fgr_idf_fk on tcit_fgr (fgr_idf_cod);
create index icit_hoi_idf_fk on tcit_hoi (hoi_idf_cod);
create index icit_hoi_hor_fk on tcit_hoi (hoi_idf_cod, hoi_hor_cod);

alter table tcit_hoi 
   add constraint ircit_hoi_pk unique (hoi_idf_cod, hoi_seq);
create index icit_hor_idf_fk on tcit_hor (hor_idf_cod);
create index icit_pvh_idf_fk on tcit_pvh (pvh_idf_cod);
create index icit_pvh_emp_fk on tcit_pvh (pvh_idf_cod, pvh_emp_cod);
create index icit_pvh_ptv_fk on tcit_pvh (pvh_idf_cod, pvh_emp_cod, pvh_ptv_cod);
create index icit_pvh_hor_fk on tcit_pvh (pvh_idf_cod, pvh_hor_cod);

alter table tcit_cit 
   add constraint rges_cit_idf_fk 
   foreign key (cit_idf_cod) 
   references tges_idf;

alter table tcit_cit 
   add constraint cit_emp_cod_fk 
   foreign key (cit_emp_cod, cit_idf_cod) 
   references tges_emp;

alter table tcit_cit 
   add constraint cit_ptv_cod_fk 
   foreign key (cit_emp_cod, cit_ptv_cod, cit_idf_cod) 
   references tges_ptv;

alter table tcit_fes 
   add constraint rges_fes_idf_fk 
   foreign key (fes_idf_cod) 
   references tges_idf;

alter table tcit_fes 
   add constraint fes_fgr_cod_fk 
   foreign key (fes_fgr_cod, fes_idf_cod) 
   references tcit_fgr;

alter table tcit_fgr 
   add constraint rges_fgr_idf_fk 
   foreign key (fgr_idf_cod) 
   references tges_idf;

alter table tcit_hoi 
   add constraint rges_hoi_idf_fk 
   foreign key (hoi_idf_cod) 
   references tges_idf;

alter table tcit_hoi 
   add constraint hoi_hor_cod_fk 
   foreign key (hoi_hor_cod, hoi_idf_cod) 
   references tcit_hor;

alter table tcit_hor 
   add constraint rges_hor_idf_fk 
   foreign key (hor_idf_cod) 
   references tges_idf;

alter table tcit_pvh 
   add constraint rges_pvh_idf_fk 
   foreign key (pvh_idf_cod) 
   references tges_idf;

alter table tcit_pvh 
   add constraint pvh_emp_cod_fk 
   foreign key (pvh_emp_cod, pvh_idf_cod) 
   references tges_emp;

alter table tcit_pvh 
   add constraint pvh_hor_cod_fk 
   foreign key (pvh_hor_cod, pvh_idf_cod) 
   references tcit_hor;

alter table tcit_pvh 
   add constraint pvh_ptv_cod_fk 
   foreign key (pvh_emp_cod, pvh_ptv_cod, pvh_idf_cod) 
   references tges_ptv;
