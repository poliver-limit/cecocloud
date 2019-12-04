create table tges_art (
   art_cod varchar(4) not null,
    art_idf_cod varchar(4) not null,
    art_usucre varchar(255),
    art_datcre timestamp,
    art_usumod varchar(255),
    art_datmod timestamp,
    art_ali varchar(30),
    art_blo boolean not null,
    art_cst boolean not null,
    art_sto boolean not null,
    art_creref boolean not null,
    art_decpru int4 not null,
    art_des varchar(2000) not null,
    art_descur varchar(60),
    art_fce numeric(15, 3) not null,
    art_fcs numeric(15, 3) not null,
    art_pvp numeric(17, 5) not null,
    art_art_cod varchar(4),
    art_art_cod02 varchar(4),
    art_codrae varchar(4),
    art_emp_cod varchar(4),
    art_far_cod varchar(4) not null,
    art_gma_cod varchar(4),
    art_iva_cod varchar(4) not null,
    art_mca_cod varchar(4),
    art_mod_cod varchar(4),
    primary key (art_cod, art_idf_cod)
);

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

create table tges_dep (
   dep_cod varchar(4) not null,
    dep_emp_cod varchar(4) not null,
    dep_idf_cod varchar(4) not null,
    dep_usucre varchar(255),
    dep_datcre timestamp,
    dep_usumod varchar(255),
    dep_datmod timestamp,
    dep_des varchar(60) not null,
    dep_obs varchar(1000),
    primary key (dep_cod, dep_emp_cod, dep_idf_cod)
);

