package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.model.form.LoginForm;
import site.licsber.shop.model.form.LoginFormRes;
import site.licsber.shop.repository.UserRepository;
import site.licsber.shop.service.LoginService;
import site.licsber.shop.utils.TokenUtils;

import java.util.Date;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Res login(LoginForm form) {
        log.info(form.toString());

        Res res = new Res();

        User user = userRepository.findByTel(form.getTel());
        if (user == null) {
            res.setCode(400);
            res.setMsg("用户名不存在");
        } else if (form.getPassword().equals(user.getPassword())) {
            res.setCode(200);
            res.setMsg("登陆成功");
            res.setData(new LoginFormRes(user.getNick(), user.getToken(), user.getLastLogin()));

            user.setToken(TokenUtils.genToken());
            user.setLastLogin(new Date().getTime());
            userRepository.save(user);
        } else {
            res.setCode(400);
            res.setMsg("密码不正确");
        }

        return res;
    }

}
