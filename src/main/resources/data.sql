-- Insert test data for Chef table
INSERT INTO tbaw_chef (name, specialization, experience_years) VALUES
    ('Chef John', 'Italian Cuisine', 10),
    ('Chef Maria', 'Asian Cuisine', 8),
    ('Chef Alex', 'French Cuisine', 12);

-- Insert test data for Dish table
INSERT INTO tbaw_dish (name, description, price, category, is_Vegetarian) VALUES
    ('Spaghetti Bolognese', 'Classic Italian pasta dish', 12.99, 'Pasta', false),
    ('Sushi Platter', 'Assorted sushi rolls', 22.50, 'Sushi', false),
    ('Coq au Vin', 'Classic French chicken dish', 18.75, 'Main Course', false),
    ('Greek Salad', 'Fresh salad with feta cheese', 8.50, 'Salad', true),
    ('Vegetarian Stir-Fry', 'Assorted vegetables stir-fried', 14.25, 'Main Course', true),
    ('Chocolate Mousse', 'Rich chocolate dessert', 6.99, 'Dessert', false);

-- Insert test data for Order table
INSERT INTO tbaw_order (table_Number, order_Time, status, chef_id, total_Amount) VALUES
    (1, '2023-01-01 12:30:00', 'In Progress', 1, 35.99),
    (2, '2023-01-02 18:45:00', 'Completed', 2, 55.25),
    (3, '2023-01-03 20:00:00', 'Pending', 3, 42.50),
    (4, '2023-01-04 14:15:00', 'Completed', 1, 25.75),
    (5, '2023-01-05 19:30:00', 'In Progress', 2, 32.50),
    (6, '2023-01-06 21:00:00', 'Pending', 3, 18.75),
    (7, '2023-01-07 13:45:00', 'Completed', 1, 45.80);

-- Insert test data for order_dishes (association table)
INSERT INTO tbaw_order_dishes (order_id, dish_id) VALUES
    (1, 1), -- Spaghetti Bolognese for Order 1
    (2, 2), -- Sushi Platter for Order 2
    (3, 3), -- Coq au Vin for Order 3
    (4, 4), -- Greek Salad for Order 4
    (5, 5), -- Vegetarian Stir-Fry for Order 5
    (5, 6), -- Chocolate Mousse for Order 5
    (6, 3), -- Coq au Vin for Order 6
    (7, 2), -- Sushi Platter for Order 7
    (7, 3); -- Coq au Vin for Order 7