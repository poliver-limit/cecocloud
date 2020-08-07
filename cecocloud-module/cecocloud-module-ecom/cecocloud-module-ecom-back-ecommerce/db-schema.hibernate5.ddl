create sequence hibernate_sequence start with 1 increment by  1;

    create table apikey (
       id number(19,0) not null,
        created_by varchar2(64 char) not null,
        created_date timestamp not null,
        lastmod_by varchar2(64 char),
        lastmod_date timestamp,
        version number(19,0) not null,
        descripcio varchar2(100 char) not null,
        hash varchar2(64 char) not null,
        prefix varchar2(8 char) not null,
        primary key (id)
    );

    create table apikey_scope (
       apikey_id number(19,0) not null,
        scope varchar2(32 char)
    );

    create table paycomet_notification (
       order_number varchar2(255 char) not null,
        account_code varchar2(255 char) not null,
        amount double precision not null,
        amount_eur double precision not null,
        auth_code varchar2(255 char) not null,
        bank_date_time varchar2(255 char) not null,
        bic_code varchar2(255 char) not null,
        card_brand varchar2(255 char) not null,
        card_country varchar2(255 char) not null,
        concept varchar2(255 char) not null,
        currency varchar2(255 char) not null,
        error_description varchar2(255 char) not null,
        error_id number(10,0) not null,
        id_user number(10,0) not null,
        notification_hash varchar2(255 char) not null,
        response varchar2(255 char) not null,
        scoring number(10,0) not null,
        secure_payment varchar2(255 char) not null,
        token_user varchar2(255 char) not null,
        tpv_id number(10,0) not null,
        transaction_name varchar2(255 char) not null,
        transaction_type number(10,0) not null,
        primary key (order_number)
    );

    create table synchronization (
       id number(19,0) not null,
        class_name varchar2(255 char) not null,
        lst_dat_ok timestamp,
        params varchar2(2000 char) not null,
        snc_dat timestamp,
        primary key (id)
    );

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
        alb_tra_cod varchar2(6 char),
        alb_mtr_cod varchar2(10 char),
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
        div_iso varchar2(3 char),
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
        lpr_num number(10,0) not null,
        lpr_pre_cod number(10,0) not null,
        lpr_idf_cod varchar2(4 char) not null,
        lpr_usucre varchar2(255 char),
        lpr_datcre timestamp,
        lpr_usumod varchar2(255 char),
        lpr_datmod timestamp,
        lpr_art_cod varchar2(15 char) not null,
        lpr_des varchar2(4000 char) not null,
        lpr_fcs number(10,0) not null,
        lpr_pru number(17,5) not null,
        lpr_imp number(15,2) not null,
        lpr_sync varchar2(1 char),
        lpr_uni number(10,0) not null,
        primary key (lpr_emp_cod, lpr_num, lpr_pre_cod, lpr_idf_cod)
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

    create table tcom_men (
       men_cod varchar2(15 char) not null,
        men_idf_cod varchar2(4 char) not null,
        men_usucre varchar2(255 char),
        men_datcre timestamp,
        men_usumod varchar2(255 char),
        men_datmod timestamp,
        men_label varchar2(20 char) not null,
        men_label_key varchar2(20 char) not null,
        men_esource varchar2(20 char) not null,
        men_route varchar2(20 char) not null,
        primary key (men_cod, men_idf_cod)
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
        pre_cerori varchar2(1 char) not null,
        pre_cls varchar2(1 char) not null,
        pre_dia timestamp not null,
        pre_diaini timestamp,
        pre_dsg varchar2(1 char) not null,
        pre_cli_domfis varchar2(60 char),
        pre_cli_eml varchar2(60 char),
        pre_cli_emlfac varchar2(100 char),
        pre_cli_escdom varchar2(2 char),
        pre_est varchar2(1 char),
        pre_cli_nif varchar2(12 char),
        pre_nomcli varchar2(40 char) not null,
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
        pre_segrebmat varchar2(1 char) not null,
        pre_sync varchar2(1 char),
        pre_cli_tel varchar2(60 char),
        pre_cli_tipnif number(10,0),
        pre_valdiveur number(15,8) not null,
        pre_ver number(10,0) not null,
        pre_idi_cod varchar2(4 char),
        pre_mag_cod varchar2(4 char),
        pre_ope_cod varchar2(6 char) not null,
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

    create table trhu_cat (
       cat_cod varchar2(4 char) not null,
        cat_idf_cod varchar2(4 char) not null,
        cat_usucre varchar2(255 char),
        cat_datcre timestamp,
        cat_usumod varchar2(255 char),
        cat_datmod timestamp,
        cat_act varchar2(255 char),
        cat_nom varchar2(255 char) not null,
        cat_obs varchar2(1000 char),
        cat_soubas number(19,2),
        primary key (cat_cod, cat_idf_cod)
    );

    create table trhu_cen (
       cen_cod varchar2(4 char) not null,
        cen_idf_cod varchar2(4 char) not null,
        cen_usucre varchar2(255 char),
        cen_datcre timestamp,
        cen_usumod varchar2(255 char),
        cen_datmod timestamp,
        cen_nom varchar2(40 char) not null,
        primary key (cen_cod, cen_idf_cod)
    );

    create table trhu_cln (
       cln_dat timestamp not null,
        cln_idf_cod varchar2(4 char) not null,
        cln_usucre varchar2(255 char),
        cln_datcre timestamp,
        cln_usumod varchar2(255 char),
        cln_datmod timestamp,
        cln_des varchar2(1000 char),
        cln_obs varchar2(1000 char),
        cln_tdi_cod varchar2(4 char),
        primary key (cln_dat, cln_idf_cod)
    );

    create table trhu_emp (
       emp_cod varchar2(4 char) not null,
        emp_idf_cod varchar2(4 char) not null,
        emp_usucre varchar2(255 char),
        emp_datcre timestamp,
        emp_usumod varchar2(255 char),
        emp_datmod timestamp,
        emp_asiprrpagext varchar2(1 char),
        emp_cpo varchar2(5 char),
        emp_cte varchar2(10 char),
        emp_cteemb varchar2(10 char),
        emp_ctebanemp varchar2(10 char),
        emp_cteret varchar2(10 char),
        emp_ctesgr varchar2(10 char),
        emp_ctesgremp varchar2(10 char),
        emp_cteterope varchar2(1 char),
        emp_cteembterope varchar2(1 char),
        emp_cteretterope varchar2(1 char),
        emp_ctesgrterope varchar2(1 char),
        emp_ctetersgremp varchar2(1 char),
        emp_dom varchar2(60 char),
        emp_dri001 varchar2(2 char),
        emp_dri002 varchar2(2 char),
        emp_eml varchar2(60 char),
        emp_empcmp varchar2(4 char),
        emp_exccmp varchar2(4 char),
        emp_asigrp varchar2(1 char),
        emp_prnlog varchar2(1 char),
        emp_www varchar2(60 char),
        emp_pob varchar2(30 char),
        emp_tel varchar2(60 char),
        emp_crecte varchar2(1 char),
        emp_vacdianat varchar2(1 char),
        primary key (emp_cod, emp_idf_cod)
    );

    create table trhu_gfe (
       gfe_cod varchar2(4 char) not null,
        gfe_idf_cod varchar2(4 char) not null,
        gfe_nom varchar2(60 char) not null,
        gfe_obs varchar2(1000 char),
        primary key (gfe_cod, gfe_idf_cod)
    );

    create table trhu_gre (
       gre_cod varchar2(4 char) not null,
        gre_idf_cod varchar2(4 char) not null,
        gre_usucre varchar2(255 char),
        gre_datcre timestamp,
        gre_usumod varchar2(255 char),
        gre_datmod timestamp,
        gre_des varchar2(255 char) not null,
        gre_nom varchar2(30 char) not null,
        gre_numhor number(19,2) not null,
        primary key (gre_cod, gre_idf_cod)
    );

    create table trhu_gse (
       gse_emp_cod varchar2(4 char) not null,
        gse_cod varchar2(4 char) not null,
        gse_idf_cod varchar2(4 char) not null,
        gse_usucre varchar2(255 char),
        gse_datcre timestamp,
        gse_usumod varchar2(255 char),
        gse_datmod timestamp,
        gse_nom varchar2(30 char),
        primary key (gse_emp_cod, gse_cod, gse_idf_cod)
    );

    create table trhu_hor (
       hor_cod varchar2(4 char) not null,
        hor_idf_cod varchar2(4 char) not null,
        hor_usucre varchar2(255 char),
        hor_datcre timestamp,
        hor_usumod varchar2(255 char),
        hor_datmod timestamp,
        hor_des varchar2(1000 char),
        hor_hor number(19,2),
        hor_nom varchar2(30 char) not null,
        hor_tip varchar2(1 char) not null,
        primary key (hor_cod, hor_idf_cod)
    );

    create table trhu_idf (
       idf_cod varchar2(4 char) not null,
        idf_usucre varchar2(255 char),
        idf_datcre timestamp,
        idf_usumod varchar2(255 char),
        idf_datmod timestamp,
        idf_nom varchar2(40 char) not null,
        primary key (idf_cod)
    );

    create table trhu_inr (
       inr_cod varchar2(4 char) not null,
        inr_idf_cod varchar2(4 char) not null,
        inr_usucre varchar2(255 char),
        inr_datcre timestamp,
        inr_usumod varchar2(255 char),
        inr_datmod timestamp,
        inr_cln_dat timestamp,
        inr_cof_cod varchar2(4 char),
        inr_dat timestamp,
        inr_fin timestamp,
        inr_ini timestamp,
        inr_ffo_cod number(10,0),
        inr_nod_nument number(10,0),
        inr_nod_numsor number(10,0),
        inr_obs varchar2(1000 char),
        inr_ope_cod varchar2(4 char) not null,
        inr_zon_cod varchar2(4 char),
        primary key (inr_cod, inr_idf_cod)
    );

    create table trhu_nod (
       nod_num varchar2(255 char) not null,
        nod_idf_cod varchar2(4 char) not null,
        nod_usucre varchar2(255 char),
        nod_datcre timestamp,
        nod_usumod varchar2(255 char),
        nod_datmod timestamp,
        nod_tip varchar2(255 char),
        nod_tip1 varchar2(10 char),
        nod_sno_cod varchar2(4 char),
        nod_zon_coddti varchar2(4 char),
        nod_zon_codori varchar2(4 char),
        primary key (nod_num, nod_idf_cod)
    );

    create table trhu_ope (
       ope_cod varchar2(6 char) not null,
        ope_idf_cod varchar2(4 char) not null,
        ope_usucre varchar2(255 char),
        ope_datcre timestamp,
        ope_usumod varchar2(255 char),
        ope_datmod timestamp,
        ope_ban_codccr number(10,0),
        ope_cen_cod varchar2(4 char),
        ope_act varchar2(255 char) not null,
        ope_ado varchar2(1 char),
        ope_ali varchar2(255 char),
        ope_anecmp varchar2(255 char),
        ope_apldia varchar2(1 char),
        ope_app varchar2(255 char),
        ope_calhor number(10,0),
        ope_codalt varchar2(255 char),
        ope_cpo varchar2(255 char),
        ope_cml varchar2(255 char) not null,
        ope_cplsal1 number(10,0),
        ope_cplsal2 number(10,0),
        ope_ctecmp varchar2(255 char),
        ope_ccr float,
        ope_ctlhoe varchar2(1 char),
        ope_ctlffo varchar2(1 char),
        ope_cosidr varchar2(255 char),
        ope_cosadd number(10,0),
        ope_dat timestamp,
        ope_tordiaini timestamp,
        ope_datnai timestamp,
        ope_diapjb timestamp,
        ope_datvaltrg timestamp,
        ope_depcmp varchar2(255 char),
        ope_depcmpfxe varchar2(255 char),
        ope_derdie varchar2(255 char),
        ope_dcc varchar2(255 char),
        ope_discos varchar2(255 char),
        ope_dom varchar2(255 char),
        ope_dtehor number(10,0),
        ope_eml varchar2(255 char),
        ope_emlemp varchar2(255 char),
        ope_enc varchar2(255 char),
        ope_ban number(10,0),
        ope_entsor varchar2(255 char) not null,
        ope_estciv varchar2(255 char),
        ope_horcan varchar2(255 char),
        ope_horanypjb number(10,0),
        ope_horlli002 number(10,0),
        ope_horlli number(10,0),
        ope_horpenanyantpjb number(10,0),
        ope_horrut varchar2(255 char),
        ope_horvac number(10,0),
        ope_horesp varchar2(1 char),
        ope_ibnbic varchar2(255 char),
        ope_ibndcc varchar2(255 char),
        ope_ibnpai varchar2(255 char),
        ope_pruextdjs number(10,0),
        ope_pruextdls number(10,0),
        ope_pruextdms number(10,0),
        ope_pruextdcs number(10,0),
        ope_pruextdse number(10,0),
        ope_pruextdme number(10,0),
        ope_pruextdvs number(10,0),
        ope_pruhornor number(10,0),
        ope_ind varchar2(255 char),
        ope_djs varchar2(1 char),
        ope_dls varchar2(1 char),
        ope_dms varchar2(1 char),
        ope_dcs varchar2(1 char),
        ope_dse varchar2(1 char),
        ope_dme varchar2(1 char),
        ope_dvs varchar2(1 char),
        ope_llcnai varchar2(255 char),
        ope_maxhoe001 number(10,0),
        ope_mdcntf varchar2(255 char),
        ope_tor varchar2(255 char),
        ope_nif varchar2(255 char),
        ope_nmn1 number(10,0),
        ope_nmn2 number(10,0),
        ope_nom varchar2(40 char) not null,
        ope_nommae varchar2(255 char),
        ope_nompae varchar2(255 char),
        ope_ngr varchar2(1 char),
        ope_nothorext varchar2(255 char),
        ope_fil number(10,0),
        ope_mtr number(10,0),
        ope_obs varchar2(255 char),
        ope_obspjb varchar2(255 char),
        ope_ofb number(10,0),
        ope_pjb varchar2(255 char),
        ope_pas varchar2(255 char),
        ope_mns number(10,0),
        ope_pin varchar2(255 char),
        ope_plupdt varchar2(255 char),
        ope_pob varchar2(255 char),
        ope_prv varchar2(255 char),
        ope_prunitdcs number(10,0),
        ope_prunitdjs number(10,0),
        ope_prunitdls number(10,0),
        ope_prunitdme number(10,0),
        ope_prunitdms number(10,0),
        ope_prunitdse number(10,0),
        ope_prunitdvs number(10,0),
        ope_ptenmn number(10,0),
        ope_ptenmn002 number(10,0),
        ope_sex varchar2(255 char),
        ope_tpc varchar2(255 char),
        ope_tel varchar2(255 char),
        ope_telemp varchar2(255 char),
        ope_tgtcod varchar2(255 char),
        ope_usucld varchar2(255 char),
        ope_emp_codccr varchar2(4 char),
        ope_gfe_cod varchar2(4 char),
        ope_hor_cod002 varchar2(4 char),
        ope_hor_cod003 varchar2(4 char),
        ope_hor_cod varchar2(4 char) not null,
        ope_hor_codnit varchar2(4 char),
        ope_vad_cod varchar2(4 char),
        ope_ope_cod varchar2(6 char),
        ope_gre_cod varchar2(4 char),
        ope_tcs_cod varchar2(4 char),
        ope_tor_cod varchar2(4 char),
        ope_zon_cod varchar2(4 char),
        primary key (ope_cod, ope_idf_cod)
    );

    create table trhu_par (
       par_cod varchar2(4 char) not null,
        par_idf_cod varchar2(15 char) not null,
        par_usucre varchar2(255 char),
        par_datcre timestamp,
        par_usumod varchar2(255 char),
        par_datmod timestamp,
        par_des varchar2(1000 char),
        par_val varchar2(1000 char),
        primary key (par_cod, par_idf_cod)
    );

    create table trhu_rdi (
       rdi_cln_dat timestamp not null,
        rdi_idf_cod varchar2(4 char) not null,
        rdi_usucre varchar2(255 char),
        rdi_datcre timestamp,
        rdi_usumod varchar2(255 char),
        rdi_datmod timestamp,
        rdi_cat_cod varchar2(4 char) not null,
        rdi_horext number(22,0) not null,
        rdi_hornit number(22,0) not null,
        rdi_hornor number(22,0) not null,
        rdi_horteo number(22,0) not null,
        rdi_pruhornit number(15,2) not null,
        rdi_pruhornor number(15,2) not null,
        rdi_pruext number(22,0) not null,
        rdi_emp_cod varchar2(4 char) not null,
        rdi_hor_cod varchar2(255 char) not null,
        rdi_ope_cod varchar2(6 char) not null,
        rdi_reg_cod varchar2(4 char) not null,
        rdi_sec_cod varchar2(4 char) not null,
        rdi_sct_cod varchar2(4 char) not null,
        primary key (rdi_cln_dat, rdi_idf_cod)
    );

    create table trhu_reg (
       reg_cod varchar2(4 char) not null,
        reg_idf_cod varchar2(4 char) not null,
        reg_usucre varchar2(255 char),
        reg_datcre timestamp,
        reg_usumod varchar2(255 char),
        reg_datmod timestamp,
        reg_hor varchar2(255 char) not null,
        reg_mntreg varchar2(255 char) not null,
        reg_pln varchar2(255 char) not null,
        reg_nom varchar2(30 char),
        reg_maxhorlab number(3,0),
        reg_minhorlab number(3,0),
        reg_prs varchar2(255 char) not null,
        primary key (reg_cod, reg_idf_cod)
    );

    create table trhu_sct (
       sct_cod varchar2(4 char) not null,
        sct_idf_cod varchar2(4 char) not null,
        sct_usucre varchar2(255 char),
        sct_datcre timestamp,
        sct_usumod varchar2(255 char),
        sct_datmod timestamp,
        sct_cat_cod varchar2(4 char),
        sct_act varchar2(255 char),
        sct_nom varchar2(30 char),
        sct_obs varchar2(1000 char),
        primary key (sct_cod, sct_idf_cod)
    );

    create table trhu_sec (
       sec_emp_cod varchar2(4 char) not null,
        sec_cod varchar2(4 char) not null,
        sec_idf_cod varchar2(4 char) not null,
        sec_usucre varchar2(255 char),
        sec_datcre timestamp,
        sec_usumod varchar2(255 char),
        sec_datmod timestamp,
        sec_cte varchar2(10 char),
        sec_ctlhoe varchar2(255 char),
        sec_ctlffo varchar2(255 char),
        sec_depcmp varchar2(4 char),
        sec_discos varchar2(2 char),
        sec_dtehor number(19,2),
        sec_fct number(19,2),
        sec_nom varchar2(30 char),
        sec_obs varchar2(1000 char),
        sec_rolvis varchar2(15 char),
        sec_gse_cod varchar2(4 char),
        primary key (sec_emp_cod, sec_cod, sec_idf_cod)
    );

    create table trhu_sno (
       sno_cod varchar2(4 char) not null,
        sno_idf_cod varchar2(4 char) not null,
        sno_usucre varchar2(255 char),
        sno_datcre timestamp,
        sno_usumod varchar2(255 char),
        sno_datmod timestamp,
        sno_des varchar2(1000 char),
        primary key (sno_cod, sno_idf_cod)
    );

    create table trhu_tdi (
       tdi_cod varchar2(4 char) not null,
        tdi_idf_cod varchar2(4 char) not null,
        tdi_usucre varchar2(255 char),
        tdi_datcre timestamp,
        tdi_usumod varchar2(255 char),
        tdi_datmod timestamp,
        tdi_nom varchar2(30 char) not null,
        tdi_reg_cod varchar2(4 char),
        primary key (tdi_cod, tdi_idf_cod)
    );

    create table trhu_tor (
       tor_cod varchar2(6 char) not null,
        tor_idf_cod varchar2(4 char) not null,
        tor_usucre varchar2(255 char),
        tor_datcre timestamp,
        tor_usumod varchar2(255 char),
        tor_datmod timestamp,
        tor_nom varchar2(30 char) not null,
        tor_obs varchar2(1000 char) not null,
        tor_prvfes varchar2(255 char),
        primary key (tor_cod, tor_idf_cod)
    );

    create table trhu_tra (
       tra_cod varchar2(255 char) not null,
        tra_idf_cod varchar2(4 char) not null,
        tra_usucre varchar2(255 char),
        tra_datcre timestamp,
        tra_usumod varchar2(255 char),
        tra_datmod timestamp,
        tra_dathor timestamp,
        tra_obs varchar2(1000 char),
        tra_emp_cod varchar2(4 char),
        tra_nod_num varchar2(4 char),
        tra_ope_cod varchar2(6 char),
        tra_ttr_cod varchar2(4 char),
        primary key (tra_cod, tra_idf_cod)
    );

    create table trhu_ttr (
       ttr_cod varchar2(255 char) not null,
        ttr_idf_cod varchar2(4 char) not null,
        ttr_usucre varchar2(255 char),
        ttr_datcre timestamp,
        ttr_usumod varchar2(255 char),
        ttr_datmod timestamp,
        ttr_des varchar2(1000 char),
        primary key (ttr_cod, ttr_idf_cod)
    );

    create table trhu_vad (
       vad_cod varchar2(6 char) not null,
        vad_idf_cod varchar2(4 char) not null,
        vad_usucre varchar2(255 char),
        vad_datcre timestamp,
        vad_usumod varchar2(255 char),
        vad_datmod timestamp,
        vad_des varchar2(30 char) not null,
        vad_tip number(10,0) not null,
        primary key (vad_cod, vad_idf_cod)
    );

    create table trhu_zon (
       zon_cod varchar2(4 char) not null,
        zon_idf_cod varchar2(4 char) not null,
        zon_usucre varchar2(255 char),
        zon_datcre timestamp,
        zon_usumod varchar2(255 char),
        zon_datmod timestamp,
        zon_nom varchar2(30 char),
        zon_obs varchar2(1000 char),
        zon_zontre varchar2(255 char) not null,
        primary key (zon_cod, zon_idf_cod)
    );

    create table usuari (
       id number(19,0) not null,
        created_by varchar2(64 char) not null,
        created_date timestamp not null,
        lastmod_by varchar2(64 char),
        lastmod_date timestamp,
        version number(19,0) not null,
        actiu number(1,0) not null,
        codi varchar2(64 char) not null,
        contrasenya varchar2(255 char),
        email varchar2(100 char) not null,
        imatge_url varchar2(255 char),
        llinatges varchar2(100 char) not null,
        nom varchar2(100 char) not null,
        origen number(10,0),
        validat number(1,0) not null,
        primary key (id)
    );

    create table usuari_authority (
       usuari_id number(19,0) not null,
        rol varchar2(10 char)
    );

    alter table apikey 
       add constraint UK_5yilep0rivoj9b2ducr0df4kd unique (prefix);
create index order_number_fk on paycomet_notification (order_number);

    alter table synchronization 
       add constraint synchronization_uk unique (class_name, params);
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
create index icom_mag_idf_fk on tcom_mag (mag_idf_cod);
create index icom_mar_idf_fk on tcom_mar (mar_idf_cod);
create index icom_mca_idf_fk on tcom_mca (mca_idf_cod);
create index icom_mdc_idf_fk on tcom_mdc (mdc_idf_cod);
create index icom_mdc_emp_fk on tcom_mdc (mdc_emp_cod);
create index icom_mdc_cxa_fk on tcom_mdc (mdc_cxa_cod);
create index icom_men_idf_fk on tcom_men (men_idf_cod);
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
create index iges_ban_idf_fk on tges_ban (ban_idf_cod);
create index iges_cpo_idf_fk on tges_cpo (cpo_idf_cod);
create index iges_ofb_idf_fk on tges_ofb (ofb_idf_cod);

    alter table tges_ofb 
       add constraint irges_ofb_pk unique (ofb_idf_cod, ofb_cod);
create index iges_pas_idf_fk on tges_pas (pas_idf_cod);
create index iges_prv_idf_fk on tges_prv (prv_idf_cod);

    alter table tges_prv 
       add constraint irges_prv_pk unique (prv_idf_cod, prv_cod);
create index iges_tcs_idf_fk on tges_tcs (tcs_idf_cod);
create index irhu_cat_idf_fk on trhu_cat (cat_idf_cod);
create index irhu_cen_idf_fk on trhu_cen (cen_idf_cod);
create index irhu_cln_idf_fk on trhu_cln (cln_idf_cod);

    alter table trhu_cln 
       add constraint irrhu_cln_pk unique (cln_idf_cod);
create index irhu_emp_idf_fk on trhu_emp (emp_idf_cod);
create index irhu_gfe_idf_fk on trhu_gfe (gfe_idf_cod);
create index irhu_gre_idf_fk on trhu_gre (gre_idf_cod);
create index irhu_gse_idf_fk on trhu_gse (gse_idf_cod);

    alter table trhu_gse 
       add constraint irrhu_gse_pk unique (gse_idf_cod, gse_cod);
create index irhu_hor_idf_fk on trhu_hor (hor_idf_cod);
create index irhu_inr_idf_fk on trhu_inr (inr_idf_cod);
create index irhu_nod_idf_fk on trhu_nod (nod_idf_cod);
create index irhu_ope_idf_fk on trhu_ope (ope_idf_cod);
create index irhu_par_idf_fk on trhu_par (par_idf_cod);
create index irhu_rdi_idf_fk on trhu_rdi (rdi_idf_cod);

    alter table trhu_rdi 
       add constraint irrhu_rdi_pk unique (rdi_idf_cod);
create index irhu_reg_idf_fk on trhu_reg (reg_idf_cod);
create index irhu_sct_idf_fk on trhu_sct (sct_idf_cod);
create index irhu_sec_idf_fk on trhu_sec (sec_idf_cod);

    alter table trhu_sec 
       add constraint UK_2gjy6kdwg20dg4joks83qdkxv unique (sec_emp_cod, sec_gse_cod, sec_idf_cod);

    alter table trhu_sec 
       add constraint irrhu_sec_pk unique (sec_idf_cod, sec_cod);
create index irhu_sno_idf_fk on trhu_sno (sno_idf_cod);
create index irhu_tdi_idf_fk on trhu_tdi (tdi_idf_cod);
create index irhu_tor_idf_fk on trhu_tor (tor_idf_cod);
create index irhu_tra_idf_fk on trhu_tra (tra_idf_cod);
create index irhu_ttr_idf_fk on trhu_ttr (ttr_idf_cod);
create index irhu_vad_idf_fk on trhu_vad (vad_idf_cod);
create index irhu_zon_idf_fk on trhu_zon (zon_idf_cod);

    alter table usuari 
       add constraint usuari_codi_uk unique (codi);

    alter table usuari 
       add constraint usuari_email_uk unique (email);

    alter table apikey_scope 
       add constraint apkscope_apikey_fk 
       foreign key (apikey_id) 
       references apikey;

    alter table tcom_ain 
       add constraint rcom_ain_art_fk 
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

    alter table tcom_alb 
       add constraint rcom_alb_tra_fk 
       foreign key (alb_tra_cod, alb_idf_cod) 
       references tcom_tra;

    alter table tcom_alb 
       add constraint rcom_alb_mtr_fk 
       foreign key (alb_tra_cod, alb_mtr_cod, alb_idf_cod) 
       references tcom_mtr;

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
       add constraint rcom_emp_div_fk 
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
       add constraint rcom_pre_mag_fk 
       foreign key (pre_mag_cod, pre_idf_cod) 
       references tcom_mag;

    alter table tcom_pre 
       add constraint rcom_pre_ope_fk 
       foreign key (pre_ope_cod, pre_idf_cod) 
       references trhu_ope;

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

    alter table tges_ban 
       add constraint rges_ban_idf_fk 
       foreign key (ban_idf_cod) 
       references trhu_idf;

    alter table tges_cpo 
       add constraint rges_cpo_idf_fk 
       foreign key (cpo_idf_cod) 
       references trhu_idf;

    alter table tges_cpo 
       add constraint rges_cpo_pas_fk 
       foreign key (cpo_pas_cod, cpo_idf_cod) 
       references tges_pas;

    alter table tges_cpo 
       add constraint rges_cpo_prv_fk 
       foreign key (cpo_pas_cod, cpo_prv_cod, cpo_idf_cod) 
       references tges_prv;

    alter table tges_ofb 
       add constraint rges_ofb_idf_fk 
       foreign key (ofb_idf_cod) 
       references trhu_idf;

    alter table tges_ofb 
       add constraint ofb_ban_cod_fk 
       foreign key (ofb_ban_cod, ofb_idf_cod) 
       references tges_ban;

    alter table tges_ofb 
       add constraint ofb_cpo_cod_fk 
       foreign key (ofb_cpo_cod, ofb_idf_cod) 
       references tges_cpo;

    alter table tges_pas 
       add constraint rges_pas_idf_fk 
       foreign key (pas_idf_cod) 
       references trhu_idf;

    alter table tges_prv 
       add constraint rges_prv_idf_fk 
       foreign key (prv_idf_cod) 
       references trhu_idf;

    alter table tges_prv 
       add constraint rges_prv_pas_fk 
       foreign key (prv_pas_cod, prv_idf_cod) 
       references tges_pas;

    alter table tges_tcs 
       add constraint rges_tcs_idf_fk 
       foreign key (tcs_idf_cod) 
       references trhu_idf;

    alter table trhu_cat 
       add constraint rrhu_cat_idf_fk 
       foreign key (cat_idf_cod) 
       references trhu_idf;

    alter table trhu_cen 
       add constraint rrhu_cen_idf_fk 
       foreign key (cen_idf_cod) 
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

    alter table trhu_gfe 
       add constraint rrhu_gfe_idf_fk 
       foreign key (gfe_idf_cod) 
       references trhu_idf;

    alter table trhu_gre 
       add constraint rrhu_gre_idf_fk 
       foreign key (gre_idf_cod) 
       references trhu_idf;

    alter table trhu_gse 
       add constraint rrhu_gse_idf_fk 
       foreign key (gse_idf_cod) 
       references trhu_idf;

    alter table trhu_gse 
       add constraint rrhu_gse_emp_fk 
       foreign key (gse_emp_cod, gse_idf_cod) 
       references trhu_emp;

    alter table trhu_hor 
       add constraint rrhu_hor_idf_fk 
       foreign key (hor_idf_cod) 
       references trhu_idf;

    alter table trhu_inr 
       add constraint rrhu_inr_idf_fk 
       foreign key (inr_idf_cod) 
       references trhu_idf;

    alter table trhu_inr 
       add constraint rrhu_inr_cln_fk 
       foreign key (inr_cln_dat, inr_idf_cod) 
       references trhu_cln;

    alter table trhu_inr 
       add constraint rrhu_inr_ope_fk 
       foreign key (inr_ope_cod, inr_idf_cod) 
       references trhu_ope;

    alter table trhu_inr 
       add constraint rrhu_inr_zon_fk 
       foreign key (inr_zon_cod, inr_idf_cod) 
       references trhu_zon;

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
       add constraint rrhu_ope_idf_fk 
       foreign key (ope_idf_cod) 
       references trhu_idf;

    alter table trhu_ope 
       add constraint rrhu_ope_ban_fk 
       foreign key (ope_ban_codccr, ope_idf_cod) 
       references tges_ban;

    alter table trhu_ope 
       add constraint rrhu_ope_cen_fk 
       foreign key (ope_cen_cod, ope_idf_cod) 
       references trhu_cen;

    alter table trhu_ope 
       add constraint rrhu_ope_emp_fk 
       foreign key (ope_emp_codccr, ope_idf_cod) 
       references trhu_emp;

    alter table trhu_ope 
       add constraint rrhu_ope_gfe_fk 
       foreign key (ope_gfe_cod, ope_idf_cod) 
       references trhu_gfe;

    alter table trhu_ope 
       add constraint rrhu_ope_hor_fk 
       foreign key (ope_hor_cod, ope_idf_cod) 
       references trhu_hor;

    alter table trhu_ope 
       add constraint rrhu_ope_hor2_fk 
       foreign key (ope_hor_cod002, ope_idf_cod) 
       references trhu_hor;

    alter table trhu_ope 
       add constraint rrhu_ope_hor3_fk 
       foreign key (ope_hor_cod003, ope_idf_cod) 
       references trhu_hor;

    alter table trhu_ope 
       add constraint rrhu_ope_horn_fk 
       foreign key (ope_hor_codnit, ope_idf_cod) 
       references trhu_hor;

    alter table trhu_ope 
       add constraint rrhu_ope_var_fk 
       foreign key (ope_vad_cod, ope_idf_cod) 
       references trhu_vad;

    alter table trhu_ope 
       add constraint rrhu_ope_ope_fk 
       foreign key (ope_ope_cod, ope_idf_cod) 
       references trhu_ope;

    alter table trhu_ope 
       add constraint rrhu_ope_gre_fk 
       foreign key (ope_gre_cod, ope_idf_cod) 
       references trhu_gre;

    alter table trhu_ope 
       add constraint rrhu_ope_tcs_fk 
       foreign key (ope_tcs_cod, ope_idf_cod) 
       references tges_tcs;

    alter table trhu_ope 
       add constraint rrhu_ope_tor_fk 
       foreign key (ope_tor_cod, ope_idf_cod) 
       references trhu_tor;

    alter table trhu_ope 
       add constraint rrhu_ope_zon_fk 
       foreign key (ope_zon_cod, ope_idf_cod) 
       references trhu_zon;

    alter table trhu_par 
       add constraint rrhu_par_idf_fk 
       foreign key (par_idf_cod) 
       references trhu_idf;

    alter table trhu_rdi 
       add constraint rrhu_rdi_idf_fk 
       foreign key (rdi_idf_cod) 
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
       add constraint rrhu_rdi_ope_fk 
       foreign key (rdi_ope_cod, rdi_idf_cod) 
       references trhu_ope;

    alter table trhu_rdi 
       add constraint rrhu_rdi_reg_fk 
       foreign key (rdi_reg_cod, rdi_idf_cod) 
       references trhu_reg;

    alter table trhu_rdi 
       add constraint rrhu_rdi_sec_fk 
       foreign key (rdi_emp_cod, rdi_sec_cod, rdi_idf_cod) 
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
       add constraint rrhu_sct_idf_fk 
       foreign key (sct_idf_cod) 
       references trhu_idf;

    alter table trhu_sct 
       add constraint rrhu_sct_cat_fk 
       foreign key (sct_cat_cod, sct_idf_cod) 
       references trhu_cat;

    alter table trhu_sec 
       add constraint rrhu_sec_idf_fk 
       foreign key (sec_idf_cod) 
       references trhu_idf;

    alter table trhu_sec 
       add constraint rrhu_sec_emp_fk 
       foreign key (sec_emp_cod, sec_idf_cod) 
       references trhu_emp;

    alter table trhu_sec 
       add constraint rrhu_sec_gse_fk 
       foreign key (sec_emp_cod, sec_gse_cod, sec_idf_cod) 
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

    alter table trhu_tor 
       add constraint rrhu_tor_idf_fk 
       foreign key (tor_idf_cod) 
       references trhu_idf;

    alter table trhu_tra 
       add constraint rrhu_tra_idf_fk 
       foreign key (tra_idf_cod) 
       references trhu_idf;

    alter table trhu_tra 
       add constraint rrhu_tra_emp_fk 
       foreign key (tra_emp_cod, tra_idf_cod) 
       references trhu_emp;

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

    alter table trhu_vad 
       add constraint rrhu_vad_idf_fk 
       foreign key (vad_idf_cod) 
       references trhu_idf;

    alter table trhu_zon 
       add constraint rrhu_zon_idf_fk 
       foreign key (zon_idf_cod) 
       references trhu_idf;

    alter table usuari_authority 
       add constraint usuaut_usuari_fk 
       foreign key (usuari_id) 
       references usuari;
