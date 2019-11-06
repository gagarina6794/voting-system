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

INSERT INTO MENUS (date, restaurant_id)
VALUES ('2019-10-31', 1),
       ('2019-10-31', 2),
       ('2019-10-31', 3),
       ('2019-11-01', 1),
       ('2019-11-01', 2),
       ('2019-11-01', 3);

INSERT INTO DISHES (name, price, menu_id)
VALUES ('Шатобріан', 99, 1),
       ('Червоний борщ', 38, 1),
       ('Салат з тигровими креветками під кисло-солодким соусом', 146, 1),
       ('Карпаччо з лосося', 99.98, 2),
       ('Салат цезар', 110.50, 2),
       ('Хінкалі з баранини', 97, 3),
       ('Шашлик із телятини', 85, 3),
       ('Курча тапака', 70, 3),
       ('Шатобріан', 99, 4),
       ('Червоний борщ', 38, 4),
       ('Салат з тигровими креветками під кисло-солодким соусом', 146, 4),
       ('Карпаччо з лосося', 99.98, 5),
       ('Салат цезар', 110.50, 6),
       ('Хінкалі з баранини', 97, 6),
       ('Курча тапака', 70, 6);

INSERT INTO VOTES (date, restaurant_id, user_id)
VALUES ('2019-10-30', 3, 1),
       ('2019-10-30', 3, 2),
       ('2019-10-31', 2, 1),
       ('2019-10-31', 3, 2),
       ('2019-11-01', 1, 1),
       ('2019-11-01', 2, 2);