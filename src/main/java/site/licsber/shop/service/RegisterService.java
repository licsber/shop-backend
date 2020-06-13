package site.licsber.shop.service;

import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.RegisterForm;

public interface RegisterService {

    Res register(RegisterForm form);

}
