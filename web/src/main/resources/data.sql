INSERT INTO app_user (username, password, role) VALUES ('stefan', '123', 'ADMIN');
INSERT INTO app_user (username, password, role) VALUES ('manu', '123', 'STUFF');
INSERT INTO app_user (username, password, role) VALUES ('alex', '123', 'CLIENT');

INSERT INTO hotel (name,stars) VALUES ('Ozana',3);
INSERT INTO hotel (name,stars) VALUES ('Meriott',5);

INSERT INTO room (room_type,hotel_id) VALUES 
        ('SINGLE',1),
        ('SINGLE',1),
        ('DOUBLE',1),
        ('HOUSE',2),
        ('SINGLE',2),
        ('DOUBLE',2),
        ('DOUBLE',1);

INSERT INTO reservation (room_id,user_id, payment_type, price) VALUES 
        (1,3, 'CASH', 345),
        (4,3, 'CARD', 250);