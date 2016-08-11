/*Q1. define the table stucture for the product categories*/

/*database creation*/
CREATE DATABASE e_commerce;

/*open database*/
USE e_commerce;

/*create product category table*/
CREATE TABLE items(
    product_id CHAR(30),
    product_name VARCHAR(50) NOT NULL,
    parent_product_id CHAR(30),
    PRIMARY KEY (product_id)
);

/*insertion of product details in the items table*/
INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1', 'Mobiles & Tablets', NULL);

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.1', 'Mobiles', '1');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.1.1', 'Smart Phones', '1.1');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.1.2', 'Featured Phones', '1.1');
    
    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.2', 'Tablets', '1');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.2.1', '2G', '1.2');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.2.2', '3G', '1.2');
    
    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.3', 'Accessories', '1');
    
    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('1.4', 'Cases & Covers', '1');




INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2', 'Computers', Null);

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.1', 'Desktop', '2');

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.2', 'Laptop', '2');

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.3', 'Laptop Accessories', '2');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.3.1', 'Keyboard', '2.3');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.3.2', 'Mouse', '2.3');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.3.3', 'Headphones', '2.3');

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.4', 'Printers', '2');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.4.1', 'Inkjet', '2.4');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('2.4.2', 'Laser', '2.4');




INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3', 'Home Appliances', Null);

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.1', 'TVs', '3');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.1.1', 'LED', '3.1');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.1.2', 'LCD', '3.1');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.1.3', 'Plasma', '3.1');

    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.2', 'Air Conditioners', '3');
    
    INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.3', 'Washing Machines', '3');
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.3.1', 'Full Automatic', '3.3');
            INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.3.1.1', 'Top Load', '3.3.1');
            INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.3.1.2', 'Front Load', '3.3.1');
        
        INSERT INTO items(product_id, product_name, parent_product_id) VALUES('3.3.2', 'Semi Automatic', '3.3');
        
        
        
 
/*display the table of products*/
SELECT * FROM items;


/*Q2. display all categories with theirs parent category in sorted manner
and displaying Top Category where parent category is null*/
SELECT i1.product_id, i1.product_name, IFNULL(i2.product_name, "Top Category") AS parent_category
FROM items i1 LEFT JOIN items i2 ON i1.parent_product_id = i2.product_id ORDER BY parent_category;


/*Q3. display only top categories*/
SELECT product_id, product_name AS top_category FROM items WHERE parent_product_id IS NULL;