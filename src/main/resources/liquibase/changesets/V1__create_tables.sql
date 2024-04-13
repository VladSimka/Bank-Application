create table if not exists t_accounts
(
    id      serial primary key,
    number  bigint  not null unique,
    balance numeric not null
);



create table if not exists t_cards
(
    id                    serial primary key,
    number                varchar(25) not null unique,
    date                  varchar(10) not null,
    cvv                   VARCHAR(3)  not null,
    balance               numeric     not null,
    account_id            integer,
    month_limit           numeric     not null,
    date_of_setting_limit timestamp   not null,
    limit_exceeded        boolean     not null,

    constraint fk_t_card_account foreign key (account_id) references t_accounts (id)
);


create table if not exists t_transactions
(
    id       serial primary key,
    from_id  integer    not null,
    to_id    integer    not null,
    currency varchar(3) not null,
    date     timestamp  not null,
    amount   numeric    not null,
    constraint fk_transactions_cards_from foreign key (from_id) references t_cards (id),
    constraint fk_transactions_cards_to foreign key (to_id) references t_cards (id)
);

create table if not exists t_clients
(
    id         serial primary key,
    name       varchar(100) not null,
    username   varchar(100) not null,
    password   varchar(100) not null,
    account_id integer      not null,
    constraint fk_t_client_account foreign key (account_id) references t_accounts (id)

);

create table if not exists t_clients_cards
(
    client_id integer not null,
    card_id   integer not null,
    constraint fk_clients_cards_client foreign key (client_id) references t_clients (id),
    constraint fk_clients_cards_card foreign key (card_id) references t_cards (id)
);

create table if not exists t_cards_transactions
(
    card_id        integer not null,
    transaction_id integer not null,
    constraint fk_cards_transactions_card foreign key (card_id) references t_cards (id),
    constraint fk_cards_transactions_transaction foreign key (transaction_id) references t_transactions (id)
);