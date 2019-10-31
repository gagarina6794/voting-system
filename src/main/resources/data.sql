INSERT INTO USERS (name, email, password)
VALUES ('User One', 'user.one@ukr.net', 'password'),
       ('User Two', 'user.two@ukr.net', 'password'),
       ('Admin One', 'admin.one@gmail.com', 'admin'),
       ('Admin Two', 'admin.two@gmail.com', 'admin');

INSERT INTO USER_ROLES (role, user_id)
VALUES ('ROLE_USER', 1),
       ('ROLE_USER', 2),
       ('ROLE_ADMIN', 3),
       ('ROLE_ADMIN', 4);

INSERT INTO RESTAURANTS (name, user_id)
VALUES ('Manhattan-skybar', 3),
       ('Gastro', 3),
       ('Vinograd', 4);

INSERT INTO DISHES (name, price, restaurant_id)
VALUES ('Шатобріан', 99, 1),
       ('Червоний борщ', 38, 1),
       ('Салат з тигровими креветками під кисло-солодким соусом', 146, 1),
       ('Карпаччо з лосося', 99.98, 2),
       ('Салат цезар', 110.50, 2),
       ('Хінкалі з баранини', 97, 3),
       ('Шашлик із телятини', 85, 3),
       ('Курча тапака', 70, 3);

INSERT INTO MENUS (date, restaurant_id)
VALUES ('2019-10-31', 1),
       ('2019-10-31', 2),
       ('2019-10-31', 3),
       ('2019-11-01', 1),
       ('2019-11-01', 2),
       ('2019-11-01', 3);

INSERT INTO MENUS_DISHES (MENU_ID, DISHES_ID)
 VALUES (1, 1),
        (1, 2),
        (2, 4),
        (2, 5),
        (3, 6),
        (3, 7),
        (3, 8),
        (4, 1),
        (4, 2),
        (4, 3),
        (5, 4),
        (5, 5),
        (6, 6),
        (6, 7),
        (6, 8);

INSERT INTO VOTES (date, restaurant_id, user_id)
VALUES ('2019-10-31', 2, 1),
       ('2019-10-31', 3, 2),
       ('2019-11-01', 1, 1),
       ('2019-11-01', 2, 2);