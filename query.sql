ALTER TABLE orders
    ADD CONSTRAINT fk_orders_customers FOREIGN KEY (userid) REFERENCES users (id);


ALTER TABLE products
    ADD CONSTRAINT fk_products_customers FOREIGN KEY (userid) REFERENCES users (id);