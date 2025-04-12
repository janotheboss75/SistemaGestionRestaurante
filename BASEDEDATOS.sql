CREATE DATABASE IF NOT EXISTS restaurante;
USE restaurante;

#TRIGGER PARA CAMBIAR EL ESTADO DE UNA MESA SI SE MODIFICA LA COMANDA
DELIMITER $$
DROP TRIGGER IF EXISTS triggerModificarEstadosMesasCuandoSeModificaComanda $$
CREATE TRIGGER triggerModificarEstadosMesasCuandoSeModificaComanda
AFTER UPDATE
ON comandas FOR EACH ROW
BEGIN
	IF NEW.estado = "CANCELADA" OR NEW.estado = "ENTREGADA" OR NEW.idMesa != OLD.idMesa THEN
		UPDATE mesas SET estadomesa = "DISPONIBLE" WHERE idmesa = OLD.idMesa;
        IF NEW.idMesa != OLD.IdMesa THEN
			UPDATE mesas SET estadomesa = "OCUPADA" WHERE idmesa = NEW.idMesa;
		END IF;
	END IF;
END $$
DELIMITER ;


#TRIGGER PARA CUANDO SE INSERTA UNA COMANDA NUEVA , LA MESA ASIGNADA SE PONGA OCUPADA
DELIMITER $$
DROP TRIGGER IF EXISTS triggerModificarEstadosMesasCuandoSeCreaNuevaComanda $$
CREATE TRIGGER triggerModificarEstadosMesasCuandoSeCreaNuevaComanda
AFTER INSERT
ON comandas FOR EACH ROW
BEGIN
	IF NEW.estado = "ABIERTA" THEN
		UPDATE mesas SET estadomesa = "OCUPADA" WHERE idmesa = NEW.idMesa;
	END IF;
END $$
DELIMITER ;

/*
DELIMITER $$
DROP TRIGGER IF EXISTS triggerBajarStockAIngrediente $$
CREATE TRIGGER triggerBajarStockAIngrediente
AFTER INSERT
ON productocomanda FOR EACH ROW
BEGIN
	IF
END $$
DELIMITER ;

SELECT *
FROM productosComandas AS proCom
LEFT JOIN productos AS p ON p.idProducto = proCom.idProducto
LEFT JOIN ingredientesproductos AS ingPro ON ingPro.idProducto = p.idProducto
*/
