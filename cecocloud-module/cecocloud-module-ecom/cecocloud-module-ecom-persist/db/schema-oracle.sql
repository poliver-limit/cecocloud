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
        alb_cli_sgl varchar2(4 char),
        primary key (alb_emp_cod, alb_numdoc, alb_idf_cod)
    );

    create table tcom_arm (
       arm_art_cod varchar2(4 char) not null,
        arm_mag_cod varchar2(4 char) not null,
        arm_idf_cod varchar2(4 char) not null,
        arm_usucre varchar2(255 char),
        arm_datcre timestamp,
        arm_usumod varchar2(255 char),
        arm_datmod timestamp,
        arm_stk number(10,0),
        primary key (arm_art_cod, arm_mag_cod, arm_idf_cod)
    );

    create table tcom_art (
       art_cod varchar2(15 char) not null,
        art_idf_cod varchar2(4 char) not null,
        art_usucre varchar2(255 char),
        art_datcre timestamp,
        art_usumod varchar2(255 char),
        art_datmod timestamp,
        art_ain_num number(10,0),
        art_decpru number(10,0) not null,
        art_decpruiva number(10,0),
        art_des varchar2(2000 char) not null,
        art_descur varchar2(60 char),
        art_pruiva number(17,5) not null,
        art_pvp number(17,5) not null,
        art_rutinf varchar2(1000 char) not null,
        art_far_cod varchar2(6 char) not null,
        art_gma_cod varchar2(6 char),
        art_iva_cod varchar2(4 char) not null,
        art_mca_cod varchar2(6 char),
        art_mod_cod varchar2(6 char) not null,
        primary key (art_cod, art_idf_cod)
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
        iva_cmpnrp number(19,2) not null,
        iva_imr number(19,2) not null,
        cpo_irp number(19,2) not null,
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
       dar_art_cod varchar2(4 char) not null,
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
        emp_nomcom varchar2(40 char) not null,
        primary key (emp_cod, emp_idf_cod)
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
        idi_codiso varchar2(2 char) not null,
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
        lpr_pru number(10,0) not null,
        lpr_imp number(10,0) not null,
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
        mag_nom varchar2(30 char) not null,
        primary key (mag_cod, mag_idf_cod)
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

    create table tcom_mod (
       mod_cod varchar2(6 char) not null,
        mod_idf_cod varchar2(4 char) not null,
        mod_usucre varchar2(255 char),
        mod_datcre timestamp,
        mod_usumod varchar2(255 char),
        mod_datmod timestamp,
        mod_nounitra varchar2(1 char),
        mod_des varchar2(30 char) not null,
        primary key (mod_cod, mod_idf_cod)
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
        pre_cli_tel varchar2(60 char),
        pre_cli_tipnif number(10,0),
        pre_ver number(10,0) not null,
        pre_idi_cod varchar2(4 char),
        pre_iva_cod varchar2(4 char),
        pre_mag_cod varchar2(4 char),
        pre_pas_cod varchar2(4 char),
        pre_cli_painif varchar2(4 char),
        pre_prv_cod varchar2(4 char),
        pre_ser_cod varchar2(4 char),
        pre_cli_sgl varchar2(4 char),
        primary key (pre_emp_cod, pre_cod, pre_idf_cod)
    );

    create table tcom_prv (
       prv_pas_cod varchar2(4 char) not null,
        prv_cod varchar2(3 char) not null,
        prv_idf_cod varchar2(4 char) not null,
        prv_usucre varchar2(255 char),
        prv_datcre timestamp,
        prv_usumod varchar2(255 char),
        prv_datmod timestamp,
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

    create table tcom_tad (
       tad_cod varchar2(2 char) not null,
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

create index icom_ain_art_fk on tcom_ain (ain_idf_cod, ain_art_cod, ain_num);
create index icom_alb_idf_fk on tcom_alb (alb_idf_cod);
create index icom_arm_idf_fk on tcom_arm (arm_idf_cod);

    alter table tcom_arm 
       add constraint ircom_arm_pk unique (arm_idf_cod);
create index icom_art_idf_fk on tcom_art (art_idf_cod);
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
create index icom_fae_idf_fk on tcom_fae (fae_idf_cod);
create index icom_far_idf_fk on tcom_far (far_idf_cod);
create index icom_fmc_idf_fk on tcom_fmc (fmc_idf_cod);
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
create index icom_mca_idf_fk on tcom_mca (mca_idf_cod);
create index icom_mod_idf_fk on tcom_mod (mod_idf_cod);
create index icom_npg_idf_fk on tcom_npg (npg_idf_cod);
create index icom_pas_idf_fk on tcom_pas (pas_idf_cod);
create index icom_ped_idf_fk on tcom_ped (ped_idf_cod);

    alter table tcom_ped 
       add constraint ircom_ped_pk unique (ped_idf_cod, ped_cod);
create index icom_pmg_idf_fk on tcom_pmg (pmg_idf_cod);

    alter table tcom_pmg 
       add constraint ircom_pmg_pk unique (pmg_idf_cod, pmg_cod);
create index icom_pre_emp_fk on tcom_pre (pre_idf_cod, pre_emp_cod);
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
create index icom_tfc_idf_fk on tcom_tfc (tfc_idf_cod);
create index icom_tri_idf_fk on tcom_tri (tri_idf_cod);
create index icom_tve_idf_fk on tcom_tve (tve_idf_cod);

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

    alter table tcom_arm 
       add constraint rcom_arm_art_fk 
       foreign key (arm_art_cod, arm_idf_cod) 
       references tcom_art;

    alter table tcom_arm 
       add constraint rcom_arm_mag_fk 
       foreign key (arm_mag_cod, arm_idf_cod) 
       references tcom_mag;

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
       add constraint rcom_pre_ser_fk 
       foreign key (pre_emp_cod, pre_ser_cod, pre_idf_cod) 
       references tcom_ser;

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