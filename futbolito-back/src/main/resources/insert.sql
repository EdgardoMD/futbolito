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




















