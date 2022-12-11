INSERT INTO roles
(id_role, "role")
VALUES(1, 'ATHLETE');


INSERT INTO regions
(id_region, region)
VALUES(1, 'ohiggins');

INSERT INTO citys
(id_city, city, id_region)
VALUES(1, 'rancagua', 1);


INSERT INTO level_teams
(id_level_teams, "level", required_score)
VALUES(1, 'inicial', 0);

INSERT INTO public.status_invitation
(id_status_invitation, status_invitation)
VALUES(1, 'ACCEPTED');
INSERT INTO public.status_invitation
(id_status_invitation, status_invitation)
VALUES(2, 'REJECTED');
INSERT INTO public.status_invitation
(id_status_invitation, status_invitation)
VALUES(3, 'SENT');



INSERT INTO public.notification_types
(id_notification_types, type_notification)
VALUES(1, 'TEAM_INVITATION');


INSERT INTO public.status_notification
(id_status_notification, status_notification)
VALUES(1, 'REVISED');
INSERT INTO public.status_notification
(id_status_notification, status_notification)
VALUES(2, 'SENT');
INSERT INTO public.status_notification
(id_status_notification, status_notification)
VALUES(3, 'CREATED');
INSERT INTO public.status_notification
(id_status_notification, status_notification)
VALUES(4, 'VIEW');



























INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(1, 'c.cifuentes1990@gmail.com', 'CRISTOBAL', '$2a$10$Ty/pdJyPoI6rwNNpHIGl3eTEqy7qQKxvl1vCmwUX5bW4CeedtX27i', '99999', NULL);
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(2, 'a@a.a', 'andres', '$2a$10$flJKJqXFDp1DPXn1ZQb3dePbwUJDaQxcdlCEcuJYh5qUCnb520Zza', '55', NULL);
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(4, 'a@q.cl', 'a', '$2a$10$g/1T5t.p.xlyDFH8u6KYKOP.QVYpm.j/xpLw0kIp5P5f8DnVGfTtG', 'a', 'a');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(10, 'aaaa@q.cl', 'cew', '$2a$10$Iu9TW72xw6E9mToMvxrVcurbpR1cXAYqOiLu2A1OMB9lhKb6ohVLe', '165165', 'aaaa');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(12, 'bbbb@q.cl', 'cew', '$2a$10$d3htpnA0mh82Cs4hWd97qOQ8BHnWQ9tjXos2.YdkGkQlKhiJAE5wO', '165165', 'bbbb');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(14, 'cccc@q.cl', 'cew', '$2a$10$Snw5JEJ2.EyyD0DYRGH0NunR4FrpXdT.NOQltQ7tLWdtBqAmw9J0q', '165165', 'cccc');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(16, 'dddd@q.cl', 'cew', '$2a$10$m69SxAseMi6ljji7MbCxjefik1v5Bge.Z30UnKkc3WpswgMpSRzmC', '165165', 'dddd');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(18, 'eeee@q.cl', 'cew', '$2a$10$sdhkJKINwAbsEcR/SPzRGunWLhgM5n/4X1goTs0PhZP2ywKBQkC/y', '165165', 'eeee');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(20, 'ffff@q.cl', 'cew', '$2a$10$D4rlZ686uTnY/.UeaKGn4e20Ak3bA6aBtqAKtE.KOzw3jDmSWD8E.', '165165', 'ffff');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(22, 'gggg@q.cl', 'cew', '$2a$10$g3NEXr94rZyMKIwO/opMr.d9aA/YPJRKeHK7FLXbYpioEGT5B9a9S', '165165', 'gggg');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(24, 'hhhh@q.cl', 'cew', '$2a$10$EpG/d.CDP3yeu.e9MxKY3.WBuiIOpT/D1HCO7j.mNXbxuTpxVHCky', '165165', 'hhhh');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(26, 'iiii@q.cl', 'cew', '$2a$10$O3naT0zmxqeTBmyXLeVbEOqCEQKu6IVdDi18z23Ea/.z9dnDpsJs6', '165165', 'iiii');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(28, 'jjjj@q.cl', 'cew', '$2a$10$BgoYM9AqLpW48v0gKyT4x.A7qGqYgGZCzP7fe32xKsONYry09hd2i', '165165', 'jjjj');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(30, 'kkkk@q.cl', 'cew', '$2a$10$g/abPXr1EwlxuWruzghfK.0QzV8eEwj48jgEpvgLTkC1MJPTL3sW.', '165165', 'kkkk');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(32, 'llll@q.cl', 'cew', '$2a$10$YsnJLXOcFWC2RJyOyL9MUe/jV0rwjNCi9m1GO.CJBdR5kNLEux4cu', '165165', 'llll');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(34, 'mmmm@q.cl', 'cew', '$2a$10$69r.yw6BMT7iK8ZTJNSS4.fn6XZgtzhOxc9U6PI81tnfIETF6PgfO', '165165', 'mmmm');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(36, 'nnnn@q.cl', 'cew', '$2a$10$LbZsgAXtszr7dD5iiVzLnO33DjSLBVb5Y7163aj7MZsxzuVmiP1eW', '165165', 'nnnn');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(38, '����@q.cl', 'cew', '$2a$10$iCnzrdikk2cNGmkiUtMXM.bIuApLMRkjAL7hdNKC9sPQYdzzbXOgW', '165165', '����');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(40, 'oooo@q.cl', 'cew', '$2a$10$529T8XI2ZM.07CJNwW5w/u1SfKD1gW6KJQX4B.rokQpc.JzSzees2', '165165', 'oooo');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(42, 'pppp@q.cl', 'cew', '$2a$10$h6i3wvuUkqdGJlu7A2acRemnqycoTDFK4e3vyeLY7d4Ong1yupQnK', '165165', 'pppp');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(44, 'qqqq@q.cl', 'cew', '$2a$10$w6m3qCKu5hLK2wMy.6RGde51BNTSVRIPb5gJGXhknvCxecW2FSeHO', '165165', 'qqqq');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(46, 'rrrr@q.cl', 'cew', '$2a$10$Dh0v9HagOPdJQN7pMGJkReSpkYaErWnGYFxtnH2NYkPCYMKqwW2PS', '165165', 'rrrrr');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(48, 'ssss@q.cl', 'cew', '$2a$10$1JfG.ndUAtIyG4nE/377b.FuEwgtwqrgwsu0UnQ8egtTphRy9n3Hu', '165165', 'ssss');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(50, 'tttt@q.cl', 'cew', '$2a$10$RBNjHOmV5UGUI8FIARffturPwNP/r6eYPkxK5OKp1PkogTG6vdcWu', '165165', 'tttt');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(52, 'uuuu@q.cl', 'cew', '$2a$10$UbwmaIBHx1kP056660AsT.iU4amBrHrDsc.PQFd/OxJzlRQlAO5Uu', '165165', 'uuuu');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(54, 'vvvv@q.cl', 'cew', '$2a$10$hu1SOcgC9L9pVywhOfdG.O9Xt0V7i4NCbv3q/2r8DMbtaXJFEVEz6', '165165', 'vvvv');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(56, 'wwww@q.cl', 'cew', '$2a$10$hfb50xZI/qkve6oiD5riNevyEiwFAjqPOdqi/LrzWPNAqD8QPaZGq', '165165', 'wwww');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(58, 'xxxx@q.cl', 'cew', '$2a$10$OR7qXfxHphpmvayZpEFiDuDhgv.YtPY/VUQFkVELkzaRiXjlxVUMm', '165165', 'xxxx');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(60, 'yyyy@q.cl', 'cew', '$2a$10$g7RuFGVU207SdsBK3ItCyOvqgDWEouzJe4yJWjnvseZ4k80tPNJ8q', '165165', 'yyyy');
INSERT INTO users
(id_user, mail, "name", "password", phone, nick_name)
VALUES(62, 'zzzz@q.cl', 'cew', '$2a$10$Le0z5fKlQbm7eI5pp8HIkemxL.2UmzR9rF.KKaG7RrFgPosFoC2du', '165165', 'zzzz');







INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(1, 'cumplea�os', 1.7,  'pos', 'foto', 'skillfut', 3, NULL, NULL, 1);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(3, 'cumplea�os', 1.7,  'pos', 'foto', 'skillfut', 3, NULL, NULL, 2);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(5, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 4);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(11, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 10);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(13, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 12);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(15, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 14);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(17, NULL, 0.0,  NULL, NULL, NULL, 0, NULL, NULL, 16);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(19, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 18);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(21, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 20);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(23, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 22);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(25, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 24);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(27, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 26);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(29, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 28);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(31, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 30);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(33, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 32);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(35, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 34);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(37, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 36);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(39, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 38);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(41, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 40);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(43, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 42);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(45, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 44);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(47, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 46);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(49, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 48);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(51, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 50);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(53, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 52);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(55, NULL, 0.0, NULL, NULL, NULL,  0, NULL, NULL, 54);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(57, NULL, 0.0, NULL, NULL,  NULL, 0, NULL, NULL, 56);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(59, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 58);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(61, NULL, 0.0,  NULL, NULL, NULL, 0, NULL, NULL, 60);
INSERT INTO athletes
(id_athletes, birth_date, height,  "position", profile_photo, skillful_foot, weight, athlete_level, city, id_user)
VALUES(63, NULL, 0.0, NULL,  NULL, NULL, 0, NULL, NULL, 62);







INSERT INTO user_role
(role_id, user_id)
VALUES(1, 1);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 2);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 4);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 10);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 12);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 14);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 16);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 18);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 20);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 22);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 24);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 26);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 28);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 30);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 32);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 34);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 36);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 38);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 40);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 42);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 44);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 46);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 48);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 50);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 52);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 54);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 56);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 58);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 60);
INSERT INTO user_role
(role_id, user_id)
VALUES(1, 62);







INSERT INTO teams
(id_teams, "name", score, id_team_level, id_city)
VALUES(6, 'equipo', 0, 1, 1);
INSERT INTO teams
(id_teams, "name", score, id_team_level, id_city)
VALUES(8, 'equipo 2', 0, 1, 1);

