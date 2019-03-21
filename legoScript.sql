SELECT * FROM legohus.orders;
SELECT * FROM users;
SELECT * FROM lego_type;

INSERT INTO orders VALUES(9,"9999-01-01","SHIPPED",1);

DELETE FROM orders WHERE idorders = 1;

DELETE FROM users WHERE idusers = 999;

UPDATE orders 
                     SET 
                    order_date = "1870-09-09",
                    status =  "CANCELLED", 
                   userIDFK = 0 
                    WHERE idorders = 3;
                    
                    
                    INSERT INTO lego_type (idlego_type, height, width, length, idordersfk)
                    VALUES(3,3,3,4,0);
                    