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
        alb_cli_sgl varchar(4),
        primary key (alb_emp_cod, alb_numdoc, alb_idf_cod)
    );

    create table tcom_arm (
       arm_art_cod varchar(4) not null,
        arm_mag_cod varchar(4) not null,
        arm_idf_cod varchar(4) not null,
        arm_usucre varchar(255),
        arm_datcre timestamp,
        arm_usumod varchar(255),
        arm_datmod timestamp,
        arm_stk int4,
        primary key (arm_art_cod, arm_mag_cod, arm_idf_cod)
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
        art_pvp numeric(17, 5) not null,
        art_rutinf varchar(1000) not null,
        art_far_cod varchar(6) not null,
        art_gma_cod varchar(6),
        art_iva_cod varchar(4) not null,
        art_mca_cod varchar(6),
        art_mod_cod varchar(6) not null,
        primary key (art_cod, art_idf_cod)
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
        cli_sgl varchar(4),
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
        iva_cmpnrp numeric(19, 2) not null,
        iva_imr numeric(19, 2) not null,
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
       dar_art_cod varchar(4) not null,
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

    create table tcom_fae (
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
        lpr_pru int4 not null,
        lpr_imp int4 not null,
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
        mag_nom varchar(30) not null,
        primary key (mag_cod, mag_idf_cod)
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

    create table tcom_mod (
       mod_cod varchar(6) not null,
        mod_idf_cod varchar(4) not null,
        mod_usucre varchar(255),
        mod_datcre timestamp,
        mod_usumod varchar(255),
        mod_datmod timestamp,
        mod_nounitra varchar(1),
        mod_des varchar(30) not null,
        primary key (mod_cod, mod_idf_cod)
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
        pre_ser_cod varchar(4),
        pre_cli_sgl varchar(4),
        primary key (pre_emp_cod, pre_cod, pre_idf_cod)
    );

    create table tcom_prv (
       prv_pas_cod varchar(4) not null,
        prv_cod varchar(3) not null,
        prv_idf_cod varchar(4) not null,
        prv_usucre varchar(255),
        prv_datcre timestamp,
        prv_usumod varchar(255),
        prv_datmod timestamp,
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

 	create table tcom_tad (
       tad_cod varchar(2) not null,
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

    alter table tcom_fae 
       add constraint ircom_fae_pk unique (fae_idf_cod);
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
       add constraint rcom_alb_idf_fk 
       foreign key (alb_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_arm_idf_fk 
       foreign key (arm_idf_cod) 
       references tcom_idf;

    alter table tcom_arm 
       add constraint rcom_arm_art_fk 
       foreign key (arm_art_cod, arm_idf_cod) 
       references tcom_art;

    alter table tcom_arm 
       add constraint rcom_arm_mag_fk 
       foreign key (arm_mag_cod, arm_idf_cod) 
       references tcom_mag;

    alter table tcom_art 
       add constraint rcom_art_idf_fk 
       foreign key (art_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_cli_idf_fk 
       foreign key (cli_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_cpo_idf_fk 
       foreign key (cpo_idf_cod) 
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
       add constraint rcom_cxa_idf_fk 
       foreign key (cxa_idf_cod) 
       references tcom_idf;

    alter table tcom_cxa 
       add constraint rcom_cxa_emp_fk 
       foreign key (cxa_emp_cod, cxa_idf_cod) 
       references tcom_emp;

    alter table tcom_dar 
       add constraint rcom_dar_idf_fk 
       foreign key (dar_idf_cod) 
       references tcom_idf;

    alter table tcom_dar 
       add constraint rcom_dar_art_fk 
       foreign key (dar_art_cod, dar_idf_cod) 
       references tcom_art;

    alter table tcom_dar 
       add constraint rcom_dar_idi_fk 
       foreign key (dar_idi_cod, dar_idf_cod) 
       references tcom_idi;

    alter table tcom_dep 
       add constraint rcom_dep_idf_fk 
       foreign key (dep_idf_cod) 
       references tcom_idf;

    alter table tcom_dep 
       add constraint rcom_dep_emp_fk 
       foreign key (dep_emp_cod, dep_idf_cod) 
       references tcom_emp;

    alter table tcom_div 
       add constraint rcom_div_idf_fk 
       foreign key (div_idf_cod) 
       references tcom_idf;

    alter table tcom_dpg 
       add constraint rcom_dpg_idf_fk 
       foreign key (dpg_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_emp_idf_fk 
       foreign key (emp_idf_cod) 
       references tcom_idf;

    alter table tcom_fae 
       add constraint rcom_fae_idf_fk 
       foreign key (fae_idf_cod) 
       references tcom_idf;

    alter table tcom_fae 
       add constraint rcom_fae_far_fk 
       foreign key (fae_far_cod, fae_idf_cod) 
       references tcom_far;

    alter table tcom_fae 
       add constraint rcom_fae_emp_fk 
       foreign key (fae_emp_cod, fae_idf_cod) 
       references tcom_emp;

    alter table tcom_far 
       add constraint rcom_far_idf_fk 
       foreign key (far_idf_cod) 
       references tcom_idf;

    alter table tcom_fmc 
       add constraint rcom_fmc_idf_fk 
       foreign key (fmc_idf_cod) 
       references tcom_idf;

    alter table tcom_fmc 
       add constraint fmc_tri_cod_fk 
       foreign key (fmc_tri_cod, fmc_idf_cod) 
       references tcom_tri;

    alter table tcom_gma 
       add constraint rcom_gma_idf_fk 
       foreign key (gma_idf_cod) 
       references tcom_idf;

    alter table tcom_idi 
       add constraint rcom_idi_idf_fk 
       foreign key (idi_idf_cod) 
       references tcom_idf;

    alter table tcom_iva 
       add constraint rcom_iva_idf_fk 
       foreign key (iva_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_mag_idf_fk 
       foreign key (mag_idf_cod) 
       references tcom_idf;

    alter table tcom_mca 
       add constraint rcom_mca_idf_fk 
       foreign key (mca_idf_cod) 
       references tcom_idf;

    alter table tcom_mod 
       add constraint rcom_mod_idf_fk 
       foreign key (mod_idf_cod) 
       references tcom_idf;

    alter table tcom_npg 
       add constraint rcom_npg_idf_fk 
       foreign key (npg_idf_cod) 
       references tcom_idf;

    alter table tcom_pas 
       add constraint rcom_pas_idf_fk 
       foreign key (pas_idf_cod) 
       references tcom_idf;

    alter table tcom_ped 
       add constraint rcom_ped_idf_fk 
       foreign key (ped_idf_cod) 
       references tcom_idf;

    alter table tcom_ped 
       add constraint rcom_ped_emp_fk 
       foreign key (ped_emp_cod, ped_idf_cod) 
       references tcom_emp;

    alter table tcom_ped 
       add constraint rcom_ped_scp_fk 
       foreign key (ped_emp_cod, ped_scp_codcom, ped_idf_cod) 
       references tcom_scp;

    alter table tcom_pmg 
       add constraint rcom_pmg_idf_fk 
       foreign key (pmg_idf_cod) 
       references tcom_idf;

    alter table tcom_pmg 
       add constraint rcom_pmg_mag_fk 
       foreign key (pmg_mag_cod, pmg_idf_cod) 
       references tcom_mag;

    alter table tcom_pre 
       add constraint rcom_pre_idf_fk 
       foreign key (pre_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_prv_idf_fk 
       foreign key (prv_idf_cod) 
       references tcom_idf;

    alter table tcom_prv 
       add constraint rcom_prv_pas_fk 
       foreign key (prv_pas_cod, prv_idf_cod) 
       references tcom_pas;

    alter table tcom_ptv 
       add constraint rcom_ptv_idf_fk 
       foreign key (ptv_idf_cod) 
       references tcom_idf;

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

    alter table tcom_rgi 
       add constraint rcom_rgi_idf_fk 
       foreign key (rgi_idf_cod) 
       references tcom_idf;

    alter table tcom_scp 
       add constraint rcom_scp_idf_fk 
       foreign key (scp_idf_cod) 
       references tcom_idf;

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
       add constraint rcom_ser_idf_fk 
       foreign key (ser_idf_cod) 
       references tcom_idf;

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

    alter table tcom_tfc 
       add constraint rcom_tfc_idf_fk 
       foreign key (tfc_idf_cod) 
       references tcom_idf;

    alter table tcom_tri 
       add constraint rcom_tri_idf_fk 
       foreign key (tri_idf_cod) 
       references tcom_idf;

    alter table tcom_tve 
       add constraint rcom_tve_idf_fk 
       foreign key (tve_idf_cod) 
       references tcom_idf;