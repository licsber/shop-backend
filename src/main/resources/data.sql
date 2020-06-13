use shop;


insert into user (last_address, mail, nick, password, tel, privilege, like_num,
                  dis_like_num, sell_address, create_time)
VALUES ('南京市', 'silverwings@foxmail.com', 'licsber', '666', '18952188414', 10, 100, 0, '江苏南京', 1590940800000),
       ('徐州市', 'silverwings@foxmail.com', 'liujl', '666', '17351981730', 1, 100, 100, '江苏徐州', 1590940800000);

update user
set token = 'bcedbf96-0608-4a56-bb87-b0e4178c09cf'
where nick = 'licsber';

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
values ('自用 非全新 \n不讲价 诚信买家来 下面是自定义图片的示例 ![](https://cdn.licsber.site/shop/img/01-1.png)',
        10000, 0, 100, 'https://cdn.licsber.site/shop/img/01.jpg', 1, '风力发电机',
        '来自江苏盐城', 0, 13, 1, 100),
       ('复习资料 下面是自定义图片的示例  ![](https://cdn.licsber.site/shop/img/02.png)', 999, 0, 99,
        'https://cdn.licsber.site/shop/img/02.png', 1, 'Web大作业指导书',
        '程老师出品 必属精品', 1, 1, 2, 888),
       ('T恤', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/03.jpg', 1, '男士T恤',
        '99新 只穿过一次', 0, 12, 2, 666),
       ('实木书架 00年买的', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/04.jpg', 1, '实木书架',
        '绝对实木', 0, 4, 1, 666),
       ('程序员专用', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/05.jpg', 1, '测试衣服',
        '99新 只穿过一次哦', 0, 12, 2, 666),
       ('书架上的书', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/06.jpg', 1, '书籍出售',
        '注意不卖书架哦 只有书', 0, 3, 1, 666),
       ('实物如图', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/07.jpg', 1, '被子枕头三件套',
        '95新哦', 0, 12, 1, 666),
       ('茶几出售', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/08.jpg', 1, '客厅茶几',
        '伊拉克成色', 0, 12, 1, 666),
       ('被子', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/09.jpg', 1, '蚂蚁花被',
        '99新 欢迎选购', 0, 4, 1, 666),
       ('格子被子', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/10.jpeg', 1, '格子被子',
        '家里自用的', 0, 4, 1, 666),
       ('被子', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/09.jpg', 2, '已售出蚂蚁花被测试',
        '99新 欢迎选购', 0, 4, 1, 666),
       ('被子', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/09.jpg', 0, '未发布蚂蚁花被测试',
        '99新 欢迎选购', 0, 4, 1, 666),
       ('茶几出售', 10000, 0, 1000, 'https://cdn.licsber.site/shop/img/08.jpg', 3, '被BAN的客厅茶几测试',
        '伊拉克成色', 0, 12, 1, 666);

update item
set auto_delivery = '2333 这里是自动发货内容'
where id = 2;

insert into item_images (url, item_id)
values ('https://cdn.licsber.site/shop/img/03-1.jpg', 3),
       ('https://cdn.licsber.site/shop/img/03-2.jpg', 3),
       ('https://cdn.licsber.site/shop/img/04-1.jpg', 4),
       ('https://cdn.licsber.site/shop/img/08-1.jpg', 8);

insert into comment (msg, item_id, user_id)
values ('太好了', 2, 1),
       ('是我喜欢的类型', 2, 2);
