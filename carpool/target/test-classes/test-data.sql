INSERT INTO user(id, name, email, mobile, created_at, modified_at, deleted_at) VALUES (1,'Aditya','aditya@practo.com','1111111111', '2016-08-18 12:56:55', null, null)
INSERT INTO user(id, name, email, mobile, created_at, modified_at, deleted_at) VALUES (2,'Ankit','ankit@practo.com','1234567891', '2016-08-18 14:56:55', null, null)
INSERT INTO user(id, name, email, mobile, created_at, modified_at, deleted_at) VALUES (3,'Prashant','prashant@practo.com','1234567894', '2016-08-18 15:56:55', null, null)

INSERT INTO vehicle(id, id_owner, capacity, model, number_plate, created_at, modified_at, deleted_at) VALUES(1, 1, 4, 'Nano', 'Nano2348', '2016-09-18 12:56:55', null, null);
INSERT INTO vehicle(id, id_owner, capacity, model, number_plate, created_at, modified_at, deleted_at) VALUES(2, 1, 4, 'Honda', 'UP16F8598', '2016-10-18 12:56:55', null, null);
INSERT INTO vehicle(id, id_owner, capacity, model, number_plate, created_at, modified_at, deleted_at) VALUES(3, 2, 2, 'Bullet', 'UP16F0203', '2016-10-19 12:56:55', null, null);

INSERT INTO address(id, destination, longitude, latitude, created_at, modified_at, deleted_at) VALUES (1, 'JP Nagar, Banglore', 1.11, 1.22, '2016-09-18 12:56:55', null, null);
INSERT INTO address(id, destination, longitude, latitude, created_at, modified_at, deleted_at) VALUES (2, 'Bannerghatta Road, Banglore', 3.11, 4.22, '2016-09-18 11:56:55', null, null);
INSERT INTO address(id, destination, longitude, latitude, created_at, modified_at, deleted_at) VALUES (3, 'Gopalan Mall, Banglore', 5.11, 4.22, '2016-09-18 11:56:55', null, null);

INSERT INTO source(id, address, nameOffice, created_at, deleted_at, modified_at) VALUES (1, 'Kalyani Magnum Tech Park', 'Practo Mars', '2016-09-18 12:56:55', null, null);
INSERT INTO source(id, address, nameOffice, created_at, deleted_at, modified_at) VALUES (2, 'Gopalan Mall', 'Practo Venus', '2016-09-18 12:56:55', null, null);
INSERT INTO source(id, address, nameOffice, created_at, deleted_at, modified_at) VALUES (3, 'JP Nagar, Banglore', 'Practo Mercuru', '2016-09-18 12:56:55', null, null);