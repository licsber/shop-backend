package site.licsber.shop.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 11)
    private String tel;

    @Column(nullable = false, length = 32)
    private String password;

    @Column(nullable = false, length = 16)
    private String nick;

    @Column(nullable = false, length = 32)
    private String mail;

    private String lastAddress;

    // 0-被封号 1-普通用户 10-管理员
    private Integer privilege;

    private String token;

    private Long lastLogin;

}
