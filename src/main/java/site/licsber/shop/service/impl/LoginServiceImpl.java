package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.LoginForm;
import site.licsber.shop.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public Res login(LoginForm form) {
        if (form.getTel().equals("123") && form.getPassword().equals("123")) {
            return Res.builder()
                    .code(200)
                    .message("登陆成功")
                    .build();
        }
        return Res.builder()
                .code(400)
                .message("密码不正确")
                .build();
    }

}
