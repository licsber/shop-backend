package site.licsber.shop.model.form;

import lombok.Data;

@Data
public class RegisterForm {

    private String tel;
    private String password;
    private String nick;
    private String mail;
    private String sellAddress;
    private String lastAddress;

}
