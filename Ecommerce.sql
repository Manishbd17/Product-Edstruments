
--Relational database schema for an E-commerce platform. 



-- Users Table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(15),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Products Table
CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
);

-- Orders Table
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    status ENUM('Pending', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',
    total_price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Order_Items Table
CREATE TABLE Order_Items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Products(product_id) ON DELETE CASCADE
);

-- Insert statements for Users Table
INSERT INTO Users (username, email, phone_number, address) VALUES
('User 1 ', 'user1@example.com', '8934567890', '123 Main St'),
('User 2', 'user2@example.com', '0987654321', '456 Elm St');

-- Insert statements for Products Table
INSERT INTO Products (name, description, price, stock_quantity) VALUES
('Laptop', 'High-performance laptop', 999.99, 50),
('Smartphone', 'Latest model smartphone', 699.99, 100),
('Headphones', 'Noise-cancelling headphones', 199.99, 75);

-- Insert statements for Orders Table
INSERT INTO Orders (user_id, status, total_price) VALUES
(1, 'Pending', 1199.98),
(2, 'Shipped', 899.98);

-- Insert statements for Order_Items Table
INSERT INTO Order_Items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 999.99),
(1, 3, 1, 199.99),
(2, 2, 1, 699.99),
(2, 3, 1, 199.99);