create sequence hibernate_sequence start with 1 increment by  1;

create table tges_aap (
       aap_emp_cod varchar2(4 char) not null,
        aap_prj_num varchar2(6 char) not null,
        aap_apl number(10,0) not null,
        aap_idf_cod varchar2(4 char) not null,
        aap_codapl varchar2(100 char) not null,
        aap_obs varchar2(1000 char),
        aap_percen float,
        primary key (aap_emp_cod, aap_prj_num, aap_apl, aap_idf_cod)
    );

    create table tges_acc (
       acc_cli_cod varchar2(6 char) not null,
        acc_cod varchar2(4 char) not null,
        acc_idf_cod varchar2(4 char) not null,
        acc_usucre varchar2(255 char),
        acc_datcre timestamp,
        acc_usumod varchar2(255 char),
        acc_datmod timestamp,
        acc_cpo_cod varchar2(255 char),
        acc_ref002 varchar2(50 char),
        acc_ref003 varchar2(50 char),
        acc_blo varchar2(1 char) not null,
        acc_ref001 varchar2(50 char),
        acc_con varchar2(60 char),
        acc_env varchar2(10 char),
        acc_dom varchar2(30 char) not null,
        acc_def varchar2(1 char) not null,
        acc_eml varchar2(60 char),
        acc_fax varchar2(60 char),
        acc_lat float,
        acc_lon float,
        acc_obs varchar2(1000 char),
        acc_tel varchar2(60 char),
        acc_telmov varchar2(60 char),
        acc_scl_cod varchar2(255 char),
        primary key (acc_cli_cod, acc_cod, acc_idf_cod)
    );

    create table tges_alb (
       alb_emp_cod varchar2(4 char) not null,
        alb_numdoc number(10,0) not null,
        alb_idf_cod varchar2(4 char) not null,
        alb_usucre varchar2(255 char),
        alb_datcre timestamp,
        alb_usumod varchar2(255 char),
        alb_datmod timestamp,
        alb_cls varchar2(1 char) not null,
        alb_dia timestamp not null,
        alb_dti varchar2(1 char) not null,
        alb_valdiveur number(19,2),
        alb_fac_cls varchar2(255 char),
        alb_fac_num number(10,0),
        alb_fbl varchar2(1 char) not null,
        alb_fpa varchar2(1 char) not null,
        alb_num number(10,0) not null,
        alb_ser_codfac varchar2(2 char),
        primary key (alb_emp_cod, alb_numdoc, alb_idf_cod)
    );

    create table tges_ane (
       ane_emp_cod varchar2(4 char) not null,
        ane_cod varchar2(4 char) not null,
        ane_idf_cod varchar2(4 char) not null,
        ane_usucre varchar2(255 char),
        ane_datcre timestamp,
        ane_usumod varchar2(255 char),
        ane_datmod timestamp,
        ane_codcmp varchar2(30 char),
        ane_ctecmpcli varchar2(10 char),
        ane_ctecmpcos varchar2(10 char),
        ane_ctecmpexi varchar2(10 char),
        ane_ctecmppro varchar2(10 char),
        ane_ctecmpmag varchar2(10 char),
        ane_ctecmpobr varchar2(10 char),
        ane_nom varchar2(30 char),
        primary key (ane_emp_cod, ane_cod, ane_idf_cod)
    );

    create table tges_apl (
       apl_ref number(10,0) not null,
        apl_idf_cod varchar2(4 char) not null,
        apl_act varchar2(1 char) not null,
        apl_cod varchar2(15 char) not null,
        apl_des varchar2(1000 char),
        apl_nom varchar2(30 char) not null,
        apl_obs varchar2(1000 char),
        apl_tip varchar2(1 char) not null,
        apl_emp_cod varchar2(4 char),
        apl_apl_ref number(10,0),
        primary key (apl_ref, apl_idf_cod)
    );

    create table tges_art (
       art_cod varchar2(4 char) not null,
        art_idf_cod varchar2(4 char) not null,
        art_usucre varchar2(255 char),
        art_datcre timestamp,
        art_usumod varchar2(255 char),
        art_datmod timestamp,
        art_art_cod02 varchar2(15 char),
        art_art_cod varchar2(15 char),
        art_codrae varchar2(15 char),
        art_ali varchar2(30 char),
        art_blo varchar2(1 char) not null,
        art_cst varchar2(1 char) not null,
        art_sto varchar2(1 char) not null,
        art_creref varchar2(1 char) not null,
        art_decpru number(10,0) not null,
        art_des varchar2(2000 char) not null,
        art_descur varchar2(60 char),
        art_fce number(15,3) not null,
        art_fcs number(15,3) not null,
        art_pvp number(17,5) not null,
        art_emp_cod varchar2(4 char),
        art_far_cod varchar2(6 char) not null,
        art_gma_cod varchar2(6 char),
        art_iva_cod varchar2(4 char) not null,
        art_mca_cod varchar2(6 char),
        art_mod_cod varchar2(6 char) not null,
        primary key (art_cod, art_idf_cod)
    );

    create table tges_ban (
       ban_cod number(10,0) not null,
        ban_idf_cod varchar2(4 char) not null,
        ban_usucre varchar2(255 char),
        ban_datcre timestamp,
        ban_usumod varchar2(255 char),
        ban_datmod timestamp,
        ban_nom varchar2(30 char) not null,
        primary key (ban_cod, ban_idf_cod)
    );

    create table tges_cap (
       cap_emp_cod varchar2(4 char) not null,
        cap_pre_cod number(10,0) not null,
        cap_cod varchar2(4 char) not null,
        cap_idf_cod varchar2(4 char) not null,
        cap_usucre varchar2(255 char),
        cap_datcre timestamp,
        cap_usumod varchar2(255 char),
        cap_datmod timestamp,
        primary key (cap_emp_cod, cap_pre_cod, cap_cod, cap_idf_cod)
    );

    create table tges_cbc (
       cbc_ban_cod number(10,0) not null,
        cbc_cli_cod varchar2(6 char) not null,
        cbc_dcc varchar2(2 char) not null,
        cbc_emp_cod varchar2(4 char) not null,
        cbc_ccr number(10,0) not null,
        cbc_ofb_cod number(10,0) not null,
        cbc_idf_cod varchar2(4 char) not null,
        cbc_usucre varchar2(255 char),
        cbc_datcre timestamp,
        cbc_usumod varchar2(255 char),
        cbc_datmod timestamp,
        cbc_ibnbic varchar2(11 char),
        cbc_ibndcc varchar2(2 char),
        cbc_obs varchar2(1000 char),
        cbc_ibnpai varchar2(2 char),
        primary key (cbc_ban_cod, cbc_cli_cod, cbc_dcc, cbc_emp_cod, cbc_ccr, cbc_ofb_cod, cbc_idf_cod)
    );

    create table tges_cce (
       cce_cli_cod varchar2(6 char) not null,
        cce_emp_cod varchar2(4 char) not null,
        cce_idf_cod varchar2(4 char) not null,
        cce_ctecmp varchar2(10 char),
        cce_cteven varchar2(10 char),
        primary key (cce_cli_cod, cce_emp_cod, cce_idf_cod)
    );
    
    create table tges_cfg_rep (
       cfg_cod varchar2(22 char) not null,
        cfg_idf_cod varchar2(4 char) not null,
        cfg_usucre varchar2(255 char),
        cfg_datcre timestamp,
        cfg_usumod varchar2(255 char),
        cfg_datmod timestamp,
        cfg_cls varchar2(1 char),
        cfg_des varchar2(30 char) not null,
        cfg_nom varchar2(30 char) not null,
        cfg_subtip varchar2(30 char),
        cfg_tip varchar2(2 char) not null,
        cfg_emp_cod varchar2(4 char),
        cfg_ser_cod varchar2(2 char),
        primary key (cfg_cod, cfg_idf_cod)
    );

    create table tges_cli (
       cli_cod varchar2(6 char) not null,
        cli_idf_cod varchar2(4 char) not null,
        cli_usucre varchar2(255 char),
        cli_datcre timestamp,
        cli_usumod varchar2(255 char),
        cli_datmod timestamp,
        cli_acc_cod varchar2(4 char),
        cli_ban_cod number(10,0),
        cli_clr_cod varchar2(4 char),
        cli_cpo_cod varchar2(8 char),
        cli_cpo_codoficmp varchar2(8 char),
        cli_cpo_codorgges varchar2(8 char),
        cli_cpo_codunitrm varchar2(8 char),
        cli_div_cod varchar2(4 char) not null,
        cli_dpg_cod varchar2(4 char) not null,
        cli_www varchar2(60 char),
        cli_albcls number(10,0),
        cli_albval varchar2(1 char) not null,
        cli_ali varchar2(30 char),
        cli_aplims varchar2(1 char),
        cli_aplimpsrv varchar2(1 char),
        cli_pvl varchar2(1 char) not null,
        cli_ibnbic varchar2(11 char),
        cli_blo varchar2(1 char) not null,
        cli_rgtaea varchar2(1 char),
        cli_cobdiallo varchar2(255 char),
        cli_ctecmp varchar2(10 char),
        cli_cteven varchar2(10 char),
        cli_confacele varchar2(255 char),
        cli_copfac number(10,0),
        cli_bandatfirmdl019 timestamp,
        cli_dtectt float,
        cli_dtectt001 float,
        cli_dtepla001 float,
        cli_dtepla float,
        cli_dcc varchar2(2 char),
        cli_ibndcc varchar2(2 char),
        cli_domfis varchar2(60 char),
        cli_domoficmp varchar2(60 char),
        cli_domorgges varchar2(60 char),
        cli_domunitrm varchar2(60 char),
        cli_eml varchar2(60 char),
        cli_emlalb varchar2(100 char),
        cli_emlfac varchar2(100 char),
        cli_emlfacele varchar2(60 char),
        cli_ettpub varchar2(1 char) not null,
        cli_envfac varchar2(1 char),
        cli_escdom varchar2(2 char),
        cli_facele varchar2(255 char),
        cli_facmin number(19,2),
        cli_facsendte varchar2(1 char),
        cli_fax varchar2(60 char),
        cli_imsicl varchar2(1 char),
        cli_lat number(19,2),
        cli_llnfis001 varchar2(40 char),
        cli_llnfis002 varchar2(40 char),
        cli_lon number(19,2),
        cli_avifac001 varchar2(255 char) not null,
        cli_nif varchar2(12 char),
        cli_notprnpal varchar2(1 char),
        cli_notprnscl varchar2(1 char),
        cli_nomcom varchar2(40 char) not null,
        cli_nomdom varchar2(30 char),
        cli_nomfis varchar2(40 char) not null,
        cli_nomfis001 varchar2(40 char),
        cli_ccr number(19,0),
        cli_numdom varchar2(5 char),
        cli_obs varchar2(2000 char),
        cli_obsfac varchar2(1000 char),
        cli_oficmp varchar2(30 char),
        cli_orgges varchar2(30 char),
        cli_ibnpai varchar2(2 char),
        cli_parnum001 number(19,2),
        cli_parnum002 number(19,2),
        cli_parnum003 number(19,2),
        cli_parnum004 number(19,2),
        cli_parnum005 number(19,2),
        cli_parnumcom001 number(19,2),
        cli_parnumcom002 number(19,2),
        cli_parnumcom003 number(19,2),
        cli_parnumcom004 number(19,2),
        cli_parnumcom005 number(19,2),
        cli_partxt001 varchar2(60 char),
        cli_partxt002 varchar2(60 char),
        cli_partxt003 varchar2(60 char),
        cli_partxt004 varchar2(60 char),
        cli_partxt005 varchar2(60 char),
        cli_partxtcom001 varchar2(60 char),
        cli_partxtcom002 varchar2(60 char),
        cli_partxtcom003 varchar2(60 char),
        cli_partxtcom004 varchar2(60 char),
        cli_partxtcom005 varchar2(60 char),
        cli_ptefac001 float,
        cli_ret float,
        cli_ctlffo varchar2(1 char) not null,
        cli_con varchar2(60 char),
        cli_pisdom varchar2(2 char),
        cli_pordom varchar2(2 char),
        cli_pot varchar2(1 char) not null,
        cli_viscmlprt timestamp,
        cli_pubweb varchar2(1 char),
        cli_reb varchar2(1 char) not null,
        cli_recequ varchar2(1 char) not null,
        cli_banrefmdl019 varchar2(35 char),
        cli_rislim number(19,2),
        cli_rismax number(19,2),
        cli_stc_cod varchar2(4 char),
        cli_tel varchar2(60 char),
        cli_telfacele varchar2(60 char),
        cli_tipdte number(10,0),
        cli_tipext varchar2(1 char),
        cli_tipfac number(10,0) not null,
        cli_tipmsg varchar2(1 char) not null,
        cli_tipnif number(10,0),
        cli_tipper varchar2(1 char),
        cli_tipret number(10,0),
        cli_unitrm varchar2(30 char),
        cli_emp_codser varchar2(4 char),
        cli_fmc_cod varchar2(4 char) not null,
        cli_idi_cod varchar2(4 char),
        cli_iva_cod varchar2(4 char),
        cli_ofb_cod number(10,0),
        cli_ope_cod varchar2(6 char),
        cli_org_cod varchar2(6 char),
        cli_painif varchar2(4 char),
        cli_rap_cod varchar2(4 char),
        cli_rgi_cod varchar2(2 char) not null,
        cli_ser_cod varchar2(4 char),
        cli_tar_cod001 varchar2(4 char),
        cli_tar_cod002 varchar2(4 char),
        cli_tds_cod002 varchar2(6 char),
        cli_tds_cod varchar2(6 char),
        cli_sgl varchar2(4 char),
        cli_tcs_cod varchar2(4 char),
        cli_tfc_cod varchar2(4 char) not null,
        cli_tve_cod001 varchar2(4 char),
        cli_tve_cod varchar2(4 char) not null,
        cli_tra_cod varchar2(6 char),
        cli_zon_cod varchar2(4 char),
        primary key (cli_cod, cli_idf_cod)
    );

    create table tges_clm (
       clm_man_cne varchar2(30 char) not null,
        clm_cli_cod varchar2(6 char) not null,
        clm_idf_cod varchar2(4 char) not null,
        clm_usucre varchar2(255 char),
        clm_datcre timestamp,
        clm_usumod varchar2(255 char),
        clm_datmod timestamp,
        primary key (clm_man_cne, clm_cli_cod, clm_idf_cod)
    );

    create table tges_clr (
       clr_cod varchar2(4 char) not null,
        clr_idf_cod varchar2(4 char) not null,
        clr_usucre varchar2(255 char),
        clr_datcre timestamp,
        clr_usumod varchar2(255 char),
        clr_datmod timestamp,
        clr_ctecmpcpr varchar2(10 char),
        clr_ctecmpven varchar2(10 char),
        clr_des varchar2(30 char) not null,
        clr_cmp varchar2(10 char),
        primary key (clr_cod, clr_idf_cod)
    );

    create table tges_cnt (
       cnt_cod varchar2(15 char) not null,
        cnt_idf_cod varchar2(4 char) not null,
        cnt_usucre varchar2(255 char),
        cnt_datcre timestamp,
        cnt_usumod varchar2(255 char),
        cnt_datmod timestamp,
        cnt_ultval number(10,0) not null,
        primary key (cnt_cod, cnt_idf_cod)
    );

    create table tges_cpo (
       cpo_cod varchar2(8 char) not null,
        cpo_idf_cod varchar2(4 char) not null,
        cpo_usucre varchar2(255 char),
        cpo_datcre timestamp,
        cpo_usumod varchar2(255 char),
        cpo_datmod timestamp,
        cpo_mun varchar2(30 char),
        cpo_pob varchar2(30 char) not null,
        cpo_pas_cod varchar2(4 char) not null,
        cpo_prv_cod varchar2(4 char) not null,
        primary key (cpo_cod, cpo_idf_cod)
    );

    create table tges_ctp (
       ctp_cli_cod varchar2(6 char) not null,
        ctp_tip_cod varchar2(4 char) not null,
        ctp_idf_cod varchar2(4 char) not null,
        ctp_usucre varchar2(255 char),
        ctp_datcre timestamp,
        ctp_usumod varchar2(255 char),
        ctp_datmod timestamp,
        primary key (ctp_cli_cod, ctp_tip_cod, ctp_idf_cod)
    );

    create table tges_cxa (
       cxa_emp_cod varchar2(4 char) not null,
        cxa_cod varchar2(4 char) not null,
        cxa_idf_cod varchar2(4 char) not null,
        cxa_usucre varchar2(255 char),
        cxa_datcre timestamp,
        cxa_usumod varchar2(255 char),
        cxa_datmod timestamp,
        cxa_des varchar2(30 char) not null,
        cxa_apucmp varchar2(255 char) not null,
        cxa_obs varchar2(1000 char),
        primary key (cxa_emp_cod, cxa_cod, cxa_idf_cod)
    );

    create table tges_dep (
       dep_emp_cod varchar2(4 char) not null,
        dep_cod varchar2(4 char) not null,
        dep_idf_cod varchar2(4 char) not null,
        dep_usucre varchar2(255 char),
        dep_datcre timestamp,
        dep_usumod varchar2(255 char),
        dep_datmod timestamp,
        dep_des varchar2(60 char) not null,
        dep_obs varchar2(1000 char),
        primary key (dep_emp_cod, dep_cod, dep_idf_cod)
    );

    create table tges_dfs (
       dfs_far_cod varchar2(4 char) not null,
        dfs_emp_cod varchar2(4 char) not null,
        dfs_idf_cod varchar2(4 char) not null,
        dfs_usucre varchar2(255 char),
        dfs_datcre timestamp,
        dfs_usumod varchar2(255 char),
        dfs_datmod timestamp,
        dfs_obs varchar2(1000 char),
        dfs_pte number(19,2),
        dfs_sec_cod varchar2(255 char),
        primary key (dfs_far_cod, dfs_emp_cod, dfs_idf_cod)
    );

    create table tges_div (
       div_cod varchar2(4 char) not null,
        div_idf_cod varchar2(4 char) not null,
        div_usucre varchar2(255 char),
        div_datcre timestamp,
        div_usumod varchar2(255 char),
        div_datmod timestamp,
        div_abr varchar2(5 char),
        div_codcmp varchar2(255 char),
        div_decimp number(10,0) not null,
        div_decpru number(10,0) not null,
        div_nom varchar2(30 char) not null,
        div_valdiveur number(15,8) not null,
        primary key (div_cod, div_idf_cod)
    );

    create table tges_dpc (
       dpc_cli_cod varchar2(6 char) not null,
        dpc_cod varchar2(4 char) not null,
        dpc_idf_cod varchar2(4 char) not null,
        dpc_usucre varchar2(255 char),
        dpc_datcre timestamp,
        dpc_usumod varchar2(255 char),
        dpc_datmod timestamp,
        dpc_cpo_cod varchar2(10 char),
        dpc_ref002 varchar2(50 char),
        dpc_www varchar2(60 char),
        dpc_blo varchar2(1 char),
        dpc_ref001 varchar2(50 char),
        dpc_dom varchar2(60 char),
        dpc_eml varchar2(60 char),
        dpc_fax001 varchar2(60 char),
        dpc_fax002 varchar2(60 char),
        dpc_nom varchar2(30 char) not null,
        dpc_obs varchar2(1000 char),
        dpc_con varchar2(60 char),
        dpc_tel001 varchar2(60 char),
        dpc_tel002 varchar2(60 char),
        dpc_scl_cod varchar2(10 char),
        primary key (dpc_cli_cod, dpc_cod, dpc_idf_cod)
    );

    create table tges_dpg (
       dpg_cod varchar2(4 char) not null,
        dpg_idf_cod varchar2(4 char) not null,
        dpg_usucre varchar2(255 char),
        dpg_datcre timestamp,
        dpg_usumod varchar2(255 char),
        dpg_datmod timestamp,
        dpg_acuvto varchar2(255 char),
        dpg_apldteppg varchar2(255 char),
        dpg_asicmp varchar2(255 char) not null,
        dpg_codcmp varchar2(255 char),
        dpg_codfacele varchar2(255 char),
        dpg_cnccmp varchar2(255 char),
        dpg_ctecmppag varchar2(255 char),
        dpg_ctecmping varchar2(255 char),
        dpg_ctecmpcmi varchar2(255 char),
        dpg_crlefecob varchar2(255 char),
        dpg_des varchar2(30 char) not null,
        dpg_diaefeneg number(10,0),
        dpg_dricmping varchar2(255 char),
        dpg_dricmping002 varchar2(255 char),
        dpg_dricmppag varchar2(255 char),
        dpg_dricmppag002 varchar2(255 char),
        dpg_numdiaval number(10,0),
        dpg_percmi number(19,2),
        dpg_tipasiing varchar2(255 char),
        dpg_tipasipag varchar2(255 char),
        dpg_trs varchar2(255 char) not null,
        dpg_iva_cod varchar2(255 char),
        dpg_npg_cod varchar2(255 char),
        dpg_rgi_cod varchar2(255 char),
        primary key (dpg_cod, dpg_idf_cod)
    );
    
    create table tges_emg (
       emg_emp_cod varchar2(4 char) not null,
        emg_gru_cod varchar2(4 char) not null,
        emg_idf_cod varchar2(4 char) not null,
        emg_usucre varchar2(255 char),
        emg_datcre timestamp,
        emg_usumod varchar2(255 char),
        emg_datmod timestamp,
        primary key (emg_emp_cod, emg_gru_cod, emg_idf_cod)
    );

    create table tges_emp (
       emp_cod varchar2(4 char) not null,
        emp_idf_cod varchar2(4 char) not null,
        emp_usucre varchar2(255 char),
        emp_datcre timestamp,
        emp_usumod varchar2(255 char),
        emp_datmod timestamp,
        emp_cpo_codcom varchar2(8 char) not null,
        emp_cpo_codfis varchar2(8 char) not null,
        emp_div_cod varchar2(4 char) not null,
        emp_tipasicmp varchar2(2 char),
        emp_clicmp varchar2(1 char),
        emp_codcmp varchar2(60 char),
        emp_procmp varchar2(1 char),
        emp_dricmp varchar2(2 char),
        emp_driprfcmp varchar2(2 char),
        emp_domcom varchar2(60 char) not null,
        emp_domfis varchar2(60 char) not null,
        emp_eml varchar2(60 char),
        emp_tipfac number(10,0),
        emp_fax varchar2(60 char),
        emp_llnfis001 varchar2(40 char),
        emp_llnfis002 varchar2(40 char),
        emp_prnlog varchar2(1 char),
        emp_dirlog varchar2(300 char),
        emp_nif varchar2(12 char) not null,
        emp_nomcom varchar2(40 char) not null,
        emp_nomfis varchar2(40 char) not null,
        emp_nomfis001 varchar2(40 char),
        emp_tipper varchar2(1 char),
        emp_rec varchar2(1 char),
        emp_regcricxa varchar2(1 char),
        emp_rgtmtl varchar2(250 char),
        emp_dattan timestamp,
        emp_tel varchar2(60 char),
        emp_tipext varchar2(1 char),
        emp_valfac number(19,2),
        emp_www varchar2(60 char),
        emp_mag_cod varchar2(4 char),
        primary key (emp_cod, emp_idf_cod)
    );

    create table tges_fae (
       fae_far_cod varchar2(4 char) not null,
        fae_emp_cod varchar2(4 char) not null,
        fae_idf_cod varchar2(4 char) not null,
        fae_usucre varchar2(255 char),
        fae_datcre timestamp,
        fae_usumod varchar2(255 char),
        fae_datmod timestamp,
        fae_web varchar2(255 char),
        primary key (fae_far_cod, fae_emp_cod, fae_idf_cod)
    );

    create table tges_far (
       far_cod varchar2(6 char) not null,
        far_idf_cod varchar2(4 char) not null,
        far_usucre varchar2(255 char),
        far_datcre timestamp,
        far_usumod varchar2(255 char),
        far_datmod timestamp,
        far_pda varchar2(1 char),
        far_avialb varchar2(1 char) not null,
        far_ctacprcmp varchar2(10 char),
        far_ctecmpexi varchar2(500 char),
        far_ctavencmp varchar2(10 char),
        far_desope varchar2(500 char),
        far_des varchar2(30 char) not null,
        far_discos varchar2(1 char),
        far_blogenalb varchar2(1 char) not null,
        far_lotnav varchar2(1 char) not null,
        far_marmin float,
        far_marpvpcos float,
        far_obs varchar2(1000 char),
        far_ptependev float,
        far_pop varchar2(1 char),
        far_seqord number(19,0),
        far_fabunimet varchar2(1 char),
        far_tip varchar2(1 char) not null,
        far_tipser varchar2(1 char),
        far_ubinav varchar2(1 char) not null,
        far_cmiven float,
        far_fct_cod varchar2(4 char),
        far_gre_cod varchar2(4 char),
        primary key (far_cod, far_idf_cod)
    );

    create table tges_fct (
       fct_cod varchar2(4 char) not null,
        fct_idf_cod varchar2(4 char) not null,
        fct_usucre varchar2(255 char),
        fct_datcre timestamp,
        fct_usumod varchar2(255 char),
        fct_datmod timestamp,
        fct_far_cod varchar2(255 char),
        fct_des varchar2(60 char) not null,
        fct_obs varchar2(1000 char),
        primary key (fct_cod, fct_idf_cod)
    );

    create table tges_ffa (
       ffa_cod varchar2(4 char) not null,
        ffa_idf_cod varchar2(4 char) not null,
        ffa_usucre varchar2(255 char),
        ffa_datcre timestamp,
        ffa_usumod varchar2(255 char),
        ffa_datmod timestamp,
        ffa_act varchar2(1 char) not null,
        ffa_des varchar2(1000 char),
        ffa_nom varchar2(30 char) not null,
        primary key (ffa_cod, ffa_idf_cod)
    );

    create table tges_fmc (
       fmc_cod varchar2(4 char) not null,
        fmc_idf_cod varchar2(4 char) not null,
        fmc_usucre varchar2(255 char),
        fmc_datcre timestamp,
        fmc_usumod varchar2(255 char),
        fmc_datmod timestamp,
        fmc_ctavencmp varchar2(10 char),
        fmc_nom varchar2(30 char) not null,
        fmc_obs varchar2(1000 char),
        fmc_tri_cod varchar2(4 char),
        primary key (fmc_cod, fmc_idf_cod)
    );

    create table tges_fpr (
       fpr_cod varchar2(4 char) not null,
        fpr_idf_cod varchar2(4 char) not null,
        fpr_usucre varchar2(255 char),
        fpr_datcre timestamp,
        fpr_usumod varchar2(255 char),
        fpr_datmod timestamp,
        fpr_ctacprcmp varchar2(10 char),
        fpr_dricmp varchar2(2 char),
        fpr_driprfcmp varchar2(2 char),
        fpr_nom varchar2(30 char) not null,
        fpr_obs varchar2(1000 char),
        fpr_tipasicmp varchar2(2 char),
        primary key (fpr_cod, fpr_idf_cod)
    );

    create table tges_gma (
       gma_cod varchar2(4 char) not null,
        gma_idf_cod varchar2(4 char) not null,
        gma_usucre varchar2(255 char),
        gma_datcre timestamp,
        gma_usumod varchar2(255 char),
        gma_datmod timestamp,
        gma_des varchar2(30 char) not null,
        primary key (gma_cod, gma_idf_cod)
    );
    
    create table tges_gre (
       gre_emp_cod varchar2(4 char) not null,
        gre_grp_cod varchar2(4 char) not null,
        gre_idf_cod varchar2(4 char) not null,
        gre_usucre varchar2(255 char),
        gre_datcre timestamp,
        gre_usumod varchar2(255 char),
        gre_datmod timestamp,
        primary key (gre_emp_cod, gre_grp_cod, gre_idf_cod)
    );

    create table tges_grp (
       grp_cod varchar2(4 char) not null,
        grp_idf_cod varchar2(4 char) not null,
        grp_usucre varchar2(255 char),
        grp_datcre timestamp,
        grp_usumod varchar2(255 char),
        grp_datmod timestamp,
        grp_nom varchar2(30 char),
        primary key (grp_cod, grp_idf_cod)
    );

    create table tges_gru (
       gru_cod varchar2(4 char) not null,
        gru_idf_cod varchar2(4 char) not null,
        gru_usucre varchar2(255 char),
        gru_datcre timestamp,
        gru_usumod varchar2(255 char),
        gru_datmod timestamp,
        gru_nom varchar2(30 char) not null,
        gru_obs varchar2(1000 char),
        primary key (gru_cod, gru_idf_cod)
    );

    create table tges_hop (
       hop_emp_cod varchar2(4 char) not null,
        hop_prj_num varchar2(6 char) not null,
        hop_seq number(10,0) not null,
        hop_idf_cod varchar2(4 char) not null,
        hop_usucre varchar2(255 char),
        hop_datcre timestamp,
        hop_usumod varchar2(255 char),
        hop_datmod timestamp,
        hop_datfin timestamp,
        hop_datini timestamp,
        hop_tipope varchar2(255 char) not null,
        hop_ope_cod varchar2(6 char),
        primary key (hop_emp_cod, hop_prj_num, hop_seq, hop_idf_cod)
    );

    create table tges_idf (
       idf_cod varchar2(4 char) not null,
        idf_usucre varchar2(255 char),
        idf_datcre timestamp,
        idf_usumod varchar2(255 char),
        idf_datmod timestamp,
        idf_nom varchar2(40 char) not null,
        primary key (idf_cod)
    );

    create table tges_idi (
       idi_cod varchar2(4 char) not null,
        idi_idf_cod varchar2(4 char) not null,
        idi_usucre varchar2(255 char),
        idi_datcre timestamp,
        idi_usumod varchar2(255 char),
        idi_datmod timestamp,
        idi_codiso varchar2(2 char) not null,
        idi_des varchar2(30 char) not null,
        primary key (idi_cod, idi_idf_cod)
    );

    create table tges_iva (
       iva_cod varchar2(4 char) not null,
        iva_idf_cod varchar2(4 char) not null,
        iva_usucre varchar2(255 char),
        iva_datcre timestamp,
        iva_usumod varchar2(255 char),
        iva_datmod timestamp,
        iva_codcmp varchar2(4 char) not null,
        iva_codreqcmp varchar2(4 char) not null,
        iva_des varchar2(30 char) not null,
        iva_pte number(19,2) not null,
        iva_req number(19,2) not null,
        iva_txt varchar2(6 char),
        primary key (iva_cod, iva_idf_cod)
    );
    
    create table tges_lff (
       lff_ffa_cod varchar2(4 char) not null,
        lff_ord number(19,2) not null,
        lff_idf_cod varchar2(4 char) not null,
        lff_usucre varchar2(255 char),
        lff_datcre timestamp,
        lff_usumod varchar2(255 char),
        lff_datmod timestamp,
        lff_apltot varchar2(1 char) not null,
        lff_cncfac varchar2(1 char),
        lff_fml varchar2(255 char),
        lff_impfac varchar2(1 char),
        lff_prn varchar2(1 char) not null,
        lff_nom varchar2(60 char) not null,
        primary key (lff_ffa_cod, lff_ord, lff_idf_cod)
    );

    create table tges_mag (
       mag_cod varchar2(4 char) not null,
        mag_idf_cod varchar2(4 char) not null,
        mag_usucre varchar2(255 char),
        mag_datcre timestamp,
        mag_usumod varchar2(255 char),
        mag_datmod timestamp,
        mag_cpo_cod varchar2(10 char),
        mag_div_cod varchar2(10 char),
        mag_ctetrs varchar2(10 char),
        mag_dricmp1 varchar2(2 char),
        mag_dricmp2 varchar2(2 char),
        mag_dom varchar2(60 char) not null,
        mag_eml varchar2(60 char),
        mag_fax varchar2(60 char),
        mag_nom varchar2(30 char) not null,
        mag_obs varchar2(1000 char),
        mag_res varchar2(30 char),
        mag_tel varchar2(60 char),
        mag_tipasicmp varchar2(2 char),
        mag_valinvtrs varchar2(1 char) not null,
        primary key (mag_cod, mag_idf_cod)
    );

    create table tges_man (
       man_cne varchar2(30 char) not null,
        man_idf_cod varchar2(4 char) not null,
        man_usucre varchar2(255 char),
        man_datcre timestamp,
        man_usumod varchar2(255 char),
        man_datmod timestamp,
        man_act varchar2(1 char),
        man_cat varchar2(1 char),
        man_ape varchar2(60 char) not null,
        man_datcdc timestamp,
        man_datexd timestamp,
        man_dom varchar2(100 char),
        man_eml varchar2(60 char),
        man_nif varchar2(15 char),
        man_nom varchar2(30 char) not null,
        man_obs varchar2(1000 char),
        man_tel varchar2(60 char),
        primary key (man_cne, man_idf_cod)
    );

    create table tges_mca (
       mca_cod varchar2(4 char) not null,
        mca_idf_cod varchar2(4 char) not null,
        mca_usucre varchar2(255 char),
        mca_datcre timestamp,
        mca_usumod varchar2(255 char),
        mca_datmod timestamp,
        mca_des varchar2(30 char) not null,
        primary key (mca_cod, mca_idf_cod)
    );

    create table tges_mod (
       mod_cod varchar2(4 char) not null,
        mod_idf_cod varchar2(4 char) not null,
        mod_usucre varchar2(255 char),
        mod_datcre timestamp,
        mod_usumod varchar2(255 char),
        mod_datmod timestamp,
        mod_nounitra varchar2(1 char),
        mod_des varchar2(30 char) not null,
        primary key (mod_cod, mod_idf_cod)
    );

    create table tges_mtr (
       mtr_tra_cod varchar2(4 char) not null,
        mtr_cod varchar2(4 char) not null,
        mtr_idf_cod varchar2(4 char) not null,
        mtr_usucre varchar2(255 char),
        mtr_datcre timestamp,
        mtr_usumod varchar2(255 char),
        mtr_datmod timestamp,
        mtr_act varchar2(1 char),
        mtr_cdu varchar2(30 char),
        mtr_des varchar2(60 char),
        mtr_mtr001 varchar2(10 char),
        mtr_mtr002 varchar2(10 char),
        mtr_nif varchar2(12 char),
        mtr_obs varchar2(1000 char),
        mtr_pesmax number(19,2),
        mtr_tara number(19,2),
        mtr_vehemp varchar2(1 char),
        primary key (mtr_tra_cod, mtr_cod, mtr_idf_cod)
    );

    create table tges_npg (
       npg_cod varchar2(4 char) not null,
        npg_idf_cod varchar2(4 char) not null,
        npg_usucre varchar2(255 char),
        npg_datcre timestamp,
        npg_usumod varchar2(255 char),
        npg_datmod timestamp,
        npg_des varchar2(30 char) not null,
        npg_obs varchar2(1000 char) not null,
        primary key (npg_cod, npg_idf_cod)
    );

    create table tges_ofb (
       ofb_ban_cod number(10,0) not null,
        ofb_cod number(10,0) not null,
        ofb_idf_cod varchar2(4 char) not null,
        ofb_usucre varchar2(255 char),
        ofb_datcre timestamp,
        ofb_usumod varchar2(255 char),
        ofb_datmod timestamp,
        ofb_cpo_cod varchar2(8 char) not null,
        ofb_con varchar2(60 char),
        ofb_dom varchar2(60 char),
        ofb_fax varchar2(60 char),
        ofb_obs varchar2(1000 char),
        ofb_tel varchar2(60 char),
        primary key (ofb_ban_cod, ofb_cod, ofb_idf_cod)
    );

    create table tges_org (
       org_cod varchar2(4 char) not null,
        org_idf_cod varchar2(4 char) not null,
        org_usucre varchar2(255 char),
        org_datcre timestamp,
        org_usumod varchar2(255 char),
        org_datmod timestamp,
        org_cpo_cod varchar2(8 char),
        org_www varchar2(60 char),
        org_con varchar2(30 char),
        org_dom varchar2(60 char),
        org_eml varchar2(60 char),
        org_fax varchar2(60 char),
        org_ger varchar2(30 char),
        org_nom varchar2(30 char) not null,
        org_obs varchar2(1000 char),
        org_tel varchar2(60 char),
        primary key (org_cod, org_idf_cod)
    );

    create table tges_par (
       par_cod varchar2(15 char) not null,
        par_idf_cod varchar2(4 char) not null,
        par_usucre varchar2(255 char),
        par_datcre timestamp,
        par_usumod varchar2(255 char),
        par_datmod timestamp,
        par_des varchar2(1000 char) not null,
        par_val varchar2(4000 char) not null,
        primary key (par_cod, par_idf_cod)
    );

    create table tges_pas (
       pas_cod varchar2(4 char) not null,
        pas_idf_cod varchar2(4 char) not null,
        pas_usucre varchar2(255 char),
        pas_datcre timestamp,
        pas_usumod varchar2(255 char),
        pas_datmod timestamp,
        pas_cee varchar2(1 char),
        pas_codiso varchar2(3 char),
        pas_codiso002 varchar2(2 char),
        pas_nif varchar2(2 char),
        pas_nom varchar2(30 char) not null,
        primary key (pas_cod, pas_idf_cod)
    );
    
    create table tges_pbu (
       pbu_gma_cod varchar2(4 char) not null,
        pbu_tra_cod varchar2(15 char) not null,
        pbu_idf_cod varchar2(4 char) not null,
        pbu_usucre varchar2(255 char),
        pbu_datcre timestamp,
        pbu_usumod varchar2(255 char),
        pbu_datmod timestamp,
        pbu_pru001 number(17,5),
        pbu_pru002 number(17,5),
        pbu_pru003 number(17,5),
        pbu_pru004 number(17,5),
        primary key (pbu_gma_cod, pbu_tra_cod, pbu_idf_cod)
    );

    create table tges_pda (
       pda_cap_cod varchar2(255 char) not null,
        pda_emp_cod varchar2(4 char) not null,
        pda_pre_cod number(10,0) not null,
        pda_cod varchar2(4 char) not null,
        pda_idf_cod varchar2(4 char) not null,
        pda_usucre varchar2(255 char),
        pda_datcre timestamp,
        pda_usumod varchar2(255 char),
        pda_datmod timestamp,
        primary key (pda_cap_cod, pda_emp_cod, pda_pre_cod, pda_cod, pda_idf_cod)
    );

    create table tges_ped (
       ped_emp_cod varchar2(4 char) not null,
        ped_cod varchar2(4 char) not null,
        ped_idf_cod varchar2(4 char) not null,
        ped_usucre varchar2(255 char),
        ped_datcre timestamp,
        ped_usumod varchar2(255 char),
        ped_datmod timestamp,
        ped_alb varchar2(255 char) not null,
        ped_com varchar2(255 char) not null,
        ped_des varchar2(30 char) not null,
        ped_fac varchar2(255 char) not null,
        ped_famclipro varchar2(255 char) not null,
        ped_impcls varchar2(255 char) not null,
        ped_cer varchar2(255 char) not null,
        ped_ord number(19,2),
        ped_pie varchar2(1000 char),
        ped_pre varchar2(255 char) not null,
        ped_scp_codcom varchar2(255 char),
        primary key (ped_emp_cod, ped_cod, ped_idf_cod)
    );

    create table tges_pjp (
       pjp_emp_cod varchar2(4 char) not null,
        pjp_prj_num varchar2(6 char) not null,
        pjp_num number(10,0) not null,
        pjp_idf_cod varchar2(4 char) not null,
        pjp_usucre varchar2(255 char) not null,
        pjp_datcre timestamp not null,
        pjp_usumod varchar2(255 char),
        pjp_datmod timestamp,
        pjp_cap_cod varchar2(6 char),
        pjp_obs varchar2(1000 char),
        pjp_pda_cod varchar2(6 char),
        pjp_pre_cod number(10,0),
        primary key (pjp_emp_cod, pjp_prj_num, pjp_num, pjp_idf_cod)
    );

    create table tges_pmg (
       pmg_mag_cod varchar2(4 char) not null,
        pmg_cod varchar2(4 char) not null,
        pmg_idf_cod varchar2(4 char) not null,
        pmg_usucre varchar2(255 char),
        pmg_datcre timestamp,
        pmg_usumod varchar2(255 char),
        pmg_datmod timestamp,
        pmg_diaini timestamp not null,
        pmg_des varchar2(30 char) not null,
        primary key (pmg_mag_cod, pmg_cod, pmg_idf_cod)
    );

    create table tges_ppj (
       ppj_emp_cod varchar2(4 char) not null,
        ppj_prj_num varchar2(6 char) not null,
        ppj_pro_cod varchar2(6 char) not null,
        ppj_idf_cod varchar2(4 char) not null,
        ppj_usucre varchar2(255 char),
        ppj_datcre timestamp,
        primary key (ppj_emp_cod, ppj_prj_num, ppj_pro_cod, ppj_idf_cod)
    );

    create table tges_ppz (
       ppz_tra_cod varchar2(15 char) not null,
        ppz_zon_cod varchar2(4 char) not null,
        ppz_idf_cod varchar2(4 char) not null,
        ppz_usucre varchar2(255 char),
        ppz_datcre timestamp,
        ppz_usumod varchar2(255 char),
        ppz_datmod timestamp,
        ppz_div_cod varchar2(4 char) not null,
        ppz_obs varchar2(1000 char),
        ppz_precio number(17,5) not null,
        primary key (ppz_tra_cod, ppz_zon_cod, ppz_idf_cod)
    );

    create table tges_pre (
       pre_emp_cod varchar2(4 char) not null,
        pre_cod number(10,0) not null,
        pre_idf_cod varchar2(4 char) not null,
        pre_usucre varchar2(255 char),
        pre_datcre timestamp,
        pre_usumod varchar2(255 char),
        pre_datmod timestamp,
        primary key (pre_emp_cod, pre_cod, pre_idf_cod)
    );

    create table tges_prj (
       prj_emp_cod varchar2(4 char) not null,
        prj_num varchar2(6 char) not null,
        prj_idf_cod varchar2(4 char) not null,
        prj_usucre varchar2(255 char),
        prj_datcre timestamp,
        prj_usumod varchar2(255 char),
        prj_datmod timestamp,
        prj_ane_cod varchar2(4 char),
        prj_acc_cod varchar2(4 char),
        prj_cli_cod varchar2(6 char),
        prj_cpo_cod varchar2(8 char),
        prj_div_cod varchar2(4 char),
        prj_dir varchar2(200 char),
        prj_crealbcli varchar2(1 char),
        prj_prualbcli number(10,0),
        prj_tip number(10,0),
        prj_codcmp varchar2(4 char),
        prj_percon varchar2(60 char),
        prj_telcon varchar2(30 char),
        prj_crlcos varchar2(1 char),
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
        prj_des varchar2(1000 char),
        prj_descur varchar2(500 char),
        prj_dta varchar2(1 char),
        prj_dipfia varchar2(250 char),
        prj_dirtec varchar2(60 char),
        prj_est number(10,0),
        prj_baj number(15,8),
        prj_gstgen number(15,2),
        prj_valexc varchar2(1 char),
        prj_tas number(5,2),
        prj_pda varchar2(1 char),
        prj_horrut number(7,2),
        prj_horequ number(7,2),
        prj_horeqc number(7,2),
        prj_horeqg number(7,2),
        prj_impfia number(15,3),
        prj_mesgar number(7,2),
        prj_mulcli varchar2(1 char),
        prj_nom varchar2(250 char) not null,
        prj_obs varchar2(1000 char),
        prj_pteejc number(7,2),
        prj_pteejg number(7,2),
        prj_pteeje number(7,2),
        prj_plspel varchar2(1 char),
        prj_pob varchar2(100 char),
        prj_prumigfac number(15,2),
        prj_ref varchar2(20 char),
        prj_res varchar2(60 char),
        prj_ret number(5,2),
        prj_tipret varchar2(1 char),
        prj_tec varchar2(3000 char),
        prj_tipeje number(10,0),
        prj_tipinv varchar2(1 char),
        prj_tipobr number(10,0),
        prj_valetm number(15,3),
        prj_ffa_cod varchar2(6 char),
        prj_iva_codinv varchar2(4 char),
        prj_mag_cod varchar2(4 char),
        prj_ope_codadm varchar2(6 char),
        prj_ope_codcgr varchar2(6 char),
        prj_ope_enccod varchar2(6 char),
        prj_ope_cod varchar2(6 char),
        prj_tpj_cod varchar2(6 char),
        prj_rgi_codinv varchar2(2 char),
        prj_clr_cod varchar2(4 char),
        prj_sec_cod varchar2(2 char),
        prj_ser_cod varchar2(2 char),
        prj_sei_codinv varchar2(4 char),
        prj_scl_cod varchar2(4 char),
        prj_zon_cod varchar2(4 char),
        primary key (prj_emp_cod, prj_num, prj_idf_cod)
    );

    create table tges_pro (
       pro_cod varchar2(4 char) not null,
        pro_idf_cod varchar2(4 char) not null,
        pro_usucre varchar2(255 char),
        pro_datcre timestamp,
        pro_usumod varchar2(255 char),
        pro_datmod timestamp,
        pro_cpo_cod varchar2(8 char) not null,
        pro_div_cod varchar2(4 char) not null,
        pro_dpg_cod varchar2(4 char) not null,
        pro_blo varchar2(1 char),
        pro_dhm varchar2(1 char),
        pro_nomcom varchar2(30 char),
        pro_nomfis varchar2(1000 char),
        pro_scn varchar2(1 char),
        pro_fpr_cod varchar2(4 char) not null,
        pro_rgi_cod varchar2(4 char) not null,
        pro_tve_cod varchar2(4 char) not null,
        primary key (pro_cod, pro_idf_cod)
    );

    create table tges_prv (
       prv_pas_cod varchar2(4 char) not null,
        prv_cod varchar2(4 char) not null,
        prv_idf_cod varchar2(4 char) not null,
        prv_usucre varchar2(255 char),
        prv_datcre timestamp,
        prv_usumod varchar2(255 char),
        prv_datmod timestamp,
        prv_nom varchar2(30 char) not null,
        primary key (prv_pas_cod, prv_cod, prv_idf_cod)
    );

    create table tges_ptv (
       ptv_emp_cod varchar2(4 char) not null,
        ptv_cod varchar2(4 char) not null,
        ptv_idf_cod varchar2(4 char) not null,
        ptv_usucre varchar2(255 char),
        ptv_datcre timestamp,
        ptv_usumod varchar2(255 char),
        ptv_datmod timestamp,
        ptv_cxa_cod varchar2(4 char) not null,
        ptv_cli_cod varchar2(6 char) not null,
        ptv_div_cod varchar2(4 char) not null,
        ptv_div_cod002 varchar2(4 char),
        ptv_dpg_cod varchar2(4 char) not null,
        ptv_ip varchar2(60 char),
        ptv_dirimg varchar2(80 char),
        ptv_apecxa varchar2(60 char),
        ptv_ultnaz number(10,0),
        ptv_datimp date,
        ptv_enu varchar2(255 char) not null,
        ptv_horinidia date,
        ptv_tipprn varchar2(255 char) not null,
        ptv_nom varchar2(30 char) not null,
        ptv_talpgn varchar2(15 char),
        ptv_cpç varchar2(1000 char),
        ptv_ivaicl varchar2(255 char) not null,
        ptv_linbot number(10,0) not null,
        ptv_peu varchar2(1000 char),
        ptv_bdd varchar2(20 char),
        ptv_dir varchar2(80 char),
        ptv_mag_cod varchar2(4 char) not null,
        ptv_ope_cod varchar2(6 char) not null,
        ptv_ser_cod varchar2(2 char),
        primary key (ptv_emp_cod, ptv_cod, ptv_idf_cod)
    );

    create table tges_rap (
       rap_cod varchar2(4 char) not null,
        rap_idf_cod varchar2(4 char) not null,
        rap_usucre varchar2(255 char),
        rap_datcre timestamp,
        rap_usumod varchar2(255 char),
        rap_datmod timestamp,
        rap_abs varchar2(1 char),
        rap_des varchar2(30 char),
        rap_esc varchar2(1 char),
        rap_limini number(19,2),
        rap_limfin number(19,2),
        rap_pte float,
        rap_pte001 float,
        primary key (rap_cod, rap_idf_cod)
    );

    create table tges_rgc (
       rgc_emp_cod varchar2(4 char) not null,
        rgc_seq number(10,0) not null,
        rgc_idf_cod varchar2(4 char) not null,
        rgc_usucre varchar2(255 char),
        rgc_datcre timestamp,
        rgc_usumod varchar2(255 char),
        rgc_datmod timestamp,
        rgc_cli_cod varchar2(4 char),
        rgc_com varchar2(1500 char),
        rgc_dac varchar2(500 char),
        rgc_dat timestamp,
        rgc_desmtj varchar2(60 char),
        rgc_int varchar2(60 char) not null,
        rgc_mtj varchar2(1 char) not null,
        rgc_tip varchar2(1 char) not null,
        rgc_apl_ref number(10,0),
        primary key (rgc_emp_cod, rgc_seq, rgc_idf_cod)
    );

    create table tges_rgi (
       rgi_cod varchar2(4 char) not null,
        rgi_idf_cod varchar2(4 char) not null,
        rgi_usucre varchar2(255 char),
        rgi_datcre timestamp,
        rgi_usumod varchar2(255 char),
        rgi_datmod timestamp,
        rgi_codcmp varchar2(30 char),
        rgi_codele varchar2(2 char),
        rgi_des varchar2(30 char) not null,
        rgi_tip number(10,0) not null,
        primary key (rgi_cod, rgi_idf_cod)
    );

    create table tges_scl (
       scl_cli_cod varchar2(6 char) not null,
        scl_cod varchar2(4 char) not null,
        scl_idf_cod varchar2(4 char) not null,
        scl_usucre varchar2(255 char),
        scl_datcre timestamp,
        scl_usumod varchar2(255 char),
        scl_datmod timestamp,
        scl_acc_cod varchar2(4 char),
        scl_clr_cod varchar2(4 char),
        scl_cpo_cod varchar2(8 char),
        scl_act varchar2(60 char),
        scl_albcls number(10,0),
        scl_blo varchar2(1 char) not null,
        scl_oficmp varchar2(30 char),
        scl_orgges varchar2(30 char),
        scl_unitrm varchar2(30 char),
        scl_confacele varchar2(255 char),
        scl_cpo_codoficmp varchar2(8 char),
        scl_cpo_codorgges varchar2(8 char),
        scl_cpo_codunitrm varchar2(8 char),
        scl_dom varchar2(60 char),
        scl_domoficmp varchar2(60 char),
        scl_domorgges varchar2(60 char),
        scl_domunitrm varchar2(60 char),
        scl_emlfacele varchar2(60 char),
        scl_emlfac varchar2(100 char),
        scl_fax varchar2(60 char),
        scl_lat number(19,2),
        scl_lon number(19,2),
        scl_nom varchar2(30 char) not null,
        scl_obs varchar2(2000 char),
        scl_ret float,
        scl_pvl varchar2(1 char) not null,
        scl_pubweb varchar2(1 char),
        scl_reb varchar2(1 char),
        scl_rgi_codinv varchar2(2 char),
        scl_sei_codinv varchar2(2 char),
        scl_tds_cod002 varchar2(6 char),
        scl_tel varchar2(60 char),
        scl_telfacele varchar2(60 char),
        scl_tipdte number(10,0),
        scl_tipinv varchar2(1 char),
        scl_tipret number(10,0),
        scl_iva_cod varchar2(6 char),
        scl_ope_codenc varchar2(6 char),
        scl_ope_codres varchar2(6 char),
        scl_rgi_cod varchar2(2 char),
        scl_tar_cod001 varchar2(4 char),
        scl_tar_cod002 varchar2(4 char),
        scl_tds_cod varchar2(6 char),
        scl_tcs_cod varchar2(4 char),
        scl_tve_cod001 varchar2(4 char),
        scl_tve_cod varchar2(4 char),
        scl_zon_cod varchar2(4 char),
        primary key (scl_cli_cod, scl_cod, scl_idf_cod)
    );

    create table tges_scp (
       scp_emp_cod varchar2(4 char) not null,
        scp_cod varchar2(4 char) not null,
        scp_idf_cod varchar2(4 char) not null,
        scp_usucre varchar2(255 char),
        scp_datcre timestamp,
        scp_usumod varchar2(255 char),
        scp_datmod timestamp,
        scp_ctecprcmp varchar2(255 char),
        scp_ctecprprfcmp varchar2(255 char) not null,
        scp_des varchar2(30 char) not null,
        scp_dsgivacmp varchar2(1 char) not null,
        scp_dricmp varchar2(255 char) not null,
        scp_driprfcmp varchar2(255 char),
        scp_tipasicmp varchar2(255 char) not null,
        scp_diaini timestamp not null,
        scp_diafin timestamp not null,
        scp_emp_cod002 varchar2(4 char),
        scp_mag_cod varchar2(4 char),
        primary key (scp_emp_cod, scp_cod, scp_idf_cod)
    );

    create table tges_sei (
       sei_emp_cod varchar2(4 char) not null,
        sei_cod varchar2(4 char) not null,
        sei_idf_cod varchar2(4 char) not null,
        sei_des varchar2(60 char) not null,
        sei_dia001 timestamp not null,
        sei_dia002 timestamp not null,
        sei_serdef varchar2(1 char),
        sei_ultfac number(19,2),
        primary key (sei_emp_cod, sei_cod, sei_idf_cod)
    );

    create table tges_ser (
       ser_emp_cod varchar2(4 char) not null,
        ser_cod varchar2(2 char) not null,
        ser_idf_cod varchar2(4 char) not null,
        ser_usucre varchar2(255 char),
        ser_datcre timestamp,
        ser_usumod varchar2(255 char),
        ser_datmod timestamp,
        ser_ped_cod varchar2(4 char),
        ser_dep_cod varchar2(4 char),
        ser_dte varchar2(1 char) not null,
        ser_cnrvencli varchar2(1 char),
        ser_cteadmpre varchar2(10 char),
        ser_ctepre varchar2(10 char),
        ser_cteprfadmpre varchar2(10 char),
        ser_cteprfpre varchar2(10 char),
        ser_ctevencmp varchar2(10 char),
        ser_ctevenettpubcmp varchar2(10 char),
        ser_ctevenprfcmp varchar2(10 char),
        ser_ctevenettpubprfcmp varchar2(10 char),
        ser_ultalb number(10,0) not null,
        ser_ultalbprf number(10,0) not null,
        ser_ultpre number(10,0) not null,
        ser_ultfac number(10,0) not null,
        ser_ultfacprf number(10,0) not null,
        ser_ultpreprf number(10,0) not null,
        ser_des varchar2(30 char) not null,
        ser_dsgivacmp varchar2(1 char) not null,
        ser_dricmp varchar2(2 char),
        ser_driprfcmp varchar2(2 char),
        ser_facrct varchar2(1 char),
        ser_titfac varchar2(500 char),
        ser_ncf varchar2(20 char),
        ser_man varchar2(1 char) not null,
        ser_tipasicmp varchar2(2 char),
        ser_trscmp varchar2(1 char),
        ser_dia001 timestamp not null,
        ser_dia002 timestamp not null,
        ser_emp_codprn varchar2(4 char),
        ser_mag_cod varchar2(4 char),
        ser_ped_codfac varchar2(4 char),
        primary key (ser_emp_cod, ser_cod, ser_idf_cod)
    );

    create table tges_stc (
       stc_cod varchar2(4 char) not null,
        stc_idf_cod varchar2(4 char) not null,
        stc_usucre varchar2(255 char),
        stc_datcre timestamp,
        stc_usumod varchar2(255 char),
        stc_datmod timestamp,
        stc_nom varchar2(30 char),
        stc_obs varchar2(1000 char),
        primary key (stc_cod, stc_idf_cod)
    );

    create table tges_sue (
       sue_cod varchar2(4 char) not null,
        sue_idf_cod varchar2(4 char) not null,
        sue_usucre varchar2(255 char),
        sue_datcre timestamp,
        sue_usumod varchar2(255 char),
        sue_datmod timestamp,
        sue_nom varchar2(30 char) not null,
        sue_ori varchar2(30 char) not null,
        sue_prukgr number(19,2) not null,
        primary key (sue_cod, sue_idf_cod)
    );

    create table tges_sui (
       sui_art_cod varchar2(6 char) not null,
        sui_cls varchar2(6 char) not null,
        sui_mag_cod varchar2(6 char) not null,
        sui_idf_cod varchar2(4 char) not null,
        sui_usucre varchar2(255 char),
        sui_datcre timestamp,
        sui_usumod varchar2(255 char),
        sui_datmod timestamp,
        sui_div_cod varchar2(4 char) not null,
        sui_prucosuni number(19,2) not null,
        sui_uniini number(19,2) not null,
        sui_unimetini number(19,2),
        sui_pmg_cod varchar2(255 char),
        primary key (sui_art_cod, sui_cls, sui_mag_cod, sui_idf_cod)
    );

    create table tges_taj (
       taj_emp_cod varchar2(4 char) not null,
        taj_prj_num varchar2(6 char) not null,
        taj_pro_cod varchar2(6 char) not null,
        taj_tpr_cod varchar2(6 char) not null,
        taj_idf_cod varchar2(4 char) not null,
        taj_usucre varchar2(255 char),
        taj_datcre timestamp,
        taj_usumod varchar2(255 char),
        taj_datmod timestamp,
        primary key (taj_emp_cod, taj_prj_num, taj_pro_cod, taj_tpr_cod, taj_idf_cod)
    );

    create table tges_tar (
       tar_cod varchar2(4 char) not null,
        tar_idf_cod varchar2(4 char) not null,
        tar_usucre varchar2(255 char),
        tar_datcre timestamp,
        tar_usumod varchar2(255 char),
        tar_datmod timestamp,
        tar_canpru varchar2(1 char),
        tar_diafin timestamp,
        tar_diaini timestamp,
        tar_dtegen varchar2(1 char),
        tar_des varchar2(30 char) not null,
        tar_calpvp varchar2(1 char),
        tar_ptemanobr number(19,2) not null,
        tar_ptemat number(19,2) not null,
        tar_ofr varchar2(1 char),
        tar_tip varchar2(1 char),
        primary key (tar_cod, tar_idf_cod)
    );

    create table tges_tcs (
       tcs_cod varchar2(4 char) not null,
        tcs_idf_cod varchar2(4 char) not null,
        tcs_usucre varchar2(255 char),
        tcs_datcre timestamp,
        tcs_usumod varchar2(255 char),
        tcs_datmod timestamp,
        tcs_des varchar2(1000 char),
        tcs_min number(19,2),
        tcs_nom varchar2(30 char) not null,
        tcs_pte number(19,2),
        primary key (tcs_cod, tcs_idf_cod)
    );

    create table tges_tds (
       tds_cod varchar2(4 char) not null,
        tds_idf_cod varchar2(4 char) not null,
        tds_usucre varchar2(255 char),
        tds_datcre timestamp,
        tds_usumod varchar2(255 char),
        tds_datmod timestamp,
        tds_des varchar2(30 char) not null,
        tds_obs varchar2(1000 char),
        primary key (tds_cod, tds_idf_cod)
    );

    create table tges_tfc (
       tfc_cod varchar2(4 char) not null,
        tfc_idf_cod varchar2(4 char) not null,
        tfc_usucre varchar2(255 char),
        tfc_datcre timestamp,
        tfc_usumod varchar2(255 char),
        tfc_datmod timestamp,
        tfc_crd varchar2(1 char),
        tfc_des varchar2(30 char) not null,
        primary key (tfc_cod, tfc_idf_cod)
    );

    create table tges_tin (
       tin_cod varchar2(4 char) not null,
        tin_idf_cod varchar2(4 char) not null,
        tin_usucre varchar2(255 char),
        tin_datcre timestamp,
        tin_usumod varchar2(255 char),
        tin_datmod timestamp,
        tin_nom varchar2(30 char) not null,
        primary key (tin_cod, tin_idf_cod)
    );

    create table tges_tip (
       tip_cod varchar2(4 char) not null,
        tip_idf_cod varchar2(4 char) not null,
        tip_usucre varchar2(255 char),
        tip_datcre timestamp,
        tip_usumod varchar2(255 char),
        tip_datmod timestamp,
        tip_des varchar2(30 char) not null,
        primary key (tip_cod, tip_idf_cod)
    );

    create table tges_tpj (
       tpj_cod varchar2(6 char) not null,
        tpj_idf_cod varchar2(4 char) not null,
        tpj_usucre varchar2(255 char),
        tpj_datcre timestamp,
        tpj_usumod varchar2(255 char),
        tpj_datmod timestamp,
        tpj_des varchar2(30 char),
        tpj_nom varchar2(30 char) not null,
        primary key (tpj_cod, tpj_idf_cod)
    );
    
    create table tges_tpl (
       tpl_apl number(3,0) not null,
        tpl_tra_cod varchar2(15 char) not null,
        tpl_cod varchar2(20 char) not null,
        tpl_idf_cod varchar2(4 char) not null,
        tpl_usucre varchar2(255 char),
        tpl_datcre timestamp,
        tpl_usumod varchar2(255 char),
        tpl_datmod timestamp,
        tpl_obs varchar2(1000 char),
        primary key (tpl_apl, tpl_tra_cod, tpl_cod, tpl_idf_cod)
    );

    create table tges_tpr (
       tpr_pro_cod varchar2(4 char) not null,
        tpr_cod varchar2(4 char) not null,
        tpr_idf_cod varchar2(4 char) not null,
        tpr_usucre varchar2(255 char),
        tpr_datcre timestamp,
        tpr_usumod varchar2(255 char),
        tpr_datmod timestamp,
        primary key (tpr_pro_cod, tpr_cod, tpr_idf_cod)
    );

    create table tges_tra (
       tra_cod varchar2(4 char) not null,
        tra_idf_cod varchar2(4 char) not null,
        tra_usucre varchar2(255 char),
        tra_datcre timestamp,
        tra_usumod varchar2(255 char),
        tra_datmod timestamp,
        tra_cpo_cod varchar2(8 char) not null,
        tra_div_cod varchar2(4 char) not null,
        tra_www varchar2(255 char),
        tra_con varchar2(255 char),
        tra_dom varchar2(255 char),
        tra_eml varchar2(255 char),
        tra_fax varchar2(255 char),
        tra_fpa varchar2(255 char),
        tra_hri varchar2(255 char),
        tra_nif varchar2(12 char) not null,
        tra_nom varchar2(30 char) not null,
        tra_obs varchar2(255 char),
        tra_tel varchar2(255 char),
        tra_vehemp varchar2(255 char),
        tra_pro_cod varchar2(6 char),
        primary key (tra_cod, tra_idf_cod)
    );

    create table tges_tri (
       tri_cod varchar2(4 char) not null,
        tri_idf_cod varchar2(4 char) not null,
        tri_usucre varchar2(255 char),
        tri_datcre timestamp,
        tri_usumod varchar2(255 char),
        tri_datmod timestamp,
        tri_des varchar2(30 char) not null,
        tri_albnotfac number(10,0),
        tri_efeneg number(10,0),
        tri_nifigu varchar2(255 char),
        tri_pensrv number(10,0),
        tri_vtopennotvnt number(10,0),
        tri_vtopenvnt number(10,0),
        primary key (tri_cod, tri_idf_cod)
    );

    create table tges_tun (
       tun_cod varchar2(4 char) not null,
        tun_idf_cod varchar2(4 char) not null,
        tun_usucre varchar2(255 char),
        tun_datcre timestamp,
        tun_usumod varchar2(255 char),
        tun_datmod timestamp,
        tun_des varchar2(60 char) not null,
        tun_fc number(14,4),
        primary key (tun_cod, tun_idf_cod)
    );

    create table tges_tve (
       tve_cod varchar2(4 char) not null,
        tve_idf_cod varchar2(4 char) not null,
        tve_usucre varchar2(255 char),
        tve_datcre timestamp,
        tve_usumod varchar2(255 char),
        tve_datmod timestamp,
        tve_clsvtocmp varchar2(255 char),
        tve_ultdiamescpr varchar2(1 char),
        tve_ultdiamesven varchar2(1 char),
        tve_des varchar2(30 char),
        tve_dia002pla number(10,0),
        tve_diapga number(10,0),
        tve_diapla number(10,0),
        tve_diapla001 number(10,0),
        tve_diapla004 number(10,0),
        tve_diapla005 number(10,0),
        tve_diapla002 number(10,0),
        tve_diapla003 number(10,0),
        tve_gencobpag varchar2(1 char),
        tve_imppla number(19,2),
        tve_mespga varchar2(255 char),
        tve_mestan varchar2(255 char),
        tve_mindia number(10,0),
        tve_numpla number(10,0),
        tve_ptepla001 float,
        tve_ptepla004 float,
        tve_ptepla005 float,
        tve_ptepla002 float,
        tve_ptepla003 float,
        tve_mesclt varchar2(1 char),
        tve_tip varchar2(1 char) not null,
        primary key (tve_cod, tve_idf_cod)
    );

    create table tges_uba (
       uba_art_cod varchar2(6 char) not null,
        uba_mag_cod varchar2(6 char) not null,
        uba_idf_cod varchar2(4 char) not null,
        uba_usucre varchar2(255 char),
        uba_datcre timestamp,
        uba_usumod varchar2(255 char),
        uba_datmod timestamp,
        uba_uni varchar2(22 char),
        uba_ubi_cod varchar2(255 char),
        primary key (uba_art_cod, uba_mag_cod, uba_idf_cod)
    );

    create table tges_ubi (
       ubi_mag_cod varchar2(6 char) not null,
        ubi_cod varchar2(4 char) not null,
        ubi_idf_cod varchar2(4 char) not null,
        ubi_usucre varchar2(255 char),
        ubi_datcre timestamp,
        ubi_usumod varchar2(255 char),
        ubi_datmod timestamp,
        ubi_des varchar2(30 char),
        primary key (ubi_mag_cod, ubi_cod, ubi_idf_cod)
    );
    
    create table tges_usg (
       usg_gru_cod varchar2(4 char) not null,
        usg_usu_cod varchar2(30 char) not null,
        usg_idf_cod varchar2(4 char) not null,
        usg_usucre varchar2(255 char),
        usg_datcre timestamp,
        usg_usumod varchar2(255 char),
        usg_datmod timestamp,
        primary key (usg_gru_cod, usg_usu_cod, usg_idf_cod)
    );

    create table tges_vpp (
       vpp_emp_cod varchar2(4 char) not null,
        vpp_prj_num varchar2(6 char) not null,
        vpp_pro_cod varchar2(6 char) not null,
        vpp_idf_cod varchar2(4 char) not null,
        vpp_usucre varchar2(255 char),
        vpp_datcre timestamp,
        vpp_tve_cod varchar2(4 char) not null,
        primary key (vpp_emp_cod, vpp_prj_num, vpp_pro_cod, vpp_idf_cod)
    );

    create table tges_zon (
       zon_cod varchar2(4 char) not null,
        zon_idf_cod varchar2(4 char) not null,
        zon_usucre varchar2(255 char),
        zon_datcre timestamp,
        zon_usumod varchar2(255 char),
        zon_datmod timestamp,
        zon_des varchar2(1000 char),
        zon_nom varchar2(30 char),
        zon_precio number(19,2),
        zon_radio_km number(10,0),
        primary key (zon_cod, zon_idf_cod)
    );
    
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
create index iges_cfg_idf_fk on tges_cfg_rep (cfg_idf_cod);
create index iges_cfg_idf_fk on tges_cfg (cfg_idf_cod);
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
create index iges_fae_idf_fk on tges_fae (fae_idf_cod);

    alter table tges_fae 
       add constraint irges_fae_pk unique (fae_idf_cod);
