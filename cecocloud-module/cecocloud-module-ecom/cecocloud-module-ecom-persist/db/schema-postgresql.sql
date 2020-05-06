    create table tcom_art (
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
        art_pvp numeric(17, 5) not null,
        art_emp_cod varchar(4),
        art_far_cod varchar(6) not null,
        art_gma_cod varchar(6),
        art_iva_cod varchar(4) not null,
        art_mca_cod varchar(6),
        art_mod_cod varchar(6) not null,
        primary key (art_cod, art_idf_cod)
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

create index icom_art_idf_fk on tcom_art (art_idf_cod);
create index icom_cnt_idf_fk on tcom_cnt (cnt_idf_cod);
create index icom_emp_idf_fk on tcom_emp (emp_idf_cod);
create index icom_fae_idf_fk on tcom_fae (fae_idf_cod);

    alter table tcom_fae 
       add constraint ircom_fae_pk unique (fae_idf_cod);
create index icom_far_idf_fk on tcom_far (far_idf_cod);
create index icom_gma_idf_fk on tcom_gma (gma_idf_cod);
create index icom_iva_idf_fk on tcom_iva (iva_idf_cod);
create index icom_mca_idf_fk on tcom_mca (mca_idf_cod);
create index icom_mod_idf_fk on tcom_mod (mod_idf_cod);  

    alter table tcom_art 
       add constraint rcom_art_idf_fk 
       foreign key (art_idf_cod) 
       references tcom_idf;

    alter table tcom_art 
       add constraint rcom_art_art_fk 
       foreign key (art_art_cod, art_idf_cod) 
       references tcom_art;

    alter table tcom_art 
       add constraint rcom_art_art_cod02_fk 
       foreign key (art_art_cod02, art_idf_cod) 
       references tcom_art;

    alter table tcom_art 
       add constraint rcom_art_articleRaee_fk 
       foreign key (art_codrae, art_idf_cod) 
       references tcom_art;

    alter table tcom_art 
       add constraint rcom_art_emp_fk 
       foreign key (art_emp_cod, art_idf_cod) 
       references tcom_emp;

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

    alter table tcom_cnt 
       add constraint rcom_cnt_idf_fk 
       foreign key (cnt_idf_cod) 
       references tcom_idf;

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

    alter table tcom_gma 
       add constraint rcom_gma_idf_fk 
       foreign key (gma_idf_cod) 
       references tcom_idf;

    alter table tcom_iva 
       add constraint rcom_iva_idf_fk 
       foreign key (iva_idf_cod) 
       references tcom_idf;

    alter table tcom_mca 
       add constraint rcom_mca_idf_fk 
       foreign key (mca_idf_cod) 
       references tcom_idf;

    alter table tcom_mod 
       add constraint rcom_mod_idf_fk 
       foreign key (mod_idf_cod) 
       references tcom_idf;