    create table tcom_ain (
       ain_art_cod varchar2(15 char) not null,
        ain_num number(10,0) not null,
        ain_idf_cod varchar2(4 char) not null,
        ain_usucre varchar2(255 char),
        ain_datcre timestamp,
        ain_usumod varchar2(255 char),
        ain_datmod timestamp,
        ain_des varchar2(60 char) not null,
        ain_fitnom varchar2(250 char),
        ain_tip number(10,0),
        ain_web varchar2(255 char),
        primary key (ain_art_cod, ain_num, ain_idf_cod)
    );

    create table tcom_alb (
       alb_emp_cod varchar2(4 char) not null,
        alb_numdoc number(10,0) not null,
        alb_idf_cod varchar2(4 char) not null,
        alb_usucre varchar2(255 char),
        alb_datcre timestamp,
        alb_usumod varchar2(255 char),
        alb_datmod timestamp,
        alb_cli_cod varchar2(6 char),
        alb_cli_cpo_cod varchar2(8 char),
        alb_cpo_cod varchar2(8 char),
        alb_div_cod varchar2(4 char),
        alb_dpg_cod varchar2(4 char),
        alb_cls varchar2(1 char) not null,
        alb_dia timestamp not null,
        alb_dti varchar2(1 char) not null,
        alb_valdiveur number(19,2) not null,
        alb_cli_domfis varchar2(60 char),
        alb_cli_eml varchar2(60 char),
        alb_cli_emlfac varchar2(100 char),
        alb_cli_escdom varchar2(2 char),
        alb_fac_cls varchar2(255 char),
        alb_fac_num number(10,0),
        alb_fbl varchar2(1 char) not null,
        alb_fpa varchar2(1 char) not null,
        alb_cli_nif varchar2(12 char),
        alb_cli_nomcom varchar2(40 char) not null,
        alb_cli_nomdom varchar2(30 char),
        alb_cli_nomfis varchar2(40 char) not null,
        alb_num number(10,0) not null,
        alb_cli_numdom varchar2(5 char),
        alb_obs varchar2(1000 char),
        alb_cli_pisdom varchar2(2 char),
        alb_cli_pordom varchar2(2 char),
        alb_pru number(15,8),
        alb_pruiva number(15,8),
        alb_ser_codfac varchar2(2 char),
        alb_cli_tel varchar2(60 char),
        alb_cli_tipnif number(10,0),
        alb_idi_cod varchar2(4 char),
        alb_iva_cod varchar2(4 char),
        alb_mag_cod varchar2(4 char),
        alb_pmg_cod varchar2(255 char),
        alb_ope_codcml varchar2(6 char) not null,
        alb_ope_cod varchar2(6 char) not null,
        alb_pas_cod varchar2(4 char),
        alb_cli_painif varchar2(4 char),
        alb_pre_cod number(10,0),
        alb_prv_cod varchar2(4 char),
        alb_ptv_cod varchar2(4 char) not null,
        alb_ser_cod varchar2(2 char),
        alb_cli_sgl varchar2(2 char),
        primary key (alb_emp_cod, alb_numdoc, alb_idf_cod)
    );

    create table tcom_apc (
       apc_emp_cod varchar2(4 char) not null,
        apc_num number(10,0) not null,
        apc_pre_cod number(10,0) not null,
        apc_idf_cod varchar2(4 char) not null,
        apc_usucre varchar2(255 char),
        apc_datcre timestamp,
        apc_usumod varchar2(255 char),
        apc_datmod timestamp,
        apc_cxa_cod varchar2(4 char),
        apc_des varchar2(30 char),
        apc_dia timestamp not null,
        apc_est number(10,0) not null,
        apc_imp number(15,2) not null,
        apc_sync varchar2(1 char),
        primary key (apc_emp_cod, apc_num, apc_pre_cod, apc_idf_cod)
    );

    create table tcom_art (
       art_cod varchar2(15 char) not null,
        art_idf_cod varchar2(4 char) not null,
        art_usucre varchar2(255 char),
        art_datcre timestamp,
        art_usumod varchar2(255 char),
        art_datmod timestamp,
        art_ain_num number(10,0),
        art_blo varchar2(1 char) not null,
        art_decpru number(10,0) not null,
        art_decpruiva number(10,0),
        art_des varchar2(2000 char) not null,
        art_descur varchar2(60 char),
        art_tipuni varchar2(4 char),
        art_pruiva number(25,10),
        art_pvp number(25,10) not null,
        art_rutinf varchar2(1000 char),
        art_tlt varchar2(20 char),
        art_far_cod varchar2(6 char) not null,
        art_gma_cod varchar2(6 char),
        art_iva_cod varchar2(4 char) not null,
        art_mca_cod varchar2(6 char),
        art_mod_cod varchar2(6 char),
        art_tun_cod varchar2(4 char),
        primary key (art_cod, art_idf_cod)
    );

    create table tcom_bfc (
       bfc_emp_cod varchar2(4 char) not null,
        bfc_fac_cls varchar2(1 char) not null,
        bfc_fac_num number(10,0) not null,
        bfc_iva_cod varchar2(4 char) not null,
        bfc_ser_cod varchar2(2 char) not null,
        bfc_idf_cod varchar2(4 char) not null,
        bfc_usucre varchar2(255 char),
        bfc_datcre timestamp,
        bfc_usumod varchar2(255 char),
        bfc_datmod timestamp,
        primary key (bfc_emp_cod, bfc_fac_cls, bfc_fac_num, bfc_iva_cod, bfc_ser_cod, bfc_idf_cod)
    );

    create table tcom_cli (
       cli_cod varchar2(6 char) not null,
        cli_idf_cod varchar2(4 char) not null,
        cli_usucre varchar2(255 char),
        cli_datcre timestamp,
        cli_usumod varchar2(255 char),
        cli_datmod timestamp,
        cli_cpo_cod varchar2(8 char),
        cli_dpg_cod varchar2(4 char) not null,
        cli_domfis varchar2(60 char),
        cli_eml varchar2(60 char),
        cli_emlfac varchar2(100 char),
        cli_escdom varchar2(2 char),
        cli_nif varchar2(12 char),
        cli_nomcom varchar2(40 char) not null,
        cli_nomdom varchar2(30 char),
        cli_nomfis varchar2(40 char) not null,
        cli_numdom varchar2(5 char),
        cli_pisdom varchar2(2 char),
        cli_pordom varchar2(2 char),
        cli_tel varchar2(60 char),
        cli_tipnif number(10,0),
        cli_fmc_cod varchar2(4 char) not null,
        cli_idi_cod varchar2(4 char),
        cli_iva_cod varchar2(4 char),
        cli_painif varchar2(2 char),
        cli_rgi_cod varchar2(2 char) not null,
        cli_sgl varchar2(2 char),
        cli_tfc_cod varchar2(4 char) not null,
        cli_tve_cod varchar2(4 char) not null,
        primary key (cli_cod, cli_idf_cod)
    );

    create table tcom_cnt (
       cnt_cod varchar2(15 char) not null,
        cnt_idf_cod varchar2(4 char) not null,
        cnt_usucre varchar2(255 char),
        cnt_datcre timestamp,
        cnt_usumod varchar2(255 char),
        cnt_datmod timestamp,
        cnt_ultval number(10,0) not null,
        primary key (cnt_cod, cnt_idf_cod)
    );

    create table tcom_cpo (
       cpo_cod varchar2(8 char) not null,
        cpo_idf_cod varchar2(4 char) not null,
        cpo_usucre varchar2(255 char),
        cpo_datcre timestamp,
        cpo_usumod varchar2(255 char),
        cpo_datmod timestamp,
        cpo_cmpnrp number(19,2),
        cpo_imr number(19,2),
        cpo_irp number(19,2),
        cpo_mun varchar2(30 char),
        cpo_pob varchar2(30 char) not null,
        cpo_pas_cod varchar2(4 char) not null,
        cpo_prv_cod varchar2(4 char) not null,
        primary key (cpo_cod, cpo_idf_cod)
    );

    create table tcom_cxa (
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

    create table tcom_dar (
       dar_art_cod varchar2(15 char) not null,
        dar_idi_cod varchar2(4 char) not null,
        dar_idf_cod varchar2(4 char) not null,
        dar_usucre varchar2(255 char),
        dar_datcre timestamp,
        dar_usumod varchar2(255 char),
        dar_datmod timestamp,
        dar_des varchar2(2000 char) not null,
        primary key (dar_art_cod, dar_idi_cod, dar_idf_cod)
    );

    create table tcom_dep (
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

    create table tcom_div (
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
        div_iso varchar2(3 char) not null,
        div_nom varchar2(30 char) not null,
        div_valdiveur number(15,8) not null,
        primary key (div_cod, div_idf_cod)
    );

    create table tcom_dpg (
       dpg_cod varchar2(4 char) not null,
        dpg_idf_cod varchar2(4 char) not null,
        dpg_usucre varchar2(255 char),
        dpg_datcre timestamp,
        dpg_usumod varchar2(255 char),
        dpg_datmod timestamp,
        dpg_acuvto varchar2(255 char) not null,
        dpg_apldteppg varchar2(255 char) not null,
        dpg_asicmp varchar2(255 char) not null,
        dpg_codcmp varchar2(255 char) not null,
        dpg_codfacele varchar2(255 char) not null,
        dpg_cnccmp varchar2(255 char) not null,
        dpg_ctecmppag varchar2(255 char) not null,
        dpg_ctecmping varchar2(255 char) not null,
        dpg_ctecmpcmi varchar2(255 char) not null,
        dpg_crlefecob varchar2(255 char) not null,
        dpg_des varchar2(30 char) not null,
        dpg_diaefeneg number(10,0) not null,
        dpg_dricmping varchar2(255 char) not null,
        dpg_dricmping002 varchar2(255 char) not null,
        dpg_dricmppag varchar2(255 char) not null,
        dpg_dricmppag002 varchar2(255 char) not null,
        dpg_numdiaval number(10,0) not null,
        dpg_percmi number(19,2) not null,
        dpg_tipasiing varchar2(255 char) not null,
        dpg_tipasipag varchar2(255 char) not null,
        dpg_trs varchar2(255 char) not null,
        dpg_iva_cod varchar2(255 char) not null,
        dpg_npg_cod varchar2(255 char) not null,
        dpg_rgi_cod varchar2(255 char) not null,
        primary key (dpg_cod, dpg_idf_cod)
    );

    create table tcom_emp (
       emp_cod varchar2(4 char) not null,
        emp_idf_cod varchar2(4 char) not null,
        emp_usucre varchar2(255 char),
        emp_datcre timestamp,
        emp_usumod varchar2(255 char),
        emp_datmod timestamp,
        emp_div_cod varchar2(4 char) not null,
        emp_nomcom varchar2(40 char) not null,
        primary key (emp_cod, emp_idf_cod)
    );

    create table tcom_fac (
       fac_cls varchar2(1 char) not null,
        fac_emp_cod varchar2(4 char) not null,
        fac_num number(10,0) not null,
        fac_ser_cod varchar2(2 char) not null,
        fac_idf_cod varchar2(4 char) not null,
        fac_usucre varchar2(255 char),
        fac_datcre timestamp,
        fac_usumod varchar2(255 char),
        fac_datmod timestamp,
        fac_cli_cod varchar2(6 char) not null,
        fac_cli_cpo_cod varchar2(8 char),
        fac_cpo_cod varchar2(8 char) not null,
        fac_div_cod varchar2(4 char) not null,
        fac_dpg_cod varchar2(4 char),
        fac_bim number(15,3) not null,
        fac_cos number(15,3) not null,
        fac_dia timestamp not null,
        fac_cli_domfis varchar2(60 char),
        fac_cli_eml varchar2(60 char),
        fac_cli_emlfac varchar2(100 char),
        fac_cli_escdom varchar2(2 char),
        fac_fpa varchar2(1 char) not null,
        fac_bru number(15,3) not null,
        fac_cli_nif varchar2(12 char),
        fac_cli_nomcom varchar2(40 char) not null,
        fac_cli_nomdom varchar2(30 char),
        fac_cli_nomfis varchar2(40 char) not null,
        fac_nomfiscli varchar2(40 char) not null,
        fac_cli_numdom varchar2(5 char),
        fac_cli_pisdom varchar2(2 char),
        fac_cli_pordom varchar2(2 char),
        fac_tot number(15,3) not null,
        fac_recequ varchar2(1 char) not null,
        fac_ref varchar2(100 char),
        fac_cli_tel varchar2(60 char),
        fac_cli_tipnif number(10,0),
        fac_valdiveur number(15,8) not null,
        fac_idi_cod varchar2(4 char),
        fac_pas_cod varchar2(4 char),
        fac_cli_painif varchar2(4 char),
        fac_pre_cod number(10,0),
        fac_prv_cod varchar2(4 char),
        fac_ptv_cod varchar2(4 char),
        fac_rgi_cod varchar2(2 char) not null,
        fac_cli_sgl varchar2(2 char),
        fac_tve_cod varchar2(4 char) not null,
        primary key (fac_cls, fac_emp_cod, fac_num, fac_ser_cod, fac_idf_cod)
    );

    create table tcom_fae (
       fae_far_cod varchar2(6 char) not null,
        fae_emp_cod varchar2(4 char) not null,
        fae_idf_cod varchar2(4 char) not null,
        fae_usucre varchar2(255 char),
        fae_datcre timestamp,
        fae_usumod varchar2(255 char),
        fae_datmod timestamp,
        fae_web varchar2(255 char),
        primary key (fae_far_cod, fae_emp_cod, fae_idf_cod)
    );

    create table tcom_far (
       far_cod varchar2(6 char) not null,
        far_idf_cod varchar2(4 char) not null,
        far_usucre varchar2(255 char),
        far_datcre timestamp,
        far_usumod varchar2(255 char),
        far_datmod timestamp,
        far_pda varchar2(1 char),
        far_des varchar2(30 char) not null,
        primary key (far_cod, far_idf_cod)
    );

    create table tcom_fmc (
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

    create table tcom_fpr (
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

    create table tcom_gma (
       gma_cod varchar2(6 char) not null,
        gma_idf_cod varchar2(4 char) not null,
        gma_usucre varchar2(255 char),
        gma_datcre timestamp,
        gma_usumod varchar2(255 char),
        gma_datmod timestamp,
        gma_des varchar2(30 char) not null,
        primary key (gma_cod, gma_idf_cod)
    );

    create table tcom_idf (
       idf_cod varchar2(4 char) not null,
        idf_usucre varchar2(255 char),
        idf_datcre timestamp,
        idf_usumod varchar2(255 char),
        idf_datmod timestamp,
        idf_nom varchar2(40 char) not null,
        primary key (idf_cod)
    );

    create table tcom_idi (
       idi_cod varchar2(4 char) not null,
        idi_idf_cod varchar2(4 char) not null,
        idi_usucre varchar2(255 char),
        idi_datcre timestamp,
        idi_usumod varchar2(255 char),
        idi_datmod timestamp,
        idi_codiso varchar2(2 char),
        idi_des varchar2(30 char) not null,
        primary key (idi_cod, idi_idf_cod)
    );

    create table tcom_iva (
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

    create table tcom_lac (
       lac_alb_numdoc number(10,0) not null,
        lac_emp_cod varchar2(4 char) not null,
        lac_num number(10,0) not null,
        lac_idf_cod varchar2(4 char) not null,
        lac_usucre varchar2(255 char),
        lac_datcre timestamp,
        lac_usumod varchar2(255 char),
        lac_datmod timestamp,
        lac_art_cod varchar2(15 char) not null,
        lac_des varchar2(2000 char) not null,
        lac_fcs number(10,0) not null,
        lac_pru number(10,0) not null,
        lac_imp number(10,0) not null,
        lac_uni number(10,0) not null,
        lac_iva_cod varchar2(4 char),
        primary key (lac_alb_numdoc, lac_emp_cod, lac_num, lac_idf_cod)
    );

    create table tcom_lpr (
       lpr_emp_cod varchar2(4 char) not null,
        lpr_pre_cod number(10,0) not null,
        codi number(10,0) not null,
        lpr_idf_cod varchar2(4 char) not null,
        lpr_usucre varchar2(255 char),
        lpr_datcre timestamp,
        lpr_usumod varchar2(255 char),
        lpr_datmod timestamp,
        lpr_art_cod varchar2(15 char) not null,
        lpr_des varchar2(4000 char) not null,
        lpr_fcs number(10,0) not null,
        lpr_num number(10,0),
        lpr_pru number(17,2) not null,
        lpr_imp number(15,2) not null,
        lpr_sync varchar2(1 char),
        lpr_uni number(10,0) not null,
        primary key (lpr_emp_cod, lpr_pre_cod, codi, lpr_idf_cod)
    );

    create table tcom_mag (
       mag_cod varchar2(4 char) not null,
        mag_idf_cod varchar2(4 char) not null,
        mag_usucre varchar2(255 char),
        mag_datcre timestamp,
        mag_usumod varchar2(255 char),
        mag_datmod timestamp,
        mag_cpo_cod varchar2(8 char) not null,
        mag_div_cod varchar2(4 char) not null,
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

    create table tcom_mar (
       mar_art_cod varchar2(15 char) not null,
        mar_mag_cod varchar2(4 char) not null,
        mar_idf_cod varchar2(4 char) not null,
        mar_usucre varchar2(255 char),
        mar_datcre timestamp,
        mar_usumod varchar2(255 char),
        mar_datmod timestamp,
        mar_cosmag number(15,2),
        mar_ultdiaivt timestamp,
        mar_diaultcpl timestamp,
        mar_demmeanu number(17,3),
        mar_diaultcpr timestamp,
        mar_diaespcom number(10,0),
        mar_loteco number(15,3),
        mar_pruexicpl number(17,5),
        mar_prucosexi number(17,5),
        mar_stomax number(15,3),
        mar_stomin number(15,3),
        mar_stosgr number(15,3),
        mar_llc varchar2(30 char),
        mar_ultprucos number(17,5),
        mar_ultprucpl number(17,5),
        primary key (mar_art_cod, mar_mag_cod, mar_idf_cod)
    );

    create table tcom_mca (
       mca_cod varchar2(6 char) not null,
        mca_idf_cod varchar2(4 char) not null,
        mca_usucre varchar2(255 char),
        mca_datcre timestamp,
        mca_usumod varchar2(255 char),
        mca_datmod timestamp,
        mca_des varchar2(30 char) not null,
        primary key (mca_cod, mca_idf_cod)
    );

    create table tcom_mdc (
       mdc_cxa_cod varchar2(4 char) not null,
        mdc_emp_cod varchar2(4 char) not null,
        mdc_num number(10,0) not null,
        mdc_idf_cod varchar2(4 char) not null,
        mdc_usucre varchar2(255 char),
        mdc_datcre timestamp,
        mdc_usumod varchar2(255 char),
        mdc_datmod timestamp,
        mdc_div_cod varchar2(4 char) not null,
        mdc_dpg_cod varchar2(4 char) not null,
        mdc_anc varchar2(1 char) not null,
        mdc_cls varchar2(1 char) not null,
        mdc_dia timestamp not null,
        mdc_imp number(15,3) not null,
        mdc_trs varchar2(1 char) not null,
        mdc_valdiveur number(15,8) not null,
        mdc_ope_cod varchar2(6 char) not null,
        mdc_pre_cod number(10,0),
        primary key (mdc_cxa_cod, mdc_emp_cod, mdc_num, mdc_idf_cod)
    );

    create table tcom_mod (
       mod_cod varchar2(6 char) not null,
        mod_idf_cod varchar2(4 char) not null,
        mod_usucre varchar2(255 char),
        mod_datcre timestamp,
        mod_usumod varchar2(255 char),
        mod_datmod timestamp,
        mod_des varchar2(30 char) not null,
        primary key (mod_cod, mod_idf_cod)
    );

    create table tcom_mtr (
       mtr_tra_cod varchar2(6 char) not null,
        mtr_cod varchar2(10 char) not null,
        mtr_idf_cod varchar2(4 char) not null,
        mtr_usucre varchar2(255 char),
        mtr_datcre timestamp,
        mtr_usumod varchar2(255 char),
        mtr_datmod timestamp,
        mtr_act varchar2(1 char) not null,
        mtr_cdu varchar2(30 char),
        mtr_des varchar2(60 char) not null,
        mtr_mtr001 varchar2(10 char) not null,
        mtr_mtr002 varchar2(10 char),
        mtr_nif varchar2(12 char),
        mtr_obs varchar2(1000 char),
        mtr_pesmax number(19,2),
        mtr_tara number(19,2),
        mtr_vehemp varchar2(1 char),
        primary key (mtr_tra_cod, mtr_cod, mtr_idf_cod)
    );

    create table tcom_npg (
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

    create table tcom_pas (
       pas_cod varchar2(5 char) not null,
        pas_idf_cod varchar2(4 char) not null,
        pas_usucre varchar2(255 char),
        pas_datcre timestamp,
        pas_usumod varchar2(255 char),
        pas_datmod timestamp,
        pas_cee varchar2(1 char),
        pas_codiso varchar2(3 char),
        pas_codiso002 varchar2(2 char),
        pas_cmpnrp number(19,2),
        pas_imr number(19,2),
        pas_irp number(19,2),
        pas_nif varchar2(2 char),
        pas_nom varchar2(30 char) not null,
        primary key (pas_cod, pas_idf_cod)
    );

    create table tcom_ped (
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

    create table tcom_pmg (
       pmg_mag_cod varchar2(4 char) not null,
        pmg_cod varchar2(22 char) not null,
        pmg_idf_cod varchar2(4 char) not null,
        pmg_usucre varchar2(255 char),
        pmg_datcre timestamp,
        pmg_usumod varchar2(255 char),
        pmg_datmod timestamp,
        pmg_diaini timestamp not null,
        pmg_des varchar2(30 char) not null,
        primary key (pmg_mag_cod, pmg_cod, pmg_idf_cod)
    );

    create table tcom_pni (
       pni_cod varchar2(2 char) not null,
        pni_nom varchar2(40 char),
        pni_tamnif varchar2(15 char),
        pni_tipnif varchar2(1 char) not null,
        primary key (pni_cod)
    );

    create table tcom_pre (
       pre_emp_cod varchar2(4 char) not null,
        pre_cod number(10,0) not null,
        pre_idf_cod varchar2(22 char) not null,
        pre_usucre varchar2(255 char),
        pre_datcre timestamp,
        pre_usumod varchar2(255 char),
        pre_datmod timestamp,
        pre_cli_cod varchar2(6 char),
        pre_cli_cpo_cod varchar2(8 char),
        pre_cpo_cod varchar2(8 char),
        pre_div_cod varchar2(4 char),
        pre_dpg_cod varchar2(4 char),
        pre_dia timestamp not null,
        pre_diaini timestamp,
        pre_cli_domfis varchar2(60 char),
        pre_cli_eml varchar2(60 char),
        pre_cli_emlfac varchar2(100 char),
        pre_cli_escdom varchar2(2 char),
        pre_est varchar2(1 char),
        pre_cli_nif varchar2(12 char),
        pre_cli_nomcom varchar2(40 char) not null,
        pre_cli_nomdom varchar2(30 char),
        pre_cli_nomfis varchar2(40 char) not null,
        pre_num number(10,0) not null,
        pre_cli_numdom varchar2(5 char),
        pre_obs varchar2(2000 char),
        pre_cli_pisdom varchar2(2 char),
        pre_cli_pordom varchar2(2 char),
        pre_pru number(15,8),
        pre_pruiva number(15,8),
        pre_sync varchar2(1 char),
        pre_cli_tel varchar2(60 char),
        pre_cli_tipnif number(10,0),
        pre_ver number(10,0) not null,
        pre_idi_cod varchar2(4 char),
        pre_iva_cod varchar2(4 char),
        pre_mag_cod varchar2(4 char),
        pre_pas_cod varchar2(4 char),
        pre_cli_painif varchar2(4 char),
        pre_prv_cod varchar2(4 char),
        pre_ptv_cod varchar2(4 char),
        pre_ser_cod varchar2(2 char) not null,
        pre_cli_sgl varchar2(2 char),
        primary key (pre_emp_cod, pre_cod, pre_idf_cod)
    );

    create table tcom_pro (
       pro_cod varchar2(6 char) not null,
        pro_idf_cod varchar2(4 char) not null,
        pro_usucre varchar2(255 char),
        pro_datcre timestamp,
        pro_usumod varchar2(255 char),
        pro_datmod timestamp,
        pro_cpo_cod varchar2(8 char) not null,
        pro_div_cod varchar2(4 char) not null,
        pro_dpg_cod varchar2(4 char) not null,
        pro_blo varchar2(1 char) not null,
        pro_dhm varchar2(1 char) not null,
        pro_nomcom varchar2(40 char) not null,
        pro_nomfis varchar2(40 char) not null,
        pro_scn varchar2(1 char) not null,
        pro_fpr_cod varchar2(4 char) not null,
        pro_rgi_cod varchar2(2 char) not null,
        pro_tve_cod varchar2(4 char) not null,
        primary key (pro_cod, pro_idf_cod)
    );

    create table tcom_prv (
       prv_pas_cod varchar2(5 char) not null,
        prv_cod varchar2(3 char) not null,
        prv_idf_cod varchar2(4 char) not null,
        prv_usucre varchar2(255 char),
        prv_datcre timestamp,
        prv_usumod varchar2(255 char),
        prv_datmod timestamp,
        prv_cmpnrp number(19,2),
        prv_imr number(19,2),
        prv_irp number(19,2),
        prv_nom varchar2(30 char) not null,
        primary key (prv_pas_cod, prv_cod, prv_idf_cod)
    );

    create table tcom_ptv (
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
        ptv_ope_cod varchar2(6 char),
        ptv_ser_cod varchar2(2 char),
        primary key (ptv_emp_cod, ptv_cod, ptv_idf_cod)
    );

    create table tcom_rgi (
       rgi_cod varchar2(2 char) not null,
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

    create table tcom_scp (
       scp_emp_cod varchar2(4 char) not null,
        scp_cod varchar2(2 char) not null,
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

    create table tcom_ser (
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
        ser_ultpre number(10,0),
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

    create table tcom_sto (
       STO_TIP varchar2(1 char) not null,
        sto_art_cod varchar2(15 char) not null,
        sto_mag_cod varchar2(4 char) not null,
        sto_pmg_cod varchar2(22 char) not null,
        sto_idf_cod varchar2(4 char) not null,
        sto_usucre varchar2(255 char),
        sto_datcre timestamp,
        sto_usumod varchar2(255 char),
        sto_datmod timestamp,
        STO_UNICOMCLI number(15,3),
        STO_UNICPRPRO number(15,3),
        STO_UNICPRPRO002 number(15,3),
        STO_UNIDEF number(15,3),
        STO_UNIDEF002 number(15,3),
        STO_UNIDIPCLI number(15,3),
        STO_UNIDIPPRO number(15,3),
        STO_UNIENTALTMAG number(15,3),
        STO_UNIENTALTMAG002 number(15,3),
        STO_UNIENTINV number(15,3),
        STO_UNIENTINV002 number(15,3),
        STO_UNIFAB number(15,3),
        STO_UNIFAB002 number(15,3),
        STO_UNIINI number(15,3),
        STO_UNIINI002 number(15,3),
        STO_UNIPENREB number(15,3),
        STO_UNIRSV number(15,3),
        STO_UNIRSV002 number(15,3),
        STO_UNISORALB number(15,3),
        STO_UNISORALB002 number(15,3),
        STO_UNISORALTMAG002 number(15,3),
        STO_UNISORFAB number(15,3),
        STO_UNISORFAB002 number(15,3),
        STO_UNISORFABALB number(15,3),
        STO_UNISORFABALB002 number(15,3),
        STO_UNISORINV number(15,3),
        STO_UNISORINV002 number(15,3),
        STO_UNISORMAG number(15,3),
        STO_VALCOMCLI number(15,3),
        STO_VALCPRPRO number(15,3),
        STO_VALCPRPRO002 number(15,3),
        STO_VALDEF number(15,3),
        STO_VALDEF002 number(15,3),
        STO_VALDIPCLI number(15,3),
        STO_VALDIPPRO number(15,3),
        STO_VALENTALTMAG number(15,3),
        STO_VALENTALTMAG002 number(15,3),
        STO_VALENTINV number(15,3),
        STO_VALENTINV002 number(15,3),
        STO_VALFAB number(15,3),
        STO_VALFAB002 number(15,3),
        STO_VALINI number(15,3),
        STO_VALINI002 number(15,3),
        STO_VALPENREB number(15,3),
        STO_VALRSV002 number(15,3),
        STO_VALSORALB number(15,3),
        STO_VALSORALB002 number(15,3),
        STO_VALSORALTMAG002 number(15,3),
        STO_VALSORFAB number(15,3),
        STO_VALSORFAB002 number(15,3),
        STO_VALSORINV number(15,3),
        STO_VALSORINV002 number(15,3),
        STO_VALSORMAG number(15,3),
        STO_VALUNIRSV number(15,3),
        primary key (STO_TIP, sto_art_cod, sto_mag_cod, sto_pmg_cod, sto_idf_cod)
    );

    create table tcom_tad (
       tad_cod varchar2(2 char) not null,
        tad_usucre varchar2(255 char),
        tad_datcre timestamp,
        tad_usumod varchar2(255 char),
        tad_datmod timestamp,
        tad_des varchar2(30 char) not null,
        primary key (tad_cod)
    );

    create table tcom_tfc (
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

    create table tcom_tra (
       tra_cod varchar2(6 char) not null,
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

    create table tcom_tri (
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

    create table tcom_tun (
       tun_cod varchar2(4 char) not null,
        tun_idf_cod varchar2(4 char) not null,
        tun_usucre varchar2(255 char),
        tun_datcre timestamp,
        tun_usumod varchar2(255 char),
        tun_datmod timestamp,
        tun_des varchar2(60 char) not null,
        tun_fc number(10,0),
        primary key (tun_cod, tun_idf_cod)
    );

    create table tcom_tve (
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

    create table tcom_vcx (
       vcx_cxa_cod varchar2(4 char) not null,
        vcx_mdc_num number(10,0) not null,
        vcx_emp_cod varchar2(4 char) not null,
        vcx_mov number(10,0) not null,
        vcx_idf_cod varchar2(4 char) not null,
        vcx_usucre varchar2(255 char),
        vcx_datcre timestamp,
        vcx_usumod varchar2(255 char),
        vcx_datmod timestamp,
        vcx_cmpvcpseq number(10,0),
        vcx_imp number(15,3) not null,
        vcx_fac_cls varchar2(1 char),
        vcx_fac_num number(10,0),
        vcx_ser_cod varchar2(2 char),
        vcx_ven_num number(10,0),
        primary key (vcx_cxa_cod, vcx_mdc_num, vcx_emp_cod, vcx_mov, vcx_idf_cod)
    );

    create table tcom_ven (
       ven_emp_cod varchar2(4 char) not null,
        ven_fac_cls varchar2(1 char) not null,
        ven_fac_num number(10,0) not null,
        ven_num number(10,0) not null,
        ven_ser_cod varchar2(2 char) not null,
        ven_idf_cod varchar2(4 char) not null,
        ven_usucre varchar2(255 char),
        ven_datcre timestamp,
        ven_usumod varchar2(255 char),
        ven_datmod timestamp,
        ven_div_cod varchar2(4 char) not null,
        ven_cmpvenseq number(10,0),
        ven_cntenv number(10,0),
        ven_dia timestamp not null,
        ven_diaini timestamp,
        ven_imp number(15,3) not null,
        ven_retgar varchar2(1 char),
        ven_valdiveur number(15,8) not null,
        primary key (ven_emp_cod, ven_fac_cls, ven_fac_num, ven_num, ven_ser_cod, ven_idf_cod)
    );

create index icom_ain_art_fk on tcom_ain (ain_idf_cod, ain_art_cod, ain_num);
create index icom_alb_idf_fk on tcom_alb (alb_idf_cod);
create index icom_apc_idf_fk on tcom_apc (apc_idf_cod);
create index icom_apc_emp_fk on tcom_apc (apc_emp_cod);
create index icom_apc_pre_fk on tcom_apc (apc_pre_cod);
create index icom_art_idf_fk on tcom_art (art_idf_cod);
create index icom_bfc_idf_fk on tcom_bfc (bfc_idf_cod);
create index icom_bfc_emp_fk on tcom_bfc (bfc_emp_cod);
create index icom_bfc_ser_fk on tcom_bfc (bfc_ser_cod);
create index icom_bfc_fac_fk on tcom_bfc (bfc_fac_cls, bfc_fac_num);
create index icom_bfc_iva_fk on tcom_bfc (bfc_iva_cod);
create index icom_cli_idf_fk on tcom_cli (cli_idf_cod);
create index icom_cnt_idf_fk on tcom_cnt (cnt_idf_cod);
create index icom_cpo_idf_fk on tcom_cpo (cpo_idf_cod);
create index icom_cxa_idf_fk on tcom_cxa (cxa_idf_cod);
create index icom_cxa_emp_fk on tcom_cxa (cxa_emp_cod);
create index icom_dar_idf_fk on tcom_dar (dar_idf_cod);
create index icom_dep_idf_fk on tcom_dep (dep_idf_cod);

    alter table tcom_dep 
       add constraint ircom_dep_pk unique (dep_idf_cod, dep_cod);
create index icom_div_idf_fk on tcom_div (div_idf_cod);
create index icom_dpg_idf_fk on tcom_dpg (dpg_idf_cod);
create index icom_emp_idf_fk on tcom_emp (emp_idf_cod);
create index icom_fac_idf_fk on tcom_fac (fac_idf_cod);
create index icom_fac_emp_fk on tcom_fac (fac_emp_cod);
create index icom_fac_ser_fk on tcom_fac (fac_ser_cod);
create index icom_fae_idf_fk on tcom_fae (fae_idf_cod);
create index icom_far_idf_fk on tcom_far (far_idf_cod);
create index icom_fmc_idf_fk on tcom_fmc (fmc_idf_cod);
create index icom_fpr_idf_fk on tcom_fpr (fpr_idf_cod);
create index icom_gma_idf_fk on tcom_gma (gma_idf_cod);
create index icom_idi_idf_fk on tcom_idi (idi_idf_cod);
create index icom_iva_idf_fk on tcom_iva (iva_idf_cod);
create index icom_lac_emp_fk on tcom_lac (lac_idf_cod, lac_emp_cod);
create index icom_lac_alb_fk on tcom_lac (lac_idf_cod, lac_emp_cod, lac_alb_numdoc);
create index icom_lpr_emp_fk on tcom_lpr (lpr_idf_cod, lpr_emp_cod);
create index icom_lpr_pre_fk on tcom_lpr (lpr_idf_cod, lpr_emp_cod, lpr_pre_cod);

    alter table tcom_lpr 
       add constraint rcom_lpr_pk unique (lpr_idf_cod, lpr_emp_cod, lpr_pre_cod, lpr_num);
create index icom_mag_idf_fk on tcom_mag (mag_idf_cod);
create index icom_mar_idf_fk on tcom_mar (mar_idf_cod);
create index icom_mca_idf_fk on tcom_mca (mca_idf_cod);
create index icom_mdc_idf_fk on tcom_mdc (mdc_idf_cod);
create index icom_mdc_emp_fk on tcom_mdc (mdc_emp_cod);
create index icom_mdc_cxa_fk on tcom_mdc (mdc_cxa_cod);
create index icom_mod_idf_fk on tcom_mod (mod_idf_cod);
create index icom_mtr_idf_fk on tcom_mtr (mtr_idf_cod);
create index icom_npg_idf_fk on tcom_npg (npg_idf_cod);
create index icom_pas_idf_fk on tcom_pas (pas_idf_cod);
create index icom_ped_idf_fk on tcom_ped (ped_idf_cod);

    alter table tcom_ped 
       add constraint ircom_ped_pk unique (ped_idf_cod, ped_cod);
create index icom_pmg_idf_fk on tcom_pmg (pmg_idf_cod);
create index icom_pre_emp_fk on tcom_pre (pre_idf_cod, pre_emp_cod);
create index icom_pro_idf_fk on tcom_pro (pro_idf_cod);
create index icom_prv_idf_fk on tcom_prv (prv_idf_cod);
create index icom_ptv_emp_fk on tcom_ptv (ptv_idf_cod, ptv_emp_cod);
create index icom_rgi_idf_fk on tcom_rgi (rgi_idf_cod);
create index icom_scp_idf_fk on tcom_scp (scp_idf_cod);

    alter table tcom_scp 
       add constraint ircom_scp_pk unique (scp_idf_cod, scp_cod);
create index icom_ser_idf_fk on tcom_ser (ser_idf_cod);

    alter table tcom_ser 
       add constraint ircom_ser_pk unique (ser_idf_cod, ser_cod);
create index icom_sto_idf_fk on tcom_sto (sto_idf_cod);
create index icom_tfc_idf_fk on tcom_tfc (tfc_idf_cod);
create index icom_tra_idf_fk on tcom_tra (tra_idf_cod);
create index icom_tri_idf_fk on tcom_tri (tri_idf_cod);
create index icom_tun_idf_fk on tcom_tun (tun_idf_cod);
create index icom_tve_idf_fk on tcom_tve (tve_idf_cod);
create index icom_vcx_idf_fk on tcom_vcx (vcx_idf_cod);
create index icom_vcx_cxa_fk on tcom_vcx (vcx_cxa_cod);
create index icom_vcx_emp_fk on tcom_vcx (vcx_emp_cod);
create index icom_vcx_mdc_fk on tcom_vcx (vcx_mdc_num);
create index icom_ven_idf_fk on tcom_ven (ven_idf_cod);
create index icom_ven_emp_fk on tcom_ven (ven_emp_cod);
create index icom_ven_ser_fk on tcom_ven (ven_ser_cod);
create index icom_ven_fac_fk on tcom_ven (ven_fac_cls, ven_fac_num);

    alter table tcom_ain 
       add constraint rges_ain_art_fk 
       foreign key (ain_art_cod, ain_idf_cod) 
       references tcom_art;

    alter table tcom_alb 
       add constraint rcom_alb_cli_fk 
       foreign key (alb_cli_cod, alb_idf_cod) 
       references tcom_cli;

    alter table tcom_alb 
       add constraint alb_cpo_cod_fk 
       foreign key (alb_cpo_cod, alb_idf_cod) 
       references tcom_cpo;

    alter table tcom_alb 
       add constraint rcom_alb_cli_cpo_fk 
       foreign key (alb_cli_cpo_cod, alb_idf_cod) 
       references tcom_cpo;

    alter table tcom_alb 
       add constraint rcom_alb_div_fk 
       foreign key (alb_div_cod, alb_idf_cod) 
       references tcom_div;

    alter table tcom_alb 
       add constraint rcom_alb_dpg_fk 
       foreign key (alb_dpg_cod, alb_idf_cod) 
       references tcom_dpg;

    alter table tcom_alb 
       add constraint rcom_alb_emp_fk 
       foreign key (alb_emp_cod, alb_idf_cod) 
       references tcom_emp;

    alter table tcom_alb 
       add constraint rcom_alb_idi_fk 
       foreign key (alb_idi_cod, alb_idf_cod) 
       references tcom_idi;

    alter table tcom_alb 
       add constraint rcom_alb_iva_fk 
       foreign key (alb_iva_cod, alb_idf_cod) 
       references tcom_iva;

    alter table tcom_alb 
       add constraint rcom_alb_mag_fk 
       foreign key (alb_mag_cod, alb_idf_cod) 
       references tcom_mag;

    alter table tcom_alb 
       add constraint rcom_alb_pmg_fk 
       foreign key (alb_mag_cod, alb_pmg_cod, alb_idf_cod) 
       references tcom_pmg;

    alter table tcom_alb 
       add constraint rcom_alb_opecml_fk 
       foreign key (alb_ope_cod, alb_idf_cod) 
       references trhu_ope;

    alter table tcom_alb 
       add constraint rcom_alb_pai_fk 
       foreign key (alb_pas_cod, alb_idf_cod) 
       references tcom_pas;

    alter table tcom_alb 
       add constraint rcom_alb_cli_pni_fk 
       foreign key (alb_cli_painif) 
       references tcom_pni;

    alter table tcom_alb 
       add constraint rcom_alb_pre_fk 
       foreign key (alb_emp_cod, alb_pre_cod, alb_idf_cod) 
       references tcom_pre;

    alter table tcom_alb 
       add constraint rcom_alb_prv_fk 
       foreign key (alb_pas_cod, alb_prv_cod, alb_idf_cod) 
       references tcom_prv;

    alter table tcom_alb 
       add constraint rcom_alb_ptv_fk 
       foreign key (alb_emp_cod, alb_ptv_cod, alb_idf_cod) 
       references tcom_ptv;

    alter table tcom_alb 
       add constraint rcom_alb_ser_fk 
       foreign key (alb_emp_cod, alb_ser_cod, alb_idf_cod) 
       references tcom_ser;

    alter table tcom_apc 
       add constraint rcom_apc_cxa_fk 
       foreign key (apc_emp_cod, apc_cxa_cod, apc_idf_cod) 
       references tcom_cxa;

    alter table tcom_apc 
       add constraint rcom_apc_emp_fk 
       foreign key (apc_emp_cod, apc_idf_cod) 
       references tcom_emp;

    alter table tcom_apc 
       add constraint rcom_apc_pre_fk 
       foreign key (apc_emp_cod, apc_pre_cod, apc_idf_cod) 
       references tcom_pre;

    alter table tcom_art 
       add constraint rcom_art_ain_fk 
       foreign key (art_cod, art_ain_num, art_idf_cod) 
       references tcom_ain;

    alter table tcom_art 
       add constraint rcom_art_far_fk 
       foreign key (art_far_cod, art_idf_cod) 
       references tcom_far;

    alter table tcom_art 
       add constraint rcom_art_gma_fk 
       foreign key (art_gma_cod, art_idf_cod) 
       references tcom_gma;

    alter table tcom_art 
       add constraint rcom_art_iva_fk 
       foreign key (art_iva_cod, art_idf_cod) 
       references tcom_iva;

    alter table tcom_art 
       add constraint rcom_art_mca_fk 
       foreign key (art_mca_cod, art_idf_cod) 
       references tcom_mca;

    alter table tcom_art 
       add constraint rcom_art_mod_fk 
       foreign key (art_mod_cod, art_idf_cod) 
       references tcom_mod;

    alter table tcom_art 
       add constraint rcom_art_tun_fk 
       foreign key (art_tun_cod, art_idf_cod) 
       references tcom_tun;

    alter table tcom_bfc 
       add constraint rcom_bfc_emp_fk 
       foreign key (bfc_emp_cod, bfc_idf_cod) 
       references tcom_emp;

    alter table tcom_bfc 
       add constraint rcom_bfc_fac_fk 
       foreign key (bfc_fac_cls, bfc_emp_cod, bfc_fac_num, bfc_ser_cod, bfc_idf_cod) 
       references tcom_fac;

    alter table tcom_bfc 
       add constraint rcom_bfc_iva_fk 
       foreign key (bfc_iva_cod, bfc_idf_cod) 
       references tcom_iva;

    alter table tcom_bfc 
       add constraint rcom_bfc_ser_fk 
       foreign key (bfc_emp_cod, bfc_ser_cod, bfc_idf_cod) 
       references tcom_ser;

    alter table tcom_cli 
       add constraint cli_cpo_cod_fk 
       foreign key (cli_cpo_cod, cli_idf_cod) 
       references tcom_cpo;

    alter table tcom_cli 
       add constraint cli_dpg_cod_fk 
       foreign key (cli_dpg_cod, cli_idf_cod) 
       references tcom_dpg;

    alter table tcom_cli 
       add constraint cli_fmc_cod_fk 
       foreign key (cli_fmc_cod, cli_idf_cod) 
       references tcom_fmc;

    alter table tcom_cli 
       add constraint cli_idi_cod_fk 
       foreign key (cli_idi_cod, cli_idf_cod) 
       references tcom_idi;

    alter table tcom_cli 
       add constraint cli_iva_cod_fk 
       foreign key (cli_iva_cod, cli_idf_cod) 
       references tcom_iva;

    alter table tcom_cli 
       add constraint cli_pni_cod_fk 
       foreign key (cli_painif) 
       references tcom_pni;

    alter table tcom_cli 
       add constraint cli_rgi_cod_fk 
       foreign key (cli_rgi_cod, cli_idf_cod) 
       references tcom_rgi;

    alter table tcom_cli 
       add constraint cli_tfc_cod_fk 
       foreign key (cli_tfc_cod, cli_idf_cod) 
       references tcom_tfc;

    alter table tcom_cnt 
       add constraint rcom_cnt_idf_fk 
       foreign key (cnt_idf_cod) 
       references tcom_idf;

    alter table tcom_cpo 
       add constraint rcom_cpo_pas_fk 
       foreign key (cpo_pas_cod, cpo_idf_cod) 
       references tcom_pas;

    alter table tcom_cpo 
       add constraint rcom_cpo_prv_fk 
       foreign key (cpo_pas_cod, cpo_prv_cod, cpo_idf_cod) 
       references tcom_prv;

    alter table tcom_cxa 
       add constraint rcom_cxa_emp_fk 
       foreign key (cxa_emp_cod, cxa_idf_cod) 
       references tcom_emp;

    alter table tcom_dar 
       add constraint rcom_dar_art_fk 
       foreign key (dar_art_cod, dar_idf_cod) 
       references tcom_art;

    alter table tcom_dar 
       add constraint rcom_dar_idi_fk 
       foreign key (dar_idi_cod, dar_idf_cod) 
       references tcom_idi;

    alter table tcom_dep 
       add constraint rcom_dep_emp_fk 
       foreign key (dep_emp_cod, dep_idf_cod) 
       references tcom_emp;

    alter table tcom_dpg 
       add constraint rcom_dpg_iva_fk 
       foreign key (dpg_iva_cod, dpg_idf_cod) 
       references tcom_iva;

    alter table tcom_dpg 
       add constraint rcom_dpg_npg_fk 
       foreign key (dpg_npg_cod, dpg_idf_cod) 
       references tcom_npg;

    alter table tcom_dpg 
       add constraint rcom_dpg_rgi_fk 
       foreign key (dpg_rgi_cod, dpg_idf_cod) 
       references tcom_rgi;

    alter table tcom_emp 
       add constraint rges_emp_div_fk 
       foreign key (emp_div_cod, emp_idf_cod) 
       references tcom_div;

    alter table tcom_fac 
       add constraint rcom_fac_cli_fk 
       foreign key (fac_cli_cod, fac_idf_cod) 
       references tcom_cli;

    alter table tcom_fac 
       add constraint fac_cpo_cod_fk 
       foreign key (fac_cpo_cod, fac_idf_cod) 
       references tcom_cpo;

    alter table tcom_fac 
       add constraint rcom_fac_cli_cpo_fk 
       foreign key (fac_cli_cpo_cod, fac_idf_cod) 
       references tcom_cpo;

    alter table tcom_fac 
       add constraint rcom_fac_div_fk 
       foreign key (fac_div_cod, fac_idf_cod) 
       references tcom_div;

    alter table tcom_fac 
       add constraint rcom_fac_dpg_fk 
       foreign key (fac_dpg_cod, fac_idf_cod) 
       references tcom_dpg;

    alter table tcom_fac 
       add constraint rcom_fac_emp_fk 
       foreign key (fac_emp_cod, fac_idf_cod) 
       references tcom_emp;

    alter table tcom_fac 
       add constraint rcom_fac_idi_fk 
       foreign key (fac_idi_cod, fac_idf_cod) 
       references tcom_idi;

    alter table tcom_fac 
       add constraint rcom_fac_pai_fk 
       foreign key (fac_pas_cod, fac_idf_cod) 
       references tcom_pas;

    alter table tcom_fac 
       add constraint rcom_fac_cli_pni_fk 
       foreign key (fac_cli_painif) 
       references tcom_pni;

    alter table tcom_fac 
       add constraint rcom_fac_pre_fk 
       foreign key (fac_emp_cod, fac_pre_cod, fac_idf_cod) 
       references tcom_pre;

    alter table tcom_fac 
       add constraint rcom_fac_prv_fk 
       foreign key (fac_pas_cod, fac_prv_cod, fac_idf_cod) 
       references tcom_prv;

    alter table tcom_fac 
       add constraint rcom_fac_ptv_fk 
       foreign key (fac_emp_cod, fac_ptv_cod, fac_idf_cod) 
       references tcom_ptv;

    alter table tcom_fac 
       add constraint fac_rgi_cod_fk 
       foreign key (fac_rgi_cod, fac_idf_cod) 
       references tcom_rgi;

    alter table tcom_fac 
       add constraint rcom_fac_ser_fk 
       foreign key (fac_emp_cod, fac_ser_cod, fac_idf_cod) 
       references tcom_ser;

    alter table tcom_fac 
       add constraint fac_tve_cod_fk 
       foreign key (fac_tve_cod, fac_idf_cod) 
       references tcom_tve;

    alter table tcom_fae 
       add constraint rcom_fae_far_fk 
       foreign key (fae_far_cod, fae_idf_cod) 
       references tcom_far;

    alter table tcom_fae 
       add constraint rcom_fae_emp_fk 
       foreign key (fae_emp_cod, fae_idf_cod) 
       references tcom_emp;

    alter table tcom_fmc 
       add constraint fmc_tri_cod_fk 
       foreign key (fmc_tri_cod, fmc_idf_cod) 
       references tcom_tri;

    alter table tcom_lac 
       add constraint rcom_lac_alb_fk 
       foreign key (lac_emp_cod, lac_alb_numdoc, lac_idf_cod) 
       references tcom_alb;

    alter table tcom_lac 
       add constraint rcom_lac_art_fk 
       foreign key (lac_art_cod, lac_idf_cod) 
       references tcom_art;

    alter table tcom_lac 
       add constraint rcom_lac_emp_fk 
       foreign key (lac_emp_cod, lac_idf_cod) 
       references tcom_emp;

    alter table tcom_lac 
       add constraint rcom_lac_iva_fk 
       foreign key (lac_iva_cod, lac_idf_cod) 
       references tcom_iva;

    alter table tcom_lpr 
       add constraint rcom_lpr_art_fk 
       foreign key (lpr_art_cod, lpr_idf_cod) 
       references tcom_art;

    alter table tcom_lpr 
       add constraint rcom_lpr_emp_fk 
       foreign key (lpr_emp_cod, lpr_idf_cod) 
       references tcom_emp;

    alter table tcom_lpr 
       add constraint rcom_lpr_pre_fk 
       foreign key (lpr_emp_cod, lpr_pre_cod, lpr_idf_cod) 
       references tcom_pre;

    alter table tcom_mag 
       add constraint mag_cpo_cod_fk 
       foreign key (mag_cpo_cod, mag_idf_cod) 
       references tcom_cpo;

    alter table tcom_mag 
       add constraint rcom_mag_div_fk 
       foreign key (mag_div_cod, mag_idf_cod) 
       references tcom_div;

    alter table tcom_mar 
       add constraint rcom_mar_art_fk 
       foreign key (mar_art_cod, mar_idf_cod) 
       references tcom_art;

    alter table tcom_mar 
       add constraint rcom_mar_mag_fk 
       foreign key (mar_mag_cod, mar_idf_cod) 
       references tcom_mag;

    alter table tcom_mdc 
       add constraint rcom_mdc_cxa_fk 
       foreign key (mdc_emp_cod, mdc_cxa_cod, mdc_idf_cod) 
       references tcom_cxa;

    alter table tcom_mdc 
       add constraint rcom_mdc_div_fk 
       foreign key (mdc_div_cod, mdc_idf_cod) 
       references tcom_div;

    alter table tcom_mdc 
       add constraint rcom_mdc_dpg_fk 
       foreign key (mdc_dpg_cod, mdc_idf_cod) 
       references tcom_dpg;

    alter table tcom_mdc 
       add constraint rcom_mdc_emp_fk 
       foreign key (mdc_emp_cod, mdc_idf_cod) 
       references tcom_emp;

    alter table tcom_mdc 
       add constraint rcom_mdc_ope_fk 
       foreign key (mdc_ope_cod, mdc_idf_cod) 
       references trhu_ope;

    alter table tcom_mdc 
       add constraint rcom_mdc_pre_fk 
       foreign key (mdc_emp_cod, mdc_pre_cod, mdc_idf_cod) 
       references tcom_pre;

    alter table tcom_mtr 
       add constraint rcom_zon_tra_fk 
       foreign key (mtr_tra_cod, mtr_idf_cod) 
       references tcom_tra;

    alter table tcom_ped 
       add constraint rcom_ped_emp_fk 
       foreign key (ped_emp_cod, ped_idf_cod) 
       references tcom_emp;

    alter table tcom_ped 
       add constraint rcom_ped_scp_fk 
       foreign key (ped_emp_cod, ped_scp_codcom, ped_idf_cod) 
       references tcom_scp;

    alter table tcom_pmg 
       add constraint rcom_pmg_mag_fk 
       foreign key (pmg_mag_cod, pmg_idf_cod) 
       references tcom_mag;

    alter table tcom_pre 
       add constraint rcom_pre_cli_fk 
       foreign key (pre_cli_cod, pre_idf_cod) 
       references tcom_cli;

    alter table tcom_pre 
       add constraint rcom_pre_cpo_fk 
       foreign key (pre_cpo_cod, pre_idf_cod) 
       references tcom_cpo;

    alter table tcom_pre 
       add constraint rcom_pre_cli_cpo_fk 
       foreign key (pre_cli_cpo_cod, pre_idf_cod) 
       references tcom_cpo;

    alter table tcom_pre 
       add constraint rcom_pre_div_fk 
       foreign key (pre_div_cod, pre_idf_cod) 
       references tcom_div;

    alter table tcom_pre 
       add constraint rcom_pre_dpg_fk 
       foreign key (pre_dpg_cod, pre_idf_cod) 
       references tcom_dpg;

    alter table tcom_pre 
       add constraint rcom_pre_emp_fk 
       foreign key (pre_emp_cod, pre_idf_cod) 
       references tcom_emp;

    alter table tcom_pre 
       add constraint rcom_pre_idi_fk 
       foreign key (pre_idi_cod, pre_idf_cod) 
       references tcom_idi;

    alter table tcom_pre 
       add constraint rcom_pre_iva_fk 
       foreign key (pre_iva_cod, pre_idf_cod) 
       references tcom_iva;

    alter table tcom_pre 
       add constraint rcom_pre_mag_fk 
       foreign key (pre_mag_cod, pre_idf_cod) 
       references tcom_mag;

    alter table tcom_pre 
       add constraint rcom_pre_pai_fk 
       foreign key (pre_pas_cod, pre_idf_cod) 
       references tcom_pas;

    alter table tcom_pre 
       add constraint rcom_pre_cli_pni_fk 
       foreign key (pre_cli_painif) 
       references tcom_pni;

    alter table tcom_pre 
       add constraint rcom_pre_prv_fk 
       foreign key (pre_pas_cod, pre_prv_cod, pre_idf_cod) 
       references tcom_prv;

    alter table tcom_pre 
       add constraint rcom_pre_ptv_fk 
       foreign key (pre_emp_cod, pre_ptv_cod, pre_idf_cod) 
       references tcom_ptv;

    alter table tcom_pre 
       add constraint rcom_pre_ser_fk 
       foreign key (pre_emp_cod, pre_ser_cod, pre_idf_cod) 
       references tcom_ser;

    alter table tcom_pro 
       add constraint rcom_pro_cpo_fk 
       foreign key (pro_cpo_cod, pro_idf_cod) 
       references tcom_cpo;

    alter table tcom_pro 
       add constraint rcom_pro_div_fk 
       foreign key (pro_div_cod, pro_idf_cod) 
       references tcom_div;

    alter table tcom_pro 
       add constraint rcom_pro_dpg_fk 
       foreign key (pro_dpg_cod, pro_idf_cod) 
       references tcom_dpg;

    alter table tcom_pro 
       add constraint rcom_pro_fpr_fk 
       foreign key (pro_fpr_cod, pro_idf_cod) 
       references tcom_fpr;

    alter table tcom_pro 
       add constraint rcom_pro_rgi_fk 
       foreign key (pro_rgi_cod, pro_idf_cod) 
       references tcom_rgi;

    alter table tcom_pro 
       add constraint rcom_pro_tve_fk 
       foreign key (pro_tve_cod, pro_idf_cod) 
       references tcom_tve;

    alter table tcom_prv 
       add constraint rcom_prv_pas_fk 
       foreign key (prv_pas_cod, prv_idf_cod) 
       references tcom_pas;

    alter table tcom_ptv 
       add constraint rcom_ptv_cxa_fk 
       foreign key (ptv_emp_cod, ptv_cxa_cod, ptv_idf_cod) 
       references tcom_cxa;

    alter table tcom_ptv 
       add constraint rcom_ptv_cli_fk 
       foreign key (ptv_cli_cod, ptv_idf_cod) 
       references tcom_cli;

    alter table tcom_ptv 
       add constraint rcom_ptv_div_fk 
       foreign key (ptv_div_cod, ptv_idf_cod) 
       references tcom_div;

    alter table tcom_ptv 
       add constraint rcom_ptv_div002_fk 
       foreign key (ptv_div_cod002, ptv_idf_cod) 
       references tcom_div;

    alter table tcom_ptv 
       add constraint rcom_ptv_dpg_fk 
       foreign key (ptv_dpg_cod, ptv_idf_cod) 
       references tcom_dpg;

    alter table tcom_ptv 
       add constraint rcom_ptv_mag_fk 
       foreign key (ptv_mag_cod, ptv_idf_cod) 
       references tcom_mag;

    alter table tcom_ptv 
       add constraint rcom_ptv_ope_fk 
       foreign key (ptv_ope_cod, ptv_idf_cod) 
       references trhu_ope;

    alter table tcom_ptv 
       add constraint rcom_ptv_ser_fk 
       foreign key (ptv_emp_cod, ptv_ser_cod, ptv_idf_cod) 
       references tcom_ser;

    alter table tcom_scp 
       add constraint rcom_scp_emp_fk 
       foreign key (scp_emp_cod, scp_idf_cod) 
       references tcom_emp;

    alter table tcom_scp 
       add constraint rcom_scp_emp002_fk 
       foreign key (scp_emp_cod002, scp_idf_cod) 
       references tcom_emp;

    alter table tcom_scp 
       add constraint rcom_scp_mag_fk 
       foreign key (scp_mag_cod, scp_idf_cod) 
       references tcom_mag;

    alter table tcom_ser 
       add constraint rcom_ser_pedcondicio_fk 
       foreign key (ser_emp_cod, ser_ped_cod, ser_idf_cod) 
       references tcom_ped;

    alter table tcom_ser 
       add constraint rcom_ser_dep_fk 
       foreign key (ser_emp_cod, ser_dep_cod, ser_idf_cod) 
       references tcom_dep;

    alter table tcom_ser 
       add constraint rcom_ser_emp_fk 
       foreign key (ser_emp_cod, ser_idf_cod) 
       references tcom_emp;

    alter table tcom_ser 
       add constraint rcom_ser_empOp_fk 
       foreign key (ser_emp_codprn, ser_idf_cod) 
       references tcom_emp;

    alter table tcom_ser 
       add constraint rcom_ser_mag_fk 
       foreign key (ser_mag_cod, ser_idf_cod) 
       references tcom_mag;

    alter table tcom_ser 
       add constraint rcom_ser_ped_fk 
       foreign key (ser_emp_cod, ser_ped_codfac, ser_idf_cod) 
       references tcom_ped;

    alter table tcom_sto 
       add constraint rcom_sto_art_fk 
       foreign key (sto_art_cod, sto_idf_cod) 
       references tcom_art;

    alter table tcom_sto 
       add constraint rcom_sto_mag_fk 
       foreign key (sto_mag_cod, sto_idf_cod) 
       references tcom_mag;

    alter table tcom_sto 
       add constraint rcom_sto_pmg_fk 
       foreign key (sto_mag_cod, sto_pmg_cod, sto_idf_cod) 
       references tcom_pmg;

    alter table tcom_tra 
       add constraint rcom_tra_cpo_fk 
       foreign key (tra_cpo_cod, tra_idf_cod) 
       references tcom_cpo;

    alter table tcom_tra 
       add constraint rcom_tra_div_fk 
       foreign key (tra_div_cod, tra_idf_cod) 
       references tcom_div;

    alter table tcom_tra 
       add constraint rcom_tra_pro_fk 
       foreign key (tra_pro_cod, tra_idf_cod) 
       references tcom_pro;

    alter table tcom_vcx 
       add constraint rcom_vcx_cxa_fk 
       foreign key (vcx_emp_cod, vcx_cxa_cod, vcx_idf_cod) 
       references tcom_cxa;

    alter table tcom_vcx 
       add constraint rcom_vcx_mdc_fk 
       foreign key (vcx_cxa_cod, vcx_emp_cod, vcx_mdc_num, vcx_idf_cod) 
       references tcom_mdc;

    alter table tcom_vcx 
       add constraint rcom_vcx_emp_fk 
       foreign key (vcx_emp_cod, vcx_idf_cod) 
       references tcom_emp;

    alter table tcom_vcx 
       add constraint rcom_vcx_fac_fk 
       foreign key (vcx_fac_cls, vcx_emp_cod, vcx_fac_num, vcx_ser_cod, vcx_idf_cod) 
       references tcom_fac;

    alter table tcom_vcx 
       add constraint rcom_vcx_ser_fk 
       foreign key (vcx_emp_cod, vcx_ser_cod, vcx_idf_cod) 
       references tcom_ser;

    alter table tcom_vcx 
       add constraint rcom_vcx_ven_fk 
       foreign key (vcx_emp_cod, vcx_fac_cls, vcx_fac_num, vcx_ven_num, vcx_ser_cod, vcx_idf_cod) 
       references tcom_ven;

    alter table tcom_ven 
       add constraint rcom_ven_div_fk 
       foreign key (ven_div_cod, ven_idf_cod) 
       references tcom_div;

    alter table tcom_ven 
       add constraint rcom_ven_emp_fk 
       foreign key (ven_emp_cod, ven_idf_cod) 
       references tcom_emp;

    alter table tcom_ven 
       add constraint rcom_ven_fac_fk 
       foreign key (ven_fac_cls, ven_emp_cod, ven_fac_num, ven_ser_cod, ven_idf_cod) 
       references tcom_fac;

    alter table tcom_ven 
       add constraint rcom_ven_ser_fk 
       foreign key (ven_emp_cod, ven_ser_cod, ven_idf_cod) 
       references tcom_ser;
