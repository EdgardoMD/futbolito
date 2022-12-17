


INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(1, 'c.cifuentes1990@gmail.com', 'CRISTOBAL', '$2a$10$Ty/pdJyPoI6rwNNpHIGl3eTEqy7qQKxvl1vCmwUX5bW4CeedtX27i', '99999', 'kristobal', current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(2, 'anrn@q.cl', 'arf', '$2a$10$g/1T5t.p.xlyDFH8u6KYKOP.QVYpm.j/xpLw0kIp5P5f8DnVGfTtG', '165165', 'aaaaa2' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(3, 'aaaa@q.cl', 'cew', '$2a$10$Iu9TW72xw6E9mToMvxrVcurbpR1cXAYqOiLu2A1OMB9lhKb6ohVLe', '165165', 'aaaaa3' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(4, 'bbbb@q.cl', 'cew', '$2a$10$d3htpnA0mh82Cs4hWd97qOQ8BHnWQ9tjXos2.YdkGkQlKhiJAE5wO', '165165', 'aaaaa4' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(5, 'cccc@q.cl', 'cew', '$2a$10$Snw5JEJ2.EyyD0DYRGH0NunR4FrpXdT.NOQltQ7tLWdtBqAmw9J0q', '165165', 'aaaaa5' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(6, 'dddd@q.cl', 'cew', '$2a$10$m69SxAseMi6ljji7MbCxjefik1v5Bge.Z30UnKkc3WpswgMpSRzmC', '165165', 'aaaaa6' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(7, 'eeee@q.cl', 'cew', '$2a$10$sdhkJKINwAbsEcR/SPzRGunWLhgM5n/4X1goTs0PhZP2ywKBQkC/y', '165165', 'aaaab7' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(8, 'ffff@q.cl', 'cew', '$2a$10$D4rlZ686uTnY/.UeaKGn4e20Ak3bA6aBtqAKtE.KOzw3jDmSWD8E.', '165165', 'aaaab8' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(9, 'gggg@q.cl', 'cew', '$2a$10$g3NEXr94rZyMKIwO/opMr.d9aA/YPJRKeHK7FLXbYpioEGT5B9a9S', '165165', 'aaaab9' , current_timestamp);

INSERT INTO users
(id_user, mail, name, password, phone, nick_name, creation_date)
VALUES(10, 'hhhh@q.cl', 'cew', '$2a$10$EpG/d.CDP3yeu.e9MxKY3.WBuiIOpT/D1HCO7j.mNXbxuTpxVHCky', '165165', 'aaaab0' , current_timestamp);






INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(1, 'cumplea�os', 1.7,  'pos', 'foto', 'skillfut', 3, NULL, NULL, 1, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(2, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 2, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(3, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 3, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(4, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 4, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(5, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 5, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(6, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 6, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(7, NULL, 0.0,  NULL, NULL, NULL, 0, NULL, NULL, 7, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(8, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 8, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(9, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 9, current_timestamp);

INSERT INTO athletes
(id_athletes, birth_date, height,  position, profile_photo, skillful_foot, weight, athlete_level, city, id_user, creation_date)
VALUES(10, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 10, current_timestamp);








INSERT INTO user_role
(role_id, user_id)
VALUES(1, 1);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 2);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 3);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 4);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 5);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 6);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 7);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 8);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 9);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 10);







