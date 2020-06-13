package site.licsber.shop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(unique = true, nullable = false, length = 11)
    @JsonIgnore
    private String tel;

    @Column(nullable = false, length = 32)
    @JsonIgnore
    private String password;

    @Column(nullable = false, length = 16)
    private String nick;

    @Column(nullable = false, length = 32)
    private String mail;

    private String sellAddress;

    @JsonIgnore
    private String lastAddress;

    // 0-被封号 1-普通用户 10-管理员
    @JsonIgnore
    private Integer privilege = 1;

    @Column(unique = true)
    @JsonIgnore
    private String token;

    @JsonIgnore
    private Long lastLogin;
    private Long createTime = new Date().getTime();

    private Integer likeNum = 0;

    private Integer disLikeNum = 0;

}
