package site.licsber.shop.service;

import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.LoginForm;

public interface LoginService {

    Res login(LoginForm form);

}
