INSERT INTO user (`id`, `birth_date`, `name`)
VALUES (10001, sysdate(), 'AB');
INSERT INTO user (`id`, `birth_date`, `name`)
VALUES (10002, sysdate(), 'Jill');
INSERT INTO user (`id`, `birth_date`, `name`)
VALUES (10003, sysdate(), 'Jam');
INSERT INTO post (`id`, `description`, `user_id`)
VALUES(11001, 'My First Post', 10001);
INSERT INTO post (`id`, `description`, `user_id`)
VALUES(11002, 'My Second Post', 10001);