create table tges_aap (
       aap_emp_cod varchar(4) not null,
        aap_prj_num varchar(6) not null,
        aap_apl int4 not null,
        aap_idf_cod varchar(4) not null,
        aap_codapl varchar(100) not null,
        aap_obs varchar(1000),
        aap_percen float4,
        primary key (aap_emp_cod, aap_prj_num, aap_apl, aap_idf_cod)
    );

    create table tges_acc (
       acc_cli_cod varchar(6) not null,
        acc_cod varchar(4) not null,
        acc_idf_cod varchar(4) not null,
        acc_usucre varchar(255),
        acc_datcre timestamp,
        acc_usumod varchar(255),
        acc_datmod timestamp,
        acc_cpo_cod varchar(255),
        acc_ref002 varchar(50),
        acc_ref003 varchar(50),
        acc_blo varchar(1) not null,
        acc_ref001 varchar(50),
        acc_con varchar(60),
        acc_env varchar(10),
        acc_dom varchar(30) not null,
        acc_def varchar(1) not null,
        acc_eml varchar(60),
        acc_fax varchar(60),
        acc_lat float4,
        acc_lon float4,
        acc_obs varchar(1000),
        acc_tel varchar(60),
        acc_telmov varchar(60),
        acc_scl_cod varchar(255),
        primary key (acc_cli_cod, acc_cod, acc_idf_cod)
    );

    create table tges_alb (
       alb_emp_cod varchar(4) not null,
        alb_numdoc int4 not null,
        alb_idf_cod varchar(4) not null,
        alb_usucre varchar(255),
        alb_datcre timestamp,
        alb_usumod varchar(255),
        alb_datmod timestamp,
        alb_cls varchar(1) not null,
        alb_dia timestamp not null,
        alb_dti varchar(1) not null,
        alb_valdiveur numeric(19, 2),
        alb_fac_cls varchar(255),
        alb_fac_num int4,
        alb_fbl varchar(1) not null,
        alb_fpa varchar(1) not null,
        alb_num int4 not null,
        alb_ser_codfac varchar(2),
        primary key (alb_emp_cod, alb_numdoc, alb_idf_cod)
    );

    create table tges_ane (
       ane_emp_cod varchar(4) not null,
        ane_cod varchar(4) not null,
        ane_idf_cod varchar(4) not null,
        ane_usucre varchar(255),
        ane_datcre timestamp,
        ane_usumod varchar(255),
        ane_datmod timestamp,
        ane_codcmp varchar(30),
        ane_ctecmpcli varchar(10),
        ane_ctecmpcos varchar(10),
        ane_ctecmpexi varchar(10),
        ane_ctecmppro varchar(10),
        ane_ctecmpmag varchar(10),
        ane_ctecmpobr varchar(10),
        ane_nom varchar(30),
        primary key (ane_emp_cod, ane_cod, ane_idf_cod)
    );

    create table tges_apl (
       apl_ref int4 not null,
        apl_idf_cod varchar(4) not null,
        apl_act varchar(1) not null,
        apl_cod varchar(15) not null,
        apl_des varchar(1000),
        apl_nom varchar(30) not null,
        apl_obs varchar(1000),
        apl_tip varchar(1) not null,
        apl_emp_cod varchar(4),
        apl_apl_ref int4,
        primary key (apl_ref, apl_idf_cod)
    );

    create table tges_art (
       art_cod varchar(4) not null,
        art_idf_cod varchar(4) not null,
        art_usucre varchar(255),
        art_datcre timestamp,
        art_usumod varchar(255),
        art_datmod timestamp,
        art_art_cod02 varchar(15),
        art_art_cod varchar(15),
        art_codrae varchar(15),
        art_ali varchar(30),
        art_blo varchar(1) not null,
        art_cst varchar(1) not null,
        art_sto varchar(1) not null,
        art_creref varchar(1) not null,
        art_decpru int4 not null,
        art_des varchar(2000) not null,
        art_descur varchar(60),
        art_fce numeric(15, 3) not null,
        art_fcs numeric(15, 3) not null,
        art_pvp numeric(17, 5) not null,
        art_emp_cod varchar(4),
        art_far_cod varchar(6) not null,
        art_gma_cod varchar(6),
        art_iva_cod varchar(4) not null,
        art_mca_cod varchar(6),
        art_mod_cod varchar(6) not null,
        primary key (art_cod, art_idf_cod)
    );

    create table tges_ban (
       ban_cod int4 not null,
        ban_idf_cod varchar(4) not null,
        ban_usucre varchar(255),
        ban_datcre timestamp,
        ban_usumod varchar(255),
        ban_datmod timestamp,
        ban_nom varchar(30) not null,
        primary key (ban_cod, ban_idf_cod)
    );

    create table tges_cap (
       cap_emp_cod varchar(4) not null,
        cap_pre_cod int4 not null,
        cap_cod varchar(4) not null,
        cap_idf_cod varchar(4) not null,
        cap_usucre varchar(255),
        cap_datcre timestamp,
        cap_usumod varchar(255),
        cap_datmod timestamp,
        primary key (cap_emp_cod, cap_pre_cod, cap_cod, cap_idf_cod)
    );

    create table tges_cbc (
       cbc_ban_cod int4 not null,
        cbc_cli_cod varchar(6) not null,
        cbc_dcc varchar(2) not null,
        cbc_emp_cod varchar(4) not null,
        cbc_ccr int4 not null,
        cbc_ofb_cod int4 not null,
        cbc_idf_cod varchar(4) not null,
        cbc_usucre varchar(255),
        cbc_datcre timestamp,
        cbc_usumod varchar(255),
        cbc_datmod timestamp,
        cbc_ibnbic varchar(11),
        cbc_ibndcc varchar(2),
        cbc_obs varchar(1000),
        cbc_ibnpai varchar(2),
        primary key (cbc_ban_cod, cbc_cli_cod, cbc_dcc, cbc_emp_cod, cbc_ccr, cbc_ofb_cod, cbc_idf_cod)
    );

    create table tges_cce (
       cce_cli_cod varchar(6) not null,
        cce_emp_cod varchar(4) not null,
        cce_idf_cod varchar(4) not null,
        cce_ctecmp varchar(10),
        cce_cteven varchar(10),
        primary key (cce_cli_cod, cce_emp_cod, cce_idf_cod)
    );

    create table tges_cfg_rep (
       cfg_cod varchar(22) not null,
        cfg_idf_cod varchar(4) not null,
        cfg_usucre varchar(255),
        cfg_datcre timestamp,
        cfg_usumod varchar(255),
        cfg_datmod timestamp,
        cfg_cls varchar(1),
        cfg_des varchar(30) not null,
        cfg_nom varchar(30) not null,
        cfg_subtip varchar(30),
        cfg_tip varchar(2) not null,
        cfg_emp_cod varchar(4),
        cfg_ser_cod varchar(2),
        primary key (cfg_cod, cfg_idf_cod)
    );

    create table tges_cli (
       cli_cod varchar(6) not null,
        cli_idf_cod varchar(4) not null,
        cli_usucre varchar(255),
        cli_datcre timestamp,
        cli_usumod varchar(255),
        cli_datmod timestamp,
        cli_acc_cod varchar(4),
        cli_ban_cod int4,
        cli_clr_cod varchar(4),
        cli_cpo_cod varchar(8),
        cli_cpo_codoficmp varchar(8),
        cli_cpo_codorgges varchar(8),
        cli_cpo_codunitrm varchar(8),
        cli_div_cod varchar(4) not null,
        cli_dpg_cod varchar(4) not null,
        cli_www varchar(60),
        cli_albcls int4,
        cli_albval varchar(1) not null,
        cli_ali varchar(30),
        cli_aplims varchar(1),
        cli_aplimpsrv varchar(1),
        cli_pvl varchar(1) not null,
        cli_ibnbic varchar(11),
        cli_blo varchar(1) not null,
        cli_rgtaea varchar(1),
        cli_cobdiallo varchar(255),
        cli_ctecmp varchar(10),
        cli_cteven varchar(10),
        cli_confacele varchar(255),
        cli_copfac int4,
        cli_bandatfirmdl019 timestamp,
        cli_dtectt float4,
        cli_dtectt001 float4,
        cli_dtepla001 float4,
        cli_dtepla float4,
        cli_dcc varchar(2),
        cli_ibndcc varchar(2),
        cli_domfis varchar(60),
        cli_domoficmp varchar(60),
        cli_domorgges varchar(60),
        cli_domunitrm varchar(60),
        cli_eml varchar(60),
        cli_emlalb varchar(100),
        cli_emlfac varchar(100),
        cli_emlfacele varchar(60),
        cli_ettpub varchar(1) not null,
        cli_envfac varchar(1),
        cli_escdom varchar(2),
        cli_facele varchar(255),
        cli_facmin numeric(19, 2),
        cli_facsendte varchar(1),
        cli_fax varchar(60),
        cli_imsicl varchar(1),
        cli_lat numeric(19, 2),
        cli_llnfis001 varchar(40),
        cli_llnfis002 varchar(40),
        cli_lon numeric(19, 2),
        cli_avifac001 varchar(255) not null,
        cli_nif varchar(12),
        cli_notprnpal varchar(1),
        cli_notprnscl varchar(1),
        cli_nomcom varchar(40) not null,
        cli_nomdom varchar(30),
        cli_nomfis varchar(40) not null,
        cli_nomfis001 varchar(40),
        cli_ccr int8,
        cli_numdom varchar(5),
        cli_obs varchar(2000),
        cli_obsfac varchar(1000),
        cli_oficmp varchar(30),
        cli_orgges varchar(30),
        cli_ibnpai varchar(2),
        cli_parnum001 numeric(19, 2),
        cli_parnum002 numeric(19, 2),
        cli_parnum003 numeric(19, 2),
        cli_parnum004 numeric(19, 2),
        cli_parnum005 numeric(19, 2),
        cli_parnumcom001 numeric(19, 2),
        cli_parnumcom002 numeric(19, 2),
        cli_parnumcom003 numeric(19, 2),
        cli_parnumcom004 numeric(19, 2),
        cli_parnumcom005 numeric(19, 2),
        cli_partxt001 varchar(60),
        cli_partxt002 varchar(60),
        cli_partxt003 varchar(60),
        cli_partxt004 varchar(60),
        cli_partxt005 varchar(60),
        cli_partxtcom001 varchar(60),
        cli_partxtcom002 varchar(60),
        cli_partxtcom003 varchar(60),
        cli_partxtcom004 varchar(60),
        cli_partxtcom005 varchar(60),
        cli_ptefac001 float4,
        cli_ret float4,
        cli_ctlffo varchar(1) not null,
        cli_con varchar(60),
        cli_pisdom varchar(2),
        cli_pordom varchar(2),
        cli_pot varchar(1) not null,
        cli_viscmlprt timestamp,
        cli_pubweb varchar(1),
        cli_reb varchar(1) not null,
        cli_recequ varchar(1) not null,
        cli_banrefmdl019 varchar(35),
        cli_rislim numeric(19, 2),
        cli_rismax numeric(19, 2),
        cli_stc_cod varchar(4),
        cli_tel varchar(60),
        cli_telfacele varchar(60),
        cli_tipdte int4,
        cli_tipext varchar(1),
        cli_tipfac int4 not null,
        cli_tipmsg varchar(1) not null,
        cli_tipnif int4,
        cli_tipper varchar(1),
        cli_tipret int4,
        cli_unitrm varchar(30),
        cli_emp_codser varchar(4),
        cli_fmc_cod varchar(4) not null,
        cli_idi_cod varchar(4),
        cli_iva_cod varchar(4),
        cli_ofb_cod int4,
        cli_ope_cod varchar(6),
        cli_org_cod varchar(6),
        cli_painif varchar(4),
        cli_rap_cod varchar(4),
        cli_rgi_cod varchar(2) not null,
        cli_ser_cod varchar(4),
        cli_tar_cod001 varchar(4),
        cli_tar_cod002 varchar(4),
        cli_tds_cod002 varchar(6),
        cli_tds_cod varchar(6),
        cli_sgl varchar(4),
        cli_tcs_cod varchar(4),
        cli_tfc_cod varchar(4) not null,
        cli_tve_cod001 varchar(4),
        cli_tve_cod varchar(4) not null,
        cli_tra_cod varchar(6),
        cli_zon_cod varchar(4),
        primary key (cli_cod, cli_idf_cod)
    );

    create table tges_clm (
       clm_man_cne varchar(30) not null,
        clm_cli_cod varchar(6) not null,
        clm_idf_cod varchar(4) not null,
        clm_usucre varchar(255),
        clm_datcre timestamp,
        clm_usumod varchar(255),
        clm_datmod timestamp,
        primary key (clm_man_cne, clm_cli_cod, clm_idf_cod)
    );

    create table tges_clr (
       clr_cod varchar(4) not null,
        clr_idf_cod varchar(4) not null,
        clr_usucre varchar(255),
        clr_datcre timestamp,
        clr_usumod varchar(255),
        clr_datmod timestamp,
        clr_ctecmpcpr varchar(10),
        clr_ctecmpven varchar(10),
        clr_des varchar(30) not null,
        clr_cmp varchar(10),
        primary key (clr_cod, clr_idf_cod)
    );

    create table tges_cnt (
       cnt_cod varchar(15) not null,
        cnt_idf_cod varchar(4) not null,
        cnt_usucre varchar(255),
        cnt_datcre timestamp,
        cnt_usumod varchar(255),
        cnt_datmod timestamp,
        cnt_ultval int4 not null,
        primary key (cnt_cod, cnt_idf_cod)
    );

    create table tges_cpo (
       cpo_cod varchar(8) not null,
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

    create table tges_ctp (
       ctp_cli_cod varchar(6) not null,
        ctp_tip_cod varchar(4) not null,
        ctp_idf_cod varchar(4) not null,
        ctp_usucre varchar(255),
        ctp_datcre timestamp,
        ctp_usumod varchar(255),
        ctp_datmod timestamp,
        primary key (ctp_cli_cod, ctp_tip_cod, ctp_idf_cod)
    );

    create table tges_cxa (
       cxa_emp_cod varchar(4) not null,
        cxa_cod varchar(4) not null,
        cxa_idf_cod varchar(4) not null,
        cxa_usucre varchar(255),
        cxa_datcre timestamp,
        cxa_usumod varchar(255),
        cxa_datmod timestamp,
        cxa_des varchar(30) not null,
        cxa_apucmp varchar(255) not null,
        cxa_obs varchar(1000),
        primary key (cxa_emp_cod, cxa_cod, cxa_idf_cod)
    );

    create table tges_dep (
       dep_emp_cod varchar(4) not null,
        dep_cod varchar(4) not null,
        dep_idf_cod varchar(4) not null,
        dep_usucre varchar(255),
        dep_datcre timestamp,
        dep_usumod varchar(255),
        dep_datmod timestamp,
        dep_des varchar(60) not null,
        dep_obs varchar(1000),
        primary key (dep_emp_cod, dep_cod, dep_idf_cod)
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
        dfs_sec_cod varchar(255),
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

    create table tges_dpc (
       dpc_cli_cod varchar(6) not null,
        dpc_cod varchar(4) not null,
        dpc_idf_cod varchar(4) not null,
        dpc_usucre varchar(255),
        dpc_datcre timestamp,
        dpc_usumod varchar(255),
        dpc_datmod timestamp,
        dpc_cpo_cod varchar(10),
        dpc_ref002 varchar(50),
        dpc_www varchar(60),
        dpc_blo varchar(1),
        dpc_ref001 varchar(50),
        dpc_dom varchar(60),
        dpc_eml varchar(60),
        dpc_fax001 varchar(60),
        dpc_fax002 varchar(60),
        dpc_nom varchar(30) not null,
        dpc_obs varchar(1000),
        dpc_con varchar(60),
        dpc_tel001 varchar(60),
        dpc_tel002 varchar(60),
        dpc_scl_cod varchar(10),
        primary key (dpc_cli_cod, dpc_cod, dpc_idf_cod)
    );

    create table tges_dpg (
       dpg_cod varchar(4) not null,
        dpg_idf_cod varchar(4) not null,
        dpg_usucre varchar(255),
        dpg_datcre timestamp,
        dpg_usumod varchar(255),
        dpg_datmod timestamp,
        dpg_acuvto varchar(255),
        dpg_apldteppg varchar(255),
        dpg_asicmp varchar(255) not null,
        dpg_codcmp varchar(255),
        dpg_codfacele varchar(255),
        dpg_cnccmp varchar(255),
        dpg_ctecmppag varchar(255),
        dpg_ctecmping varchar(255),
        dpg_ctecmpcmi varchar(255),
        dpg_crlefecob varchar(255),
        dpg_des varchar(30) not null,
        dpg_diaefeneg int4,
        dpg_dricmping varchar(255),
        dpg_dricmping002 varchar(255),
        dpg_dricmppag varchar(255),
        dpg_dricmppag002 varchar(255),
        dpg_numdiaval int4,
        dpg_percmi numeric(19, 2),
        dpg_tipasiing varchar(255),
        dpg_tipasipag varchar(255),
        dpg_trs varchar(255) not null,
        dpg_iva_cod varchar(255),
        dpg_npg_cod varchar(255),
        dpg_rgi_cod varchar(255),
        primary key (dpg_cod, dpg_idf_cod)
    );

    create table tges_emg (
       emg_emp_cod varchar(4) not null,
        emg_gru_cod varchar(4) not null,
        emg_idf_cod varchar(4) not null,
        emg_usucre varchar(255),
        emg_datcre timestamp,
        emg_usumod varchar(255),
        emg_datmod timestamp,
        primary key (emg_emp_cod, emg_gru_cod, emg_idf_cod)
    );

    create table tges_emp (
       emp_cod varchar(4) not null,
        emp_idf_cod varchar(4) not null,
        emp_usucre varchar(255),
        emp_datcre timestamp,
        emp_usumod varchar(255),
        emp_datmod timestamp,
        emp_cpo_codcom varchar(8) not null,
        emp_cpo_codfis varchar(8) not null,
        emp_div_cod varchar(4) not null,
        emp_tipasicmp varchar(2),
        emp_clicmp varchar(1),
        emp_codcmp varchar(60),
        emp_procmp varchar(1),
        emp_dricmp varchar(2),
        emp_driprfcmp varchar(2),
        emp_domcom varchar(60) not null,
        emp_domfis varchar(60) not null,
        emp_eml varchar(60),
        emp_tipfac int4,
        emp_fax varchar(60),
        emp_llnfis001 varchar(40),
        emp_llnfis002 varchar(40),
        emp_prnlog varchar(1),
        emp_dirlog varchar(300),
        emp_nif varchar(12) not null,
        emp_nomcom varchar(40) not null,
        emp_nomfis varchar(40) not null,
        emp_nomfis001 varchar(40),
        emp_tipper varchar(1),
        emp_rec varchar(1),
        emp_regcricxa varchar(1),
        emp_rgtmtl varchar(250),
        emp_dattan timestamp,
        emp_tel varchar(60),
        emp_tipext varchar(1),
        emp_valfac numeric(19, 2),
        emp_www varchar(60),
        emp_mag_cod varchar(4),
        primary key (emp_cod, emp_idf_cod)
    );

    create table tges_etp (
       etp_emp_cod varchar(4) not null,
        etp_num numeric(19, 2) not null,
        etp_prj_num varchar(6) not null,
        etp_cod varchar(4) not null,
        etp_idf_cod varchar(4) not null,
        etp_usucre varchar(255),
        etp_datcre timestamp,
        etp_usumod varchar(255),
        etp_datmod timestamp,
        etp_div_cod varchar(4) not null,
        etp_des varchar(1000) not null,
        etp_dspfnr numeric(15, 3),
        etp_diafin timestamp,
        etp_diaini timestamp not null,
        etp_esttra numeric(19, 2),
        etp_magman numeric(15, 3),
        etp_obs varchar(1000),
        etp_revgru varchar(1),
        etp_revres varchar(1),
        etp_revetp varchar(1),
        etp_tan varchar(1),
        etp_tip numeric(19, 2),
        etp_valdiveur numeric(15, 8) not null,
        primary key (etp_emp_cod, etp_num, etp_prj_num, etp_cod, etp_idf_cod)
    );

    create table tges_fae (
       fae_far_cod varchar(4) not null,
        fae_emp_cod varchar(4) not null,
        fae_idf_cod varchar(4) not null,
        fae_usucre varchar(255),
        fae_datcre timestamp,
        fae_usumod varchar(255),
        fae_datmod timestamp,
        fae_web varchar(255),
        primary key (fae_far_cod, fae_emp_cod, fae_idf_cod)
    );

    create table tges_far (
       far_cod varchar(6) not null,
        far_idf_cod varchar(4) not null,
        far_usucre varchar(255),
        far_datcre timestamp,
        far_usumod varchar(255),
        far_datmod timestamp,
        far_pda varchar(1),
        far_avialb varchar(1) not null,
        far_ctacprcmp varchar(10),
        far_ctecmpexi varchar(500),
        far_ctavencmp varchar(10),
        far_desope varchar(500),
        far_des varchar(30) not null,
        far_discos varchar(1),
        far_blogenalb varchar(1) not null,
        far_lotnav varchar(1) not null,
        far_marmin float4,
        far_marpvpcos float4,
        far_obs varchar(1000),
        far_ptependev float4,
        far_pop varchar(1),
        far_seqord int8,
        far_fabunimet varchar(1),
        far_tip varchar(1) not null,
        far_tipser varchar(1),
        far_ubinav varchar(1) not null,
        far_cmiven float4,
        far_fct_cod varchar(4),
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
        fct_far_cod varchar(255),
        fct_des varchar(60) not null,
        fct_obs varchar(1000),
        primary key (fct_cod, fct_idf_cod)
    );

    create table tges_ffa (
       ffa_cod varchar(4) not null,
        ffa_idf_cod varchar(4) not null,
        ffa_usucre varchar(255),
        ffa_datcre timestamp,
        ffa_usumod varchar(255),
        ffa_datmod timestamp,
        ffa_act varchar(1) not null,
        ffa_des varchar(1000),
        ffa_nom varchar(30) not null,
        primary key (ffa_cod, ffa_idf_cod)
    );

    create table tges_fmc (
       fmc_cod varchar(4) not null,
        fmc_idf_cod varchar(4) not null,
        fmc_usucre varchar(255),
        fmc_datcre timestamp,
        fmc_usumod varchar(255),
        fmc_datmod timestamp,
        fmc_ctavencmp varchar(10),
        fmc_nom varchar(30) not null,
        fmc_obs varchar(1000),
        fmc_tri_cod varchar(4),
        primary key (fmc_cod, fmc_idf_cod)
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
        gma_prupes numeric(8, 4),
        primary key (gma_cod, gma_idf_cod)
    );

    create table tges_gre (
       gre_emp_cod varchar(4) not null,
        gre_grp_cod varchar(4) not null,
        gre_idf_cod varchar(4) not null,
        gre_usucre varchar(255),
        gre_datcre timestamp,
        gre_usumod varchar(255),
        gre_datmod timestamp,
        primary key (gre_emp_cod, gre_grp_cod, gre_idf_cod)
    );

    create table tges_grp (
       grp_cod varchar(4) not null,
        grp_idf_cod varchar(4) not null,
        grp_usucre varchar(255),
        grp_datcre timestamp,
        grp_usumod varchar(255),
        grp_datmod timestamp,
        grp_nom varchar(30),
        primary key (grp_cod, grp_idf_cod)
    );

    create table tges_gru (
       gru_cod varchar(4) not null,
        gru_idf_cod varchar(4) not null,
        gru_usucre varchar(255),
        gru_datcre timestamp,
        gru_usumod varchar(255),
        gru_datmod timestamp,
        gru_nom varchar(30) not null,
        gru_obs varchar(1000),
        primary key (gru_cod, gru_idf_cod)
    );

    create table tges_hop (
       hop_emp_cod varchar(4) not null,
        hop_prj_num varchar(6) not null,
        hop_seq int4 not null,
        hop_idf_cod varchar(4) not null,
        hop_usucre varchar(255),
        hop_datcre timestamp,
        hop_usumod varchar(255),
        hop_datmod timestamp,
        hop_datfin timestamp,
        hop_datini timestamp,
        hop_tipope varchar(255) not null,
        hop_ope_cod varchar(6),
        primary key (hop_emp_cod, hop_prj_num, hop_seq, hop_idf_cod)
    );

    create table tges_idf (
       idf_cod varchar(4) not null,
        idf_usucre varchar(255),
        idf_datcre timestamp,
        idf_usumod varchar(255),
        idf_datmod timestamp,
        idf_nom varchar(40) not null,
        primary key (idf_cod)
    );

    create table tges_idi (
       idi_cod varchar(4) not null,
        idi_idf_cod varchar(4) not null,
        idi_usucre varchar(255),
        idi_datcre timestamp,
        idi_usumod varchar(255),
        idi_datmod timestamp,
        idi_codiso varchar(2) not null,
        idi_des varchar(30) not null,
        primary key (idi_cod, idi_idf_cod)
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

    create table tges_les (
       les_emp_cod varchar(4) not null,
        les_etp_cod varchar(4) not null,
        les_etp_num numeric(3, 0) not null,
        les_prj_num varchar(6) not null,
        les_seq int4 not null,
        les_idf_cod varchar(4) not null,
        les_usucre varchar(255),
        les_datcre timestamp,
        les_usumod varchar(255),
        les_datmod timestamp,
        les_art_cod varchar(15) not null,
        les_codint varchar(30),
        les_cod varchar(30) not null,
        les_cosuni numeric(17, 5) not null,
        les_cosant numeric(10, 2),
        les_cosreaact numeric(10, 2),
        les_cosreaant numeric(10, 2),
        les_des varchar(2000) not null,
        les_desred varchar(128) not null,
        les_eas_seq numeric(10, 0),
        les_impiptact numeric(10, 2),
        les_impiptant numeric(10, 2),
        les_numori numeric(3, 0),
        les_pru numeric(17, 5) not null,
        les_ref varchar(30),
        les_seqpae numeric(10, 0),
        les_unietd numeric(15, 3) not null,
        les_uniact numeric(15, 3),
        les_uniant numeric(15, 3),
        les_unipre numeric(15, 3),
        les_pre_cod varchar(22) not null,
        les_lpr_num varchar(22) not null,
        les_uce_seq varchar(22) not null,
        les_tun_cod varchar(4) not null,
        primary key (les_emp_cod, les_etp_cod, les_etp_num, les_prj_num, les_seq, les_idf_cod)
    );

    create table tges_lff (
       lff_ffa_cod varchar(4) not null,
        lff_ord numeric(19, 2) not null,
        lff_idf_cod varchar(4) not null,
        lff_usucre varchar(255),
        lff_datcre timestamp,
        lff_usumod varchar(255),
        lff_datmod timestamp,
        lff_apltot varchar(1) not null,
        lff_cncfac varchar(1),
        lff_fml varchar(255),
        lff_impfac varchar(1),
        lff_prn varchar(1) not null,
        lff_nom varchar(60) not null,
        primary key (lff_ffa_cod, lff_ord, lff_idf_cod)
    );

    create table tges_lpr (
       lpr_emp_cod varchar(4) not null,
        lpr_num int4 not null,
        lpr_pre_cod int4 not null,
        lpr_idf_cod varchar(4) not null,
        lpr_usucre varchar(255),
        lpr_datcre timestamp,
        lpr_usumod varchar(255),
        lpr_datmod timestamp,
        lpr_art_cod varchar(15) not null,
        lpr_des varchar(4000) not null,
        lpr_fcs int4 not null,
        lpr_pru numeric(17, 5) not null,
        lpr_imp numeric(15, 2) not null,
        lpr_sync varchar(1),
        lpr_uni int4 not null,
        primary key (lpr_emp_cod, lpr_num, lpr_pre_cod, lpr_idf_cod)
    );

    create table tges_mag (
       mag_cod varchar(4) not null,
        mag_idf_cod varchar(4) not null,
        mag_usucre varchar(255),
        mag_datcre timestamp,
        mag_usumod varchar(255),
        mag_datmod timestamp,
        mag_cpo_cod varchar(10),
        mag_div_cod varchar(10),
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
        mag_valinvtrs varchar(1) not null,
        primary key (mag_cod, mag_idf_cod)
    );

    create table tges_man (
       man_cne varchar(30) not null,
        man_idf_cod varchar(4) not null,
        man_usucre varchar(255),
        man_datcre timestamp,
        man_usumod varchar(255),
        man_datmod timestamp,
        man_act varchar(1),
        man_cat varchar(1),
        man_ape varchar(60) not null,
        man_datcdc timestamp,
        man_datexd timestamp,
        man_dom varchar(100),
        man_eml varchar(60),
        man_nif varchar(15),
        man_nom varchar(30) not null,
        man_obs varchar(1000),
        man_tel varchar(60),
        primary key (man_cne, man_idf_cod)
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
        mod_nounitra varchar(1),
        mod_des varchar(30) not null,
        primary key (mod_cod, mod_idf_cod)
    );

    create table tges_mtr (
       mtr_tra_cod varchar(4) not null,
        mtr_cod varchar(4) not null,
        mtr_idf_cod varchar(4) not null,
        mtr_usucre varchar(255),
        mtr_datcre timestamp,
        mtr_usumod varchar(255),
        mtr_datmod timestamp,
        mtr_act varchar(1),
        mtr_cdu varchar(30),
        mtr_des varchar(60),
        mtr_mtr001 varchar(10),
        mtr_mtr002 varchar(10),
        mtr_nif varchar(12),
        mtr_obs varchar(1000),
        mtr_pesmax numeric(19, 2),
        mtr_tara numeric(19, 2),
        mtr_vehemp varchar(1),
        primary key (mtr_tra_cod, mtr_cod, mtr_idf_cod)
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

    create table tges_ofb (
       ofb_ban_cod int4 not null,
        ofb_cod int4 not null,
        ofb_idf_cod varchar(4) not null,
        ofb_usucre varchar(255),
        ofb_datcre timestamp,
        ofb_usumod varchar(255),
        ofb_datmod timestamp,
        ofb_cpo_cod varchar(8) not null,
        ofb_con varchar(60),
        ofb_dom varchar(60),
        ofb_fax varchar(60),
        ofb_obs varchar(1000),
        ofb_tel varchar(60),
        primary key (ofb_ban_cod, ofb_cod, ofb_idf_cod)
    );

    create table tges_org (
       org_cod varchar(4) not null,
        org_idf_cod varchar(4) not null,
        org_usucre varchar(255),
        org_datcre timestamp,
        org_usumod varchar(255),
        org_datmod timestamp,
        org_cpo_cod varchar(8),
        org_www varchar(60),
        org_con varchar(30),
        org_dom varchar(60),
        org_eml varchar(60),
        org_fax varchar(60),
        org_ger varchar(30),
        org_nom varchar(30) not null,
        org_obs varchar(1000),
        org_tel varchar(60),
        primary key (org_cod, org_idf_cod)
    );

    create table tges_par (
       par_cod varchar(15) not null,
        par_idf_cod varchar(4) not null,
        par_usucre varchar(255),
        par_datcre timestamp,
        par_usumod varchar(255),
        par_datmod timestamp,
        par_des varchar(1000) not null,
        par_val varchar(4000) not null,
        primary key (par_cod, par_idf_cod)
    );

    create table tges_pas (
       pas_cod varchar(4) not null,
        pas_idf_cod varchar(4) not null,
        pas_usucre varchar(255),
        pas_datcre timestamp,
        pas_usumod varchar(255),
        pas_datmod timestamp,
        pas_cee varchar(1),
        pas_codiso varchar(3),
        pas_codiso002 varchar(2),
        pas_nif varchar(2),
        pas_nom varchar(30) not null,
        primary key (pas_cod, pas_idf_cod)
    );

    create table tges_pbu (
       pbu_gma_cod varchar(4) not null,
        pbu_tra_cod varchar(15) not null,
        pbu_idf_cod varchar(4) not null,
        pbu_usucre varchar(255),
        pbu_datcre timestamp,
        pbu_usumod varchar(255),
        pbu_datmod timestamp,
        pbu_pru001 numeric(17, 5),
        pbu_pru002 numeric(17, 5),
        pbu_pru003 numeric(17, 5),
        pbu_pru004 numeric(17, 5),
        primary key (pbu_gma_cod, pbu_tra_cod, pbu_idf_cod)
    );

    create table tges_pda (
       pda_cap_cod varchar(255) not null,
        pda_emp_cod varchar(4) not null,
        pda_pre_cod int4 not null,
        pda_cod varchar(4) not null,
        pda_idf_cod varchar(4) not null,
        pda_usucre varchar(255),
        pda_datcre timestamp,
        pda_usumod varchar(255),
        pda_datmod timestamp,
        primary key (pda_cap_cod, pda_emp_cod, pda_pre_cod, pda_cod, pda_idf_cod)
    );

    create table tges_ped (
       ped_emp_cod varchar(4) not null,
        ped_cod varchar(4) not null,
        ped_idf_cod varchar(4) not null,
        ped_usucre varchar(255),
        ped_datcre timestamp,
        ped_usumod varchar(255),
        ped_datmod timestamp,
        ped_alb varchar(255) not null,
        ped_com varchar(255) not null,
        ped_des varchar(30) not null,
        ped_fac varchar(255) not null,
        ped_famclipro varchar(255) not null,
        ped_impcls varchar(255) not null,
        ped_cer varchar(255) not null,
        ped_ord numeric(19, 2),
        ped_pie varchar(1000),
        ped_pre varchar(255) not null,
        ped_scp_codcom varchar(255),
        primary key (ped_emp_cod, ped_cod, ped_idf_cod)
    );

    create table tges_pjp (
       pjp_emp_cod varchar(4) not null,
        pjp_prj_num varchar(6) not null,
        pjp_num int4 not null,
        pjp_idf_cod varchar(4) not null,
        pjp_usucre varchar(255) not null,
        pjp_datcre timestamp not null,
        pjp_usumod varchar(255),
        pjp_datmod timestamp,
        pjp_cap_cod varchar(6),
        pjp_obs varchar(1000),
        pjp_pda_cod varchar(6),
        pjp_pre_cod int4,
        primary key (pjp_emp_cod, pjp_prj_num, pjp_num, pjp_idf_cod)
    );

    create table tges_pmg (
       pmg_mag_cod varchar(4) not null,
        pmg_cod varchar(4) not null,
        pmg_idf_cod varchar(4) not null,
        pmg_usucre varchar(255),
        pmg_datcre timestamp,
        pmg_usumod varchar(255),
        pmg_datmod timestamp,
        pmg_diaini timestamp not null,
        pmg_des varchar(30) not null,
        primary key (pmg_mag_cod, pmg_cod, pmg_idf_cod)
    );

    create table tges_ppj (
       ppj_emp_cod varchar(4) not null,
        ppj_prj_num varchar(6) not null,
        ppj_pro_cod varchar(6) not null,
        ppj_idf_cod varchar(4) not null,
        ppj_usucre varchar(255),
        ppj_datcre timestamp,
        primary key (ppj_emp_cod, ppj_prj_num, ppj_pro_cod, ppj_idf_cod)
    );

    create table tges_ppz (
       ppz_tra_cod varchar(15) not null,
        ppz_zon_cod varchar(4) not null,
        ppz_idf_cod varchar(4) not null,
        ppz_usucre varchar(255),
        ppz_datcre timestamp,
        ppz_usumod varchar(255),
        ppz_datmod timestamp,
        ppz_div_cod varchar(4) not null,
        ppz_obs varchar(1000),
        ppz_precio numeric(17, 5) not null,
        primary key (ppz_tra_cod, ppz_zon_cod, ppz_idf_cod)
    );

    create table tges_pre (
       pre_emp_cod varchar(4) not null,
        pre_cod int4 not null,
        pre_idf_cod varchar(4) not null,
        pre_usucre varchar(255),
        pre_datcre timestamp,
        pre_usumod varchar(255),
        pre_datmod timestamp,
        pre_num int4 not null,
        primary key (pre_emp_cod, pre_cod, pre_idf_cod)
    );

    create table tges_prj (
       prj_emp_cod varchar(4) not null,
        prj_num varchar(6) not null,
        prj_idf_cod varchar(4) not null,
        prj_usucre varchar(255),
        prj_datcre timestamp,
        prj_usumod varchar(255),
        prj_datmod timestamp,
        prj_ane_cod varchar(4),
        prj_acc_cod varchar(4),
        prj_cli_cod varchar(6),
        prj_cpo_cod varchar(8),
        prj_div_cod varchar(4),
        prj_dir varchar(200),
        prj_crealbcli varchar(1),
        prj_prualbcli int4,
        prj_tip int4,
        prj_codcmp varchar(4),
        prj_percon varchar(60),
        prj_telcon varchar(30),
        prj_crlcos varchar(1),
        prj_diaadj timestamp,
        prj_diadevava timestamp,
        prj_plaeje timestamp,
        prj_datfin timestamp,
        prj_datfinprt timestamp,
        prj_datfingar timestamp,
        prj_datfmz timestamp,
        prj_datini timestamp,
        prj_datgar timestamp,
        prj_diarebfin timestamp,
        prj_diarebpvi timestamp,
        prj_des varchar(1000),
        prj_descur varchar(500),
        prj_dta varchar(1),
        prj_dipfia varchar(250),
        prj_dirtec varchar(60),
        prj_est int4,
        prj_baj numeric(15, 8),
        prj_gstgen numeric(15, 2),
        prj_valexc varchar(1),
        prj_tas numeric(5, 2),
        prj_pda varchar(1),
        prj_horrut numeric(7, 2),
        prj_horequ numeric(7, 2),
        prj_horeqc numeric(7, 2),
        prj_horeqg numeric(7, 2),
        prj_impfia numeric(15, 3),
        prj_mesgar numeric(7, 2),
        prj_mulcli varchar(1),
        prj_nom varchar(250) not null,
        prj_obs varchar(1000),
        prj_pteejc numeric(7, 2),
        prj_pteejg numeric(7, 2),
        prj_pteeje numeric(7, 2),
        prj_plspel varchar(1),
        prj_pob varchar(100),
        prj_prumigfac numeric(15, 2),
        prj_ref varchar(20),
        prj_res varchar(60),
        prj_ret numeric(5, 2),
        prj_tipret varchar(1),
        prj_tec varchar(3000),
        prj_tipeje int4,
        prj_tipinv varchar(1),
        prj_tipobr int4,
        prj_valetm numeric(15, 3),
        prj_ffa_cod varchar(6),
        prj_iva_codinv varchar(4),
        prj_mag_cod varchar(4),
        prj_ope_codadm varchar(6),
        prj_ope_codcgr varchar(6),
        prj_ope_enccod varchar(6),
        prj_ope_cod varchar(6),
        prj_tpj_cod varchar(6),
        prj_rgi_codinv varchar(2),
        prj_clr_cod varchar(4),
        prj_sec_cod varchar(2),
        prj_ser_cod varchar(2),
        prj_sei_codinv varchar(4),
        prj_scl_cod varchar(4),
        prj_zon_cod varchar(4),
        primary key (prj_emp_cod, prj_num, prj_idf_cod)
    );

    create table tges_pro (
       pro_cod varchar(4) not null,
        pro_idf_cod varchar(4) not null,
        pro_usucre varchar(255),
        pro_datcre timestamp,
        pro_usumod varchar(255),
        pro_datmod timestamp,
        pro_cpo_cod varchar(8) not null,
        pro_div_cod varchar(4) not null,
        pro_dpg_cod varchar(4) not null,
        pro_blo varchar(1),
        pro_dhm varchar(1),
        pro_nomcom varchar(30),
        pro_nomfis varchar(1000),
        pro_scn varchar(1),
        pro_fpr_cod varchar(4) not null,
        pro_rgi_cod varchar(4) not null,
        pro_tve_cod varchar(4) not null,
        primary key (pro_cod, pro_idf_cod)
    );

    create table tges_prv (
       prv_pas_cod varchar(4) not null,
        prv_cod varchar(4) not null,
        prv_idf_cod varchar(4) not null,
        prv_usucre varchar(255),
        prv_datcre timestamp,
        prv_usumod varchar(255),
        prv_datmod timestamp,
        prv_nom varchar(30) not null,
        primary key (prv_pas_cod, prv_cod, prv_idf_cod)
    );

    create table tges_ptv (
       ptv_emp_cod varchar(4) not null,
        ptv_cod varchar(4) not null,
        ptv_idf_cod varchar(4) not null,
        ptv_usucre varchar(255),
        ptv_datcre timestamp,
        ptv_usumod varchar(255),
        ptv_datmod timestamp,
        ptv_cxa_cod varchar(4) not null,
        ptv_cli_cod varchar(6) not null,
        ptv_div_cod varchar(4) not null,
        ptv_div_cod002 varchar(4),
        ptv_dpg_cod varchar(4) not null,
        ptv_ip varchar(60),
        ptv_dirimg varchar(80),
        ptv_apecxa varchar(60),
        ptv_ultnaz int4,
        ptv_datimp date,
        ptv_enu varchar(255) not null,
        ptv_horinidia time,
        ptv_tipprn varchar(255) not null,
        ptv_nom varchar(30) not null,
        ptv_talpgn varchar(15),
        ptv_cpç varchar(1000),
        ptv_ivaicl varchar(255) not null,
        ptv_linbot int4 not null,
        ptv_peu varchar(1000),
        ptv_bdd varchar(20),
        ptv_dir varchar(80),
        ptv_mag_cod varchar(4) not null,
        ptv_ope_cod varchar(6) not null,
        ptv_ser_cod varchar(2),
        primary key (ptv_emp_cod, ptv_cod, ptv_idf_cod)
    );

    create table tges_rap (
       rap_cod varchar(4) not null,
        rap_idf_cod varchar(4) not null,
        rap_usucre varchar(255),
        rap_datcre timestamp,
        rap_usumod varchar(255),
        rap_datmod timestamp,
        rap_abs varchar(1),
        rap_des varchar(30),
        rap_esc varchar(1),
        rap_limini numeric(19, 2),
        rap_limfin numeric(19, 2),
        rap_pte float4,
        rap_pte001 float4,
        primary key (rap_cod, rap_idf_cod)
    );

    create table tges_rgc (
       rgc_emp_cod varchar(4) not null,
        rgc_seq int4 not null,
        rgc_idf_cod varchar(4) not null,
        rgc_usucre varchar(255),
        rgc_datcre timestamp,
        rgc_usumod varchar(255),
        rgc_datmod timestamp,
        rgc_cli_cod varchar(4),
        rgc_com varchar(1500),
        rgc_dac varchar(500),
        rgc_dat timestamp,
        rgc_desmtj varchar(60),
        rgc_int varchar(60) not null,
        rgc_mtj varchar(1) not null,
        rgc_tip varchar(1) not null,
        rgc_apl_ref int4,
        primary key (rgc_emp_cod, rgc_seq, rgc_idf_cod)
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

    create table tges_scl (
       scl_cli_cod varchar(6) not null,
        scl_cod varchar(4) not null,
        scl_idf_cod varchar(4) not null,
        scl_usucre varchar(255),
        scl_datcre timestamp,
        scl_usumod varchar(255),
        scl_datmod timestamp,
        scl_acc_cod varchar(4),
        scl_clr_cod varchar(4),
        scl_cpo_cod varchar(8),
        scl_act varchar(60),
        scl_albcls int4,
        scl_blo varchar(1) not null,
        scl_oficmp varchar(30),
        scl_orgges varchar(30),
        scl_unitrm varchar(30),
        scl_confacele varchar(255),
        scl_cpo_codoficmp varchar(8),
        scl_cpo_codorgges varchar(8),
        scl_cpo_codunitrm varchar(8),
        scl_dom varchar(60),
        scl_domoficmp varchar(60),
        scl_domorgges varchar(60),
        scl_domunitrm varchar(60),
        scl_emlfacele varchar(60),
        scl_emlfac varchar(100),
        scl_fax varchar(60),
        scl_lat numeric(19, 2),
        scl_lon numeric(19, 2),
        scl_nom varchar(30) not null,
        scl_obs varchar(2000),
        scl_ret float4,
        scl_pvl varchar(1) not null,
        scl_pubweb varchar(1),
        scl_reb varchar(1),
        scl_rgi_codinv varchar(2),
        scl_sei_codinv varchar(2),
        scl_tds_cod002 varchar(6),
        scl_tel varchar(60),
        scl_telfacele varchar(60),
        scl_tipdte int4,
        scl_tipinv varchar(1),
        scl_tipret int4,
        scl_iva_cod varchar(6),
        scl_ope_codenc varchar(6),
        scl_ope_codres varchar(6),
        scl_rgi_cod varchar(2),
        scl_tar_cod001 varchar(4),
        scl_tar_cod002 varchar(4),
        scl_tds_cod varchar(6),
        scl_tcs_cod varchar(4),
        scl_tve_cod001 varchar(4),
        scl_tve_cod varchar(4),
        scl_zon_cod varchar(4),
        primary key (scl_cli_cod, scl_cod, scl_idf_cod)
    );

    create table tges_scp (
       scp_emp_cod varchar(4) not null,
        scp_cod varchar(4) not null,
        scp_idf_cod varchar(4) not null,
        scp_usucre varchar(255),
        scp_datcre timestamp,
        scp_usumod varchar(255),
        scp_datmod timestamp,
        scp_ctecprcmp varchar(255),
        scp_ctecprprfcmp varchar(255) not null,
        scp_des varchar(30) not null,
        scp_dsgivacmp varchar(1) not null,
        scp_dricmp varchar(255) not null,
        scp_driprfcmp varchar(255),
        scp_tipasicmp varchar(255) not null,
        scp_diaini timestamp not null,
        scp_diafin timestamp not null,
        scp_emp_cod002 varchar(4),
        scp_mag_cod varchar(4),
        primary key (scp_emp_cod, scp_cod, scp_idf_cod)
    );

    create table tges_sei (
       sei_emp_cod varchar(4) not null,
        sei_cod varchar(4) not null,
        sei_idf_cod varchar(4) not null,
        sei_des varchar(60) not null,
        sei_dia001 timestamp not null,
        sei_dia002 timestamp not null,
        sei_serdef varchar(1),
        sei_ultfac numeric(19, 2),
        primary key (sei_emp_cod, sei_cod, sei_idf_cod)
    );

    create table tges_ser (
       ser_emp_cod varchar(4) not null,
        ser_cod varchar(2) not null,
        ser_idf_cod varchar(4) not null,
        ser_usucre varchar(255),
        ser_datcre timestamp,
        ser_usumod varchar(255),
        ser_datmod timestamp,
        ser_ped_cod varchar(4),
        ser_dep_cod varchar(4),
        ser_dte varchar(1) not null,
        ser_cnrvencli varchar(1),
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
        ser_dsgivacmp varchar(1) not null,
        ser_dricmp varchar(2),
        ser_driprfcmp varchar(2),
        ser_facrct varchar(1),
        ser_titfac varchar(500),
        ser_ncf varchar(20),
        ser_man varchar(1) not null,
        ser_tipasicmp varchar(2),
        ser_trscmp varchar(1),
        ser_dia001 timestamp not null,
        ser_dia002 timestamp not null,
        ser_emp_codprn varchar(4),
        ser_mag_cod varchar(4),
        ser_ped_codfac varchar(4),
        primary key (ser_emp_cod, ser_cod, ser_idf_cod)
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
        sui_mag_cod varchar(6) not null,
        sui_idf_cod varchar(4) not null,
        sui_usucre varchar(255),
        sui_datcre timestamp,
        sui_usumod varchar(255),
        sui_datmod timestamp,
        sui_div_cod varchar(4) not null,
        sui_prucosuni numeric(19, 2) not null,
        sui_uniini numeric(19, 2) not null,
        sui_unimetini numeric(19, 2),
        sui_pmg_cod varchar(255),
        primary key (sui_art_cod, sui_cls, sui_mag_cod, sui_idf_cod)
    );

    create table tges_taj (
       taj_emp_cod varchar(4) not null,
        taj_prj_num varchar(6) not null,
        taj_pro_cod varchar(6) not null,
        taj_tpr_cod varchar(6) not null,
        taj_idf_cod varchar(4) not null,
        taj_usucre varchar(255),
        taj_datcre timestamp,
        taj_usumod varchar(255),
        taj_datmod timestamp,
        primary key (taj_emp_cod, taj_prj_num, taj_pro_cod, taj_tpr_cod, taj_idf_cod)
    );

    create table tges_tar (
       tar_cod varchar(4) not null,
        tar_idf_cod varchar(4) not null,
        tar_usucre varchar(255),
        tar_datcre timestamp,
        tar_usumod varchar(255),
        tar_datmod timestamp,
        tar_canpru varchar(1),
        tar_diafin timestamp,
        tar_diaini timestamp,
        tar_dtegen varchar(1),
        tar_des varchar(30) not null,
        tar_calpvp varchar(1),
        tar_ptemanobr numeric(19, 2) not null,
        tar_ptemat numeric(19, 2) not null,
        tar_ofr varchar(1),
        tar_tip varchar(1),
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
        tfc_crd varchar(1),
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

    create table tges_tpj (
       tpj_cod varchar(6) not null,
        tpj_idf_cod varchar(4) not null,
        tpj_usucre varchar(255),
        tpj_datcre timestamp,
        tpj_usumod varchar(255),
        tpj_datmod timestamp,
        tpj_des varchar(30),
        tpj_nom varchar(30) not null,
        primary key (tpj_cod, tpj_idf_cod)
    );

    create table tges_tpl (
       tpl_apl numeric(3, 0) not null,
        tpl_tra_cod varchar(15) not null,
        tpl_cod varchar(20) not null,
        tpl_idf_cod varchar(4) not null,
        tpl_usucre varchar(255),
        tpl_datcre timestamp,
        tpl_usumod varchar(255),
        tpl_datmod timestamp,
        tpl_obs varchar(1000),
        primary key (tpl_apl, tpl_tra_cod, tpl_cod, tpl_idf_cod)
    );

    create table tges_tpr (
       tpr_pro_cod varchar(4) not null,
        tpr_cod varchar(4) not null,
        tpr_idf_cod varchar(4) not null,
        tpr_usucre varchar(255),
        tpr_datcre timestamp,
        tpr_usumod varchar(255),
        tpr_datmod timestamp,
        primary key (tpr_pro_cod, tpr_cod, tpr_idf_cod)
    );

    create table tges_tra (
       tra_cod varchar(4) not null,
        tra_idf_cod varchar(4) not null,
        tra_usucre varchar(255),
        tra_datcre timestamp,
        tra_usumod varchar(255),
        tra_datmod timestamp,
        tra_cpo_cod varchar(8) not null,
        tra_div_cod varchar(4) not null,
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
        tra_vehemp varchar(255),
        tra_pro_cod varchar(6),
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
        tri_nifigu varchar(255),
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
        tve_ultdiamescpr varchar(1),
        tve_ultdiamesven varchar(1),
        tve_des varchar(30),
        tve_dia002pla int4,
        tve_diapga int4,
        tve_diapla int4,
        tve_diapla001 int4,
        tve_diapla004 int4,
        tve_diapla005 int4,
        tve_diapla002 int4,
        tve_diapla003 int4,
        tve_gencobpag varchar(1),
        tve_imppla numeric(19, 2),
        tve_mespga varchar(255),
        tve_mestan varchar(255),
        tve_mindia int4,
        tve_numpla int4,
        tve_ptepla001 float4,
        tve_ptepla004 float4,
        tve_ptepla005 float4,
        tve_ptepla002 float4,
        tve_ptepla003 float4,
        tve_mesclt varchar(1),
        tve_tip varchar(1) not null,
        primary key (tve_cod, tve_idf_cod)
    );

    create table tges_uba (
       uba_art_cod varchar(6) not null,
        uba_mag_cod varchar(6) not null,
        uba_idf_cod varchar(4) not null,
        uba_usucre varchar(255),
        uba_datcre timestamp,
        uba_usumod varchar(255),
        uba_datmod timestamp,
        uba_uni varchar(22),
        uba_ubi_cod varchar(255),
        primary key (uba_art_cod, uba_mag_cod, uba_idf_cod)
    );

    create table tges_ubi (
       ubi_mag_cod varchar(6) not null,
        ubi_cod varchar(4) not null,
        ubi_idf_cod varchar(4) not null,
        ubi_usucre varchar(255),
        ubi_datcre timestamp,
        ubi_usumod varchar(255),
        ubi_datmod timestamp,
        ubi_des varchar(30),
        primary key (ubi_mag_cod, ubi_cod, ubi_idf_cod)
    );

    create table tges_uce (
       uce_emp_cod varchar(4) not null,
        uce_etp_cod varchar(4) not null,
        uce_etp_num numeric(3, 0) not null,
        uce_prj_num varchar(6) not null,
        uce_seq int4 not null,
        uce_idf_cod varchar(4) not null,
        uce_usucre varchar(255),
        uce_datcre timestamp,
        uce_usumod varchar(255),
        uce_datmod timestamp,
        uce_codint varchar(30),
        uce_cod varchar(30) not null,
        uce_cosact numeric(10, 2),
        uce_cosant numeric(10, 2),
        uce_cosreaact numeric(10, 2),
        uce_cosreaant numeric(10, 2),
        uce_des varchar(250),
        uce_eas_seq numeric(10, 0),
        uce_impiptact numeric(10, 2),
        uce_impiptant numeric(10, 2),
        uce_numori numeric(3, 0),
        uce_pdcact numeric(10, 2),
        uce_pdcant numeric(10, 2),
        primary key (uce_emp_cod, uce_etp_cod, uce_etp_num, uce_prj_num, uce_seq, uce_idf_cod)
    );

    create table tges_usg (
       usg_gru_cod varchar(4) not null,
        usg_usu_cod varchar(30) not null,
        usg_idf_cod varchar(4) not null,
        usg_usucre varchar(255),
        usg_datcre timestamp,
        usg_usumod varchar(255),
        usg_datmod timestamp,
        primary key (usg_gru_cod, usg_usu_cod, usg_idf_cod)
    );

    create table tges_vpp (
       vpp_emp_cod varchar(4) not null,
        vpp_prj_num varchar(6) not null,
        vpp_pro_cod varchar(6) not null,
        vpp_idf_cod varchar(4) not null,
        vpp_usucre varchar(255),
        vpp_datcre timestamp,
        vpp_tve_cod varchar(4) not null,
        primary key (vpp_emp_cod, vpp_prj_num, vpp_pro_cod, vpp_idf_cod)
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
    
create index iges_aap_emp_fk on tges_aap (aap_idf_cod, aap_emp_cod);
create index iges_aap_prj_fk on tges_aap (aap_idf_cod, aap_prj_num);
create index iges_acc_idf_fk on tges_acc (acc_idf_cod);

    alter table tges_acc 
       add constraint irges_acc_pk unique (acc_idf_cod, acc_cod);
create index iges_alb_idf_fk on tges_alb (alb_idf_cod);

    alter table tges_alb 
       add constraint irges_alb_pk unique (alb_idf_cod);
create index iges_ane_idf_fk on tges_ane (ane_idf_cod);

    alter table tges_ane 
       add constraint irges_ane_pk unique (ane_idf_cod, ane_cod);
create index iges_apl_idf_fk on tges_apl (apl_idf_cod);
create index iges_art_idf_fk on tges_art (art_idf_cod);
create index iges_ban_idf_fk on tges_ban (ban_idf_cod);
create index iges_cap_emp_fk on tges_cap (cap_idf_cod, cap_emp_cod);
create index iges_cap_pre_fk on tges_cap (cap_idf_cod, cap_emp_cod, cap_pre_cod);
create index iges_cbc_idf_fk on tges_cbc (cbc_idf_cod);
create index iges_cce_idf_fk on tges_cce (cce_idf_cod);
create index iges_cfg_idf_fk on tges_cfg_rep (cfg_idf_cod);

    alter table tges_cfg_rep 
       add constraint irges_cfg_pk unique (cfg_idf_cod, cfg_emp_cod, cfg_ser_cod, cfg_cls, cfg_tip, cfg_subtip);
create index iges_cli_idf_fk on tges_cli (cli_idf_cod);

    alter table tges_clm 
       add constraint mancli_uk unique (clm_man_cne, clm_cli_cod);
create index iges_clr_idf_fk on tges_clr (clr_idf_cod);
create index iges_cnt_idf_fk on tges_cnt (cnt_idf_cod);
create index iges_cpo_idf_fk on tges_cpo (cpo_idf_cod);

    alter table tges_ctp 
       add constraint tipusr_uk unique (ctp_cli_cod, ctp_tip_cod);
create index iges_cxa_idf_fk on tges_cxa (cxa_idf_cod);
create index iges_cxa_emp_fk on tges_cxa (cxa_emp_cod);
create index iges_dep_idf_fk on tges_dep (dep_idf_cod);

    alter table tges_dep 
       add constraint irges_dep_pk unique (dep_idf_cod, dep_cod);
create index iges_dfs_idf_fk on tges_dfs (dfs_idf_cod);

    alter table tges_dfs 
       add constraint irges_dfs_pk unique (dfs_idf_cod);
create index iges_div_idf_fk on tges_div (div_idf_cod);
create index iges_dpc_idf_fk on tges_dpc (dpc_idf_cod);

    alter table tges_dpc 
       add constraint irges_dpc_pk unique (dpc_idf_cod, dpc_cod);
create index iges_dpg_idf_fk on tges_dpg (dpg_idf_cod);
create index iges_emg_idf_fk on tges_emg (emg_idf_cod);
create index iges_emp_idf_fk on tges_emp (emp_idf_cod);
create index iges_etp_emp_fk on tges_etp (etp_idf_cod, etp_emp_cod, etp_prj_num, etp_cod, etp_num);
create index iges_fae_idf_fk on tges_fae (fae_idf_cod);

    alter table tges_fae 
       add constraint irges_fae_pk unique (fae_idf_cod);
create index iges_far_idf_fk on tges_far (far_idf_cod);
create index iges_fct_idf_fk on tges_fct (fct_idf_cod);
create index iges_ffa_idf_fk on tges_ffa (ffa_idf_cod);
create index iges_fmc_idf_fk on tges_fmc (fmc_idf_cod);
create index iges_fpr_idf_fk on tges_fpr (fpr_idf_cod);
create index iges_gma_idf_fk on tges_gma (gma_idf_cod);
create index iges_gre_idf_fk on tges_gre (gre_idf_cod);
create index iges_grp_idf_fk on tges_grp (grp_idf_cod);
create index iges_gru_idf_fk on tges_gru (gru_idf_cod);
create index iges_hop_emp_fk on tges_hop (hop_idf_cod, hop_emp_cod);
create index iges_hop_prj_fk on tges_hop (hop_idf_cod, hop_prj_num);
create index iges_hop_ope_fk on tges_hop (hop_idf_cod, hop_ope_cod);
create index iges_idi_idf_fk on tges_idi (idi_idf_cod);
create index iges_iva_idf_fk on tges_iva (iva_idf_cod);
create index iges_les_idf_fk on tges_les (les_idf_cod);

    alter table tges_les 
       add constraint irges_les_pk unique (les_idf_cod, les_emp_cod, les_prj_num, les_etp_cod, les_etp_num, les_cod);
create index iges_lff_idf_fk on tges_lff (lff_idf_cod);
create index iges_lpr_emp_fk on tges_lpr (lpr_idf_cod, lpr_emp_cod);
create index iges_lpr_pre_fk on tges_lpr (lpr_idf_cod, lpr_emp_cod, lpr_pre_cod);
create index iges_mag_idf_fk on tges_mag (mag_idf_cod);
create index iges_man_idf_fk on tges_man (man_idf_cod);
create index iges_mca_idf_fk on tges_mca (mca_idf_cod);
create index iges_mod_idf_fk on tges_mod (mod_idf_cod);
create index iges_npg_idf_fk on tges_npg (npg_idf_cod);
create index iges_ofb_idf_fk on tges_ofb (ofb_idf_cod);

    alter table tges_ofb 
       add constraint irges_ofb_pk unique (ofb_idf_cod, ofb_cod);
create index iges_org_idf_fk on tges_org (org_idf_cod);
create index iges_par_idf_fk on tges_par (par_idf_cod);
create index iges_pas_idf_fk on tges_pas (pas_idf_cod);
create index iges_pbu_idf_fk on tges_pbu (pbu_idf_cod);
create index iges_pda_emp_fk on tges_pda (pda_idf_cod, pda_emp_cod);
create index iges_pda_pre_fk on tges_pda (pda_idf_cod, pda_emp_cod, pda_pre_cod);
create index iges_pda_cap_fk on tges_pda (pda_idf_cod, pda_emp_cod, pda_pre_cod, pda_cap_cod);
create index iges_ped_idf_fk on tges_ped (ped_idf_cod);

    alter table tges_ped 
       add constraint irges_ped_pk unique (ped_idf_cod, ped_cod);
create index iges_pjp_emp_fk on tges_pjp (pjp_idf_cod, pjp_emp_cod);
create index iges_pjp_prj_fk on tges_pjp (pjp_idf_cod, pjp_prj_num);
create index iges_pjp_pre_fk on tges_pjp (pjp_idf_cod, pjp_pre_cod);
create index iges_pjp_pda_fk on tges_pjp (pjp_idf_cod, pjp_pda_cod);
create index iges_pjp_cap_fk on tges_pjp (pjp_idf_cod, pjp_cap_cod);
create index iges_pmg_idf_fk on tges_pmg (pmg_idf_cod);

    alter table tges_pmg 
       add constraint irges_pmg_pk unique (pmg_idf_cod, pmg_cod);
create index iges_ppj_emp_fk on tges_ppj (ppj_idf_cod, ppj_emp_cod);
create index iges_ppj_prj_fk on tges_ppj (ppj_idf_cod, ppj_prj_num);
create index iges_ppj_pro_fk on tges_ppj (ppj_idf_cod, ppj_pro_cod);
create index iges_ppz_idf_fk on tges_ppz (ppz_idf_cod);
create index iges_pre_emp_fk on tges_pre (pre_idf_cod, pre_emp_cod);
create index iges_prj_idf_fk on tges_prj (prj_idf_cod);

    alter table tges_prj 
       add constraint irges_prj_pk unique (prj_idf_cod, prj_num);
create index iges_pro_idf_fk on tges_pro (pro_idf_cod);
create index iges_prv_idf_fk on tges_prv (prv_idf_cod);

    alter table tges_prv 
       add constraint irges_prv_pk unique (prv_idf_cod, prv_cod);
create index iges_ptv_emp_fk on tges_ptv (ptv_idf_cod, ptv_emp_cod);
create index iges_rap_idf_fk on tges_rap (rap_idf_cod);
create index iges_rgc_emp_fk on tges_rgc (rgc_idf_cod, rgc_emp_cod);
create index iges_rgc_cli_fk on tges_rgc (rgc_idf_cod, rgc_cli_cod);
create index iges_rgc_apl_fk on tges_rgc (rgc_idf_cod, rgc_apl_ref);
create index iges_rgi_idf_fk on tges_rgi (rgi_idf_cod);
create index iges_scl_idf_fk on tges_scl (scl_idf_cod);

    alter table tges_scl 
       add constraint irges_scl_pk unique (scl_idf_cod, scl_cod);
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
create index iges_taj_emp_fk on tges_taj (taj_idf_cod, taj_emp_cod);
create index iges_taj_prj_fk on tges_taj (taj_idf_cod, taj_prj_num);
create index iges_taj_pro_fk on tges_taj (taj_idf_cod, taj_pro_cod);
create index iges_taj_tpr_fk on tges_taj (taj_idf_cod, taj_tpr_cod);
create index iges_tar_idf_fk on tges_tar (tar_idf_cod);
create index iges_tcs_idf_fk on tges_tcs (tcs_idf_cod);
create index iges_tds_idf_fk on tges_tds (tds_idf_cod);
create index iges_tfc_idf_fk on tges_tfc (tfc_idf_cod);
create index iges_tin_idf_fk on tges_tin (tin_idf_cod);
create index iges_tip_idf_fk on tges_tip (tip_idf_cod);
create index iges_tpj_idf_fk on tges_tpj (tpj_idf_cod);
create index iges_tpl_idf_fk on tges_tpl (tpl_idf_cod);
create index iges_tpr_pro_fk on tges_tpr (tpr_idf_cod, tpr_pro_cod);
create index iges_tra_idf_fk on tges_tra (tra_idf_cod);
create index iges_tri_idf_fk on tges_tri (tri_idf_cod);
create index iges_tun_idf_fk on tges_tun (tun_idf_cod);
create index iges_tve_idf_fk on tges_tve (tve_idf_cod);
create index iges_uba_idf_fk on tges_uba (uba_idf_cod);

alter table tges_aap 
       add constraint rges_aap_idf_fk 
       foreign key (aap_idf_cod) 
       references tges_idf;

    alter table tges_aap 
       add constraint rges_aap_emp_fk 
       foreign key (aap_emp_cod, aap_idf_cod) 
       references tges_emp;

    alter table tges_aap 
       add constraint rges_aap_prj_fk 
       foreign key (aap_emp_cod, aap_prj_num, aap_idf_cod) 
       references tges_prj;

    alter table tges_acc 
       add constraint rges_acc_cli_fk 
       foreign key (acc_cli_cod, acc_idf_cod) 
       references tges_cli;

    alter table tges_acc 
       add constraint acc_cpo_cod_fk 
       foreign key (acc_cpo_cod, acc_idf_cod) 
       references tges_cpo;

    alter table tges_acc 
       add constraint acc_scl_cod_fk 
       foreign key (acc_cli_cod, acc_scl_cod, acc_idf_cod) 
       references tges_scl;

    alter table tges_alb 
       add constraint rges_alb_emp_fk 
       foreign key (alb_emp_cod, alb_idf_cod) 
       references tges_emp;

    alter table tges_ane 
       add constraint rges_ane_emp_fk 
       foreign key (ane_emp_cod, ane_idf_cod) 
       references tges_emp;

    alter table tges_apl 
       add constraint rges_apl_idf_fk 
       foreign key (apl_idf_cod) 
       references tges_idf;

    alter table tges_apl 
       add constraint rges_apl_emp_fk 
       foreign key (apl_emp_cod, apl_idf_cod) 
       references tges_emp;

    alter table tges_apl 
       add constraint rges_apl_apl_fk 
       foreign key (apl_apl_ref, apl_idf_cod) 
       references tges_apl;

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

    alter table tges_ban 
       add constraint rges_ban_idf_fk 
       foreign key (ban_idf_cod) 
       references trhu_idf;

    alter table tges_cap 
       add constraint rges_cap_emp_fk 
       foreign key (cap_emp_cod, cap_idf_cod) 
       references tges_emp;

    alter table tges_cap 
       add constraint rges_cap_pre_fk 
       foreign key (cap_emp_cod, cap_pre_cod, cap_idf_cod) 
       references tges_pre;

    alter table tges_cbc 
       add constraint rges_cbc_ban_fk 
       foreign key (cbc_ban_cod, cbc_idf_cod) 
       references tges_ban;

    alter table tges_cbc 
       add constraint rges_cbc_cli_fk 
       foreign key (cbc_cli_cod, cbc_idf_cod) 
       references tges_cli;

    alter table tges_cbc 
       add constraint rges_cbc_emp_fk 
       foreign key (cbc_emp_cod, cbc_idf_cod) 
       references tges_emp;

    alter table tges_cbc 
       add constraint rges_cbc_ofb_fk 
       foreign key (cbc_ban_cod, cbc_ofb_cod, cbc_idf_cod) 
       references tges_ofb;

    alter table tges_cce 
       add constraint rges_cce_idf_fk 
       foreign key (cce_idf_cod) 
       references tges_idf;

    alter table tges_cce 
       add constraint rges_cce_cli_fk 
       foreign key (cce_cli_cod, cce_idf_cod) 
       references tges_cli;

    alter table tges_cce 
       add constraint rges_cce_emp_fk 
       foreign key (cce_emp_cod, cce_idf_cod) 
       references tges_emp;

    alter table tges_cfg_rep 
       add constraint rges_cfg_emp_fk 
       foreign key (cfg_emp_cod, cfg_idf_cod) 
       references tges_emp;

    alter table tges_cfg_rep 
       add constraint rges_cfg_ser_fk 
       foreign key (cfg_emp_cod, cfg_ser_cod, cfg_idf_cod) 
       references tges_ser;

    alter table tges_cli 
       add constraint cli_acc_cod_fk 
       foreign key (cli_cod, cli_acc_cod, cli_idf_cod) 
       references tges_acc;

    alter table tges_cli 
       add constraint cli_ban_cod_fk 
       foreign key (cli_ban_cod, cli_idf_cod) 
       references tges_ban;

    alter table tges_cli 
       add constraint cli_clr_cod_fk 
       foreign key (cli_clr_cod, cli_idf_cod) 
       references tges_clr;

    alter table tges_cli 
       add constraint cli_cpo_cod_fk 
       foreign key (cli_cpo_cod, cli_idf_cod) 
       references tges_cpo;

    alter table tges_cli 
       add constraint cli_cpo_codoficmp_fk 
       foreign key (cli_cpo_codoficmp, cli_idf_cod) 
       references tges_cpo;

    alter table tges_cli 
       add constraint cli_cpo_codunitrm_fk 
       foreign key (cli_cpo_codorgges, cli_idf_cod) 
       references tges_cpo;

    alter table tges_cli 
       add constraint cli_div_cod_fk 
       foreign key (cli_div_cod, cli_idf_cod) 
       references tges_div;

    alter table tges_cli 
       add constraint cli_dpg_cod_fk 
       foreign key (cli_dpg_cod, cli_idf_cod) 
       references tges_dpg;

    alter table tges_cli 
       add constraint cli_emp_codser_fk 
       foreign key (cli_emp_codser, cli_idf_cod) 
       references tges_emp;

    alter table tges_cli 
       add constraint cli_fmc_cod_fk 
       foreign key (cli_fmc_cod, cli_idf_cod) 
       references tges_fmc;

    alter table tges_cli 
       add constraint cli_idi_cod_fk 
       foreign key (cli_idi_cod, cli_idf_cod) 
       references tges_idi;

    alter table tges_cli 
       add constraint cli_iva_cod_fk 
       foreign key (cli_iva_cod, cli_idf_cod) 
       references tges_iva;

    alter table tges_cli 
       add constraint cli_ofb_cod_fk 
       foreign key (cli_ban_cod, cli_ofb_cod, cli_idf_cod) 
       references tges_ofb;

    alter table tges_cli 
       add constraint cli_ope_cod_fk 
       foreign key (cli_ope_cod, cli_idf_cod) 
       references trhu_ope;

    alter table tges_cli 
       add constraint cli_org_cod_fk 
       foreign key (cli_org_cod, cli_idf_cod) 
       references tges_org;

    alter table tges_cli 
       add constraint cli_pni_cod_fk 
       foreign key (cli_painif) 
       references tlim_pni;

    alter table tges_cli 
       add constraint cli_rap_cod_fk 
       foreign key (cli_rap_cod, cli_idf_cod) 
       references tges_rap;

    alter table tges_cli 
       add constraint cli_rgi_cod_fk 
       foreign key (cli_rgi_cod, cli_idf_cod) 
       references tges_rgi;

    alter table tges_cli 
       add constraint cli_ser_cod_fk 
       foreign key (cli_emp_codser, cli_ser_cod, cli_idf_cod) 
       references tges_ser;

    alter table tges_cli 
       add constraint cli_tar_cod001_fk 
       foreign key (cli_tar_cod001, cli_idf_cod) 
       references tges_tar;

    alter table tges_cli 
       add constraint cli_tar_cod002_fk 
       foreign key (cli_tar_cod002, cli_idf_cod) 
       references tges_tar;

    alter table tges_cli 
       add constraint cli_tds_cod_fk 
       foreign key (cli_tds_cod, cli_idf_cod) 
       references tges_tds;

    alter table tges_cli 
       add constraint cli_tds_cod002_fk 
       foreign key (cli_tds_cod002, cli_idf_cod) 
       references tges_tds;

    alter table tges_cli 
       add constraint cli_tcs_cod_fk 
       foreign key (cli_tcs_cod, cli_idf_cod) 
       references tges_tcs;

    alter table tges_cli 
       add constraint cli_tfc_cod_fk 
       foreign key (cli_tfc_cod, cli_idf_cod) 
       references tges_tfc;

    alter table tges_cli 
       add constraint cli_tve_cod001_fk 
       foreign key (cli_tve_cod001, cli_idf_cod) 
       references tges_tve;

    alter table tges_cli 
       add constraint cli_tra_cod_fk 
       foreign key (cli_tra_cod, cli_idf_cod) 
       references tges_tra;

    alter table tges_cli 
       add constraint cli_zon_cod_fk 
       foreign key (cli_zon_cod, cli_idf_cod) 
       references tges_zon;

    alter table tges_clm 
       add constraint rges_clm_man_fk 
       foreign key (clm_man_cne, clm_idf_cod) 
       references tges_man;

    alter table tges_clm 
       add constraint rges_clm_cli_fk 
       foreign key (clm_cli_cod, clm_idf_cod) 
       references tges_cli;

    alter table tges_cnt 
       add constraint rges_cnt_idf_fk 
       foreign key (cnt_idf_cod) 
       references tges_idf;

    alter table tges_cpo 
       add constraint rges_cpo_pas_fk 
       foreign key (cpo_pas_cod, cpo_idf_cod) 
       references tges_pas;

    alter table tges_cpo 
       add constraint rges_cpo_prv_fk 
       foreign key (cpo_pas_cod, cpo_prv_cod, cpo_idf_cod) 
       references tges_prv;

    alter table tges_cpo 
       add constraint rges_cpo_idf_fk 
       foreign key (cpo_idf_cod) 
       references trhu_idf;

    alter table tges_ctp 
       add constraint rges_ctp_cli_fk 
       foreign key (ctp_cli_cod, ctp_idf_cod) 
       references tges_cli;

    alter table tges_ctp 
       add constraint rges_ctp_tip_fk 
       foreign key (ctp_tip_cod, ctp_idf_cod) 
       references tges_tip;

    alter table tges_cxa 
       add constraint rges_cxa_emp_fk 
       foreign key (cxa_emp_cod, cxa_idf_cod) 
       references tges_emp;

    alter table tges_dep 
       add constraint rges_dep_emp_fk 
       foreign key (dep_emp_cod, dep_idf_cod) 
       references tges_emp;

    alter table tges_dfs 
       add constraint rges_dfs_far_fk 
       foreign key (dfs_far_cod, dfs_idf_cod) 
       references tges_far;

    alter table tges_dfs 
       add constraint rges_dfs_emp_fk 
       foreign key (dfs_emp_cod, dfs_idf_cod) 
       references tges_emp;

    alter table tges_dfs 
       add constraint rges_dfs_sec_fk 
       foreign key (dfs_emp_cod, dfs_sec_cod, dfs_idf_cod) 
       references trhu_sec;

    alter table tges_dpc 
       add constraint rges_dpc_cli_fk 
       foreign key (dpc_cli_cod, dpc_idf_cod) 
       references tges_cli;

    alter table tges_dpc 
       add constraint rges_dpc_cpo_fk 
       foreign key (dpc_cpo_cod, dpc_idf_cod) 
       references tges_cpo;

    alter table tges_dpc 
       add constraint rges_dpc_scl_fk 
       foreign key (dpc_cli_cod, dpc_scl_cod, dpc_idf_cod) 
       references tges_scl;

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

    alter table tges_emg 
       add constraint rges_emg_emp_fk 
       foreign key (emg_emp_cod, emg_idf_cod) 
       references tges_emp;

    alter table tges_emg 
       add constraint rges_emg_gru_fk 
       foreign key (emg_gru_cod, emg_idf_cod) 
       references tges_gru;

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
       add constraint rges_emp_mag_fk 
       foreign key (emp_mag_cod, emp_idf_cod) 
       references tges_mag;

    alter table tges_etp 
       add constraint rges_etp_div_fk 
       foreign key (etp_div_cod, etp_idf_cod) 
       references tges_div;

    alter table tges_etp 
       add constraint rges_etp_prj_fk 
       foreign key (etp_emp_cod, etp_prj_num, etp_idf_cod) 
       references tges_prj;

    alter table tges_fae 
       add constraint rges_fae_far_fk 
       foreign key (fae_far_cod, fae_idf_cod) 
       references tges_far;

    alter table tges_fae 
       add constraint rges_fae_emp_fk 
       foreign key (fae_emp_cod, fae_idf_cod) 
       references tges_emp;

    alter table tges_far 
       add constraint rges_far_fct_fk 
       foreign key (far_fct_cod, far_idf_cod) 
       references tges_fct;

    alter table tges_far 
       add constraint rges_far_gre_fk 
       foreign key (far_gre_cod, far_idf_cod) 
       references trhu_gre;

    alter table tges_fct 
       add constraint rges_fct_far_fk 
       foreign key (fct_far_cod, fct_idf_cod) 
       references tges_far;

    alter table tges_fmc 
       add constraint fmc_tri_cod_fk 
       foreign key (fmc_tri_cod, fmc_idf_cod) 
       references tges_tri;

    alter table tges_gre 
       add constraint rges_gre_emp_fk 
       foreign key (gre_emp_cod, gre_idf_cod) 
       references tges_emp;

    alter table tges_gre 
       add constraint rges_gre_gru_fk 
       foreign key (gre_grp_cod, gre_idf_cod) 
       references tges_grp;

    alter table tges_hop 
       add constraint rges_hop_emp_fk 
       foreign key (hop_emp_cod, hop_idf_cod) 
       references tges_emp;

    alter table tges_hop 
       add constraint hop_ope_cod_fk 
       foreign key (hop_ope_cod, hop_idf_cod) 
       references trhu_ope;

    alter table tges_hop 
       add constraint rges_hop_prj_fk 
       foreign key (hop_emp_cod, hop_prj_num, hop_idf_cod) 
       references tges_prj;

    alter table tges_les 
       add constraint rges_les_art_fk 
       foreign key (les_art_cod, les_idf_cod) 
       references tges_art;

    alter table tges_les 
       add constraint rges_les_emp_fk 
       foreign key (les_emp_cod, les_idf_cod) 
       references tges_emp;

    alter table tges_les 
       add constraint rges_les_etp_fk 
       foreign key (les_emp_cod, les_etp_num, les_prj_num, les_etp_cod, les_idf_cod) 
       references tges_etp;

    alter table tges_les 
       add constraint rges_les_pre_fk 
       foreign key (les_emp_cod, les_pre_cod, les_idf_cod) 
       references tges_pre;

    alter table tges_les 
       add constraint rges_les_lpr_fk 
       foreign key (les_emp_cod, les_lpr_num, les_pre_cod, les_idf_cod) 
       references tges_lpr;

    alter table tges_les 
       add constraint rges_les_prj_fk 
       foreign key (les_emp_cod, les_prj_num, les_idf_cod) 
       references tges_prj;

    alter table tges_les 
       add constraint rges_les_uce_fk 
       foreign key (les_emp_cod, les_etp_cod, les_etp_num, les_prj_num, les_uce_seq, les_idf_cod) 
       references tges_uce;

    alter table tges_les 
       add constraint rges_les_tun_fk 
       foreign key (les_tun_cod, les_idf_cod) 
       references tges_tun;

    alter table tges_lff 
       add constraint rges_lff_ffa_fk 
       foreign key (lff_ffa_cod, lff_idf_cod) 
       references tges_ffa;

    alter table tges_lpr 
       add constraint rges_lpr_art_fk 
       foreign key (lpr_art_cod, lpr_idf_cod) 
       references tges_art;

    alter table tges_lpr 
       add constraint rges_lpr_emp_fk 
       foreign key (lpr_emp_cod, lpr_idf_cod) 
       references tges_emp;

    alter table tges_lpr 
       add constraint rges_lpr_pre_fk 
       foreign key (lpr_emp_cod, lpr_pre_cod, lpr_idf_cod) 
       references tges_pre;

    alter table tges_mag 
       add constraint rges_mag_cpo_fk 
       foreign key (mag_cpo_cod, mag_idf_cod) 
       references tges_cpo;

    alter table tges_mag 
       add constraint rges_mag_div_fk 
       foreign key (mag_div_cod, mag_idf_cod) 
       references tges_div;

    alter table tges_mtr 
       add constraint rges_zon_tra_fk 
       foreign key (mtr_tra_cod, mtr_idf_cod) 
       references tges_tra;

    alter table tges_ofb 
       add constraint ofb_ban_cod_fk 
       foreign key (ofb_ban_cod, ofb_idf_cod) 
       references tges_ban;

    alter table tges_ofb 
       add constraint ofb_cpo_cod_fk 
       foreign key (ofb_cpo_cod, ofb_idf_cod) 
       references tges_cpo;

    alter table tges_ofb 
       add constraint rges_ofb_idf_fk 
       foreign key (ofb_idf_cod) 
       references trhu_idf;

    alter table tges_org 
       add constraint org_cpo_cod_fk 
       foreign key (org_cpo_cod, org_idf_cod) 
       references tges_cpo;

    alter table tges_pas 
       add constraint rges_pas_idf_fk 
       foreign key (pas_idf_cod) 
       references trhu_idf;

    alter table tges_pbu 
       add constraint rges_pbu_gma_fk 
       foreign key (pbu_gma_cod, pbu_idf_cod) 
       references tges_gma;

    alter table tges_pbu 
       add constraint rges_pbu_tra_fk 
       foreign key (pbu_tra_cod, pbu_idf_cod) 
       references tges_tra;

    alter table tges_pda 
       add constraint rges_pda_cap_fk 
       foreign key (pda_emp_cod, pda_pre_cod, pda_cap_cod, pda_idf_cod) 
       references tges_cap;

    alter table tges_pda 
       add constraint rges_pda_emp_fk 
       foreign key (pda_emp_cod, pda_idf_cod) 
       references tges_emp;

    alter table tges_pda 
       add constraint rges_pda_pre_fk 
       foreign key (pda_emp_cod, pda_pre_cod, pda_idf_cod) 
       references tges_pre;

    alter table tges_ped 
       add constraint rges_ped_emp_fk 
       foreign key (ped_emp_cod, ped_idf_cod) 
       references tges_emp;

    alter table tges_ped 
       add constraint rges_ped_scp_fk 
       foreign key (ped_emp_cod, ped_scp_codcom, ped_idf_cod) 
       references tges_scp;

    alter table tges_pjp 
       add constraint rges_pjp_cap_fk 
       foreign key (pjp_emp_cod, pjp_pre_cod, pjp_cap_cod, pjp_idf_cod) 
       references tges_cap;

    alter table tges_pjp 
       add constraint rges_pjp_emp_fk 
       foreign key (pjp_emp_cod, pjp_idf_cod) 
       references tges_emp;

    alter table tges_pjp 
       add constraint rges_pjp_pda_fk 
       foreign key (pjp_cap_cod, pjp_emp_cod, pjp_pre_cod, pjp_pda_cod, pjp_idf_cod) 
       references tges_pda;

    alter table tges_pjp 
       add constraint rges_pjp_pre_fk 
       foreign key (pjp_emp_cod, pjp_pre_cod, pjp_idf_cod) 
       references tges_pre;

    alter table tges_pjp 
       add constraint rges_pjp_prj_fk 
       foreign key (pjp_emp_cod, pjp_prj_num, pjp_idf_cod) 
       references tges_prj;

    alter table tges_pmg 
       add constraint rges_pmg_mag_fk 
       foreign key (pmg_mag_cod, pmg_idf_cod) 
       references tges_mag;

    alter table tges_ppj 
       add constraint rges_ppj_emp_fk 
       foreign key (ppj_emp_cod, ppj_idf_cod) 
       references tges_emp;

    alter table tges_ppj 
       add constraint rges_ppj_prj_fk 
       foreign key (ppj_emp_cod, ppj_prj_num, ppj_idf_cod) 
       references tges_prj;

    alter table tges_ppj 
       add constraint rges_ppj_pro_fk 
       foreign key (ppj_pro_cod, ppj_idf_cod) 
       references tges_pro;

    alter table tges_ppz 
       add constraint ppz_div_cod_fk 
       foreign key (ppz_div_cod, ppz_idf_cod) 
       references tges_div;

    alter table tges_ppz 
       add constraint rges_ppz_tra_fk 
       foreign key (ppz_tra_cod, ppz_idf_cod) 
       references tges_tra;

    alter table tges_ppz 
       add constraint rges_ppz_zon_fk 
       foreign key (ppz_zon_cod, ppz_idf_cod) 
       references tges_zon;

    alter table tges_pre 
       add constraint rges_pre_emp_fk 
       foreign key (pre_emp_cod, pre_idf_cod) 
       references tges_emp;

    alter table tges_prj 
       add constraint prj_ane_cod_fk 
       foreign key (prj_emp_cod, prj_ane_cod, prj_idf_cod) 
       references tges_ane;

    alter table tges_prj 
       add constraint prj_cli_cod_fk 
       foreign key (prj_cli_cod, prj_idf_cod) 
       references tges_cli;

    alter table tges_prj 
       add constraint prj_acc_cod_fk 
       foreign key (prj_cli_cod, prj_acc_cod, prj_idf_cod) 
       references tges_acc;

    alter table tges_prj 
       add constraint prj_cpo_cod_fk 
       foreign key (prj_cpo_cod, prj_idf_cod) 
       references tges_cpo;

    alter table tges_prj 
       add constraint prj_div_cod_fk 
       foreign key (prj_div_cod, prj_idf_cod) 
       references tges_div;

    alter table tges_prj 
       add constraint prj_emp_cod_fk 
       foreign key (prj_emp_cod, prj_idf_cod) 
       references tges_emp;

    alter table tges_prj 
       add constraint prj_ffa_cod_fk 
       foreign key (prj_ffa_cod, prj_idf_cod) 
       references tges_ffa;

    alter table tges_prj 
       add constraint prj_iva_codinv_fk 
       foreign key (prj_iva_codinv, prj_idf_cod) 
       references tges_iva;

    alter table tges_prj 
       add constraint prj_mag_cod_fk 
       foreign key (prj_mag_cod, prj_idf_cod) 
       references tges_mag;

    alter table tges_prj 
       add constraint prj_ope_codadm_fk 
       foreign key (prj_ope_codadm, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint prj_ope_codcgr_fk 
       foreign key (prj_ope_codcgr, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint prj_ope_enccod_fk 
       foreign key (prj_ope_enccod, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint prj_ope_cod_fk 
       foreign key (prj_ope_cod, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint prj_tpj_cod_fk 
       foreign key (prj_tpj_cod, prj_idf_cod) 
       references tges_tpj;

    alter table tges_prj 
       add constraint prj_rgi_codinv_fk 
       foreign key (prj_rgi_codinv, prj_idf_cod) 
       references tges_rgi;

    alter table tges_prj 
       add constraint prj_clr_cod_fk 
       foreign key (prj_clr_cod, prj_idf_cod) 
       references tges_clr;

    alter table tges_prj 
       add constraint prj_sec_cod_fk 
       foreign key (prj_emp_cod, prj_sec_cod, prj_idf_cod) 
       references trhu_sec;

    alter table tges_prj 
       add constraint prj_ser_cod_fk 
       foreign key (prj_emp_cod, prj_ser_cod, prj_idf_cod) 
       references tges_ser;

    alter table tges_prj 
       add constraint prj_sei_codinv_fk 
       foreign key (prj_emp_cod, prj_sei_codinv, prj_idf_cod) 
       references tges_sei;

    alter table tges_prj 
       add constraint prj_scl_cod_fk 
       foreign key (prj_cli_cod, prj_scl_cod, prj_idf_cod) 
       references tges_scl;

    alter table tges_prj 
       add constraint prj_zon_cod_fk 
       foreign key (prj_zon_cod, prj_idf_cod) 
       references tges_zon;

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
       add constraint rges_pro_rgi_fk 
       foreign key (pro_rgi_cod, pro_idf_cod) 
       references tges_rgi;

    alter table tges_pro 
       add constraint rges_pro_tve_fk 
       foreign key (pro_tve_cod, pro_idf_cod) 
       references tges_tve;

    alter table tges_prv 
       add constraint rges_prv_pas_fk 
       foreign key (prv_pas_cod, prv_idf_cod) 
       references tges_pas;

    alter table tges_prv 
       add constraint rges_prv_idf_fk 
       foreign key (prv_idf_cod) 
       references trhu_idf;

    alter table tges_ptv 
       add constraint rges_ptv_cxa_fk 
       foreign key (ptv_emp_cod, ptv_cxa_cod, ptv_idf_cod) 
       references tges_cxa;

    alter table tges_ptv 
       add constraint rges_ptv_cli_fk 
       foreign key (ptv_cli_cod, ptv_idf_cod) 
       references tges_cli;

    alter table tges_ptv 
       add constraint rges_ptv_div_fk 
       foreign key (ptv_div_cod, ptv_idf_cod) 
       references tges_div;

    alter table tges_ptv 
       add constraint rges_ptv_div002_fk 
       foreign key (ptv_div_cod002, ptv_idf_cod) 
       references tges_div;

    alter table tges_ptv 
       add constraint rges_ptv_dpg_fk 
       foreign key (ptv_dpg_cod, ptv_idf_cod) 
       references tges_dpg;

    alter table tges_ptv 
       add constraint rges_ptv_mag_fk 
       foreign key (ptv_mag_cod, ptv_idf_cod) 
       references tges_mag;

    alter table tges_ptv 
       add constraint rges_ptv_ope_fk 
       foreign key (ptv_ope_cod, ptv_idf_cod) 
       references trhu_ope;

    alter table tges_ptv 
       add constraint rges_ptv_ser_fk 
       foreign key (ptv_emp_cod, ptv_ser_cod, ptv_idf_cod) 
       references tges_ser;

    alter table tges_rgc 
       add constraint rges_rgc_cli_fk 
       foreign key (rgc_cli_cod, rgc_idf_cod) 
       references tges_cli;

    alter table tges_rgc 
       add constraint rges_rgc_emp_fk 
       foreign key (rgc_emp_cod, rgc_idf_cod) 
       references tges_emp;

    alter table tges_rgc 
       add constraint rges_rgc_apl_fk 
       foreign key (rgc_apl_ref, rgc_idf_cod) 
       references tges_apl;

    alter table tges_scl 
       add constraint scl_acc_cod_fk 
       foreign key (scl_cli_cod, scl_acc_cod, scl_idf_cod) 
       references tges_acc;

    alter table tges_scl 
       add constraint scl_clr_cod_fk 
       foreign key (scl_clr_cod, scl_idf_cod) 
       references tges_clr;

    alter table tges_scl 
       add constraint scl_cli_cod_fk 
       foreign key (scl_cli_cod, scl_idf_cod) 
       references tges_cli;

    alter table tges_scl 
       add constraint scl_cpo_cod_fk 
       foreign key (scl_cpo_cod, scl_idf_cod) 
       references tges_cpo;

    alter table tges_scl 
       add constraint scl_iva_cod_fk 
       foreign key (scl_iva_cod, scl_idf_cod) 
       references tges_iva;

    alter table tges_scl 
       add constraint scl_ope_codenc_fk 
       foreign key (scl_ope_codenc, scl_idf_cod) 
       references trhu_ope;

    alter table tges_scl 
       add constraint scl_ope_codres_fk 
       foreign key (scl_ope_codres, scl_idf_cod) 
       references trhu_ope;

    alter table tges_scl 
       add constraint scl_rgi_cod_fk 
       foreign key (scl_rgi_cod, scl_idf_cod) 
       references tges_rgi;

    alter table tges_scl 
       add constraint scl_tar_cod001_fk 
       foreign key (scl_tar_cod001, scl_idf_cod) 
       references tges_tar;

    alter table tges_scl 
       add constraint scl_tar_cod002_fk 
       foreign key (scl_tar_cod002, scl_idf_cod) 
       references tges_tar;

    alter table tges_scl 
       add constraint scl_tds_cod_fk 
       foreign key (scl_tds_cod, scl_idf_cod) 
       references tges_tds;

    alter table tges_scl 
       add constraint scl_tcs_cod_fk 
       foreign key (scl_tcs_cod, scl_idf_cod) 
       references tges_tcs;

    alter table tges_scl 
       add constraint scl_tve_cod_fk 
       foreign key (scl_tve_cod, scl_idf_cod) 
       references tges_tve;

    alter table tges_scl 
       add constraint scl_tve_cod001_fk 
       foreign key (scl_tve_cod001, scl_idf_cod) 
       references tges_tve;

    alter table tges_scl 
       add constraint scl_zon_cod_fk 
       foreign key (scl_zon_cod, scl_idf_cod) 
       references tges_zon;

    alter table tges_scp 
       add constraint rges_scp_emp_fk 
       foreign key (scp_emp_cod, scp_idf_cod) 
       references tges_emp;

    alter table tges_scp 
       add constraint rges_scp_emp002_fk 
       foreign key (scp_emp_cod002, scp_idf_cod) 
       references tges_emp;

    alter table tges_scp 
       add constraint rges_scp_mag_fk 
       foreign key (scp_mag_cod, scp_idf_cod) 
       references tges_mag;

    alter table tges_sei 
       add constraint rges_sei_idf_fk 
       foreign key (sei_idf_cod) 
       references tges_idf;

    alter table tges_sei 
       add constraint rges_sei_emp_fk 
       foreign key (sei_emp_cod, sei_idf_cod) 
       references tges_emp;

    alter table tges_ser 
       add constraint rges_ser_pedcondicio_fk 
       foreign key (ser_emp_cod, ser_ped_cod, ser_idf_cod) 
       references tges_ped;

    alter table tges_ser 
       add constraint rges_ser_dep_fk 
       foreign key (ser_emp_cod, ser_dep_cod, ser_idf_cod) 
       references tges_dep;

    alter table tges_ser 
       add constraint rges_ser_emp_fk 
       foreign key (ser_emp_cod, ser_idf_cod) 
       references tges_emp;

    alter table tges_ser 
       add constraint rges_ser_empOp_fk 
       foreign key (ser_emp_codprn, ser_idf_cod) 
       references tges_emp;

    alter table tges_ser 
       add constraint rges_ser_mag_fk 
       foreign key (ser_mag_cod, ser_idf_cod) 
       references tges_mag;

    alter table tges_ser 
       add constraint rges_ser_ped_fk 
       foreign key (ser_emp_cod, ser_ped_codfac, ser_idf_cod) 
       references tges_ped;

    alter table tges_sui 
       add constraint rges_sui_art_fk 
       foreign key (sui_art_cod, sui_idf_cod) 
       references tges_art;

    alter table tges_sui 
       add constraint rges_sui_div_fk 
       foreign key (sui_div_cod, sui_idf_cod) 
       references tges_div;

    alter table tges_sui 
       add constraint rges_sui_mag_fk 
       foreign key (sui_mag_cod, sui_idf_cod) 
       references tges_mag;

    alter table tges_sui 
       add constraint rges_sui_pmg_fk 
       foreign key (sui_mag_cod, sui_pmg_cod, sui_idf_cod) 
       references tges_pmg;

    alter table tges_taj 
       add constraint rges_taj_emp_fk 
       foreign key (taj_emp_cod, taj_idf_cod) 
       references tges_emp;

    alter table tges_taj 
       add constraint rges_taj_prj_fk 
       foreign key (taj_emp_cod, taj_prj_num, taj_idf_cod) 
       references tges_prj;

    alter table tges_taj 
       add constraint rges_taj_pro_fk 
       foreign key (taj_pro_cod, taj_idf_cod) 
       references tges_pro;

    alter table tges_taj 
       add constraint rges_taj_tpr_fk 
       foreign key (taj_pro_cod, taj_tpr_cod, taj_idf_cod) 
       references tges_tpr;

    alter table tges_tcs 
       add constraint rges_tcs_idf_fk 
       foreign key (tcs_idf_cod) 
       references trhu_idf;

    alter table tges_tpl 
       add constraint rges_tpl_tra_fk 
       foreign key (tpl_tra_cod, tpl_idf_cod) 
       references tges_tra;

    alter table tges_tpr 
       add constraint rges_tpr_pro_fk 
       foreign key (tpr_pro_cod, tpr_idf_cod) 
       references tges_pro;

    alter table tges_tra 
       add constraint rges_tra_cpo_fk 
       foreign key (tra_cpo_cod, tra_idf_cod) 
       references tges_cpo;

    alter table tges_tra 
       add constraint rges_tra_div_fk 
       foreign key (tra_div_cod, tra_idf_cod) 
       references tges_div;

    alter table tges_tra 
       add constraint rges_tra_pro_fk 
       foreign key (tra_pro_cod, tra_idf_cod) 
       references tges_pro;

    alter table tges_uba 
       add constraint rges_uba_art_fk 
       foreign key (uba_art_cod, uba_idf_cod) 
       references tges_art;

    alter table tges_uba 
       add constraint rges_uba_mag_fk 
       foreign key (uba_mag_cod, uba_idf_cod) 
       references tges_mag;

    alter table tges_uba 
       add constraint rges_uba_ubi_fk 
       foreign key (uba_mag_cod, uba_ubi_cod, uba_idf_cod) 
       references tges_ubi;

    alter table tges_ubi 
       add constraint rges_ubi_mag_fk 
       foreign key (ubi_mag_cod, ubi_idf_cod) 
       references tges_mag;

    alter table tges_uce 
       add constraint rges_uce_emp_fk 
       foreign key (uce_emp_cod, uce_idf_cod) 
       references tges_emp;

    alter table tges_uce 
       add constraint rges_uce_etp_fk 
       foreign key (uce_emp_cod, uce_etp_num, uce_prj_num, uce_etp_cod, uce_idf_cod) 
       references tges_etp;

    alter table tges_uce 
       add constraint rges_uce_prj_fk 
       foreign key (uce_emp_cod, uce_prj_num, uce_idf_cod) 
       references tges_prj;

    alter table tges_usg 
       add constraint rges_usg_gru_fk 
       foreign key (usg_gru_cod, usg_idf_cod) 
       references tges_gru;

    alter table tges_vpp 
       add constraint rges_vpp_emp_fk 
       foreign key (vpp_emp_cod, vpp_idf_cod) 
       references tges_emp;

    alter table tges_vpp 
       add constraint rges_vpp_prj_fk 
       foreign key (vpp_emp_cod, vpp_prj_num, vpp_idf_cod) 
       references tges_prj;

    alter table tges_vpp 
       add constraint rges_vpp_pro_fk 
       foreign key (vpp_pro_cod, vpp_idf_cod) 
       references tges_pro;

    alter table tges_vpp 
       add constraint rges_vpp_tve_fk 
       foreign key (vpp_tve_cod, vpp_idf_cod) 
       references tges_tve;