create index iges_far_idf_fk on tges_far (far_idf_cod);
create index iges_fct_idf_fk on tges_fct (fct_idf_cod);
create index iges_ffa_idf_fk on tges_ffa (ffa_idf_cod);
create index iges_fmc_idf_fk on tges_fmc (fmc_idf_cod);
create index iges_fpr_idf_fk on tges_fpr (fpr_idf_cod);
create index iges_gma_idf_fk on tges_gma (gma_idf_cod);
create index irhu_gre_idf_fk on trhu_gre (gre_idf_cod);
create index iges_grp_idf_fk on tges_grp (grp_idf_cod);
create index iges_gru_idf_fk on tges_gru (gru_idf_cod);
create index iges_hop_emp_fk on tges_hop (hop_idf_cod, hop_emp_cod);
create index iges_hop_prj_fk on tges_hop (hop_idf_cod, hop_prj_num);
create index iges_hop_ope_fk on tges_hop (hop_idf_cod, hop_ope_cod);
create index iges_idi_idf_fk on tges_idi (idi_idf_cod);
create index iges_iva_idf_fk on tges_iva (iva_idf_cod);
create index iges_lff_idf_fk on tges_lff (lff_idf_cod);
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
create index iges_tpl_idf_fk on tges_tpl (tpl_idf_cod);
create index iges_taj_tpr_fk on tges_taj (taj_idf_cod, taj_tpr_cod);
create index iges_tar_idf_fk on tges_tar (tar_idf_cod);
create index iges_tcs_idf_fk on tges_tcs (tcs_idf_cod);
create index iges_tds_idf_fk on tges_tds (tds_idf_cod);
create index iges_tfc_idf_fk on tges_tfc (tfc_idf_cod);
create index iges_tin_idf_fk on tges_tin (tin_idf_cod);
create index iges_tip_idf_fk on tges_tip (tip_idf_cod);
create index iges_tpj_idf_fk on tges_tpj (tpj_idf_cod);
create index iges_tpr_pro_fk on tges_tpr (tpr_idf_cod, tpr_pro_cod);
create index iges_tra_idf_fk on tges_tra (tra_idf_cod);
create index iges_tri_idf_fk on tges_tri (tri_idf_cod);
create index iges_tun_idf_fk on tges_tun (tun_idf_cod);
create index iges_tve_idf_fk on tges_tve (tve_idf_cod);
create index iges_uba_idf_fk on tges_uba (uba_idf_cod);

    alter table tges_uba 
       add constraint irges_uba_pk unique (uba_idf_cod);