create table tges_dfs (
   dfs_far_cod varchar(4) not null,
    dfs_emp_cod varchar(4) not null,
    dfs_idf_cod varchar(4) not null,
    dfs_usucre varchar(255),
    dfs_datcre timestamp,
    dfs_usumod varchar(255),
    dfs_datmod timestamp,
    dfs_obs varchar(1000),
    dfs_pte numeric(19, 2),
    dfs_sec_cod varchar(4) not null,
    primary key (dfs_far_cod, dfs_emp_cod, dfs_idf_cod)
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

create table tges_emp (
   emp_cod varchar(4) not null,
    emp_idf_cod varchar(4) not null,
    emp_usucre varchar(255),
    emp_datcre timestamp,
    emp_usumod varchar(255),
    emp_datmod timestamp,
    emp_tipasicmp varchar(2),
    emp_codcmp varchar(60),
    emp_dricmp varchar(2),
    emp_driprfcmp varchar(2),
    emp_domcom varchar(60) not null,
    emp_domfis varchar(60) not null,
    emp_eml varchar(60),
    emp_fax varchar(60),
    emp_llnfis001 varchar(40),
    emp_llnfis002 varchar(40),
    emp_prnlog boolean,
    emp_dirlog varchar(300),
    emp_nomcom varchar(40) not null,
    emp_nomfis varchar(40) not null,
    emp_nomfis001 varchar(40),
    emp_rec boolean,
    emp_regcricxa boolean,
    emp_rgtmtl varchar(250),
    emp_dattan timestamp,
    emp_tel varchar(60),
    emp_valfac numeric(19, 2),
    emp_www varchar(60),
    emp_cpo_codcom varchar(4) not null,
    emp_cpo_codfis varchar(4) not null,
    emp_div_cod varchar(4) not null,
    emp_mag_cod varchar(4),
    primary key (emp_cod, emp_idf_cod)
);

create table tges_fae (
   fae_far_cod varchar(4) not null,
    fae_emp_cod varchar(4) not null,
    fae_idf_cod varchar(4) not null,
    fae_usucre varchar(255),
    fae_datcre timestamp,
    fae_usumod varchar(255),
    fae_datmod timestamp,
    fae_web boolean,
    primary key (fae_far_cod, fae_emp_cod, fae_idf_cod)
);

create table tges_far (
   far_cod varchar(4) not null,
    far_idf_cod varchar(4) not null,
    far_usucre varchar(255),
    far_datcre timestamp,
    far_usumod varchar(255),
    far_datmod timestamp,
    far_pda boolean,
    far_ctacprcmp varchar(10),
    far_ctecmpexi varchar(500),
    far_ctavencmp varchar(10),
    far_desope varchar(500),
    far_des varchar(30) not null,
    far_discos boolean,
    far_blogenalb boolean not null,
    far_lotnav boolean not null,
    far_marmin float4,
    far_marpvpcos float4,
    far_obs varchar(1000),
    far_ptependev float4,
    far_pop boolean,
    far_seqord int8,
    far_fabunimet boolean,
    far_ubinav boolean not null,
    far_cmiven float4,
    far_fct_cod varchar(4) not null,
    far_gre_cod varchar(4),
    primary key (far_cod, far_idf_cod)
);

create table tges_fct (
   fct_cod varchar(4) not null,
    fct_idf_cod varchar(4) not null,
    fct_usucre varchar(255),
    fct_datcre timestamp,
    fct_usumod varchar(255),
    fct_datmod timestamp,
    fct_des varchar(60) not null,
    fct_obs varchar(1000),
    fct_far_cod varchar(4) not null,
    primary key (fct_cod, fct_idf_cod)
);

create table tges_fpr (
   fpr_cod varchar(4) not null,
    fpr_idf_cod varchar(4) not null,
    fpr_usucre varchar(255),
    fpr_datcre timestamp,
    fpr_usumod varchar(255),
    fpr_datmod timestamp,
    fpr_ctacprcmp varchar(10),
    fpr_dricmp varchar(2),
    fpr_driprfcmp varchar(2),
    fpr_nom varchar(30) not null,
    fpr_obs varchar(1000),
    fpr_tipasicmp varchar(2),
    primary key (fpr_cod, fpr_idf_cod)
);

create table tges_gma (
   gma_cod varchar(4) not null,
    gma_idf_cod varchar(4) not null,
    gma_usucre varchar(255),
    gma_datcre timestamp,
    gma_usumod varchar(255),
    gma_datmod timestamp,
    gma_des varchar(30) not null,
    primary key (gma_cod, gma_idf_cod)
);

create table tges_idf (
   idf_cod varchar(4) not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    idf_nom varchar(40) not null,
    primary key (idf_cod)
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

create table tges_mag (
   mag_cod varchar(4) not null,
    mag_idf_cod varchar(4) not null,
    mag_usucre varchar(255),
    mag_datcre timestamp,
    mag_usumod varchar(255),
    mag_datmod timestamp,
    mag_ctetrs varchar(10),
    mag_dricmp1 varchar(2),
    mag_dricmp2 varchar(2),
    mag_dom varchar(60) not null,
    mag_eml varchar(60),
    mag_fax varchar(60),
    mag_nom varchar(30) not null,
    mag_obs varchar(1000),
    mag_res varchar(30),
    mag_tel varchar(60),
    mag_tipasicmp varchar(2),
    mag_valinvtrs int4 not null,
    mag_cpo_cod varchar(4) not null,
    mag_div_cod varchar(4) not null,
    primary key (mag_cod, mag_idf_cod)
);

create table tges_mca (
   mca_cod varchar(4) not null,
    mca_idf_cod varchar(4) not null,
    mca_usucre varchar(255),
    mca_datcre timestamp,
    mca_usumod varchar(255),
    mca_datmod timestamp,
    mca_des varchar(30) not null,
    primary key (mca_cod, mca_idf_cod)
);

create table tges_mod (
   mod_cod varchar(4) not null,
    mod_idf_cod varchar(4) not null,
    mod_usucre varchar(255),
    mod_datcre timestamp,
    mod_usumod varchar(255),
    mod_datmod timestamp,
    mod_nounitra boolean,
    mod_des varchar(30) not null,
    primary key (mod_cod, mod_idf_cod)
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

create table tges_ped (
   ped_cod varchar(4) not null,
    ped_emp_cod varchar(4) not null,
    ped_idf_cod varchar(4) not null,
    ped_usucre varchar(255),
    ped_datcre timestamp,
    ped_usumod varchar(255),
    ped_datmod timestamp,
    ped_alb boolean not null,
    ped_com boolean not null,
    ped_des varchar(30) not null,
    ped_fac boolean not null,
    ped_famclipro boolean not null,
    ped_impcls boolean not null,
    ped_cer boolean not null,
    ped_ord numeric(19, 2),
    ped_pie varchar(1000),
    ped_pre boolean not null,
    ped_scp_codcom varchar(4) not null,
    primary key (ped_cod, ped_emp_cod, ped_idf_cod)
);

create table tges_pmg (
   pmg_cod varchar(4) not null,
    pmg_idf_cod varchar(4) not null,
    pmg_mag_cod varchar(4) not null,
    pmg_usucre varchar(255),
    pmg_datcre timestamp,
    pmg_usumod varchar(255),
    pmg_datmod timestamp,
    pmg_diaini timestamp not null,
    pmg_des varchar(30) not null,
    primary key (pmg_cod, pmg_idf_cod, pmg_mag_cod)
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

create table tges_scp (
   scp_cod varchar(4) not null,
    scp_emp_cod varchar(4) not null,
    scp_idf_cod varchar(4) not null,
    scp_usucre varchar(255),
    scp_datcre timestamp,
    scp_usumod varchar(255),
    scp_datmod timestamp,
    scp_ctecprcmp varchar(255),
    scp_ctecprprfcmp varchar(255) not null,
    scp_departament varchar(255),
    scp_des varchar(30) not null,
    scp_dsgivacmp boolean not null,
    scp_dricmp varchar(255) not null,
    scp_driprfcmp varchar(255),
    scp_tipasicmp varchar(255) not null,
    scp_diaini timestamp not null,
    scp_diafin timestamp not null,
    scp_emp_od002 varchar(4),
    scp_mag_cod varchar(4),
    primary key (scp_cod, scp_emp_cod, scp_idf_cod)
);

create table tges_sei (
   sei_cod varchar(4) not null,
    sei_emp_cod varchar(4) not null,
    sei_idf_cod varchar(4) not null,
    sei_usucre varchar(255),
    sei_datcre timestamp,
    sei_usumod varchar(255),
    sei_datmod timestamp,
    sei_des varchar(60) not null,
    sei_dia001 timestamp not null,
    sei_dia002 timestamp not null,
    sei_serdef boolean,
    sei_ultfac numeric(19, 2),
    primary key (sei_cod, sei_emp_cod, sei_idf_cod)
);

create table tges_ser (
   ser_cod varchar(4) not null,
    ser_emp_cod varchar(4) not null,
    ser_idf_cod varchar(4) not null,
    ser_usucre varchar(255),
    ser_datcre timestamp,
    ser_usumod varchar(255),
    ser_datmod timestamp,
    ser_dte boolean not null,
    ser_cnrvencli boolean,
    ser_cteadmpre varchar(10),
    ser_ctepre varchar(10),
    ser_cteprfadmpre varchar(10),
    ser_cteprfpre varchar(10),
    ser_ctevencmp varchar(10),
    ser_ctevenettpubcmp varchar(10),
    ser_ctevenprfcmp varchar(10),
    ser_ctevenettpubprfcmp varchar(10),
    ser_ultalb int4 not null,
    ser_ultalbprf int4 not null,
    ser_ultpre int4 not null,
    ser_ultfac int4 not null,
    ser_ultfacprf int4 not null,
    ser_ultpreprf int4 not null,
    ser_des varchar(30) not null,
    ser_dsgivacmp boolean not null,
    ser_dricmp varchar(2),
    ser_driprfcmp varchar(2),
    ser_titfac varchar(500),
    ser_ncf varchar(20),
    ser_man boolean not null,
    ser_tipasicmp varchar(2),
    ser_trscmp boolean,
    ser_dia001 timestamp not null,
    ser_dia002 timestamp not null,
    ser_ped_cod varchar(4),
    ser_dep_cod varchar(4),
    ser_emp_codprn varchar(4),
    ser_mag_cod varchar(4),
    ser_ped_codfac varchar(4),
    primary key (ser_cod, ser_emp_cod, ser_idf_cod)
);

create table tges_stc (
   stc_cod varchar(4) not null,
    stc_idf_cod varchar(4) not null,
    stc_usucre varchar(255),
    stc_datcre timestamp,
    stc_usumod varchar(255),
    stc_datmod timestamp,
    stc_nom varchar(30),
    stc_obs varchar(1000),
    primary key (stc_cod, stc_idf_cod)
);

create table tges_sue (
   sue_cod varchar(4) not null,
    sue_idf_cod varchar(4) not null,
    sue_usucre varchar(255),
    sue_datcre timestamp,
    sue_usumod varchar(255),
    sue_datmod timestamp,
    sue_nom varchar(30) not null,
    sue_ori varchar(30) not null,
    sue_prukgr numeric(19, 2) not null,
    primary key (sue_cod, sue_idf_cod)
);

create table tges_sui (
   sui_art_cod varchar(6) not null,
    sui_cls varchar(6) not null,
    sui_idf_cod varchar(4) not null,
    sui_mag_cod varchar(6) not null,
    sui_usucre varchar(255),
    sui_datcre timestamp,
    sui_usumod varchar(255),
    sui_datmod timestamp,
    sui_prucosuni numeric(19, 2) not null,
    sui_uniini numeric(19, 2) not null,
    sui_unimetini numeric(19, 2),
    sui_div_cod varchar(4) not null,
    sui_pmg_cod varchar(4) not null,
    primary key (sui_art_cod, sui_cls, sui_idf_cod, sui_mag_cod)
);

create table tges_tar (
   tar_cod varchar(4) not null,
    tar_idf_cod varchar(4) not null,
    tar_usucre varchar(255),
    tar_datcre timestamp,
    tar_usumod varchar(255),
    tar_datmod timestamp,
    tar_canpru boolean,
    tar_diafin timestamp,
    tar_diaini timestamp,
    tar_dtegen boolean,
    tar_des varchar(30) not null,
    tar_ptemanobr numeric(19, 2) not null,
    tar_ptemat numeric(19, 2) not null,
    tar_ofr boolean,
    primary key (tar_cod, tar_idf_cod)
);

create table tges_tcs (
   tcs_cod varchar(4) not null,
    tcs_idf_cod varchar(4) not null,
    tcs_usucre varchar(255),
    tcs_datcre timestamp,
    tcs_usumod varchar(255),
    tcs_datmod timestamp,
    tcs_des varchar(1000),
    tcs_min numeric(19, 2),
    tcs_nom varchar(30) not null,
    tcs_pte numeric(19, 2),
    primary key (tcs_cod, tcs_idf_cod)
);

create table tges_tds (
   tds_cod varchar(4) not null,
    tds_idf_cod varchar(4) not null,
    tds_usucre varchar(255),
    tds_datcre timestamp,
    tds_usumod varchar(255),
    tds_datmod timestamp,
    tds_des varchar(30) not null,
    tds_obs varchar(1000),
    primary key (tds_cod, tds_idf_cod)
);

create table tges_tfc (
   tfc_cod varchar(4) not null,
    tfc_idf_cod varchar(4) not null,
    tfc_usucre varchar(255),
    tfc_datcre timestamp,
    tfc_usumod varchar(255),
    tfc_datmod timestamp,
    tfc_crd boolean,
    tfc_des varchar(30) not null,
    primary key (tfc_cod, tfc_idf_cod)
);

create table tges_tin (
   tin_cod varchar(4) not null,
    tin_idf_cod varchar(4) not null,
    tin_usucre varchar(255),
    tin_datcre timestamp,
    tin_usumod varchar(255),
    tin_datmod timestamp,
    tin_nom varchar(30) not null,
    primary key (tin_cod, tin_idf_cod)
);

create table tges_tip (
   tip_cod varchar(4) not null,
    tip_idf_cod varchar(4) not null,
    tip_usucre varchar(255),
    tip_datcre timestamp,
    tip_usumod varchar(255),
    tip_datmod timestamp,
    tip_des varchar(30) not null,
    primary key (tip_cod, tip_idf_cod)
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

create table tges_tri (
   tri_cod varchar(4) not null,
    tri_idf_cod varchar(4) not null,
    tri_usucre varchar(255),
    tri_datcre timestamp,
    tri_usumod varchar(255),
    tri_datmod timestamp,
    tri_des varchar(30) not null,
    tri_albnotfac int4,
    tri_efeneg int4,
    tri_nifigu boolean not null,
    tri_pensrv int4,
    tri_vtopennotvnt int4,
    tri_vtopenvnt int4,
    primary key (tri_cod, tri_idf_cod)
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

create table tges_uba (
   uba_art_cod varchar(6) not null,
    uba_idf_cod varchar(4) not null,
    uba_mag_cod varchar(6) not null,
    uba_usucre varchar(255),
    uba_datcre timestamp,
    uba_usumod varchar(255),
    uba_datmod timestamp,
    uba_uni varchar(22),
    uba_ubi_cod varchar(4) not null,
    primary key (uba_art_cod, uba_idf_cod, uba_mag_cod)
);

create table tges_ubi (
   ubi_cod varchar(4) not null,
    ubi_idf_cod varchar(4) not null,
    ubi_mag_cod varchar(6) not null,
    ubi_usucre varchar(255),
    ubi_datcre timestamp,
    ubi_usumod varchar(255),
    ubi_datmod timestamp,
    ubi_des varchar(30),
    primary key (ubi_cod, ubi_idf_cod, ubi_mag_cod)
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

create table trhu_cat (
   cat_cod varchar(4) not null,
    cat_idf_cod varchar(4) not null,
    cat_usucre varchar(255),
    cat_datcre timestamp,
    cat_usumod varchar(255),
    cat_datmod timestamp,
    cat_act boolean,
    cat_nom varchar(255) not null,
    cat_obs varchar(1000),
    cat_soubas numeric(19, 2),
    primary key (cat_cod, cat_idf_cod)
);

create table trhu_cln (
   cln_dat varchar(4) not null,
    cln_idf_cod varchar(4) not null,
    cln_usucre varchar(255),
    cln_datcre timestamp,
    cln_usumod varchar(255),
    cln_datmod timestamp,
    cln_des varchar(1000),
    cln_obs varchar(1000),
    cln_tdi_cod varchar(4) not null,
    primary key (cln_dat, cln_idf_cod)
);

create table trhu_emp (
   emp_cod varchar(4) not null,
    emp_idf_cod varchar(4) not null,
    emp_usucre varchar(255),
    emp_datcre timestamp,
    emp_usumod varchar(255),
    emp_datmod timestamp,
    emp_asiprrpagext boolean,
    emp_cpo varchar(5),
    emp_cte varchar(10),
    emp_cteemb varchar(10),
    emp_cteorgsgremp varchar(10),
    emp_ctebanemp varchar(10),
    emp_cteret varchar(10),
    emp_ctesgr varchar(10),
    emp_ctesgremp varchar(10),
    emp_cteterope boolean,
    emp_cteembterope boolean,
    emp_cteterorgsgremp boolean,
    emp_cteretterope boolean,
    emp_ctesgrterope boolean,
    emp_ctetersgremp boolean,
    emp_dom varchar(60),
    emp_dri001 varchar(2),
    emp_dri002 varchar(2),
    emp_eml varchar(60),
    emp_empcmp varchar(4),
    emp_exccmp varchar(4),
    emp_asigrp boolean,
    emp_prnlog boolean,
    emp_www varchar(60),
    emp_pob varchar(30),
    emp_tel varchar(60),
    emp_crecte boolean,
    emp_vacdianat boolean,
    primary key (emp_cod, emp_idf_cod)
);

create table trhu_gre (
   gre_cod varchar(4) not null,
    gre_idf_cod varchar(4) not null,
    gre_usucre varchar(255),
    gre_datcre timestamp,
    gre_usumod varchar(255),
    gre_datmod timestamp,
    gre_des varchar(255) not null,
    gre_nom varchar(30) not null,
    gre_numhor numeric(19, 2) not null,
    primary key (gre_cod, gre_idf_cod)
);

create table trhu_gse (
   gse_cod varchar(4) not null,
    gse_emp_cod varchar(4) not null,
    gse_idf_cod varchar(4) not null,
    gse_usucre varchar(255),
    gse_datcre timestamp,
    gse_usumod varchar(255),
    gse_datmod timestamp,
    gse_nom varchar(30),
    primary key (gse_cod, gse_emp_cod, gse_idf_cod)
);

create table trhu_hor (
   hor_cod varchar(4) not null,
    hor_idf_cod varchar(4) not null,
    hor_usucre varchar(255),
    hor_datcre timestamp,
    hor_usumod varchar(255),
    hor_datmod timestamp,
    hor_des varchar(1000),
    hor_hor numeric(19, 2),
    hor_nom varchar(30) not null,
    primary key (hor_cod, hor_idf_cod)
);

create table trhu_idf (
   idf_cod varchar(4) not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    idf_nom varchar(40) not null,
    primary key (idf_cod)
);

create table trhu_nod (
   nod_num varchar(4) not null,
    nod_idf_cod varchar(4) not null,
    nod_usucre varchar(255),
    nod_datcre timestamp,
    nod_usumod varchar(255),
    nod_datmod timestamp,
    nod_cod int4,
    nod_tip varchar(255),
    nod_tip1 varchar(10),
    nod_sno_cod varchar(4) not null,
    nod_zon_coddti varchar(4) not null,
    nod_zon_codori varchar(4) not null,
    primary key (nod_num, nod_idf_cod)
);

create table trhu_ope (
   ope_cod varchar(4) not null,
    ope_idf_cod varchar(4) not null,
    ope_usucre varchar(255),
    ope_datcre timestamp,
    ope_usumod varchar(255),
    ope_datmod timestamp,
    ope_hor_cod varchar(4) not null,
    ope_nom varchar(40) not null,
    nom varchar(40),
    primary key (ope_cod, ope_idf_cod)
);

create table trhu_rdi (
   caledariCodi varchar(255) not null,
    rdi_idf_cod varchar(4) not null,
    rdi_usucre varchar(255),
    rdi_datcre timestamp,
    rdi_usumod varchar(255),
    rdi_datmod timestamp,
    rdi_horext numeric(22, 0) not null,
    rdi_hornit numeric(22, 0) not null,
    rdi_hornor numeric(22, 0) not null,
    rdi_horteo numeric(22, 0) not null,
    rdi_pruhornit numeric(15, 2) not null,
    rdi_pruhornor numeric(15, 2) not null,
    rdi_pruext numeric(22, 0) not null,
    rdi_cln_dat varchar(4) not null,
    rdi_cat_cod varchar(4) not null,
    rdi_emp_cod varchar(4) not null,
    rdi_hor_cod varchar(4) not null,
    rdi_ope_cod varchar(4) not null,
    rdi_reg_cod varchar(4) not null,
    rdi_sec_cod varchar(4) not null,
    rdi_sct_cod varchar(4) not null,
    primary key (caledariCodi, rdi_idf_cod)
);

create table trhu_reg (
   reg_cod varchar(4) not null,
    reg_idf_cod varchar(4) not null,
    reg_usucre varchar(255),
    reg_datcre timestamp,
    reg_usumod varchar(255),
    reg_datmod timestamp,
    reg_hor boolean not null,
    reg_mntreg boolean not null,
    reg_pln boolean not null,
    reg_nom varchar(30),
    reg_maxhorlab numeric(19, 2),
    reg_minhorlab numeric(19, 2),
    reg_prs boolean not null,
    primary key (reg_cod, reg_idf_cod)
);

create table trhu_sct (
   sct_cod varchar(4) not null,
    sct_idf_cod varchar(4) not null,
    sct_usucre varchar(255),
    sct_datcre timestamp,
    sct_usumod varchar(255),
    sct_datmod timestamp,
    sct_act boolean,
    sct_cat_cod varchar(4),
    sct_nom varchar(30),
    sct_obs varchar(1000),
    primary key (sct_cod, sct_idf_cod)
);

create table trhu_sec (
   sec_cod varchar(4) not null,
    sec_emp_cod varchar(4) not null,
    sec_idf_cod varchar(4) not null,
    sec_usucre varchar(255),
    sec_datcre timestamp,
    sec_usumod varchar(255),
    sec_datmod timestamp,
    sec_cte varchar(10),
    sec_ctlhoe boolean,
    sec_ctlffo boolean,
    sec_depcmp varchar(4),
    sec_discos varchar(2),
    sec_dtehor numeric(19, 2),
    sec_fct numeric(19, 2),
    sec_nom varchar(30),
    sec_obs varchar(1000),
    sec_rolvis varchar(15),
    sec_gse_cod varchar(4) not null,
    primary key (sec_cod, sec_emp_cod, sec_idf_cod)
);

create table trhu_sno (
   sno_cod varchar(4) not null,
    sno_idf_cod varchar(4) not null,
    sno_usucre varchar(255),
    sno_datcre timestamp,
    sno_usumod varchar(255),
    sno_datmod timestamp,
    sno_des varchar(1000),
    primary key (sno_cod, sno_idf_cod)
);

create table trhu_tdi (
   tdi_cod varchar(4) not null,
    tdi_idf_cod varchar(4) not null,
    tdi_usucre varchar(255),
    tdi_datcre timestamp,
    tdi_usumod varchar(255),
    tdi_datmod timestamp,
    tdi_nom varchar(30) not null,
    tdi_reg_cod varchar(4) not null,
    primary key (tdi_cod, tdi_idf_cod)
);

create table trhu_tra (
   tra_cod varchar(4) not null,
    tra_idf_cod varchar(4) not null,
    tra_usucre varchar(255),
    tra_datcre timestamp,
    tra_usumod varchar(255),
    tra_datmod timestamp,
    tra_dathor timestamp,
    tra_obs varchar(1000),
    tra_emp_cod varchar(4),
    tra_nod_num varchar(4),
    tra_ope_cod varchar(4) not null,
    tra_ttr_cod varchar(4) not null,
    primary key (tra_cod, tra_idf_cod)
);

create table trhu_ttr (
   ttr_cod varchar(4) not null,
    ttr_idf_cod varchar(4) not null,
    ttr_usucre varchar(255),
    ttr_datcre timestamp,
    ttr_usumod varchar(255),
    ttr_datmod timestamp,
    ttr_des varchar(1000),
    primary key (ttr_cod, ttr_idf_cod)
);

create table trhu_zon (
   zon_cod varchar(4) not null,
    zon_idf_cod varchar(4) not null,
    zon_usucre varchar(255),
    zon_datcre timestamp,
    zon_usumod varchar(255),
    zon_datmod timestamp,
    zon_nom varchar(30),
    zon_obs varchar(1000),
    zon_zontre boolean not null,
    primary key (zon_cod, zon_idf_cod)
);

create index iges_art_idf_fk on tges_art (art_idf_cod);
create index iges_cpo_idf_fk on tges_cpo (cpo_idf_cod);
create index iges_dep_idf_fk on tges_dep (dep_idf_cod);

    alter table tges_dep 
       add constraint irges_dep_pk unique (dep_idf_cod, dep_cod);
create index iges_dfs_idf_fk on tges_dfs (dfs_idf_cod);

    alter table tges_dfs 
       add constraint irges_dfs_pk unique (dfs_idf_cod);
create index iges_div_idf_fk on tges_div (div_idf_cod);
create index iges_dpg_idf_fk on tges_dpg (dpg_idf_cod);
create index iges_emp_idf_fk on tges_emp (emp_idf_cod);
create index iges_fae_idf_fk on tges_fae (fae_idf_cod);

    alter table tges_fae 
       add constraint irges_fae_pk unique (fae_idf_cod);
create index iges_far_idf_fk on tges_far (far_idf_cod);
create index iges_fct_idf_fk on tges_fct (fct_idf_cod);
create index iges_fpr_idf_fk on tges_fpr (fpr_idf_cod);
create index iges_gma_idf_fk on tges_gma (gma_idf_cod);
create index iges_iva_idf_fk on tges_iva (iva_idf_cod);
create index iges_mag_idf_fk on tges_mag (mag_idf_cod);
create index iges_mca_idf_fk on tges_mca (mca_idf_cod);
create index iges_mod_idf_fk on tges_mod (mod_idf_cod);
create index iges_npg_idf_fk on tges_npg (npg_idf_cod);
create index iges_pas_idf_fk on tges_pas (pas_idf_cod);
create index iges_ped_idf_fk on tges_ped (ped_idf_cod);

    alter table tges_ped 
       add constraint irges_ped_pk unique (ped_idf_cod, ped_cod);
create index iges_pmg_idf_fk on tges_pmg (pmg_idf_cod);

    alter table tges_pmg 
       add constraint irges_pmg_pk unique (pmg_idf_cod, pmg_cod);
create index iges_pro_idf_fk on tges_pro (pro_idf_cod);
create index iges_prv_idf_fk on tges_prv (prv_idf_cod);

    alter table tges_prv 
       add constraint irges_prv_pk unique (prv_idf_cod, prv_cod);
create index iges_rgi_idf_fk on tges_rgi (rgi_idf_cod);
create index iges_scp_idf_fk on tges_scp (scp_idf_cod);

    alter table tges_scp 
       add constraint irges_scp_pk unique (scp_idf_cod, scp_cod);
create index iges_sei_idf_fk on tges_sei (sei_idf_cod);

    alter table tges_sei 
       add constraint irges_sei_pk unique (sei_idf_cod, sei_cod);
create index iges_ser_idf_fk on tges_ser (ser_idf_cod);

    alter table tges_ser 
       add constraint irges_ser_pk unique (ser_idf_cod, ser_cod);
create index iges_stc_idf_fk on tges_stc (stc_idf_cod);
create index iges_sue_idf_fk on tges_sue (sue_idf_cod);
create index iges_sui_idf_fk on tges_sui (sui_idf_cod);

    alter table tges_sui 
       add constraint irges_sui_pk unique (sui_idf_cod);
create index iges_tar_idf_fk on tges_tar (tar_idf_cod);
create index iges_tcs_idf_fk on tges_tcs (tcs_idf_cod);
create index iges_tds_idf_fk on tges_tds (tds_idf_cod);
create index iges_tfc_idf_fk on tges_tfc (tfc_idf_cod);
create index iges_tin_idf_fk on tges_tin (tin_idf_cod);
create index iges_tip_idf_fk on tges_tip (tip_idf_cod);
create index iges_tra_idf_fk on tges_tra (tra_idf_cod);
create index iges_tri_idf_fk on tges_tri (tri_idf_cod);
create index iges_tun_idf_fk on tges_tun (tun_idf_cod);
create index iges_tve_idf_fk on tges_tve (tve_idf_cod);
create index iges_uba_idf_fk on tges_uba (uba_idf_cod);

    alter table tges_uba 
       add constraint irges_uba_pk unique (uba_idf_cod);
create index iges_ubi_idf_fk on tges_ubi (ubi_idf_cod);

    alter table tges_ubi 
       add constraint irges_ubi_pk unique (ubi_idf_cod, ubi_cod);
create index iges_zon_idf_fk on tges_zon (zon_idf_cod);
create index irhu_cat_idf_fk on trhu_cat (cat_idf_cod);
create index irhu_cln_idf_fk on trhu_cln (cln_idf_cod);

    alter table trhu_cln 
       add constraint irrhu_cln_pk unique (cln_idf_cod);
create index irhu_emp_idf_fk on trhu_emp (emp_idf_cod);
create index irhu_gre_idf_fk on trhu_gre (gre_idf_cod);
create index irhu_gse_idf_fk on trhu_gse (gse_idf_cod);

    alter table trhu_gse 
       add constraint irrhu_gse_pk unique (gse_idf_cod, gse_cod);
create index irhu_hor_idf_fk on trhu_hor (hor_idf_cod);
create index irhu_nod_idf_fk on trhu_nod (nod_idf_cod);

    alter table trhu_nod 
       add constraint irrhu_nod_pk unique (nod_idf_cod, nod_cod);
create index irhu_ope_idf_fk on trhu_ope (ope_idf_cod);
create index irhu_rdi_idf_fk on trhu_rdi (rdi_idf_cod);

    alter table trhu_rdi 
       add constraint irrhu_rdi_pk unique (rdi_idf_cod);
create index irhu_reg_idf_fk on trhu_reg (reg_idf_cod);
create index irhu_sct_idf_fk on trhu_sct (sct_idf_cod);
create index irhu_sec_idf_fk on trhu_sec (sec_idf_cod);

    alter table trhu_sec 
       add constraint UK_2gjy6kdwg20dg4joks83qdkxv unique (sec_gse_cod, sec_emp_cod, sec_idf_cod);

    alter table trhu_sec 
       add constraint irrhu_sec_pk unique (sec_idf_cod, sec_cod);
create index irhu_sno_idf_fk on trhu_sno (sno_idf_cod);
create index irhu_tdi_idf_fk on trhu_tdi (tdi_idf_cod);
create index irhu_tra_idf_fk on trhu_tra (tra_idf_cod);
create index irhu_ttr_idf_fk on trhu_ttr (ttr_idf_cod);
create index irhu_zon_idf_fk on trhu_zon (zon_idf_cod);

alter table tges_art 
   add constraint rges_art_art_fk 
   foreign key (art_art_cod, art_idf_cod) 
   references tges_art;

alter table tges_art 
   add constraint rges_art_art_cod02_fk 
   foreign key (art_art_cod02, art_idf_cod) 
   references tges_art;

alter table tges_art 
   add constraint rges_art_articleRaee_fk 
   foreign key (art_codrae, art_idf_cod) 
   references tges_art;

alter table tges_art 
   add constraint rges_art_emp_fk 
   foreign key (art_emp_cod, art_idf_cod) 
   references tges_emp;

alter table tges_art 
   add constraint rges_art_far_fk 
   foreign key (art_far_cod, art_idf_cod) 
   references tges_far;

alter table tges_art 
   add constraint rges_art_gma_fk 
   foreign key (art_gma_cod, art_idf_cod) 
   references tges_gma;

alter table tges_art 
   add constraint rges_art_idf_fk 
   foreign key (art_idf_cod) 
   references tges_idf;

alter table tges_art 
   add constraint rges_art_iva_fk 
   foreign key (art_iva_cod, art_idf_cod) 
   references tges_iva;

alter table tges_art 
   add constraint rges_art_mca_fk 
   foreign key (art_mca_cod, art_idf_cod) 
   references tges_mca;

alter table tges_art 
   add constraint rges_art_mod_fk 
   foreign key (art_mod_cod, art_idf_cod) 
   references tges_mod;

alter table tges_cpo 
   add constraint rges_cpo_idf_fk 
   foreign key (cpo_idf_cod) 
   references tges_idf;

alter table tges_cpo 
   add constraint rges_cpo_pas_fk 
   foreign key (cpo_pas_cod, cpo_idf_cod) 
   references tges_pas;

alter table tges_cpo 
   add constraint rges_cpo_prv_fk 
   foreign key (cpo_prv_cod, cpo_idf_cod, cpo_pas_cod) 
   references tges_prv;

alter table tges_dep 
   add constraint rges_dep_idf_fk 
   foreign key (dep_idf_cod) 
   references tges_idf;

alter table tges_dfs 
   add constraint rges_dfs_far_fk 
   foreign key (dfs_far_cod, dfs_idf_cod) 
   references tges_far;

alter table tges_dfs 
   add constraint rges_dfs_fae_fk 
   foreign key (dfs_far_cod, dfs_emp_cod, dfs_idf_cod) 
   references tges_fae;

alter table tges_dfs 
   add constraint rges_dfs_idf_fk 
   foreign key (dfs_idf_cod) 
   references tges_idf;

alter table tges_dfs 
   add constraint rges_dfs_sec_fk 
   foreign key (dfs_sec_cod, dfs_emp_cod, dfs_idf_cod) 
   references trhu_sec;

alter table tges_div 
   add constraint rges_div_idf_fk 
   foreign key (div_idf_cod) 
   references tges_idf;

alter table tges_dpg 
   add constraint rges_dpg_idf_fk 
   foreign key (dpg_idf_cod) 
   references tges_idf;

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

alter table tges_emp 
   add constraint rges_emp_cpo_fk 
   foreign key (emp_cpo_codcom, emp_idf_cod) 
   references tges_cpo;

alter table tges_emp 
   add constraint rges_emp_cpofis_fk 
   foreign key (emp_cpo_codfis, emp_idf_cod) 
   references tges_cpo;

alter table tges_emp 
   add constraint rges_emp_div_fk 
   foreign key (emp_div_cod, emp_idf_cod) 
   references tges_div;

alter table tges_emp 
   add constraint rges_emp_idf_fk 
   foreign key (emp_idf_cod) 
   references tges_idf;

alter table tges_emp 
   add constraint rges_emp_mag_fk 
   foreign key (emp_mag_cod, emp_idf_cod) 
   references tges_mag;

alter table tges_fae 
   add constraint rges_fae_emp_fk 
   foreign key (fae_emp_cod, fae_idf_cod) 
   references tges_emp;

alter table tges_fae 
   add constraint rges_fae_far_fk 
   foreign key (fae_far_cod, fae_idf_cod) 
   references tges_far;

alter table tges_fae 
   add constraint rges_fae_idf_fk 
   foreign key (fae_idf_cod) 
   references tges_idf;

alter table tges_far 
   add constraint rges_far_fct_fk 
   foreign key (far_fct_cod, far_idf_cod) 
   references tges_fct;

alter table tges_far 
   add constraint rges_far_idf_fk 
   foreign key (far_idf_cod) 
   references tges_idf;

alter table tges_far 
   add constraint rges_far_gre_fk 
   foreign key (far_gre_cod, far_idf_cod) 
   references trhu_gre;

alter table tges_fct 
   add constraint rges_fct_far_fk 
   foreign key (fct_far_cod, fct_idf_cod) 
   references tges_far;

alter table tges_fct 
   add constraint rges_fct_idf_fk 
   foreign key (fct_idf_cod) 
   references tges_idf;

alter table tges_fpr 
   add constraint rges_fpr_idf_fk 
   foreign key (fpr_idf_cod) 
   references tges_idf;

alter table tges_gma 
   add constraint rges_gma_idf_fk 
   foreign key (gma_idf_cod) 
   references tges_idf;

alter table tges_iva 
   add constraint rges_iva_idf_fk 
   foreign key (iva_idf_cod) 
   references tges_idf;

alter table tges_mag 
   add constraint rges_mag_cpo_fk 
   foreign key (mag_cpo_cod, mag_idf_cod) 
   references tges_cpo;

alter table tges_mag 
   add constraint rges_mag_div_fk 
   foreign key (mag_div_cod, mag_idf_cod) 
   references tges_div;

alter table tges_mag 
   add constraint rges_mag_idf_fk 
   foreign key (mag_idf_cod) 
   references tges_idf;

alter table tges_mca 
   add constraint rges_mca_idf_fk 
   foreign key (mca_idf_cod) 
   references tges_idf;

alter table tges_mod 
   add constraint rges_mod_idf_fk 
   foreign key (mod_idf_cod) 
   references tges_idf;

alter table tges_mtr 
   add constraint rges_mtr_idf_fk 
   foreign key (mtr_idf_cod) 
   references tges_idf;

alter table tges_mtr 
   add constraint rges_zon_tra_fk 
   foreign key (mtr_tra_cod, mtr_idf_cod) 
   references tges_tra;

alter table tges_npg 
   add constraint rges_npg_idf_fk 
   foreign key (npg_idf_cod) 
   references tges_idf;

alter table tges_pas 
   add constraint rges_pas_idf_fk 
   foreign key (pas_idf_cod) 
   references tges_idf;

alter table tges_ped 
   add constraint rges_ped_idf_fk 
   foreign key (ped_idf_cod) 
   references tges_idf;

alter table tges_ped 
   add constraint rges_ped_scp_fk 
   foreign key (ped_scp_codcom, ped_emp_cod, ped_idf_cod) 
   references tges_scp;

alter table tges_pmg 
   add constraint rges_pmg_idf_fk 
   foreign key (pmg_idf_cod) 
   references tges_idf;

alter table tges_pmg 
   add constraint rges_pmg_mag_fk 
   foreign key (pmg_mag_cod, pmg_idf_cod) 
   references tges_mag;

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
   references tges_idf;

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
   references tges_idf;

alter table tges_prv 
   add constraint rges_prv_pas_fk 
   foreign key (prv_pas_cod, prv_idf_cod) 
   references tges_pas;

alter table tges_rgi 
   add constraint rges_rgi_idf_fk 
   foreign key (rgi_idf_cod) 
   references tges_idf;

alter table tges_scp 
   add constraint rges_scp_emp_fk 
   foreign key (scp_emp_od002, scp_idf_cod) 
   references tges_emp;

alter table tges_scp 
   add constraint rges_scp_idf_fk 
   foreign key (scp_idf_cod) 
   references tges_idf;

alter table tges_scp 
   add constraint rges_scp_mag_fk 
   foreign key (scp_mag_cod, scp_idf_cod) 
   references tges_mag;

alter table tges_sei 
   add constraint rges_sei_idf_fk 
   foreign key (sei_idf_cod) 
   references tges_idf;

alter table tges_ser 
   add constraint rges_ser_pedcondicio_fk 
   foreign key (ser_ped_cod, ser_emp_cod, ser_idf_cod) 
   references tges_ped;

alter table tges_ser 
   add constraint rges_ser_dep_fk 
   foreign key (ser_dep_cod, ser_emp_cod, ser_idf_cod) 
   references tges_dep;

alter table tges_ser 
   add constraint rges_ser_emp_fk 
   foreign key (ser_emp_codprn, ser_idf_cod) 
   references tges_emp;

alter table tges_ser 
   add constraint rges_ser_idf_fk 
   foreign key (ser_idf_cod) 
   references tges_idf;

alter table tges_ser 
   add constraint rges_ser_mag_fk 
   foreign key (ser_mag_cod, ser_idf_cod) 
   references tges_mag;

alter table tges_ser 
   add constraint rges_ser_ped_fk 
   foreign key (ser_ped_codfac, ser_emp_cod, ser_idf_cod) 
   references tges_ped;

alter table tges_stc 
   add constraint rges_stc_idf_fk 
   foreign key (stc_idf_cod) 
   references tges_idf;

alter table tges_sue 
   add constraint rges_sue_idf_fk 
   foreign key (sue_idf_cod) 
   references tges_idf;

alter table tges_sui 
   add constraint rges_sui_art_fk 
   foreign key (sui_art_cod, sui_idf_cod) 
   references tges_art;

alter table tges_sui 
   add constraint rges_sui_div_fk 
   foreign key (sui_div_cod, sui_idf_cod) 
   references tges_div;

alter table tges_sui 
   add constraint rges_sui_idf_fk 
   foreign key (sui_idf_cod) 
   references tges_idf;

alter table tges_sui 
   add constraint rges_sui_pmg_fk 
   foreign key (sui_pmg_cod, sui_idf_cod, sui_mag_cod) 
   references tges_pmg;

alter table tges_tar 
   add constraint rges_tar_idf_fk 
   foreign key (tar_idf_cod) 
   references tges_idf;

alter table tges_tcs 
   add constraint rges_tcs_idf_fk 
   foreign key (tcs_idf_cod) 
   references tges_idf;

alter table tges_tds 
   add constraint rges_tds_idf_fk 
   foreign key (tds_idf_cod) 
   references tges_idf;

alter table tges_tfc 
   add constraint rges_tfc_idf_fk 
   foreign key (tfc_idf_cod) 
   references tges_idf;

alter table tges_tin 
   add constraint rges_tin_idf_fk 
   foreign key (tin_idf_cod) 
   references tges_idf;

alter table tges_tip 
   add constraint rges_tip_idf_fk 
   foreign key (tip_idf_cod) 
   references tges_idf;

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
   references tges_idf;

alter table tges_tra 
   add constraint rges_tra_pro_fk 
   foreign key (tra_pro_cod, tra_idf_cod) 
   references tges_pro;

alter table tges_tri 
   add constraint rges_tri_idf_fk 
   foreign key (tri_idf_cod) 
   references tges_idf;

alter table tges_tun 
   add constraint rges_tun_idf_fk 
   foreign key (tun_idf_cod) 
   references tges_idf;

alter table tges_tve 
   add constraint rges_tve_idf_fk 
   foreign key (tve_idf_cod) 
   references tges_idf;

alter table tges_uba 
   add constraint rges_uba_art_fk 
   foreign key (uba_art_cod, uba_idf_cod) 
   references tges_art;

alter table tges_uba 
   add constraint rges_uba_idf_fk 
   foreign key (uba_idf_cod) 
   references tges_idf;

alter table tges_uba 
   add constraint rges_uba_ubi_fk 
   foreign key (uba_ubi_cod, uba_idf_cod, uba_mag_cod) 
   references tges_ubi;

alter table tges_ubi 
   add constraint rges_ubi_idf_fk 
   foreign key (ubi_idf_cod) 
   references tges_idf;

alter table tges_ubi 
   add constraint rges_ubi_mag_fk 
   foreign key (ubi_mag_cod, ubi_idf_cod) 
   references tges_mag;

alter table tges_zon 
   add constraint rges_zon_idf_fk 
   foreign key (zon_idf_cod) 
   references tges_idf;

alter table trhu_cat 
   add constraint rrhu_cat_idf_fk 
   foreign key (cat_idf_cod) 
   references trhu_idf;

alter table trhu_cln 
   add constraint rrhu_cln_idf_fk 
   foreign key (cln_idf_cod) 
   references trhu_idf;

alter table trhu_cln 
   add constraint rrhu_cln_tdi_fk 
   foreign key (cln_tdi_cod, cln_idf_cod) 
   references trhu_tdi;

alter table trhu_emp 
   add constraint rrhu_emp_idf_fk 
   foreign key (emp_idf_cod) 
   references trhu_idf;

alter table trhu_gre 
   add constraint rrhu_gre_idf_fk 
   foreign key (gre_idf_cod) 
   references trhu_idf;

alter table trhu_gse 
   add constraint rrhu_gse_idf_fk 
   foreign key (gse_idf_cod) 
   references trhu_idf;

alter table trhu_hor 
   add constraint rrhu_hor_idf_fk 
   foreign key (hor_idf_cod) 
   references trhu_idf;

alter table trhu_nod 
   add constraint rrhu_nod_idf_fk 
   foreign key (nod_idf_cod) 
   references trhu_idf;

alter table trhu_nod 
   add constraint rrhu_nod_sno_fk 
   foreign key (nod_sno_cod, nod_idf_cod) 
   references trhu_sno;

alter table trhu_nod 
   add constraint rrhu_nod_zon_dti_fk 
   foreign key (nod_zon_coddti, nod_idf_cod) 
   references trhu_zon;

alter table trhu_nod 
   add constraint rrhu_nod_zon_ori_fk 
   foreign key (nod_zon_codori, nod_idf_cod) 
   references trhu_zon;

alter table trhu_ope 
   add constraint rrhu_ope_hor_fk 
   foreign key (ope_hor_cod, ope_idf_cod) 
   references trhu_hor;

alter table trhu_ope 
   add constraint rrhu_ope_idf_fk 
   foreign key (ope_idf_cod) 
   references trhu_idf;

alter table trhu_rdi 
   add constraint rrhu_rdi_cln_fk 
   foreign key (rdi_cln_dat, rdi_idf_cod) 
   references trhu_cln;

alter table trhu_rdi 
   add constraint rrhu_rdi_cat_fk 
   foreign key (rdi_cat_cod, rdi_idf_cod) 
   references trhu_cat;

alter table trhu_rdi 
   add constraint rrhu_rdi_emp_fk 
   foreign key (rdi_emp_cod, rdi_idf_cod) 
   references trhu_emp;

alter table trhu_rdi 
   add constraint rrhu_rdi_hor_fk 
   foreign key (rdi_hor_cod, rdi_idf_cod) 
   references trhu_hor;

alter table trhu_rdi 
   add constraint rrhu_rdi_idf_fk 
   foreign key (rdi_idf_cod) 
   references trhu_idf;

alter table trhu_rdi 
   add constraint rrhu_rdi_ope_fk 
   foreign key (rdi_ope_cod, rdi_idf_cod) 
   references trhu_ope;

alter table trhu_rdi 
   add constraint rrhu_rdi_reg_fk 
   foreign key (rdi_reg_cod, rdi_idf_cod) 
   references trhu_reg;

alter table trhu_rdi 
   add constraint rrhu_rdi_sec_fk 
   foreign key (rdi_sec_cod, rdi_emp_cod, rdi_idf_cod) 
   references trhu_sec;

alter table trhu_rdi 
   add constraint rrhu_rdi_sct_fk 
   foreign key (rdi_sct_cod, rdi_idf_cod) 
   references trhu_sct;

alter table trhu_reg 
   add constraint rrhu_reg_idf_fk 
   foreign key (reg_idf_cod) 
   references trhu_idf;

alter table trhu_sct 
   add constraint rrhu_sct_cat_fk 
   foreign key (sct_cat_cod, sct_idf_cod) 
   references trhu_cat;

alter table trhu_sct 
   add constraint rrhu_sct_idf_fk 
   foreign key (sct_idf_cod) 
   references trhu_idf;

alter table trhu_sec 
   add constraint rrhu_sec_idf_fk 
   foreign key (sec_idf_cod) 
   references trhu_idf;

alter table trhu_sec 
   add constraint rrhu_sec_gse_fk 
   foreign key (sec_gse_cod, sec_emp_cod, sec_idf_cod) 
   references trhu_gse;

alter table trhu_sno 
   add constraint rrhu_sno_idf_fk 
   foreign key (sno_idf_cod) 
   references trhu_idf;

alter table trhu_tdi 
   add constraint rrhu_tdi_idf_fk 
   foreign key (tdi_idf_cod) 
   references trhu_idf;

alter table trhu_tdi 
   add constraint rrhu_tdi_reg_fk 
   foreign key (tdi_reg_cod, tdi_idf_cod) 
   references trhu_reg;

alter table trhu_tra 
   add constraint rrhu_tra_emp_fk 
   foreign key (tra_emp_cod, tra_idf_cod) 
   references trhu_emp;

alter table trhu_tra 
   add constraint rrhu_tra_idf_fk 
   foreign key (tra_idf_cod) 
   references trhu_idf;

alter table trhu_tra 
   add constraint rrhu_tra_nod_fk 
   foreign key (tra_nod_num, tra_idf_cod) 
   references trhu_nod;

alter table trhu_tra 
   add constraint rrhu_tra_ope_fk 
   foreign key (tra_ope_cod, tra_idf_cod) 
   references trhu_ope;

alter table trhu_tra 
   add constraint rrhu_tra_ttr_fk 
   foreign key (tra_ttr_cod, tra_idf_cod) 
   references trhu_ttr;

alter table trhu_ttr 
   add constraint rrhu_ttr_idf_fk 
   foreign key (ttr_idf_cod) 
   references trhu_idf;

alter table trhu_zon 
   add constraint rrhu_zon_idf_fk 
   foreign key (zon_idf_cod) 
   references trhu_idf;