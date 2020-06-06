package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.LoginForm;
import site.licsber.shop.service.impl.LoginServiceImpl;

@V1RestController
public class UserController {

    final LoginServiceImpl loginService;

    public UserController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("login")
    public Res login(@RequestBody LoginForm form) {
        if (form.getTel().equals("") ||
                form.getPassword().equals("") ||
                form.getTel().length() != 11) {
            return Res.builder()
                    .code(400)
                    .message("用户输入不合法")
                    .build();
        }
        return loginService.login(form);
    }

}
