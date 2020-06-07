use shop;


insert into user (last_address, mail, nick, password, tel, privilege, like_num,
                  dis_like_num, sell_address, create_time)
VALUES ('南京市', 'silverwings@foxmail.com', 'licsber', '666', '18952188414', 10, 100, 0, '江苏南京', 1590940800000),
       ('徐州市', 'silverwings@foxmail.com', 'liujl', '666', '17351981730', 1, 100, 100, '江苏徐州', 1590940800000);

insert into wallet (balance, type, user_id)
VALUES (100, 10, 1),
       (100, 10, 2);

insert into item_category (name)
values ('电子资料'),
       ('上课教材'),
       ('课外辅导书'),
       ('宿舍用品'),
       ('电子产品'),
       ('食品饮料'),
       ('五金工具'),
       ('宠物/用品'),
       ('动漫/周边'),
       ('奢侈品'),
       ('代步工具'),
       ('衣服'),
       ('其他闲置');

insert into item (info, origin_price, postage, price, primary_img,
                  state, title, subtitle, type, category_id, user_id, star)
values ('自用 非全新 \n不讲价 诚信买家来 !()[https://static.licsber.site/shop/img/01.jpg]',
        10000, 0, 100, 'https://static.licsber.site/shop/img/01.jpg', 1, '风力发电机',
        '来自江苏盐城', 0, 13, 1, 100),
       ('复习资料 !()[https://static.licsber.site/shop/img/02.png]', 999, 0, 99,
        'https://static.licsber.site/shop/img/02.png', 1, 'Web大作业指导书',
        '程老师出品 必属精品', 1, 1, 1, 888),
       ('T恤', 10000, 0, 1000, 'https://static.licsber.site/shop/img/03.jpg', 1, '男士T恤',
        '99新 只穿过一次', 0, 12, 1, 666);

insert into item_images (url, item_id)
values ('https://static.licsber.site/shop/img/04.jpg', 3),
       ('https://static.licsber.site/shop/img/05.jpg', 3),
       ('https://static.licsber.site/shop/img/06.jpg', 3);

