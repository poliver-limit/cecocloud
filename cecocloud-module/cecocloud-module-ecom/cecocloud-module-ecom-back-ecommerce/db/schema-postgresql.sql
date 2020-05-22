    create table paycomet_notification (
       order_number varchar(255) not null,
        account_code varchar(255) not null,
        amount int4 not null,
        amount_eur int4 not null,
        auth_code varchar(255) not null,
        bank_date_time varchar(255) not null,
        bic_code varchar(255) not null,
        card_brand varchar(255) not null,
        card_country varchar(255) not null,
        concept varchar(255) not null,
        currency varchar(255) not null,
        error_description varchar(255) not null,
        error_id int4 not null,
        id_user int4 not null,
        notification_hash varchar(255) not null,
        response varchar(255) not null,
        scoring int4 not null,
        secure_payment varchar(255) not null,
        token_user varchar(255) not null,
        tpv_id int4 not null,
        transaction_name varchar(255) not null,
        transaction_type int4 not null,
        primary key (order_number)
    );

create index order_number_fk on paycomet_notification (order_number);