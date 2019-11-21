
create table tges_cpo (
   cpo_cod varchar(4) not null,
    cpo_idf_cod varchar(4) not null,
    cpo_usucre varchar(255),
    cpo_datcre timestamp,
    cpo_usumod varchar(255),
    cpo_datmod timestamp,
    cpo_mun varchar(30),
    cpo_pob varchar(30) not null,
    cpo_pas_cod varchar(4) not null,
    cpo_prv_cod varchar(4) not null,
    primary key (cpo_cod, cpo_idf_cod)
);

create table tges_div (
   div_cod varchar(4) not null,
    div_idf_cod varchar(4) not null,
    div_usucre varchar(255),
    div_datcre timestamp,
    div_usumod varchar(255),
    div_datmod timestamp,
    div_abr varchar(5),
    div_codcmp varchar(255),
    div_decimp int4 not null,
    div_decpru int4 not null,
    div_nom varchar(30) not null,
    div_valdiveur numeric(15, 8) not null,
    primary key (div_cod, div_idf_cod)
);

create table tges_dpg (
   dpg_cod varchar(4) not null,
    dpg_idf_cod varchar(4) not null,
    dpg_usucre varchar(255),
    dpg_datcre timestamp,
    dpg_usumod varchar(255),
    dpg_datmod timestamp,
    dpg_tipasiing varchar(255) not null,
    dpg_acuvto boolean not null,
    dpg_apldteppg boolean not null,
    dpg_asicmp boolean not null,
    dpg_codcmp varchar(255) not null,
    dpg_codfacele varchar(255) not null,
    dpg_cnccmp varchar(255) not null,
    dpg_ctecmppag varchar(255) not null,
    dpg_ctecmping varchar(255) not null,
    dpg_ctecmpcmi varchar(255) not null,
    dpg_crlefecob boolean not null,
    dpg_des varchar(30) not null,
    dpg_diaefeneg int4 not null,
    dpg_dricmping varchar(255) not null,
    dpg_dricmping002 varchar(255) not null,
    dpg_dricmppag varchar(255) not null,
    dpg_dricmppag002 varchar(255) not null,
    dpg_numdiaval int4 not null,
    dpg_percmi numeric(19, 2) not null,
    dpg_tipasipag varchar(255) not null,
    dpg_trs boolean not null,
    dpg_iva_cod varchar(4) not null,
    dpg_npg_cod varchar(4) not null,
    dpg_rgi_cod varchar(4) not null,
    primary key (dpg_cod, dpg_idf_cod)
);

create table tges_fpr (
   fpr_cod varchar(4) not null,
    fpr_idf_cod varchar(4) not null,
    fpr_usucre varchar(255),
    fpr_datcre timestamp,
    fpr_usumod varchar(255),
    fpr_datmod timestamp,
    fpr_ctacprcmp varchar(255),
    fpr_dricmp varchar(255),
    fpr_driprfcmp varchar(255),
    fpr_nom varchar(30) not null,
    fpr_obs varchar(255),
    fpr_tipasicmp varchar(255),
    primary key (fpr_cod, fpr_idf_cod)
);

create table tges_iva (
   iva_cod varchar(4) not null,
    iva_idf_cod varchar(4) not null,
    iva_usucre varchar(255),
    iva_datcre timestamp,
    iva_usumod varchar(255),
    iva_datmod timestamp,
    iva_codcmp varchar(4) not null,
    iva_codreqcmp varchar(4) not null,
    iva_des varchar(30) not null,
    iva_pte numeric(19, 2) not null,
    iva_req numeric(19, 2) not null,
    iva_txt varchar(6),
    primary key (iva_cod, iva_idf_cod)
);