create index iges_ubi_idf_fk on tges_ubi (ubi_idf_cod);
create index iges_usg_idf_fk on tges_usg (usg_idf_cod);

    alter table tges_ubi 
       add constraint irges_ubi_pk unique (ubi_idf_cod, ubi_cod);
create index iges_vpp_emp_fk on tges_vpp (vpp_idf_cod, vpp_emp_cod);
create index iges_vpp_prj_fk on tges_vpp (vpp_idf_cod, vpp_prj_num);
create index iges_vpp_pro_fk on tges_vpp (vpp_idf_cod, vpp_pro_cod);
create index iges_vpp_tve_fk on tges_vpp (vpp_idf_cod, vpp_tve_cod);
create index iges_zon_idf_fk on tges_zon (zon_idf_cod);
create index irhu_cat_idf_fk on trhu_cat (cat_idf_cod);
create index irhu_cen_idf_fk on trhu_cen (cen_idf_cod);
create index irhu_cln_idf_fk on trhu_cln (cln_idf_cod);

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
       add constraint irges_cfg_pk unique (cfg_idf_cod, cfg_emp_cod, cfg_ser_cod, cfg_cls, cfg_tip, cfg_subtip);
       
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
       
    alter table tges_lff 
       add constraint rges_lff_ffa_fk 
       foreign key (lff_ffa_cod, lff_idf_cod) 
       references tges_ffa;

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