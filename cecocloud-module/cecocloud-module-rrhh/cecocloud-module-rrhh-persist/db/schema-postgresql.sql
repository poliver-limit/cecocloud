

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
create index irhu_gre_idf_fk on trhu_gre (gre_idf_cod);
create index irhu_gse_idf_fk on trhu_gse (gse_idf_cod);

    alter table trhu_gse 
       add constraint irrhu_gse_pk unique (gse_idf_cod, gse_cod);
create index irhu_hor_idf_fk on trhu_hor (hor_idf_cod);
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

    alter table trhu_nod 
       add constraint rrhu_nod_zon_ori_fk 
       foreign key (nod_zon_codori, nod_idf_cod) 
       references trhu_zon;

    alter table trhu_ope 
       add constraint rrhu_ope_idf_fk 
       foreign key (ope_idf_cod) 
       references trhu_idf;

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

   