create table tges_mtr (
   mtr_cod varchar(4) not null,
    mtr_idf_cod varchar(4) not null,
    mtr_usucre varchar(255),
    mtr_datcre timestamp,
    mtr_usumod varchar(255),
    mtr_datmod timestamp,
    mtr_nif varchar(255),
    mtr_cdu varchar(255),
    mtr_des varchar(1000),
    mtr_mtr001 varchar(255),
    mtr_mtr002 varchar(255),
    mtr_obs varchar(255),
    mtr_pesmax numeric(19, 2),
    mtr_tara numeric(19, 2),
    zon_idf_cod varchar(255),
    mtr_tra_cod varchar(4) not null,
    primary key (mtr_cod, mtr_idf_cod)
);

create table tges_npg (
   npg_cod varchar(4) not null,
    npg_idf_cod varchar(4) not null,
    npg_usucre varchar(255),
    npg_datcre timestamp,
    npg_usumod varchar(255),
    npg_datmod timestamp,
    npg_des varchar(30) not null,
    npg_obs varchar(1000) not null,
    primary key (npg_cod, npg_idf_cod)
);

create table tges_pas (
   pas_cod varchar(4) not null,
    pas_idf_cod varchar(4) not null,
    pas_usucre varchar(255),
    pas_datcre timestamp,
    pas_usumod varchar(255),
    pas_datmod timestamp,
    pas_cee boolean,
    pas_codiso varchar(3),
    pas_codiso002 varchar(2),
    pas_nif varchar(2),
    pas_nom varchar(30) not null,
    primary key (pas_cod, pas_idf_cod)
);

create table tges_pro (
   pro_cod varchar(4) not null,
    pro_idf_cod varchar(4) not null,
    pro_usucre varchar(255),
    pro_datcre timestamp,
    pro_usumod varchar(255),
    pro_datmod timestamp,
    pro_blo boolean,
    pro_dhm boolean,
    pro_nomcom varchar(30),
    pro_nomfis varchar(1000),
    pro_scn boolean,
    pro_cpo_cod varchar(4) not null,
    pro_div_cod varchar(4) not null,
    pro_dpg_cod varchar(4) not null,
    pro_fpr_cod varchar(4) not null,
    pro_rgi_cod varchar(4) not null,
    pro_tve_cod varchar(4) not null,
    primary key (pro_cod, pro_idf_cod)
);

create table tges_prv (
   prv_cod varchar(4) not null,
    prv_idf_cod varchar(4) not null,
    prv_pas_cod varchar(4) not null,
    prv_usucre varchar(255),
    prv_datcre timestamp,
    prv_usumod varchar(255),
    prv_datmod timestamp,
    prv_nom varchar(30) not null,
    primary key (prv_cod, prv_idf_cod, prv_pas_cod)
);

create table tges_rgi (
   rgi_cod varchar(4) not null,
    rgi_idf_cod varchar(4) not null,
    rgi_usucre varchar(255),
    rgi_datcre timestamp,
    rgi_usumod varchar(255),
    rgi_datmod timestamp,
    rgi_codcmp varchar(30),
    rgi_codele varchar(2),
    rgi_des varchar(30) not null,
    rgi_tip int4 not null,
    primary key (rgi_cod, rgi_idf_cod)
);

create table tges_tra (
   tra_cod varchar(4) not null,
    tra_idf_cod varchar(4) not null,
    tra_usucre varchar(255),
    tra_datcre timestamp,
    tra_usumod varchar(255),
    tra_datmod timestamp,
    tra_www varchar(255),
    tra_con varchar(255),
    tra_dom varchar(255),
    tra_eml varchar(255),
    tra_fax varchar(255),
    tra_fpa varchar(255),
    tra_hri varchar(255),
    tra_nif varchar(12) not null,
    tra_nom varchar(30) not null,
    tra_obs varchar(255),
    tra_tel varchar(255),
    tra_vehemp boolean,
    tra_cpo_cod varchar(4),
    tra_div_cod varchar(4),
    tra_pro_cod varchar(4),
    primary key (tra_cod, tra_idf_cod)
);

