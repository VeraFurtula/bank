-- Alternativno, ako koristite tabelu `users` umesto `user`, koristite sledeći unos:
INSERT INTO users (first_name, last_name, address, city, zip_code, phone, email) VALUES
('John', 'Doe', '123 Main St', 'New York', '10001', '123-456-7890', 'john.doe@example.com'),
('Jane', 'Smith', '456 Oak St', 'Los Angeles', '90001', '987-654-3210', 'jane.smith@example.com');

-- Popunjavanje tabele account ili accounts
-- Prilikom popunjavanja računa, pretpostaviću da su `user_id` vrednosti odgovarajuće korisnicima iz tabele user ili users.



-- Alternativno, ako koristite tabelu `accounts` umesto `account`, koristite sledeći unos:
INSERT INTO accounts (account_number, balance, user_id) VALUES
('1234567890', 1000.0, 1),
('0987654321', 2000.0, 2);