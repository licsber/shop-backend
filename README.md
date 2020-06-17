# Shop - 二手商品交易系统

## 项目简介

demo网址：shop.licsber.site

Web课程的大作业，具体要求如下：

商品发布管理子系统功能要求：

1． 二手商品的分类管理

2． 商品入库管理

3． 商品上架、下架管理

商品购买子系统功能要求：

1. 顾客信息注册管理

2． 二手商品信息展示

3． 网上购买及支付管理

4． 顾客留言

最后开发的是一个前后端分离的系统

后端采用SpringBoot+Mysql+Hibernate

前端采用Vue2实现 

用了element-ui（虽然可能有点过时了）

## 部署参数

前端：

图片上传部分接口(MulImgUpload.vue与ImgUpload.vue里的action)

后端接口(main.js中的axios.defaults.baseURL)

后端：

application.yml中

邮件发送部分 smtp服务器与账号密码

图片保存路径与监听端口

## 部署

后端：

1. mvn clean package

2. 拷贝 target下生成的jar到服务端

3. 执行 java -jar XXX.jar即可一键部署

前端：

1. npm install && npm run build

2. 拷贝 dist下生成的static文件夹和index.html文件至服务器

3. 配置静态文件服务器

## 参考nginx配置

```text
server {
    listen 443 ssl;
    server_name shop.licsber.site;
    
    location / {
        root /home/share/dist;
        index index.html;
    }
       
    ssl_certificate /etc/letsencrypt/live/licsber.site/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/licsber.site/privkey.pem;
    include /etc/letsencrypt/options-ssl-nginx.conf;
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem;
}

server {
    listen 443 ssl;
    server_name shop-api.licsber.site;

    location / {
        proxy_pass http://localhost:9999/;
    }

    ssl_certificate /etc/letsencrypt/live/licsber.site/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/licsber.site/privkey.pem;
    include /etc/letsencrypt/options-ssl-nginx.conf;
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem;
}

server {
    if ($host = shop.licsber.site) {
        return 301 https://$host$request_uri;
    }

    server_name shop.licsber.site;
    listen 80;
    return 404;
}
```