create table tges_tun (
   tun_cod varchar(4) not null,
    tun_idf_cod varchar(4) not null,
    tun_usucre varchar(255),
    tun_datcre timestamp,
    tun_usumod varchar(255),
    tun_datmod timestamp,
    tun_des varchar(60) not null,
    tun_fc numeric(14, 4),
    primary key (tun_cod, tun_idf_cod)
);

create table tges_tve (
   tve_cod varchar(4) not null,
    tve_idf_cod varchar(4) not null,
    tve_usucre varchar(255),
    tve_datcre timestamp,
    tve_usumod varchar(255),
    tve_datmod timestamp,
    tve_clsvtocmp varchar(255),
    tve_ultdiamescpr boolean,
    tve_ultdiamesven boolean,
    tve_des varchar(30),
    tve_dia002pla int4,
    tve_diapga int4,
    tve_diapla int4,
    tve_diapla001 int4,
    tve_diapla004 int4,
    tve_diapla005 int4,
    tve_diapla002 int4,
    tve_diapla003 int4,
    tve_gencobpag boolean,
    tve_imppla numeric(19, 2),
    tve_mespga int4,
    tve_mestan int4,
    tve_mindia int4,
    tve_numpla int4,
    tve_ptepla001 float4,
    tve_ptepla004 float4,
    tve_ptepla005 float4,
    tve_ptepla002 float4,
    tve_ptepla003 float4,
    tve_mesclt boolean,
    tve_tip int4 not null,
    primary key (tve_cod, tve_idf_cod)
);

create table tges_zon (
   zon_cod varchar(4) not null,
    zon_idf_cod varchar(4) not null,
    zon_usucre varchar(255),
    zon_datcre timestamp,
    zon_usumod varchar(255),
    zon_datmod timestamp,
    zon_des varchar(1000),
    zon_nom varchar(30),
    zon_precio numeric(19, 2),
    zon_radio_km int4,
    primary key (zon_cod, zon_idf_cod)
);

create index iges_cpo_idf_fk on tges_cpo (cpo_idf_cod);
create index iges_div_idf_fk on tges_div (div_idf_cod);
create index iges_dpg_idf_fk on tges_dpg (dpg_idf_cod);
create index iges_fpr_idf_fk on tges_fpr (fpr_idf_cod);
create index iges_iva_idf_fk on tges_iva (iva_idf_cod);
create index iges_npg_idf_fk on tges_npg (npg_idf_cod);
create index iges_pas_idf_fk on tges_pas (pas_idf_cod);
create index iges_pro_idf_fk on tges_pro (pro_idf_cod);
create index iges_prv_idf_fk on tges_prv (prv_idf_cod);

alter table tges_prv 
   add constraint irges_prv_pk unique (prv_idf_cod, prv_cod);

create index iges_rgi_idf_fk on tges_rgi (rgi_idf_cod);
create index iges_tra_idf_fk on tges_tra (tra_idf_cod);
create index iges_tun_idf_fk on tges_tun (tun_idf_cod);
create index iges_tve_idf_fk on tges_tve (tve_idf_cod);
create index iges_zon_idf_fk on tges_zon (zon_idf_cod);

alter table tges_cpo 
   add constraint rges_cpo_idf_fk 
   foreign key (cpo_idf_cod) 
   references identificador;

alter table tges_cpo 
   add constraint rges_cpo_pas_fk 
   foreign key (cpo_pas_cod, cpo_idf_cod) 
   references tges_pas;

alter table tges_cpo 
   add constraint rges_cpo_prv_fk 
   foreign key (cpo_prv_cod, cpo_idf_cod, cpo_pas_cod) 
   references tges_prv;

alter table tges_div 
   add constraint rges_div_idf_fk 
   foreign key (div_idf_cod) 
   references identificador;

alter table tges_dpg 
   add constraint rges_dpg_idf_fk 
   foreign key (dpg_idf_cod) 
   references identificador;

