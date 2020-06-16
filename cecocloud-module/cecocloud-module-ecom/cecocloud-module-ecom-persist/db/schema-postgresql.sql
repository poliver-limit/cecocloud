    create table tcom_ain (
       ain_art_cod varchar(15) not null,
        ain_num int4 not null,
        ain_idf_cod varchar(4) not null,
        ain_usucre varchar(255),
        ain_datcre timestamp,
        ain_usumod varchar(255),
        ain_datmod timestamp,
        ain_des varchar(60) not null,
        ain_fitnom varchar(250),
        ain_tip int4,
        ain_web varchar(255),
        primary key (ain_art_cod, ain_num, ain_idf_cod)
    );

    create table tcom_alb (
       alb_emp_cod varchar(4) not null,
        alb_numdoc int4 not null,
        alb_idf_cod varchar(4) not null,
        alb_usucre varchar(255),
        alb_datcre timestamp,
        alb_usumod varchar(255),
        alb_datmod timestamp,
        alb_cli_cod varchar(6),
        alb_cli_cpo_cod varchar(8),
        alb_cpo_cod varchar(8),
        alb_div_cod varchar(4),
        alb_dpg_cod varchar(4),
        alb_cls varchar(1) not null,
        alb_dia timestamp not null,
        alb_dti varchar(1) not null,
        alb_valdiveur numeric(19, 2) not null,
        alb_cli_domfis varchar(60),
        alb_cli_eml varchar(60),
        alb_cli_emlfac varchar(100),
        alb_cli_escdom varchar(2),
        alb_fac_cls varchar(255),
        alb_fac_num int4,
        alb_fbl varchar(1) not null,
        alb_fpa varchar(1) not null,
        alb_cli_nif varchar(12),
        alb_cli_nomcom varchar(40) not null,
        alb_cli_nomdom varchar(30),
        alb_cli_nomfis varchar(40) not null,
        alb_num int4 not null,
        alb_cli_numdom varchar(5),
        alb_obs varchar(1000),
        alb_cli_pisdom varchar(2),
        alb_cli_pordom varchar(2),
        alb_pru numeric(15, 8),
        alb_pruiva numeric(15, 8),
        alb_ser_codfac varchar(2),
        alb_cli_tel varchar(60),
        alb_cli_tipnif int4,
        alb_idi_cod varchar(4),
        alb_iva_cod varchar(4),
        alb_mag_cod varchar(4),
        alb_pmg_cod varchar(255),
        alb_ope_codcml varchar(6) not null,
        alb_ope_cod varchar(6) not null,
        alb_pas_cod varchar(4),
        alb_cli_painif varchar(4),
        alb_pre_cod int4,
        alb_prv_cod varchar(4),
        alb_ptv_cod varchar(4) not null,
        alb_ser_cod varchar(2),
        alb_cli_sgl varchar(2),
        primary key (alb_emp_cod, alb_numdoc, alb_idf_cod)
    );

    create table tcom_apc (
       apc_emp_cod varchar(4) not null,
        apc_num int4 not null,
        apc_pre_cod int4 not null,
        apc_idf_cod varchar(4) not null,
        apc_usucre varchar(255),
        apc_datcre timestamp,
        apc_usumod varchar(255),
        apc_datmod timestamp,
        apc_cxa_cod varchar(4),
        apc_des varchar(30),
        apc_dia timestamp not null,
        apc_est int4 not null,
        apc_imp numeric(15, 2) not null,
        primary key (apc_emp_cod, apc_num, apc_pre_cod, apc_idf_cod)
    );

    create table tcom_art (
       art_cod varchar(15) not null,
        art_idf_cod varchar(4) not null,
        art_usucre varchar(255),
        art_datcre timestamp,
        art_usumod varchar(255),
        art_datmod timestamp,
        art_ain_num int4,
        art_decpru int4 not null,
        art_decpruiva int4,
        art_des varchar(2000) not null,
        art_descur varchar(60),
        art_pruiva numeric(25, 10) not null,
        art_pvp numeric(25, 10) not null,
        art_rutinf varchar(1000) not null,
        art_far_cod varchar(6) not null,
        art_gma_cod varchar(6),
        art_iva_cod varchar(4) not null,
        art_mca_cod varchar(6),
        art_mod_cod varchar(6) not null,
        art_tun_cod varchar(4),
        primary key (art_cod, art_idf_cod)
    );

    create table tcom_bfc (
       bfc_emp_cod varchar(4) not null,
        bfc_fac_cls varchar(1) not null,
        bfc_fac_num int4 not null,
        bfc_iva_cod varchar(4) not null,
        bfc_ser_cod varchar(2) not null,
        bfc_idf_cod varchar(4) not null,
        bfc_usucre varchar(255),
        bfc_datcre timestamp,
        bfc_usumod varchar(255),
        bfc_datmod timestamp,
        primary key (bfc_emp_cod, bfc_fac_cls, bfc_fac_num, bfc_iva_cod, bfc_ser_cod, bfc_idf_cod)
    );

    create table tcom_cli (
       cli_cod varchar(6) not null,
        cli_idf_cod varchar(4) not null,
        cli_usucre varchar(255),
        cli_datcre timestamp,
        cli_usumod varchar(255),
        cli_datmod timestamp,
        cli_cpo_cod varchar(8),
        cli_dpg_cod varchar(4) not null,
        cli_domfis varchar(60),
        cli_eml varchar(60),
        cli_emlfac varchar(100),
        cli_escdom varchar(2),
        cli_nif varchar(12),
        cli_nomcom varchar(40) not null,
        cli_nomdom varchar(30),
        cli_nomfis varchar(40) not null,
        cli_numdom varchar(5),
        cli_pisdom varchar(2),
        cli_pordom varchar(2),
        cli_tel varchar(60),
        cli_tipnif int4,
        cli_fmc_cod varchar(4) not null,
        cli_idi_cod varchar(4),
        cli_iva_cod varchar(4),
        cli_painif varchar(2),
        cli_rgi_cod varchar(2) not null,
        cli_sgl varchar(2),
        cli_tfc_cod varchar(4) not null,
        cli_tve_cod varchar(4) not null,
        primary key (cli_cod, cli_idf_cod)
    );

    create table tcom_cnt (
       cnt_cod varchar(15) not null,
        cnt_idf_cod varchar(4) not null,
        cnt_usucre varchar(255),
        cnt_datcre timestamp,
        cnt_usumod varchar(255),
        cnt_datmod timestamp,
        cnt_ultval int4 not null,
        primary key (cnt_cod, cnt_idf_cod)
    );

    create table tcom_cpo (
       cpo_cod varchar(8) not null,
        cpo_idf_cod varchar(4) not null,
        cpo_usucre varchar(255),
        cpo_datcre timestamp,
        cpo_usumod varchar(255),
        cpo_datmod timestamp,
        cpo_cmpnrp numeric(19, 2) not null,
        cpo_imr numeric(19, 2) not null,
        cpo_irp numeric(19, 2) not null,
        cpo_mun varchar(30),
        cpo_pob varchar(30) not null,
        cpo_pas_cod varchar(4) not null,
        cpo_prv_cod varchar(4) not null,
        primary key (cpo_cod, cpo_idf_cod)
    );

    create table tcom_cxa (
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

    create table tcom_dar (
       dar_art_cod varchar(15) not null,
        dar_idi_cod varchar(4) not null,
        dar_idf_cod varchar(4) not null,
        dar_usucre varchar(255),
        dar_datcre timestamp,
        dar_usumod varchar(255),
        dar_datmod timestamp,
        dar_des varchar(2000) not null,
        primary key (dar_art_cod, dar_idi_cod, dar_idf_cod)
    );

    create table tcom_dep (
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

    create table tcom_div (
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

    create table tcom_dpg (
       dpg_cod varchar(4) not null,
        dpg_idf_cod varchar(4) not null,
        dpg_usucre varchar(255),
        dpg_datcre timestamp,
        dpg_usumod varchar(255),
        dpg_datmod timestamp,
        dpg_acuvto varchar(255) not null,
        dpg_apldteppg varchar(255) not null,
        dpg_asicmp varchar(255) not null,
        dpg_codcmp varchar(255) not null,
        dpg_codfacele varchar(255) not null,
        dpg_cnccmp varchar(255) not null,
        dpg_ctecmppag varchar(255) not null,
        dpg_ctecmping varchar(255) not null,
        dpg_ctecmpcmi varchar(255) not null,
        dpg_crlefecob varchar(255) not null,
        dpg_des varchar(30) not null,
        dpg_diaefeneg int4 not null,
        dpg_dricmping varchar(255) not null,
        dpg_dricmping002 varchar(255) not null,
        dpg_dricmppag varchar(255) not null,
        dpg_dricmppag002 varchar(255) not null,
        dpg_numdiaval int4 not null,
        dpg_percmi numeric(19, 2) not null,
        dpg_tipasiing varchar(255) not null,
        dpg_tipasipag varchar(255) not null,
        dpg_trs varchar(255) not null,
        dpg_iva_cod varchar(255) not null,
        dpg_npg_cod varchar(255) not null,
        dpg_rgi_cod varchar(255) not null,
        primary key (dpg_cod, dpg_idf_cod)
    );

    create table tcom_emp (
       emp_cod varchar(4) not null,
        emp_idf_cod varchar(4) not null,
        emp_usucre varchar(255),
        emp_datcre timestamp,
        emp_usumod varchar(255),
        emp_datmod timestamp,
        emp_nomcom varchar(40) not null,
        primary key (emp_cod, emp_idf_cod)
    );

    create table tcom_fac (
       fac_cls varchar(1) not null,
        fac_emp_cod varchar(4) not null,
        fac_num int4 not null,
        fac_ser_cod varchar(2) not null,
        fac_idf_cod varchar(4) not null,
        fac_usucre varchar(255),
        fac_datcre timestamp,
        fac_usumod varchar(255),
        fac_datmod timestamp,
        fac_cli_cod varchar(6) not null,
        fac_cli_cpo_cod varchar(8),
        fac_cpo_cod varchar(8) not null,
        fac_div_cod varchar(4) not null,
        fac_dpg_cod varchar(4),
        fac_bim numeric(15, 3) not null,
        fac_cos numeric(15, 3) not null,
        fac_dia timestamp not null,
        fac_cli_domfis varchar(60),
        fac_cli_eml varchar(60),
        fac_cli_emlfac varchar(100),
        fac_cli_escdom varchar(2),
        fac_fpa varchar(1) not null,
        fac_bru numeric(15, 3) not null,
        fac_cli_nif varchar(12),
        fac_cli_nomcom varchar(40) not null,
        fac_cli_nomdom varchar(30),
        fac_cli_nomfis varchar(40) not null,
        fac_nomfiscli varchar(40) not null,
        fac_cli_numdom varchar(5),
        fac_cli_pisdom varchar(2),
        fac_cli_pordom varchar(2),
        fac_tot numeric(15, 3) not null,
        fac_recequ varchar(1) not null,
        fac_ref varchar(100),
        fac_cli_tel varchar(60),
        fac_cli_tipnif int4,
        fac_valdiveur numeric(15, 8) not null,
        fac_idi_cod varchar(4),
        fac_pas_cod varchar(4),
        fac_cli_painif varchar(4),
        fac_pre_cod int4,
        fac_prv_cod varchar(4),
        fac_ptv_cod varchar(4),
        fac_rgi_cod varchar(2) not null,
        fac_cli_sgl varchar(2),
        fac_tve_cod varchar(4) not null,
        primary key (fac_cls, fac_emp_cod, fac_num, fac_ser_cod, fac_idf_cod)
    );

    create table tcom_fae (
       fae_far_cod varchar(6) not null,
        fae_emp_cod varchar(4) not null,
        fae_idf_cod varchar(4) not null,
        fae_usucre varchar(255),
        fae_datcre timestamp,
        fae_usumod varchar(255),
        fae_datmod timestamp,
        fae_web varchar(255),
        primary key (fae_far_cod, fae_emp_cod, fae_idf_cod)
    );

    create table tcom_far (
       far_cod varchar(6) not null,
        far_idf_cod varchar(4) not null,
        far_usucre varchar(255),
        far_datcre timestamp,
        far_usumod varchar(255),
        far_datmod timestamp,
        far_pda varchar(1),
        far_des varchar(30) not null,
        primary key (far_cod, far_idf_cod)
    );

    create table tcom_fmc (
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

    create table tcom_fpr (
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

    create table tcom_gma (
       gma_cod varchar(6) not null,
        gma_idf_cod varchar(4) not null,
        gma_usucre varchar(255),
        gma_datcre timestamp,
        gma_usumod varchar(255),
        gma_datmod timestamp,
        gma_des varchar(30) not null,
        primary key (gma_cod, gma_idf_cod)
    );

    create table tcom_idf (
       idf_cod varchar(4) not null,
        idf_usucre varchar(255),
        idf_datcre timestamp,
        idf_usumod varchar(255),
        idf_datmod timestamp,
        idf_nom varchar(40) not null,
        primary key (idf_cod)
    );

    create table tcom_idi (
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

    create table tcom_iva (
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

    create table tcom_lac (
       lac_alb_numdoc int4 not null,
        lac_emp_cod varchar(4) not null,
        lac_num int4 not null,
        lac_idf_cod varchar(4) not null,
        lac_usucre varchar(255),
        lac_datcre timestamp,
        lac_usumod varchar(255),
        lac_datmod timestamp,
        lac_art_cod varchar(15) not null,
        lac_des varchar(2000) not null,
        lac_fcs int4 not null,
        lac_pru int4 not null,
        lac_imp int4 not null,
        lac_uni int4 not null,
        lac_iva_cod varchar(4),
        primary key (lac_alb_numdoc, lac_emp_cod, lac_num, lac_idf_cod)
    );

    create table tcom_lpr (
       lpr_emp_cod varchar(4) not null,
        lpr_pre_cod int4 not null,
        codi int4 not null,
        lpr_idf_cod varchar(4) not null,
        lpr_usucre varchar(255),
        lpr_datcre timestamp,
        lpr_usumod varchar(255),
        lpr_datmod timestamp,
        lpr_art_cod varchar(15) not null,
        lpr_des varchar(4000) not null,
        lpr_fcs int4 not null,
        lpr_num int4,
        lpr_pru numeric(17, 2) not null,
        lpr_imp numeric(15, 2) not null,
        lpr_uni int4 not null,
        primary key (lpr_emp_cod, lpr_pre_cod, codi, lpr_idf_cod)
    );

    create table tcom_mag (
       mag_cod varchar(4) not null,
        mag_idf_cod varchar(4) not null,
        mag_usucre varchar(255),
        mag_datcre timestamp,
        mag_usumod varchar(255),
        mag_datmod timestamp,
        mag_cpo_cod varchar(8) not null,
        mag_div_cod varchar(4) not null,
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

    create table tcom_mar (
       mar_art_cod varchar(15) not null,
        mar_mag_cod varchar(4) not null,
        mar_idf_cod varchar(4) not null,
        mar_usucre varchar(255),
        mar_datcre timestamp,
        mar_usumod varchar(255),
        mar_datmod timestamp,
        mar_cosmag numeric(15, 2),
        mar_ultdiaivt timestamp,
        mar_diaultcpl timestamp,
        mar_demmeanu numeric(17, 3),
        mar_diaultcpr timestamp,
        mar_diaespcom int4,
        mar_loteco numeric(15, 3),
        mar_pruexicpl numeric(17, 5),
        mar_prucosexi numeric(17, 5),
        mar_stomax numeric(15, 3),
        mar_stomin numeric(15, 3),
        mar_stosgr numeric(15, 3),
        mar_llc varchar(30),
        mar_ultprucos numeric(17, 5),
        mar_ultprucpl numeric(17, 5),
        primary key (mar_art_cod, mar_mag_cod, mar_idf_cod)
    );

    create table tcom_mca (
       mca_cod varchar(6) not null,
        mca_idf_cod varchar(4) not null,
        mca_usucre varchar(255),
        mca_datcre timestamp,
        mca_usumod varchar(255),
        mca_datmod timestamp,
        mca_des varchar(30) not null,
        primary key (mca_cod, mca_idf_cod)
    );

    create table tcom_mdc (
       mdc_cxa_cod varchar(4) not null,
        mdc_emp_cod varchar(4) not null,
        mdc_num int4 not null,
        mdc_idf_cod varchar(4) not null,
        mdc_usucre varchar(255),
        mdc_datcre timestamp,
        mdc_usumod varchar(255),
        mdc_datmod timestamp,
        mdc_div_cod varchar(4) not null,
        mdc_dpg_cod varchar(4) not null,
        mdc_anc varchar(1) not null,
        mdc_cls varchar(1) not null,
        mdc_dia timestamp not null,
        mdc_imp numeric(15, 3) not null,
        mdc_trs varchar(1) not null,
        mdc_valdiveur numeric(15, 8) not null,
        mdc_ope_cod varchar(6) not null,
        mdc_pre_cod int4,
        primary key (mdc_cxa_cod, mdc_emp_cod, mdc_num, mdc_idf_cod)
    );

    create table tcom_mod (
       mod_cod varchar(6) not null,
        mod_idf_cod varchar(4) not null,
        mod_usucre varchar(255),
        mod_datcre timestamp,
        mod_usumod varchar(255),
        mod_datmod timestamp,
        mod_des varchar(30) not null,
        primary key (mod_cod, mod_idf_cod)
    );

    create table tcom_mtr (
       mtr_tra_cod varchar(6) not null,
        mtr_cod varchar(10) not null,
        mtr_idf_cod varchar(4) not null,
        mtr_usucre varchar(255),
        mtr_datcre timestamp,
        mtr_usumod varchar(255),
        mtr_datmod timestamp,
        mtr_act varchar(1) not null,
        mtr_cdu varchar(30),
        mtr_des varchar(60) not null,
        mtr_mtr001 varchar(10) not null,
        mtr_mtr002 varchar(10),
        mtr_nif varchar(12),
        mtr_obs varchar(1000),
        mtr_pesmax numeric(19, 2),
        mtr_tara numeric(19, 2),
        mtr_vehemp varchar(1),
        primary key (mtr_tra_cod, mtr_cod, mtr_idf_cod)
    );

    create table tcom_npg (
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

    create table tcom_pas (
       pas_cod varchar(5) not null,
        pas_idf_cod varchar(4) not null,
        pas_usucre varchar(255),
        pas_datcre timestamp,
        pas_usumod varchar(255),
        pas_datmod timestamp,
        pas_cee varchar(1),
        pas_codiso varchar(3),
        pas_codiso002 varchar(2),
        pas_cmpnrp numeric(19, 2) not null,
        pas_imr numeric(19, 2) not null,
        pas_irp numeric(19, 2) not null,
        pas_nif varchar(2),
        pas_nom varchar(30) not null,
        primary key (pas_cod, pas_idf_cod)
    );

    create table tcom_ped (
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

    create table tcom_pmg (
       pmg_mag_cod varchar(4) not null,
        pmg_cod varchar(22) not null,
        pmg_idf_cod varchar(4) not null,
        pmg_usucre varchar(255),
        pmg_datcre timestamp,
        pmg_usumod varchar(255),
        pmg_datmod timestamp,
        pmg_diaini timestamp not null,
        pmg_des varchar(30) not null,
        primary key (pmg_mag_cod, pmg_cod, pmg_idf_cod)
    );

    create table tcom_pni (
       pni_cod varchar(2) not null,
        pni_nom varchar(40),
        pni_tamnif varchar(15),
        pni_tipnif varchar(1) not null,
        primary key (pni_cod)
    );

    create table tcom_pre (
       pre_emp_cod varchar(4) not null,
        pre_cod int4 not null,
        pre_idf_cod varchar(22) not null,
        pre_usucre varchar(255),
        pre_datcre timestamp,
        pre_usumod varchar(255),
        pre_datmod timestamp,
        pre_cli_cod varchar(6),
        pre_cli_cpo_cod varchar(8),
        pre_cpo_cod varchar(8),
        pre_div_cod varchar(4),
        pre_dpg_cod varchar(4),
        pre_dia timestamp not null,
        pre_diaini timestamp,
        pre_cli_domfis varchar(60),
        pre_cli_eml varchar(60),
        pre_cli_emlfac varchar(100),
        pre_cli_escdom varchar(2),
        pre_est varchar(1),
        pre_cli_nif varchar(12),
        pre_cli_nomcom varchar(40) not null,
        pre_cli_nomdom varchar(30),
        pre_cli_nomfis varchar(40) not null,
        pre_num int4 not null,
        pre_cli_numdom varchar(5),
        pre_obs varchar(2000),
        pre_cli_pisdom varchar(2),
        pre_cli_pordom varchar(2),
        pre_pru numeric(15, 8),
        pre_pruiva numeric(15, 8),
        pre_cli_tel varchar(60),
        pre_cli_tipnif int4,
        pre_ver int4 not null,
        pre_idi_cod varchar(4),
        pre_iva_cod varchar(4),
        pre_mag_cod varchar(4),
        pre_pas_cod varchar(4),
        pre_cli_painif varchar(4),
        pre_prv_cod varchar(4),
        pre_ptv_cod varchar(4),
        pre_ser_cod varchar(4),
        pre_cli_sgl varchar(2),
        primary key (pre_emp_cod, pre_cod, pre_idf_cod)
    );

    create table tcom_pro (
       pro_cod varchar(6) not null,
        pro_idf_cod varchar(4) not null,
        pro_usucre varchar(255),
        pro_datcre timestamp,
        pro_usumod varchar(255),
        pro_datmod timestamp,
        pro_cpo_cod varchar(8) not null,
        pro_div_cod varchar(4) not null,
        pro_dpg_cod varchar(4) not null,
        pro_blo varchar(1) not null,
        pro_dhm varchar(1) not null,
        pro_nomcom varchar(40) not null,
        pro_nomfis varchar(40) not null,
        pro_scn varchar(1) not null,
        pro_fpr_cod varchar(4) not null,
        pro_rgi_cod varchar(2) not null,
        pro_tve_cod varchar(4) not null,
        primary key (pro_cod, pro_idf_cod)
    );

    create table tcom_prv (
       prv_pas_cod varchar(4) not null,
        prv_cod varchar(3) not null,
        prv_idf_cod varchar(4) not null,
        prv_usucre varchar(255),
        prv_datcre timestamp,
        prv_usumod varchar(255),
        prv_datmod timestamp,
        prv_cmpnrp numeric(19, 2) not null,
        prv_imr numeric(19, 2) not null,
        prv_irp numeric(19, 2) not null,
        prv_nom varchar(30) not null,
        primary key (prv_pas_cod, prv_cod, prv_idf_cod)
    );

    create table tcom_ptv (
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
        ptv_ope_cod varchar(6),
        ptv_ser_cod varchar(2),
        primary key (ptv_emp_cod, ptv_cod, ptv_idf_cod)
    );

    create table tcom_rgi (
       rgi_cod varchar(2) not null,
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

    create table tcom_scp (
       scp_emp_cod varchar(4) not null,
        scp_cod varchar(2) not null,
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

    create table tcom_ser (
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

    create table tcom_sto (
       STO_TIP varchar(1) not null,
        sto_art_cod varchar(15) not null,
        sto_mag_cod varchar(4) not null,
        sto_pmg_cod varchar(22) not null,
        sto_idf_cod varchar(4) not null,
        sto_usucre varchar(255),
        sto_datcre timestamp,
        sto_usumod varchar(255),
        sto_datmod timestamp,
        STO_UNICOMCLI numeric(15, 3),
        STO_UNICPRPRO numeric(15, 3),
        STO_UNICPRPRO002 numeric(15, 3),
        STO_UNIDEF numeric(15, 3),
        STO_UNIDEF002 numeric(15, 3),
        STO_UNIDIPCLI numeric(15, 3),
        STO_UNIDIPPRO numeric(15, 3),
        STO_UNIENTALTMAG numeric(15, 3),
        STO_UNIENTALTMAG002 numeric(15, 3),
        STO_UNIENTINV numeric(15, 3),
        STO_UNIENTINV002 numeric(15, 3),
        STO_UNIFAB numeric(15, 3),
        STO_UNIFAB002 numeric(15, 3),
        STO_UNIINI numeric(15, 3),
        STO_UNIINI002 numeric(15, 3),
        STO_UNIPENREB numeric(15, 3),
        STO_UNIRSV numeric(15, 3),
        STO_UNIRSV002 numeric(15, 3),
        STO_UNISORALB numeric(15, 3),
        STO_UNISORALB002 numeric(15, 3),
        STO_UNISORALTMAG002 numeric(15, 3),
        STO_UNISORFAB numeric(15, 3),
        STO_UNISORFAB002 numeric(15, 3),
        STO_UNISORFABALB numeric(15, 3),
        STO_UNISORFABALB002 numeric(15, 3),
        STO_UNISORINV numeric(15, 3),
        STO_UNISORINV002 numeric(15, 3),
        STO_UNISORMAG numeric(15, 3),
        STO_VALCOMCLI numeric(15, 3),
        STO_VALCPRPRO numeric(15, 3),
        STO_VALCPRPRO002 numeric(15, 3),
        STO_VALDEF numeric(15, 3),
        STO_VALDEF002 numeric(15, 3),
        STO_VALDIPCLI numeric(15, 3),
        STO_VALDIPPRO numeric(15, 3),
        STO_VALENTALTMAG numeric(15, 3),
        STO_VALENTALTMAG002 numeric(15, 3),
        STO_VALENTINV numeric(15, 3),
        STO_VALENTINV002 numeric(15, 3),
        STO_VALFAB numeric(15, 3),
        STO_VALFAB002 numeric(15, 3),
        STO_VALINI numeric(15, 3),
        STO_VALINI002 numeric(15, 3),
        STO_VALPENREB numeric(15, 3),
        STO_VALRSV002 numeric(15, 3),
        STO_VALSORALB numeric(15, 3),
        STO_VALSORALB002 numeric(15, 3),
        STO_VALSORALTMAG002 numeric(15, 3),
        STO_VALSORFAB numeric(15, 3),
        STO_VALSORFAB002 numeric(15, 3),
        STO_VALSORINV numeric(15, 3),
        STO_VALSORINV002 numeric(15, 3),
        STO_VALSORMAG numeric(15, 3),
        STO_VALUNIRSV numeric(15, 3),
        primary key (STO_TIP, sto_art_cod, sto_mag_cod, sto_pmg_cod, sto_idf_cod)
    );

    create table tcom_tad (
       tad_cod varchar(2) not null,
        tad_usucre varchar(255),
        tad_datcre timestamp,
        tad_usumod varchar(255),
        tad_datmod timestamp,
        tad_des varchar(30) not null,
        primary key (tad_cod)
    );

    create table tcom_tfc (
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

    create table tcom_tra (
       tra_cod varchar(6) not null,
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

    create table tcom_tri (
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

    create table tcom_tun (
       tun_cod varchar(4) not null,
        tun_idf_cod varchar(4) not null,
        tun_usucre varchar(255),
        tun_datcre timestamp,
        tun_usumod varchar(255),
        tun_datmod timestamp,
        tun_des varchar(60) not null,
        tun_fc int4,
        primary key (tun_cod, tun_idf_cod)
    );

    create table tcom_tve (
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

    create table tcom_vcx (
       vcx_cxa_cod varchar(4) not null,
        vcx_mdc_num int4 not null,
        vcx_emp_cod varchar(4) not null,
        vcx_mov int4 not null,
        vcx_idf_cod varchar(4) not null,
        vcx_usucre varchar(255),
        vcx_datcre timestamp,
        vcx_usumod varchar(255),
        vcx_datmod timestamp,
        vcx_cmpvcpseq int4,
        vcx_imp numeric(15, 3) not null,
        vcx_fac_cls varchar(1),
        vcx_fac_num int4,
        vcx_ser_cod varchar(2),
        vcx_ven_num int4,
        primary key (vcx_cxa_cod, vcx_mdc_num, vcx_emp_cod, vcx_mov, vcx_idf_cod)
    );

    create table tcom_ven (
       ven_emp_cod varchar(4) not null,
        ven_fac_cls varchar(1) not null,
        ven_fac_num int4 not null,
        ven_num int4 not null,
        ven_ser_cod varchar(2) not null,
        ven_idf_cod varchar(4) not null,
        ven_usucre varchar(255),
        ven_datcre timestamp,
        ven_usumod varchar(255),
        ven_datmod timestamp,
        ven_div_cod varchar(4) not null,
        ven_cmpvenseq int4,
        ven_cntenv int4,
        ven_dia timestamp not null,
        ven_diaini timestamp,
        ven_imp numeric(15, 3) not null,
        ven_retgar varchar(1),
        ven_valdiveur numeric(15, 8) not null,
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

    alter table tcom_prv 
       add constraint ircom_prv_pk unique (prv_idf_cod, prv_cod);
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