insert into role values (1, 'admin'), (2, 'user');

insert into users (username, password, user_role_id) values ('rita', 'qwerty', 2), ('john', '1234',2), ('andrew', 'baton',2), ('sasha', 'йцукен', 2);



insert into account (number, balance, client_id) values ('00000', 120.5, 1),
                                               ('00001', 1676.0,1),
                                               ('00002',1204775.57, 2),
                                               ('00003', 3450.0,2),
                                               ('00004', 10.5,3),
                                               ('00005',49920.5, 4);

insert into card (number, account_id) values ('0000000000000000', 1),
                                             ('0000000000000001', 1),
                                             ('0000000000000002', 2),
                                             ('0000000000000003', 3),
                                             ('0000000000000004', 4),
                                             ('0000000000000005', 5),
                                             ('0000000000000006', 6);