alter table tges_dpg 
   add constraint rges_dpg_iva_fk 
   foreign key (dpg_iva_cod, dpg_idf_cod) 
   references tges_iva;

alter table tges_dpg 
   add constraint rges_dpg_npg_fk 
   foreign key (dpg_npg_cod, dpg_idf_cod) 
   references tges_npg;

alter table tges_dpg 
   add constraint rges_dpg_rgi_fk 
   foreign key (dpg_rgi_cod, dpg_idf_cod) 
   references tges_rgi;

alter table tges_fpr 
   add constraint rges_fpr_idf_fk 
   foreign key (fpr_idf_cod) 
   references identificador;

alter table tges_iva 
   add constraint rges_iva_idf_fk 
   foreign key (iva_idf_cod) 
   references identificador;

alter table tges_mtr 
   add constraint rges_zon_idf_fk 
   foreign key (zon_idf_cod) 
   references identificador;

alter table tges_mtr 
   add constraint rges_zon_tra_fk 
   foreign key (mtr_tra_cod, mtr_idf_cod) 
   references tges_tra;

alter table tges_npg 
   add constraint rges_npg_idf_fk 
   foreign key (npg_idf_cod) 
   references identificador;

alter table tges_pas 
   add constraint rges_pas_idf_fk 
   foreign key (pas_idf_cod) 
   references identificador;

alter table tges_pro 
   add constraint rges_pro_cpo_fk 
   foreign key (pro_cpo_cod, pro_idf_cod) 
   references tges_cpo;

alter table tges_pro 
   add constraint rges_pro_div_fk 
   foreign key (pro_div_cod, pro_idf_cod) 
   references tges_div;

alter table tges_pro 
   add constraint rges_pro_dpg_fk 
   foreign key (pro_dpg_cod, pro_idf_cod) 
   references tges_dpg;

alter table tges_pro 
   add constraint rges_pro_fpr_fk 
   foreign key (pro_fpr_cod, pro_idf_cod) 
   references tges_fpr;

alter table tges_pro 
   add constraint rges_pro_idf_fk 
   foreign key (pro_idf_cod) 
   references identificador;

alter table tges_pro 
   add constraint rges_pro_rgi_fk 
   foreign key (pro_rgi_cod, pro_idf_cod) 
   references tges_rgi;

alter table tges_pro 
   add constraint rges_pro_tve_fk 
   foreign key (pro_tve_cod, pro_idf_cod) 
   references tges_tve;

alter table tges_prv 
   add constraint rges_prv_idf_fk 
   foreign key (prv_idf_cod) 
   references identificador;

alter table tges_prv 
   add constraint rges_prv_pas_fk 
   foreign key (prv_pas_cod, prv_idf_cod) 
   references tges_pas;

alter table tges_rgi 
   add constraint rges_rgi_idf_fk 
   foreign key (rgi_idf_cod) 
   references identificador;

alter table tges_tra 
   add constraint rges_tra_cpo_fk 
   foreign key (tra_cpo_cod, tra_idf_cod) 
   references tges_cpo;

alter table tges_tra 
   add constraint rges_tra_div_fk 
   foreign key (tra_div_cod, tra_idf_cod) 
   references tges_div;

alter table tges_tra 
   add constraint rges_tra_idf_fk 
   foreign key (tra_idf_cod) 
   references identificador;

alter table tges_tra 
   add constraint rges_tra_pro_fk 
   foreign key (tra_pro_cod, tra_idf_cod) 
   references tges_pro;

alter table tges_tun 
   add constraint rges_tun_idf_fk 
   foreign key (tun_idf_cod) 
   references identificador;

alter table tges_tve 
   add constraint rges_tve_idf_fk 
   foreign key (tve_idf_cod) 
   references identificador;

alter table tges_zon 
   add constraint rges_zon_idf_fk 
   foreign key (zon_idf_cod) 
   references identificador;
