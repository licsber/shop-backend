package site.licsber.shop.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.model.form.RegisterForm;
import site.licsber.shop.repository.UserRepository;
import site.licsber.shop.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

    final private UserRepository userRepository;

    public RegisterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Res register(RegisterForm form) {
        Res res = new Res(400, "此用户已存在", null);
        if (userRepository.findByTel(form.getTel()) == null) {
            User user = new User();
            BeanUtils.copyProperties(form, user);
            user = userRepository.save(user);
            res.setCode(200);
            res.setMsg("添加用户成功");
            res.setData(user.getId());
        }
        return res;
    }

}
