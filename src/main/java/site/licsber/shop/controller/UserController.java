package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.LoginForm;
import site.licsber.shop.model.form.RegisterForm;
import site.licsber.shop.service.impl.LoginServiceImpl;
import site.licsber.shop.service.impl.RegisterServiceImpl;

@V1RestController
public class UserController {

    final private LoginServiceImpl loginService;
    final private RegisterServiceImpl registerService;

    public UserController(LoginServiceImpl loginService, RegisterServiceImpl registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @RequestMapping("/login")
    public Res login(@RequestBody LoginForm form) {
        if (form.getTel().equals("") ||
                form.getPassword().equals("") ||
                form.getTel().length() != 11) {
            return Res.builder()
                    .code(400)
                    .msg("用户输入不合法")
                    .build();
        }
        return loginService.login(form);
    }

    @PostMapping("/register")
    public Res login(@RequestBody RegisterForm form) {
        if (form.getTel().equals("") ||
                form.getPassword().equals("") ||
                form.getTel().length() != 11) {
            return Res.builder()
                    .code(400)
                    .msg("用户输入不合法")
                    .build();
        }
        return registerService.register(form);
    }

}
