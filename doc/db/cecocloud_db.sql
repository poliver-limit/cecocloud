create sequence hibernate_sequence start 1 increment 1;

create table agrupacio (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(8) not null,
    descripcio varchar(100) not null,
    modul varchar(4) not null,
    pare_id int8,
    primary key (id)
);

create table agrupacio_ident (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    agrupacio_id int8 not null,
    identificador_id int8 not null,
    primary key (id)
);

create table empresa (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    activa boolean not null,
    codi varchar(4) not null,
    nif varchar(12) not null,
    nom varchar(30) not null,
    tipus int4 not null,
    empresa_comptable_id int8,
    identificador_id int8 not null,
    primary key (id)
);

create table funcionalitat (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(8) not null,
    descripcio varchar(100) not null,
    modul varchar(4) not null,
    tipus int4 not null,
    pare_id int8,
    recurs_principal_id int8 not null,
    primary key (id)
);

create table funcionalitat_ident (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    funcionalitat_id int8 not null,
    identificador_id int8 not null,
    primary key (id)
);

create table funcionalitat_perfil (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    permis varchar(20) not null,
    funcionalitat_id int8 not null,
    perfil_id int8 not null,
    primary key (id)
);

create table funcionalitat_recurs (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    principal boolean not null,
    resource_classname varchar(100) not null,
    funcionalitat_id int8 not null,
    primary key (id)
);

create table identificador (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(255),
    data_fi timestamp not null,
    data_inici timestamp not null,
    descripcio varchar(40) not null,
    llicencia varchar(2000) not null,
    llicencia_ok boolean not null,
    num_empreses int4 not null,
    num_operaris int4 not null,
    num_usuaris int4 not null,
    propietari_id int8 not null,
    primary key (id)
);

create table operari (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean not null,
    codi varchar(6) not null,
    identificador_id int8 not null,
    usuari_id int8 not null,
    primary key (id)
);

create table operari_empresa (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean not null,
    empresa_id int8 not null,
    operari_id int8 not null,
    primary key (id)
);

create table perfil (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(10) not null,
    descripcio varchar(100) not null,
    identificador_id int8 not null,
    primary key (id)
);

create table perfil_usuidentemp (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    perfil_id int8 not null,
    usuidentemp_id int8 not null,
    primary key (id)
);

create table usuari (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean not null,
    codi varchar(64) not null,
    contrasenya varchar(255),
    email varchar(100) not null,
    imatge_url varchar(255),
    llinatges varchar(100) not null,
    nom varchar(100) not null,
    validat boolean not null,
    primary key (id)
);

create table usuari_authority (
   usuari_id int8 not null,
    rol varchar(10)
);

create table usuari_ident (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    actiu boolean not null,
    identificador_id int8 not null,
    usuari_id int8 not null,
    primary key (id)
);

create table usuari_ident_empresa (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    empresa_id int8 not null,
    usuident_id int8 not null,
    primary key (id)
);

alter table agrupacio 
   add constraint agrupacio_uk unique (codi, modul);

alter table agrupacio_ident 
   add constraint agrupident_uk unique (agrupacio_id, identificador_id);

alter table empresa 
   add constraint empresa_uk unique (identificador_id, codi);

alter table funcionalitat 
   add constraint funcionalitat_uk unique (codi, modul);

alter table funcionalitat 
   add constraint funcionalitat_recprincipal_uk unique (recurs_principal_id);

alter table funcionalitat_ident 
   add constraint funcident_uk unique (funcionalitat_id, identificador_id);

alter table funcionalitat_perfil 
   add constraint funcperf_uk unique (funcionalitat_id, perfil_id, permis);

alter table funcionalitat_recurs 
   add constraint funcrecu_uk unique (funcionalitat_id, resource_classname);

alter table operari 
   add constraint operari_codi_uk unique (codi, identificador_id);

alter table operari_empresa 
   add constraint operariemp_uk unique (operari_id, empresa_id);

alter table perfil 
   add constraint perfil_uk unique (identificador_id, codi);

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_uk unique (perfil_id, usuidentemp_id);

alter table usuari 
   add constraint usuari_codi_uk unique (codi);

alter table usuari 
   add constraint usuari_email_uk unique (email);

alter table usuari_ident 
   add constraint usuident_uk unique (usuari_id, identificador_id);

alter table usuari_ident_empresa 
   add constraint usuidentemp_uk unique (usuident_id, empresa_id);

alter table agrupacio 
   add constraint agrupacio_pare_fk 
   foreign key (pare_id) 
   references agrupacio;

alter table agrupacio_ident 
   add constraint agrupident_agrupacio_fk 
   foreign key (agrupacio_id) 
   references agrupacio;

alter table agrupacio_ident 
   add constraint agrupident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table empresa 
   add constraint empresa_comptable_fk 
   foreign key (empresa_comptable_id) 
   references empresa;

alter table empresa 
   add constraint empresa_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table funcionalitat 
   add constraint funcionalitat_pare_fk 
   foreign key (pare_id) 
   references funcionalitat;

alter table funcionalitat 
   add constraint funcrecu_principal_fk 
   foreign key (recurs_principal_id) 
   references funcionalitat_recurs;

alter table funcionalitat_ident 
   add constraint funcident_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table funcionalitat_ident 
   add constraint funcident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table funcionalitat_perfil 
   add constraint funcperf_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table funcionalitat_perfil 
   add constraint funcperf_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table funcionalitat_recurs 
   add constraint funcrecu_funcionalitat_fk 
   foreign key (funcionalitat_id) 
   references funcionalitat;

alter table identificador 
   add constraint identificador_propietari_fk 
   foreign key (propietari_id) 
   references usuari;

alter table operari 
   add constraint operari_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table operari 
   add constraint operari_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table operari_empresa 
   add constraint operariemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table operari_empresa 
   add constraint operariemp_operari_fk 
   foreign key (operari_id) 
   references operari;

alter table perfil 
   add constraint perfil_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_perfil_fk 
   foreign key (perfil_id) 
   references perfil;

alter table perfil_usuidentemp 
   add constraint perfusuidentemp_usuidentemp_fk 
   foreign key (usuidentemp_id) 
   references usuari_ident_empresa;

alter table usuari_authority 
   add constraint usuaut_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_ident 
   add constraint usuident_identificador_fk 
   foreign key (identificador_id) 
   references identificador;

alter table usuari_ident 
   add constraint usuident_usuari_fk 
   foreign key (usuari_id) 
   references usuari;

