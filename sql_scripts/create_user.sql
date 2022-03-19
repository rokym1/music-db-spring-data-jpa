CREATE USER 'rokym'@'localhost' IDENTIFIED BY 'rokym';

GRANT ALL PRIVILEGES ON * . * TO 'rokym'@'localhost';

ALTER USER 'rokym'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rokym';
