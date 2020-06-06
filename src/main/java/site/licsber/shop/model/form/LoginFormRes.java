package site.licsber.shop.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginFormRes {

    private String nick;
    private String token;
    private Long lastLogin;

}
