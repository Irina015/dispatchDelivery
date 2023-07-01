DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS shopping_cart;
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS packages;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS payment;


CREATE TABLE users
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone_number VARCHAR(255),
    email_address VARCHAR(100),
    enabled  TINYINT      NOT NULL DEFAULT 1
);

CREATE TABLE orders
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    sender_address VARCHAR(255),
    sender_city VARCHAR(255),
    sender_state VARCHAR(255),
    sender_email VARCHAR(255),
    sender_phone VARCHAR(255),
    receiver_address VARCHAR(255),
    receiver_city VARCHAR(255),
    receiver_state VARCHAR(255),
    receiver_email VARCHAR(255),
    receiver_phone VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE packages
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    weight VARCHAR(255),
    height VARCHAR(255),
    width VARCHAR(255),
    length VARCHAR(255),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE authorities
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cargo
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    weight VARCHAR(100),
    length VARCHAR(100),
    height VARCHAR(100),
    priority INT,
    shippingFromCoordinate VARCHAR(100),
    shippingToCoordinate VARCHAR(100),
    shipped BOOLEAN DEFAULT FALSE,
    pickup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE shopping_cart
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    delivery_package_id INT NOT NULL,
    quantity INT,
    total_cost DOUBLE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (delivery_package_id) REFERENCES cargo(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE KEY unique_package_and_user_combo (delivery_package_id, user_id)
);

CREATE TABLE payment
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    card_number VARCHAR(100),
    holder_name VARCHAR(100),
    expired_date VARCHAR(100),
    cvv VARCHAR(100),
    billing_address VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    zip_code VARCHAR(100)
);
