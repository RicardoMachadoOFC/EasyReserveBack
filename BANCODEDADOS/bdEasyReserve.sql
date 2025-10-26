SELECT * FROM easyreserve.reserva;


USE easyreserve;
ALTER TABLE reserva
MODIFY COLUMN horario_reserva DATETIME;

DESCRIBE reserva;

SHOW VARIABLES LIKE 'datadir';
