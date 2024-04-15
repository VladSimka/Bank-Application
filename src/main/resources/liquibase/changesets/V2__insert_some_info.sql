INSERT INTO t_accounts (number, balance) VALUES
                                             (123456789, 1000.0),
                                             (987654321, 5000.0);

INSERT INTO t_cards (number, date, cvv, balance, account_id, month_limit, date_of_setting_limit, limit_exceeded)
VALUES
                         ('1234-1234-1234-1234', '12/25', '123', 2000.0, 1, 500.0, '2024-04-10 10:00:00', false),
                         ('4321-4321-4321-4321', '06/23', '456', 3000.0, 1, 1000.0, '2024-04-10 10:00:00', false);

INSERT INTO t_transactions (from_id, to_id, currency, date, amount) VALUES
                                                                        (1, 2, 'USD', '2024-04-10 10:30:00', 500.0),
                                                                        (2, 1, 'USD', '2024-04-10 11:00:00', 300.0);

INSERT INTO t_clients (name, username, password, account_id) VALUES
                                                                 ('John Doe', 'johndoe', '$2a$10$.Yyl23HQfjFgHxfq00cyZ.Dm7rhLJJrOjSuFbh2DUvbOeN2EhCuqy', 1),
                                                                 ('Jane Smith', 'janesmith', '$2a$10$2wVmZBtBXEF0G4iRBzWWEOHtlLtUcJDUwouG4q8QdLRKwMHMrE2Ry', 2);

INSERT INTO t_clients_cards (client_id, card_id) VALUES
                                                     (1, 1),
                                                     (2, 2);

INSERT INTO t_cards_transactions (card_id, transaction_id) VALUES
                                                               (1, 1),
                                                               (2, 2);