alter table usuari_ident_empresa 
   add constraint usuidentemp_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table usuari_ident_empresa 
   add constraint usuidentemp_usuidf_fk 
   foreign key (usuident_id) 
   references usuari_ident;
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
       cln_dat timestamp not null,
        cln_idf_cod varchar(4) not null,
        cln_usucre varchar(255),
        cln_datcre timestamp,
        cln_usumod varchar(255),
        cln_datmod timestamp,
        cln_des varchar(1000),
        cln_obs varchar(1000),
        cln_tdi_cod varchar(4),
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

    create table trhu_gfe (
       gfe_cod varchar(4) not null,
        gfe_idf_cod varchar(4) not null,
        gfe_usucre varchar(255),
        gfe_datcre timestamp,
        gfe_usumod varchar(255),
        gfe_datmod timestamp,
        gfe_nom varchar(60) not null,
        gfe_cte varchar(1000),
        primary key (gfe_cod, gfe_idf_cod)
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
       gse_emp_cod varchar(4) not null,
        gse_cod varchar(4) not null,
        gse_idf_cod varchar(4) not null,
        gse_usucre varchar(255),
        gse_datcre timestamp,
        gse_usumod varchar(255),
        gse_datmod timestamp,
        gse_nom varchar(30),
        primary key (gse_emp_cod, gse_cod, gse_idf_cod)
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
        hor_tip int4 not null,
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

    create table trhu_inr (
       inr_cod varchar(4) not null,
        inr_idf_cod varchar(4) not null,
        inr_usucre varchar(255),
        inr_datcre timestamp,
        inr_usumod varchar(255),
        inr_datmod timestamp,
        inr_cln_dat timestamp,
        inr_cof_cod varchar(4),
        inr_dat timestamp,
        inr_fin timestamp,
        inr_ini timestamp,
        inr_ff0_cod int4,
        inr_nod_nument int4,
        inr_nod_numsor int4,
        inr_obs varchar(1000),
        inr_ope_cod varchar(4) not null,
        inr_zon_cod varchar(4),
        primary key (inr_cod, inr_idf_cod)
    );

    create table trhu_nod (
       nod_num varchar(255) not null,
        nod_idf_cod varchar(4) not null,
        nod_usucre varchar(255),
        nod_datcre timestamp,
        nod_usumod varchar(255),
        nod_datmod timestamp,
        nod_tip varchar(255),
        nod_tip1 varchar(10),
        nod_sno_cod varchar(4),
        nod_zon_coddti varchar(4),
        nod_zon_codori varchar(4),
        primary key (nod_num, nod_idf_cod)
    );

    create table trhu_ope (
       ope_cod varchar(4) not null,
        ope_idf_cod varchar(4) not null,
        ope_usucre varchar(255),
        ope_datcre timestamp,
        ope_usumod varchar(255),
        ope_datmod timestamp,
        ope_act boolean not null,
        ope_ado boolean not null,
        ope_apldia boolean not null,
        ope_cml boolean not null,
        ope_ctlhoe int4,
        ope_ctlffo int4,
        ope_enc boolean not null,
        ope_entsor boolean not null,
        ope_horesp boolean not null,
        ope_ind boolean not null,
        ope_djs boolean not null,
        ope_dls boolean not null,
        ope_dms boolean not null,
        ope_dcs boolean not null,
        ope_dse boolean not null,
        ope_dme boolean not null,
        ope_dvs boolean not null,
        ope_tor boolean not null,
        ope_nom varchar(40) not null,
        ope_ngr boolean not null,
        ope_pin varchar(25) not null,
        ope_ptenmn int4 not null,
        ope_hor_cod varchar(4) not null,
        primary key (ope_cod, ope_idf_cod)
    );

    create table trhu_par (
       par_cod varchar(4) not null,
        par_idf_cod varchar(15) not null,
        par_usucre varchar(255),
        par_datcre timestamp,
        par_usumod varchar(255),
        par_datmod timestamp,
        par_des varchar(1000),
        par_val varchar(1000),
        primary key (par_cod, par_idf_cod)
    );

    create table trhu_rdi (
       rdi_cln_dat timestamp not null,
        rdi_idf_cod varchar(4) not null,
        rdi_usucre varchar(255),
        rdi_datcre timestamp,
        rdi_usumod varchar(255),
        rdi_datmod timestamp,
        rdi_cat_cod varchar(4) not null,
        rdi_horext numeric(22, 0) not null,
        rdi_hornit numeric(22, 0) not null,
        rdi_hornor numeric(22, 0) not null,
        rdi_horteo numeric(22, 0) not null,
        rdi_pruhornit numeric(15, 2) not null,
        rdi_pruhornor numeric(15, 2) not null,
        rdi_pruext numeric(22, 0) not null,
        rdi_emp_cod varchar(4) not null,
        rdi_hor_cod varchar(255) not null,
        rdi_ope_cod varchar(6) not null,
        rdi_reg_cod varchar(4) not null,
        rdi_sec_cod varchar(4) not null,
        rdi_sct_cod varchar(4) not null,
        primary key (rdi_cln_dat, rdi_idf_cod)
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
        sct_cat_cod varchar(4),
        sct_act boolean,
        sct_nom varchar(30),
        sct_obs varchar(1000),
        primary key (sct_cod, sct_idf_cod)
    );

    create table trhu_sec (
       sec_emp_cod varchar(4) not null,
        sec_cod varchar(4) not null,
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
        sec_gse_cod varchar(4),
        primary key (sec_emp_cod, sec_cod, sec_idf_cod)
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
        tdi_reg_cod varchar(4),
        primary key (tdi_cod, tdi_idf_cod)
    );

    create table trhu_tra (
       tra_cod varchar(255) not null,
        tra_idf_cod varchar(4) not null,
        tra_usucre varchar(255),
        tra_datcre timestamp,
        tra_usumod varchar(255),
        tra_datmod timestamp,
        tra_dathor timestamp,
        tra_obs varchar(1000),
        tra_emp_cod varchar(4),
        tra_nod_num varchar(4),
        tra_ope_cod varchar(6),
        tra_ttr_cod varchar(4),
        primary key (tra_cod, tra_idf_cod)
    );

    create table trhu_ttr (
       ttr_cod varchar(255) not null,
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
    
create index irhu_cat_idf_fk on trhu_cat (cat_idf_cod);
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
create index irhu_tra_idf_fk on trhu_tra (tra_idf_cod);
create index irhu_ttr_idf_fk on trhu_ttr (ttr_idf_cod);
create index irhu_zon_idf_fk on trhu_zon (zon_idf_cod);   

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
       add constraint rrhu_ope_hor_fk 
       foreign key (ope_hor_cod, ope_idf_cod) 
       references trhu_hor;

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

    alter table trhu_zon 
       add constraint rrhu_zon_idf_fk 
       foreign key (zon_idf_cod) 
       references trhu_idf; 
    create table tges_acc (
       acc_cli_cod varchar(4) not null,
        acc_cod varchar(4) not null,
        acc_idf_cod varchar(4) not null,
        acc_usucre varchar(255),
        acc_datcre timestamp,
        acc_usumod varchar(255),
        acc_datmod timestamp,
        acc_cpo_cod varchar(255),
        acc_env varchar(10),
        acc_dom varchar(30) not null,
        primary key (acc_cli_cod, acc_cod, acc_idf_cod)
    );

    create table tges_alb (
      	alb_emp_cod varchar(4) not null,
        alb_cod varchar(4) not null,
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
        alb_fbl boolean not null,
        alb_fpa varchar(1) not null,
        alb_num int4 not null,
        alb_numdoc int4,
        alb_ser_codfac varchar(2),
        primary key (alb_emp_cod, alb_cod, alb_idf_cod)
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

    create table tges_cli (
       cli_cod varchar(4) not null,
        cli_idf_cod varchar(4) not null,
        cli_usucre varchar(255),
        cli_datcre timestamp,
        cli_usumod varchar(255),
        cli_datmod timestamp,
        cli_acc_cod varchar(4),
        cli_ban_cod int4,
        cli_clr_cod varchar(4),
        cli_cpo_cod varchar(4),
        cli_cpo_codoficmp varchar(8),
        cli_cpo_codorgges varchar(8),
        cli_cpo_codunitrm varchar(8),
        cli_div_cod varchar(4),
        cli_dpg_cod varchar(4),
        cli_www varchar(60),
        cli_albcls int4,
        cli_albval boolean,
        cli_ali varchar(30),
        cli_aplims boolean,
        cli_aplimpsrv boolean,
        cli_pvl boolean,
        cli_ibnbic varchar(11),
        cli_blo boolean,
        cli_rgtaea boolean,
        cli_cobdiallo boolean,
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
        cli_ettpub boolean,
        cli_envfac int4,
        cli_escdom varchar(2),
        cli_facele boolean,
        cli_facmin numeric(19, 2),
        cli_facsendte boolean,
        cli_fax varchar(60),
        cli_imsicl boolean,
        cli_lat numeric(19, 2),
        cli_llnfis001 varchar(40),
        cli_llnfis002 varchar(40),
        cli_lon numeric(19, 2),
        cli_avifac001 boolean,
        cli_nif varchar(12),
        cli_notprnpal boolean,
        cli_notprnscl boolean,
        cli_nomcom varchar(40) not null,
        cli_nomdom varchar(30),
        cli_nomfis varchar(40),
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
        cli_ctlffo boolean,
        cli_con varchar(60),
        cli_pisdom varchar(2),
        cli_pordom varchar(2),
        cli_pot boolean,
        cli_viscmlprt timestamp,
        cli_pubweb boolean,
        cli_reb int4,
        cli_recequ boolean,
        cli_banrefmdl019 varchar(35),
        cli_rislim numeric(19, 2),
        cli_rismax numeric(19, 2),
        cli_stc_cod varchar(4),
        cli_tel varchar(60),
        cli_telfacele varchar(60),
        cli_tipdte int4,
        cli_tipext int4,
        cli_tipfac int4,
        cli_tipmsg int4,
        cli_tipnif int4,
        cli_tipper int4,
        cli_tipret int4,
        cli_unitrm varchar(30),
        cli_emp_codser varchar(4),
        cli_fmc_cod varchar(4),
        cli_idi_cod varchar(4),
        cli_iva_cod varchar(4),
        cli_ofb_cod int4,
        cli_ope_cod varchar(6),
        cli_org_cod varchar(6),
        cli_painif varchar(2),
        cli_rap_cod varchar(4),
        cli_rgi_cod varchar(2),
        cli_ser_cod varchar(4),
        cli_tar_cod001 varchar(4),
        cli_tar_cod002 varchar(4),
        cli_tds_cod002 varchar(6),
        cli_tds_cod varchar(6),
        cli_sgl varchar(2),
        cli_tcs_cod varchar(4),
        cli_tfc_cod varchar(4),
        cli_tve_cod001 varchar(4),
        cli_tve_cod varchar(4),
        cli_tra_cod varchar(6),
        cli_zon_cod varchar(4),
        primary key (cli_cod, cli_idf_cod)
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
        clr_cmp int4,
        primary key (clr_cod, clr_idf_cod)
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

    create table tges_dpg (
       dpg_cod varchar(4) not null,
        dpg_idf_cod varchar(4) not null,
        dpg_usucre varchar(255),
        dpg_datcre timestamp,
        dpg_usumod varchar(255),
        dpg_datmod timestamp,
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
        dpg_tipasiing varchar(255) not null,
        dpg_tipasipag varchar(255) not null,
        dpg_trs boolean not null,
        dpg_iva_cod varchar(255) not null,
        dpg_npg_cod varchar(255) not null,
        dpg_rgi_cod varchar(255) not null,
        primary key (dpg_cod, dpg_idf_cod)
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
        emp_clicmp int4,
        emp_codcmp varchar(60),
        emp_procmp int4,
        emp_dricmp varchar(2),
        emp_driprfcmp varchar(2),
        emp_domcom varchar(60) not null,
        emp_domfis varchar(60) not null,
        emp_eml varchar(60),
        emp_tipfac int4,
        emp_fax varchar(60),
        emp_llnfis001 varchar(40),
        emp_llnfis002 varchar(40),
        emp_prnlog boolean,
        emp_dirlog varchar(300),
        emp_nomcom varchar(40) not null,
        emp_nomfis varchar(40) not null,
        emp_nomfis001 varchar(40),
        emp_tipper int4,
        emp_rec boolean,
        emp_regcricxa boolean,
        emp_rgtmtl varchar(250),
        emp_dattan timestamp,
        emp_tel varchar(60),
        emp_tipext int4,
        emp_valfac numeric(19, 2),
        emp_www varchar(60),
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
       far_cod varchar(6) not null,
        far_idf_cod varchar(4) not null,
        far_usucre varchar(255),
        far_datcre timestamp,
        far_usumod varchar(255),
        far_datmod timestamp,
        far_pda boolean,
        far_avialb int4 not null,
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
        far_tip int4 not null,
        far_tipser int4,
        far_ubinav boolean not null,
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
        ffa_act boolean not null,
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
        fmc_tri_cod varchar(4) not null,
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
        mag_valinvtrs int4 not null,
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
       mtr_tra_cod varchar(4) not null,
        mtr_cod varchar(4) not null,
        mtr_idf_cod varchar(4) not null,
        mtr_usucre varchar(255),
        mtr_datcre timestamp,
        mtr_usumod varchar(255),
        mtr_datmod timestamp,
        mtr_act boolean,
        mtr_cdu varchar(30),
        mtr_des varchar(60),
        mtr_mtr001 varchar(10),
        matricula_remolc varchar(255),
        mtr_nif varchar(12),
        mtr_obs varchar(1000),
        mtr_pesmax numeric(19, 2),
        mtr_tara numeric(19, 2),
        mtr_vehemp boolean,
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
        ofb_cpo_cod varchar(4) not null,
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
        org_cpo_cod varchar(4) not null,
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
       ped_emp_cod varchar(4) not null,
        ped_cod varchar(4) not null,
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
        ped_scp_codcom varchar(255),
        primary key (ped_emp_cod, ped_cod, ped_idf_cod)
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

    create table tges_prj (
       prj_emp_cod varchar(4) not null,
        prj_cod varchar(4) not null,
        prj_idf_cod varchar(4) not null,
        prj_usucre varchar(255),
        prj_datcre timestamp,
        prj_usumod varchar(255),
        prj_datmod timestamp,
        prj_ane_cod varchar(4),
        prj_scl_cod varchar(4),
        prj_cli_cod varchar(6),
        prj_tpj_cod varchar(8),
        prj_div_cod varchar(4),
        prj_dir varchar(200),
        prj_crealbcli boolean,
        prj_prualbcli int4,
        prj_tip int4,
        prj_ali varchar(35),
        prj_codcmp varchar(4),
        prj_percon varchar(60),
        prj_telcon varchar(30),
        prj_crlcos boolean,
        prj_diaadj timestamp,
        prj_diadevava timestamp,
        prj_plaeje timestamp,
        prj_datfin timestamp,
        prj_datfinprt timestamp,
        prj_datini timestamp,
        prj_datgar timestamp,
        prj_diarebfin timestamp,
        prj_diarebpvi timestamp,
        prj_des varchar(1000),
        prj_dta boolean,
        prj_dipfia varchar(250),
        prj_dirtec varchar(60),
        prj_valdiveur numeric(19, 2),
        prj_est int4,
        prj_baj numeric(19, 2),
        prj_gstgen numeric(19, 2),
        prj_valexc boolean,
        prj_tas numeric(19, 2),
        prj_horrut numeric(19, 2),
        prj_horequ numeric(19, 2),
        prj_horeqc numeric(19, 2),
        prj_horeqg numeric(19, 2),
        prj_impfia numeric(19, 2),
        prj_mesgar numeric(19, 2),
        prj_nom varchar(250) not null,
        prj_num varchar(6),
        prj_obs varchar(1000),
        prj_pteejc numeric(19, 2),
        prj_pteejg numeric(19, 2),
        prj_pteeje numeric(19, 2),
        prj_plspel boolean,
        prj_ref varchar(20),
        prj_res varchar(60),
        prj_ret numeric(19, 2),
        prj_tipret int4,
        prj_tipinv varchar(1),
        prj_valetm numeric(19, 2),
        prj_ffa_cod varchar(4),
        prj_mag_cod varchar(4),
        prj_ope_codadm varchar(6),
        prj_ope_codcgr varchar(6),
        prj_ope_enccod varchar(6),
        prj_clr_cod varchar(4),
        prj_ser_cod varchar(2),
        prj_zon_cod varchar(4),
        prj_acc_cod varchar(4),
        prj_cpo_cod varchar(4),
        prj_ope_cod varchar(4),
        primary key (prj_emp_cod, prj_cod, prj_idf_cod)
    );

    create table tges_pro (
       pro_cod varchar(4) not null,
        pro_idf_cod varchar(4) not null,
        pro_usucre varchar(255),
        pro_datcre timestamp,
        pro_usumod varchar(255),
        pro_datmod timestamp,
        pro_cpo_cod varchar(4) not null,
        pro_div_cod varchar(4) not null,
        pro_dpg_cod varchar(4) not null,
        pro_blo boolean,
        pro_dhm boolean,
        pro_nomcom varchar(30),
        pro_nomfis varchar(1000),
        pro_scn boolean,
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

    create table tges_rap (
       rap_cod varchar(4) not null,
        rap_idf_cod varchar(4) not null,
        rap_usucre varchar(255),
        rap_datcre timestamp,
        rap_usumod varchar(255),
        rap_datmod timestamp,
        rap_abs boolean,
        rap_des varchar(30),
        rap_esc boolean,
        rap_limini numeric(19, 2),
        rap_limfin numeric(19, 2),
        rap_pte float4,
        rap_pte001 float4,
        primary key (rap_cod, rap_idf_cod)
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
        scl_cpo_cod varchar(4) not null,
        scl_act varchar(60),
        scl_albcls int4,
        scl_blo boolean,
        scl_dom varchar(60) not null,
        scl_remlfac varchar(100),
        scl_fax varchar(60),
        scl_lat numeric(19, 2),
        scl_lon numeric(19, 2),
        scl_nom varchar(30) not null,
        scl_ret float4,
        scl_pvl boolean,
        scl_pubweb boolean,
        scl_reb int4,
        scl_tel varchar(60),
        scl_tipdte int4,
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
        scp_departament varchar(255),
        scp_des varchar(30) not null,
        scp_dsgivacmp boolean not null,
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
        sei_usucre varchar(255),
        sei_datcre timestamp,
        sei_usumod varchar(255),
        sei_datmod timestamp,
        sei_des varchar(60) not null,
        sei_dia001 timestamp not null,
        sei_dia002 timestamp not null,
        sei_serdef boolean,
        sei_ultfac numeric(19, 2),
        primary key (sei_emp_cod, sei_cod, sei_idf_cod)
    );

    create table tges_ser (
       ser_emp_cod varchar(4) not null,
        ser_cod varchar(4) not null,
        ser_idf_cod varchar(4) not null,
        ser_usucre varchar(255),
        ser_datcre timestamp,
        ser_usumod varchar(255),
        ser_datmod timestamp,
        ser_ped_cod varchar(4),
        ser_dep_cod varchar(4),
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
        ser_facrct int4,
        ser_titfac varchar(500),
        ser_ncf varchar(20),
        ser_man boolean not null,
        ser_tipasicmp varchar(2),
        ser_trscmp boolean,
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
        tar_calpvp int4,
        tar_ptemanobr numeric(19, 2) not null,
        tar_ptemat numeric(19, 2) not null,
        tar_ofr boolean,
        tar_tip int4,
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

    create table tges_tpj (
       tpj_cod varchar(4) not null,
        tpj_idf_cod varchar(4) not null,
        tpj_usucre varchar(255),
        tpj_datcre timestamp,
        tpj_usumod varchar(255),
        tpj_datmod timestamp,
        tpj_des varchar(30),
        tpj_nom varchar(30) not null,
        primary key (tpj_cod, tpj_idf_cod)
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
        tra_vehemp boolean,
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

    create table tlim_pni (
       id varchar(255) not null,
        created_by varchar(64) not null,
        created_date timestamp not null,
        lastmod_by varchar(64),
        lastmod_date timestamp,
        pni_cod varchar(255),
        pni_nom varchar(40),
        pni_tamnif varchar(15),
        pni_tipnif int4 not null,
        primary key (id)
    );

    create table tlim_tad (
       tad_cod varchar(4) not null,
        tad_idf_cod varchar(4) not null,
        tad_usucre varchar(255),
        tad_datcre timestamp,
        tad_usumod varchar(255),
        tad_datmod timestamp,
        tad_des varchar(30) not null,
        primary key (tad_cod, tad_idf_cod)
    );

create index iges_acc_idf_fk on tges_acc (acc_idf_cod);

    alter table tges_acc 
       add constraint irges_acc_pk unique (acc_idf_cod, acc_cod);
create index iges_alb_idf_fk on tges_alb (alb_idf_cod);

    alter table tges_alb 
       add constraint irges_alb_pk unique (alb_idf_cod, alb_cod);
create index iges_ane_idf_fk on tges_ane (ane_idf_cod);

    alter table tges_ane 
       add constraint irges_ane_pk unique (ane_idf_cod, ane_cod);
create index iges_art_idf_fk on tges_art (art_idf_cod);
create index iges_ban_idf_fk on tges_ban (ban_idf_cod);
create index iges_cli_idf_fk on tges_cli (cli_idf_cod);
create index iges_clr_idf_fk on tges_clr (clr_idf_cod);
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
create index iges_ffa_idf_fk on tges_ffa (ffa_idf_cod);
create index iges_fmc_idf_fk on tges_fmc (fmc_idf_cod);
create index iges_fpr_idf_fk on tges_fpr (fpr_idf_cod);
create index iges_gma_idf_fk on tges_gma (gma_idf_cod);
create index iges_idi_idf_fk on tges_idi (idi_idf_cod);
create index iges_iva_idf_fk on tges_iva (iva_idf_cod);
create index iges_mag_idf_fk on tges_mag (mag_idf_cod);
create index iges_mca_idf_fk on tges_mca (mca_idf_cod);
create index iges_mod_idf_fk on tges_mod (mod_idf_cod);
create index iges_npg_idf_fk on tges_npg (npg_idf_cod);
create index iges_ofb_idf_fk on tges_ofb (ofb_idf_cod);

    alter table tges_ofb 
       add constraint irges_ofb_pk unique (ofb_idf_cod, ofb_cod);
create index iges_org_idf_fk on tges_org (org_idf_cod);
create index iges_pas_idf_fk on tges_pas (pas_idf_cod);
create index iges_ped_idf_fk on tges_ped (ped_idf_cod);

    alter table tges_ped 
       add constraint irges_ped_pk unique (ped_idf_cod, ped_cod);
create index iges_pmg_idf_fk on tges_pmg (pmg_idf_cod);

    alter table tges_pmg 
       add constraint irges_pmg_pk unique (pmg_idf_cod, pmg_cod);
create index iges_prj_idf_fk on tges_prj (prj_idf_cod);

    alter table tges_prj 
       add constraint irges_prj_pk unique (prj_idf_cod, prj_cod);
create index iges_pro_idf_fk on tges_pro (pro_idf_cod);
create index iges_prv_idf_fk on tges_prv (prv_idf_cod);

    alter table tges_prv 
       add constraint irges_prv_pk unique (prv_idf_cod, prv_cod);
create index iges_rap_idf_fk on tges_rap (rap_idf_cod);
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
create index iges_tar_idf_fk on tges_tar (tar_idf_cod);
create index iges_tcs_idf_fk on tges_tcs (tcs_idf_cod);
create index iges_tds_idf_fk on tges_tds (tds_idf_cod);
create index iges_tfc_idf_fk on tges_tfc (tfc_idf_cod);
create index iges_tin_idf_fk on tges_tin (tin_idf_cod);
create index iges_tip_idf_fk on tges_tip (tip_idf_cod);
create index iges_tpj_idf_fk on tges_tpj (tpj_idf_cod);
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

    alter table tlim_pni 
       add constraint rlim_pni_pk unique (pni_cod);
create index iges_tad_idf_fk on tlim_tad (tad_idf_cod);

    alter table tges_acc 
       add constraint rges_acc_idf_fk 
       foreign key (acc_idf_cod) 
       references tges_idf;

    alter table tges_acc 
       add constraint rges_acc_cli_fk 
       foreign key (acc_cli_cod, acc_idf_cod) 
       references tges_cli;

    alter table tges_acc 
       add constraint FK48dqb7eg1u6mkq2j7282epird 
       foreign key (acc_cpo_cod, acc_idf_cod) 
       references tges_cpo;

    alter table tges_alb 
       add constraint rges_alb_idf_fk 
       foreign key (alb_idf_cod) 
       references tges_idf;

    alter table tges_alb 
       add constraint rges_alb_emp_fk 
       foreign key (alb_emp_cod, alb_idf_cod) 
       references tges_emp;

    alter table tges_ane 
       add constraint rges_ane_idf_fk 
       foreign key (ane_idf_cod) 
       references tges_idf;

    alter table tges_ane 
       add constraint rges_ane_emp_fk 
       foreign key (ane_emp_cod, ane_idf_cod) 
       references tges_emp;

    alter table tges_art 
       add constraint rges_art_idf_fk 
       foreign key (art_idf_cod) 
       references tges_idf;

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
       references tges_idf;

    alter table tges_cli 
       add constraint rges_cli_idf_fk 
       foreign key (cli_idf_cod) 
       references tges_idf;

    alter table tges_cli 
       add constraint FK8tvogk2hfevf6435ytbtn49n4 
       foreign key (cli_cod, cli_acc_cod, cli_idf_cod) 
       references tges_acc;

    alter table tges_cli 
       add constraint FK69cu4g6nulkjbxqjnuprap6im 
       foreign key (cli_ban_cod, cli_idf_cod) 
       references tges_ban;

    alter table tges_cli 
       add constraint FKcppdmrodpr22u02mjsym97pa0 
       foreign key (cli_clr_cod, cli_idf_cod) 
       references tges_clr;

    alter table tges_cli 
       add constraint FK4rv8t60mkrnc49v3w5fw8prlv 
       foreign key (cli_cpo_cod, cli_idf_cod) 
       references tges_cpo;

    alter table tges_cli 
       add constraint FK1fr1xajw8jhbkxn7w4a2241su 
       foreign key (cli_cpo_codoficmp, cli_idf_cod) 
       references tges_cpo;

    alter table tges_cli 
       add constraint FKgrk4dvr17mock674ak3xd146e 
       foreign key (cli_cpo_codorgges, cli_idf_cod) 
       references tges_cpo;

    alter table tges_cli 
       add constraint FK96l2wcmccga3v0hrq671rj824 
       foreign key (cli_div_cod, cli_idf_cod) 
       references tges_div;

    alter table tges_cli 
       add constraint FKcxkyjfgcnht4tpw5x2qlnwv01 
       foreign key (cli_dpg_cod, cli_idf_cod) 
       references tges_dpg;

    alter table tges_cli 
       add constraint FK16lo1q51t4tf844xdurgv1ibf 
       foreign key (cli_emp_codser, cli_idf_cod) 
       references tges_emp;

    alter table tges_cli 
       add constraint FK70kdtxcnijvxseup4q7kmgkov 
       foreign key (cli_fmc_cod, cli_idf_cod) 
       references tges_fmc;

    alter table tges_cli 
       add constraint FK69bfo1mg3m947471sflug7e7x 
       foreign key (cli_idi_cod, cli_idf_cod) 
       references tges_idi;

    alter table tges_cli 
       add constraint FK6t4j8pq21lgdd6qhnpjqs97yo 
       foreign key (cli_iva_cod, cli_idf_cod) 
       references tges_iva;

    alter table tges_cli 
       add constraint FKc9qiaijmef0koi1p748klkuu4 
       foreign key (cli_ban_cod, cli_ofb_cod, cli_idf_cod) 
       references tges_ofb;

    alter table tges_cli 
       add constraint FK8cg9rhaa30tmsuu00cb5mejw2 
       foreign key (cli_ope_cod, cli_idf_cod) 
       references trhu_ope;

    alter table tges_cli 
       add constraint FKiv3o2h79p2oerulwbg37ykdop 
       foreign key (cli_org_cod, cli_idf_cod) 
       references tges_org;

    alter table tges_cli 
       add constraint FK8oipx7kstoentvp4v007mn86x 
       foreign key (cli_rap_cod, cli_idf_cod) 
       references tges_rap;

    alter table tges_cli 
       add constraint FKea03dgeggwo08re2js4l32qpc 
       foreign key (cli_rgi_cod, cli_idf_cod) 
       references tges_rgi;

    alter table tges_cli 
       add constraint FKb56fa37y3ng131c5p692vrb5i 
       foreign key (cli_emp_codser, cli_ser_cod, cli_idf_cod) 
       references tges_ser;

    alter table tges_cli 
       add constraint FKml5skiheedrd1vemamytabwa5 
       foreign key (cli_tar_cod001, cli_idf_cod) 
       references tges_tar;

    alter table tges_cli 
       add constraint FK49eiuk7ks63odd1id9ngtq387 
       foreign key (cli_tar_cod002, cli_idf_cod) 
       references tges_tar;

    alter table tges_cli 
       add constraint FK61y5q4a20bsgan9s6ahhqg560 
       foreign key (cli_tds_cod, cli_idf_cod) 
       references tges_tds;

    alter table tges_cli 
       add constraint FKjsq6i8jbk1bk75rx5ann5ighc 
       foreign key (cli_tds_cod002, cli_idf_cod) 
       references tges_tds;

    alter table tges_cli 
       add constraint FKbuimlqcb1rk3fnhkwf7y1cuya 
       foreign key (cli_tcs_cod, cli_idf_cod) 
       references tges_tcs;

    alter table tges_cli 
       add constraint FK7vhwee2a2rg9uqotqeoxcjimd 
       foreign key (cli_tfc_cod, cli_idf_cod) 
       references tges_tfc;

    alter table tges_cli 
       add constraint FKkvhnxjc233b5lh9vr61hd129t 
       foreign key (cli_tve_cod, cli_idf_cod) 
       references tges_tve;

    alter table tges_cli 
       add constraint FKdw90katwa8lqqwxjj1njdlm0 
       foreign key (cli_tve_cod001, cli_idf_cod) 
       references tges_tve;

    alter table tges_cli 
       add constraint FK386ngbcd3iwg1byhhd8w32dl4 
       foreign key (cli_tra_cod, cli_idf_cod) 
       references tges_tra;

    alter table tges_cli 
       add constraint FK1t6tcgub0c6pommuutbeua8tu 
       foreign key (cli_zon_cod, cli_idf_cod) 
       references tges_zon;

    alter table tges_clr 
       add constraint rges_clr_idf_fk 
       foreign key (clr_idf_cod) 
       references tges_idf;

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
       foreign key (cpo_pas_cod, cpo_prv_cod, cpo_idf_cod) 
       references tges_prv;

    alter table tges_dep 
       add constraint rges_dep_idf_fk 
       foreign key (dep_idf_cod) 
       references tges_idf;

    alter table tges_dep 
       add constraint rges_dep_emp_fk 
       foreign key (dep_emp_cod, dep_idf_cod) 
       references tges_emp;

    alter table tges_dfs 
       add constraint rges_dfs_idf_fk 
       foreign key (dfs_idf_cod) 
       references tges_idf;

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
       add constraint rges_emp_idf_fk 
       foreign key (emp_idf_cod) 
       references tges_idf;

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
       add constraint rges_fae_idf_fk 
       foreign key (fae_idf_cod) 
       references tges_idf;

    alter table tges_fae 
       add constraint rges_fae_far_fk 
       foreign key (fae_far_cod, fae_idf_cod) 
       references tges_far;

    alter table tges_fae 
       add constraint rges_fae_emp_fk 
       foreign key (fae_emp_cod, fae_idf_cod) 
       references tges_emp;

    alter table tges_far 
       add constraint rges_far_idf_fk 
       foreign key (far_idf_cod) 
       references tges_idf;

    alter table tges_far 
       add constraint rges_far_fct_fk 
       foreign key (far_fct_cod, far_idf_cod) 
       references tges_fct;

    alter table tges_far 
       add constraint rges_far_gre_fk 
       foreign key (far_gre_cod, far_idf_cod) 
       references trhu_gre;

    alter table tges_fct 
       add constraint rges_fct_idf_fk 
       foreign key (fct_idf_cod) 
       references tges_idf;

    alter table tges_fct 
       add constraint rges_fct_far_fk 
       foreign key (fct_far_cod, fct_idf_cod) 
       references tges_far;

    alter table tges_ffa 
       add constraint rges_ffa_idf_fk 
       foreign key (ffa_idf_cod) 
       references tges_idf;

    alter table tges_fmc 
       add constraint rges_fmc_idf_fk 
       foreign key (fmc_idf_cod) 
       references tges_idf;

    alter table tges_fmc 
       add constraint FK1n78xaaihy14sll06gx4e0tjt 
       foreign key (fmc_tri_cod, fmc_idf_cod) 
       references tges_tri;

    alter table tges_fpr 
       add constraint rges_fpr_idf_fk 
       foreign key (fpr_idf_cod) 
       references tges_idf;

    alter table tges_gma 
       add constraint rges_gma_idf_fk 
       foreign key (gma_idf_cod) 
       references tges_idf;

    alter table tges_idi 
       add constraint rges_idi_idf_fk 
       foreign key (idi_idf_cod) 
       references tges_idf;

    alter table tges_iva 
       add constraint rges_iva_idf_fk 
       foreign key (iva_idf_cod) 
       references tges_idf;

    alter table tges_mag 
       add constraint rges_mag_idf_fk 
       foreign key (mag_idf_cod) 
       references tges_idf;

    alter table tges_mag 
       add constraint rges_mag_cpo_fk 
       foreign key (mag_cpo_cod, mag_idf_cod) 
       references tges_cpo;

    alter table tges_mag 
       add constraint rges_mag_div_fk 
       foreign key (mag_div_cod, mag_idf_cod) 
       references tges_div;

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

    alter table tges_ofb 
       add constraint rges_ofb_idf_fk 
       foreign key (ofb_idf_cod) 
       references tges_idf;

    alter table tges_ofb 
       add constraint FKihv3ygxweuwu3ncn3sxuo9icp 
       foreign key (ofb_ban_cod, ofb_idf_cod) 
       references tges_ban;

    alter table tges_ofb 
       add constraint FKnxjr44xmwa9v0p0b8vactwk72 
       foreign key (ofb_cpo_cod, ofb_idf_cod) 
       references tges_cpo;

    alter table tges_org 
       add constraint rges_org_idf_fk 
       foreign key (org_idf_cod) 
       references tges_idf;

    alter table tges_org 
       add constraint FK2njyvqp4g2oxr3lva6yyyvdvi 
       foreign key (org_cpo_cod, org_idf_cod) 
       references tges_cpo;

    alter table tges_pas 
       add constraint rges_pas_idf_fk 
       foreign key (pas_idf_cod) 
       references tges_idf;

    alter table tges_ped 
       add constraint rges_ped_idf_fk 
       foreign key (ped_idf_cod) 
       references tges_idf;

    alter table tges_ped 
       add constraint rges_ped_emp_fk 
       foreign key (ped_emp_cod, ped_idf_cod) 
       references tges_emp;

    alter table tges_ped 
       add constraint rges_ped_scp_fk 
       foreign key (ped_emp_cod, ped_scp_codcom, ped_idf_cod) 
       references tges_scp;

    alter table tges_pmg 
       add constraint rges_pmg_idf_fk 
       foreign key (pmg_idf_cod) 
       references tges_idf;

    alter table tges_pmg 
       add constraint rges_pmg_mag_fk 
       foreign key (pmg_mag_cod, pmg_idf_cod) 
       references tges_mag;

    alter table tges_prj 
       add constraint rges_prj_idf_fk 
       foreign key (prj_idf_cod) 
       references tges_idf;

    alter table tges_prj 
       add constraint FKgomdmsmy4cctnqybccugx9xi1 
       foreign key (prj_emp_cod, prj_ane_cod, prj_idf_cod) 
       references tges_ane;

    alter table tges_prj 
       add constraint FKtrcmhsmh30029mso04ctl6yjd 
       foreign key (prj_cli_cod, prj_idf_cod) 
       references tges_cli;

    alter table tges_prj 
       add constraint FKfq24ll7w4wai65svvgehqtrtn 
       foreign key (prj_cli_cod, prj_acc_cod, prj_idf_cod) 
       references tges_acc;

    alter table tges_prj 
       add constraint FKbo7yrjd366kdun6ujtjux49x7 
       foreign key (prj_cpo_cod, prj_idf_cod) 
       references tges_cpo;

    alter table tges_prj 
       add constraint FKowfv4j29nu5n3datylcpos053 
       foreign key (prj_div_cod, prj_idf_cod) 
       references tges_div;

    alter table tges_prj 
       add constraint FKbpjerm2fnb7191pum3lijc071 
       foreign key (prj_emp_cod, prj_idf_cod) 
       references tges_emp;

    alter table tges_prj 
       add constraint FKafgo2otwke1ulsgqvced4ptj7 
       foreign key (prj_ffa_cod, prj_idf_cod) 
       references tges_ffa;

    alter table tges_prj 
       add constraint FKq35fmvk1ypee8gk384p26c78t 
       foreign key (prj_mag_cod, prj_idf_cod) 
       references tges_mag;

    alter table tges_prj 
       add constraint FKlgb5k78ffv0o478w09rue3n2y 
       foreign key (prj_ope_codadm, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint FKm96lqhbxkljwlni6j6tvsnb7 
       foreign key (prj_ope_codcgr, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint FKsi4bi84yq0vig92i7prcoctg 
       foreign key (prj_ope_enccod, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint FKmwne1uqcahbgepgu91exmtifw 
       foreign key (prj_ope_cod, prj_idf_cod) 
       references trhu_ope;

    alter table tges_prj 
       add constraint FKgugkgdk37jbrycpifxowtg1tb 
       foreign key (prj_tpj_cod, prj_idf_cod) 
       references tges_tpj;

    alter table tges_prj 
       add constraint FKo9x1un79u11h34c7vbmakw4s5 
       foreign key (prj_clr_cod, prj_idf_cod) 
       references tges_clr;

    alter table tges_prj 
       add constraint FKhmwj1aas0dtuq5fqh06gjs1l 
       foreign key (prj_emp_cod, prj_ser_cod, prj_idf_cod) 
       references tges_ser;

    alter table tges_prj 
       add constraint FKmqyx9emn1a44s5tvk8qfc7vy6 
       foreign key (prj_cli_cod, prj_scl_cod, prj_idf_cod) 
       references tges_scl;

    alter table tges_prj 
       add constraint FKoxch4s2vgb81yg801egbkgjgg 
       foreign key (prj_zon_cod, prj_idf_cod) 
       references tges_zon;

    alter table tges_pro 
       add constraint rges_pro_idf_fk 
       foreign key (pro_idf_cod) 
       references tges_idf;

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
       add constraint rges_prv_idf_fk 
       foreign key (prv_idf_cod) 
       references tges_idf;

    alter table tges_prv 
       add constraint rges_prv_pas_fk 
       foreign key (prv_pas_cod, prv_idf_cod) 
       references tges_pas;

    alter table tges_rap 
       add constraint rges_rap_idf_fk 
       foreign key (rap_idf_cod) 
       references tges_idf;

    alter table tges_rgi 
       add constraint rges_rgi_idf_fk 
       foreign key (rgi_idf_cod) 
       references tges_idf;

    alter table tges_scl 
       add constraint rges_scl_idf_fk 
       foreign key (scl_idf_cod) 
       references tges_idf;

    alter table tges_scl 
       add constraint FKise7ic8ta8cim42c8icqlu7kr 
       foreign key (scl_cli_cod, scl_acc_cod, scl_idf_cod) 
       references tges_acc;

    alter table tges_scl 
       add constraint FKerccqbx2ekixb89mr4g1n2gmi 
       foreign key (scl_clr_cod, scl_idf_cod) 
       references tges_clr;

    alter table tges_scl 
       add constraint FKnju6nm4t8og1uloyob37trdm8 
       foreign key (scl_cli_cod, scl_idf_cod) 
       references tges_cli;

    alter table tges_scl 
       add constraint FKt74s2itqf5pb70megpu53gbv8 
       foreign key (scl_cpo_cod, scl_idf_cod) 
       references tges_cpo;

    alter table tges_scl 
       add constraint FKqdc44rywcokmnlxkokueextiw 
       foreign key (scl_iva_cod, scl_idf_cod) 
       references tges_iva;

    alter table tges_scl 
       add constraint FKi8qocwdiks857tjnbt93q8r6w 
       foreign key (scl_ope_codenc, scl_idf_cod) 
       references trhu_ope;

    alter table tges_scl 
       add constraint FK9snpvpqsffx8f3j7luo2jjf3k 
       foreign key (scl_ope_codres, scl_idf_cod) 
       references trhu_ope;

    alter table tges_scl 
       add constraint FKrmsy1t1tligq2haeo0kw8ghk5 
       foreign key (scl_rgi_cod, scl_idf_cod) 
       references tges_rgi;

    alter table tges_scl 
       add constraint FKe3lx3fxgusvi177hgqobtyiej 
       foreign key (scl_tar_cod001, scl_idf_cod) 
       references tges_tar;

    alter table tges_scl 
       add constraint FKesu1dnqpkjcq4scgjhkp2desw 
       foreign key (scl_tar_cod002, scl_idf_cod) 
       references tges_tar;

    alter table tges_scl 
       add constraint FK5o1wycsays3llcq9plmam81p3 
       foreign key (scl_tds_cod, scl_idf_cod) 
       references tges_tds;

    alter table tges_scl 
       add constraint FKo85s2g4nsc0gte8fitklt6vhu 
       foreign key (scl_tcs_cod, scl_idf_cod) 
       references tges_tcs;

    alter table tges_scl 
       add constraint FKpxw7x0e20cp6x6opm4pmclc5b 
       foreign key (scl_tve_cod, scl_idf_cod) 
       references tges_tve;

    alter table tges_scl 
       add constraint FKpgfoip4h1jiivgh4tedvvim83 
       foreign key (scl_tve_cod001, scl_idf_cod) 
       references tges_tve;

    alter table tges_scl 
       add constraint FKhxrt44pwpeqe2e3b3cdp9s22f 
       foreign key (scl_zon_cod, scl_idf_cod) 
       references tges_zon;

    alter table tges_scp 
       add constraint rges_scp_idf_fk 
       foreign key (scp_idf_cod) 
       references tges_idf;

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
       add constraint rges_ser_idf_fk 
       foreign key (ser_idf_cod) 
       references tges_idf;

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

    alter table tges_stc 
       add constraint rges_stc_idf_fk 
       foreign key (stc_idf_cod) 
       references tges_idf;

    alter table tges_sue 
       add constraint rges_sue_idf_fk 
       foreign key (sue_idf_cod) 
       references tges_idf;

    alter table tges_sui 
       add constraint rges_sui_idf_fk 
       foreign key (sui_idf_cod) 
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
       add constraint rges_sui_mag_fk 
       foreign key (sui_mag_cod, sui_idf_cod) 
       references tges_mag;

    alter table tges_sui 
       add constraint rges_sui_pmg_fk 
       foreign key (sui_mag_cod, sui_pmg_cod, sui_idf_cod) 
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

    alter table tges_tpj 
       add constraint rges_tpj_idf_fk 
       foreign key (tpj_idf_cod) 
       references tges_idf;

    alter table tges_tra 
       add constraint rges_tra_idf_fk 
       foreign key (tra_idf_cod) 
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
       add constraint rges_uba_idf_fk 
       foreign key (uba_idf_cod) 
       references tges_idf;

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

    alter table tlim_tad 
       add constraint rges_tad_idf_fk 
       foreign key (tad_idf_cod) 
       references tges_idf;
create table tlic_config (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    filcpv varchar(1000),
    filprv varchar(1000),
    sinact boolean not null,
    empresa_id int8 not null,
    primary key (id)
);

create table tlic_cpv (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(10) not null,
    descripcio varchar(255) not null,
    licitacio_id int8 not null,
    primary key (id)
);

create table tlic_document (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(5) not null,
    hash varchar(30) not null,
    nom varchar(200) not null,
    tipus int4 not null,
    uri varchar(255) not null,
    licitacio_id int8 not null,
    primary key (id)
);

create table tlic_licitacio (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    codi varchar(200) not null,
    datact timestamp not null,
    datlim timestamp,
    destac boolean not null,
    esborr boolean not null,
    expest varchar(4) not null,
    expeds varchar(100) not null,
    expid varchar(100) not null,
    nota varchar(2000) not null,
    prctip varchar(3) not null,
    prctds varchar(1000) not null,
    impnot numeric(17, 2) not null,
    imptot numeric(17, 2) not null,
    mon varchar(3) not null,
    paicod varchar(2),
    paides varchar(200),
    prvcod varchar(5),
    prvdes varchar(200),
    prjsub varchar(4),
    prjsds varchar(1000),
    terexn int4,
    terexu varchar(3),
    prjtip varchar(4) not null,
    prjtds varchar(1000) not null,
    prjtit varchar(2000) not null,
    resum varchar(500) not null,
    unidi3 varchar(9),
    uninom varchar(200) not null,
    unitip varchar(2) not null,
    unitds varchar(100) not null,
    urgtip varchar(2) not null,
    urgtds varchar(1000) not null,
    uri varchar(255) not null,
    url varchar(200) not null,
    empresa_id int8 not null,
    primary key (id)
);


alter table tlic_config 
   add constraint configuracio_empresa_fk 
   foreign key (empresa_id) 
   references empresa;

alter table tlic_cpv 
   add constraint cpv_licitacio_fk 
   foreign key (licitacio_id) 
   references tlic_licitacio;

alter table tlic_document 
   add constraint document_licitacio_fk 
   foreign key (licitacio_id) 
   references tlic_licitacio;

alter table tlic_licitacio 
   add constraint licitacio_empresa_fk 
   foreign key (empresa_id) 
   references empresa;
create table marcatge (
   id int8 not null,
    created_by varchar(64) not null,
    created_date timestamp not null,
    lastmod_by varchar(64),
    lastmod_date timestamp,
    version int8 not null,
    data timestamp not null,
    latitud float8,
    longitud float8,
    origen int4 not null,
    operariemp_id int8 not null,
    primary key (id)
);

alter table marcatge 
   add constraint marcatge_operariemp_fk 
   foreign key (operariemp_id) 
   references operari_empresa;
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, "version")
VALUES(nextval('hibernate_sequence'),'admin','$2a$10$lLGi1t0OT7ftruz8ieC2B.ImwpGTlkVCHDiYrQKTYdlOr6fN/CFMa','admin@limit.es',NULL,'Administrador','Admin',true,true,'init',current_timestamp,0);
INSERT INTO usuari_authority VALUES(1,'ADMIN');
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, "version")
VALUES(nextval('hibernate_sequence'),'test','$2a$10$DOpxYy8VGZcKnW6aA9y4uO17KpIMFCpZRqlYjHFlFo5R/pM354g52','test@limit.es',NULL,'Test','Test',true,true,'init',current_timestamp,0);
INSERT INTO usuari(id, codi, contrasenya, email, imatge_url, nom, llinatges, validat, actiu, created_by, created_date, "version")
VALUES(nextval('hibernate_sequence'),'sync','$2a$10$j.zqnsIS6LEM/0hhIbTfS.gxd80WMl3nx0azivywrIdnTkRhrOghG','sync@limit.es',NULL,'Sincronitzacio','CECOGEST',true,true,'init',current_timestamp,0);
INSERT INTO usuari_authority VALUES(3,'SYNC');