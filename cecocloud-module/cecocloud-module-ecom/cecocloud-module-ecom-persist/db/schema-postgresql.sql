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
        cli_painif varchar(4),
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
       gma_cod varchar(4) not null,
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
       mca_cod varchar(4) not null,
        mca_idf_cod varchar(4) not null,
        mca_usucre varchar(255),
        mca_datcre timestamp,
        mca_usumod varchar(255),
        mca_datmod timestamp,
        mca_des varchar(30) not null,
        primary key (mca_cod, mca_idf_cod)
    );

    create table tcom_mod (
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

    create table tcom_pni (
       pni_cod varchar(255) not null,
        pni_nom varchar(40),
        pni_tamnif varchar(15),
        pni_tipnif varchar(1) not null,
        primary key (pni_cod)
    );

    create table tcom_prv (
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

    create table tcom_rgi (
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

    create table tcom_tad (
       tad_cod varchar(255) not null,
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
create index icom_arm_idf_fk on tcom_arm (arm_idf_cod);

    alter table tcom_arm 
       add constraint ircom_arm_pk unique (arm_idf_cod);
create index icom_art_idf_fk on tcom_art (art_idf_cod);
create index icom_cli_idf_fk on tcom_cli (cli_idf_cod);
create index icom_cnt_idf_fk on tcom_cnt (cnt_idf_cod);
create index icom_cpo_idf_fk on tcom_cpo (cpo_idf_cod);
create index icom_dar_idf_fk on tcom_dar (dar_idf_cod);
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
create index icom_mag_idf_fk on tcom_mag (mag_idf_cod);
create index icom_mca_idf_fk on tcom_mca (mca_idf_cod);
create index icom_mod_idf_fk on tcom_mod (mod_idf_cod);
create index icom_npg_idf_fk on tcom_npg (npg_idf_cod);
create index icom_pas_idf_fk on tcom_pas (pas_idf_cod);
create index icom_prv_idf_fk on tcom_prv (prv_idf_cod);

    alter table tcom_prv 
       add constraint ircom_prv_pk unique (prv_idf_cod, prv_cod);
create index icom_rgi_idf_fk on tcom_rgi (rgi_idf_cod);
create index icom_tfc_idf_fk on tcom_tfc (tfc_idf_cod);
create index icom_tri_idf_fk on tcom_tri (tri_idf_cod);
create index icom_tve_idf_fk on tcom_tve (tve_idf_cod);

    alter table tcom_ain 
       add constraint rges_ain_art_fk 
       foreign key (ain_art_cod, ain_idf_cod) 
       references tcom_art;

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

    alter table tcom_prv 
       add constraint rcom_prv_idf_fk 
       foreign key (prv_idf_cod) 
       references tcom_idf;

    alter table tcom_prv 
       add constraint rcom_prv_pas_fk 
       foreign key (prv_pas_cod, prv_idf_cod) 
       references tcom_pas;

    alter table tcom_rgi 
       add constraint rcom_rgi_idf_fk 
       foreign key (rgi_idf_cod) 
       references tcom_idf;

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