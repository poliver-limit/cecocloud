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
        amount number(10,0) not null,
        amount_eur number(10,0) not null,
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

    alter table usuari 
       add constraint usuari_codi_uk unique (codi);

    alter table usuari 
       add constraint usuari_email_uk unique (email);

    alter table apikey_scope 
       add constraint apkscope_apikey_fk 
       foreign key (apikey_id) 
       references apikey;

    alter table usuari_authority 
       add constraint usuaut_usuari_fk 
       foreign key (usuari_id) 
       references usuari;
