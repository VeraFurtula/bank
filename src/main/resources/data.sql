INSERT INTO users (first_name, last_name, address, city, zip_code, phone, email) VALUES
                                                                                     ('John', 'Doe', '123 Main St', 'New York', '10001', '123-456-7890', 'john.doe@example.com'),
                                                                                     ('Jane', 'Smith', '456 Oak St', 'Los Angeles', '90001', '987-654-3210', 'jane.smith@example.com'),
                                                                                     ('Alice', 'Johnson', '789 Maple Ave', 'Chicago', '60601', '555-123-4567', 'alice.johnson@example.com'),
                                                                                     ('Bob', 'Williams', '101 Pine St', 'San Francisco', '94101', '555-234-5678', 'bob.williams@example.com'),
                                                                                     ('Charlie', 'Brown', '202 Elm St', 'Seattle', '98101', '555-345-6789', 'charlie.brown@example.com'),
                                                                                     ('Diana', 'Prince', '303 Cedar St', 'Houston', '77001', '555-456-7890', 'diana.prince@example.com'),
                                                                                     ('Eve', 'Adams', '404 Spruce St', 'Phoenix', '85001', '555-567-8901', 'eve.adams@example.com'),
                                                                                     ('Frank', 'Miller', '505 Birch St', 'Philadelphia', '19101', '555-678-9012', 'frank.miller@example.com'),
                                                                                     ('Grace', 'Lee', '606 Walnut St', 'Dallas', '75201', '555-789-0123', 'grace.lee@example.com'),
                                                                                     ('Henry', 'Wilson', '707 Ash St', 'Boston', '02101', '555-890-1234', 'henry.wilson@example.com');

INSERT INTO accounts (account_number, balance, user_id) VALUES
('1234567890', 1000.0, 1),

('0987654321', 2000.0, 2),
('1122334455', 1500.0, 2),

('2233445566', 2500.0, 3),
('3344556677', 3000.0, 3),
('4455667788', 3500.0, 3),

('5566778899', 1200.0, 4),

('6677889900', 1800.0, 5),
('7788990011', 2200.0, 5),

('8899001122', 2700.0, 6),
('9900112233', 3200.0, 6),
('0011223344', 3700.0, 6),

('1122334455', 1600.0, 7),

('2233445566', 2100.0, 8),
('3344556677', 2600.0, 8),

('4455667788', 3100.0, 9),

('5566778899', 3600.0, 10),
('6677889900', 4100.0, 10),
('7788990011', 4600.0, 10);