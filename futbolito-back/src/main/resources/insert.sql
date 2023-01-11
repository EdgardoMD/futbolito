----------------------------------
--------TIPO DE DEPORTES----------
----------------------------------

INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(1, true, 'FOOTBALL');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(2, true, 'FOOTBALL6');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(3, true, 'FOOTBALL5');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(4, true, 'STREET_FOOTBALL');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(5, true, 'INDOOR_FOOTBALL');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(6, false, 'TENNIS');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(7, false, 'PADDLE');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(8, false, 'TABLE_TENNIS');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(9, true, 'HANDBALL');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(10, true, 'BASKETBALL');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(11, true, 'VOLLEYBALL');
INSERT INTO sports_types
(id_sport_type, is_team_sport, sport_type)
VALUES(12, true, 'RUGBY');









----------------------------------
------------ROLES-----------------
----------------------------------

INSERT INTO roles
(id_role, "role")
VALUES(1, 'ATHLETE');


----------------------------------
-----------REGIONES---------
----------------------------------

INSERT INTO regions
(id_region, region)
VALUES(1, 'ohiggins');

----------------------------------


----------------------------------
--------CIUDADES------------------
----------------------------------

INSERT INTO citys
(id_city, city, id_region)
VALUES(1, 'rancagua', 1);

----------------------------------


----------------------------------
-------NIVEL DE EQUIPO------------
----------------------------------

INSERT INTO level_teams
(id_level_teams, "level", required_score)
VALUES(1, 'inicial', 0);
----------------------------------

----------------------------------
----------ESTADO DE INVITACION----
----------------------------------

INSERT INTO status_invitation
(id_status_invitation, status_invitation)
VALUES(3, 'ACCEPTED');
INSERT INTO status_invitation
(id_status_invitation, status_invitation)
VALUES(2, 'REJECTED');
INSERT INTO status_invitation
(id_status_invitation, status_invitation)
VALUES(1, 'CREATED');

----------------------------------

----------------------------------
------TIPO DE NOTIFICACION--------
----------------------------------

INSERT INTO notification_types
(id_notification_types, type_notification)
VALUES(1, 'TEAM_INVITATION');

INSERT INTO notification_types
(id_notification_types, type_notification)
VALUES(2, 'NEW_MEMBER_TEAM');


INSERT INTO notification_types
(id_notification_types, type_notification)
VALUES(3, 'INVITATION_ACCEPTED');
INSERT INTO notification_types
(id_notification_types, type_notification)
VALUES(4, 'INVITATION_REJECTION');
INSERT INTO notification_types
(id_notification_types, type_notification)
VALUES(5, 'NEW_CHALLENGE_TEAM');





----------------------------------

----------------------------------
-----ESTADO DE NOTIFICACION-------
----------------------------------


INSERT INTO status_notification
(id_status_notification, status_notification)
VALUES(1, 'REVISED');
INSERT INTO status_notification
(id_status_notification, status_notification)
VALUES(2, 'SENT');
INSERT INTO status_notification
(id_status_notification, status_notification)
VALUES(3, 'CREATED');
INSERT INTO status_notification
(id_status_notification, status_notification)
VALUES(4, 'VIEW');

----------------------------------
----------------------------------
----------------------------------




















