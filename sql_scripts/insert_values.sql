INSERT INTO `artist_detail` VALUES 
(1,'http://www.depechemode.com/','https://www.facebook.com/depechemode','https://www.instagram.com/depechemode/'),
(2,'https://www.u2.com/','https://www.facebook.com/u2','https://instagram.com/u2'),
(3,'https://kraftwerk.com/','https://www.facebook.com/Kraftwerk','https://www.instagram.com/kraftwerkofficial/');

INSERT INTO `artist` VALUES 
(1,'Depeche Mode',1), (2,`U2`,2), (3,`Kraftwerk`,3);

INSERT INTO `album` VALUES 
(1,'Violator',1), (2,'Music For The Masses',1), (3,'Under a Blood Red Sky',2), (4,'The Man-Machine',3);

INSERT INTO `song` VALUES 
(1,'The Model',3,4), (2,'Gloria',2,3), (3,'Sunday Bloody Sunday',2,3), (4,'Never Let Me Down Again',1,2),
(5,'Behind the Wheel',1,2), (6,'World in My Eyes',1,1), (7,'Enjoy the Silence',1,1);

INSERT INTO `genre` VALUES
(1,'new wave'), (2,'electronic rock'), (3,'rock'), (4,'alternative rock'), (5,'electronic'), (6,'synth-pop');

INSERT INTO `artist_genre` VALUES 
(1,1), (1,2), (1,5), (1,6), (2,1), (2,3), (2,4), (3,5), (3,6);



