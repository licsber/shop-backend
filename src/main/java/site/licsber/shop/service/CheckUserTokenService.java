package site.licsber.shop.service;

import site.licsber.shop.model.entity.User;

public interface CheckUserTokenService {

    User valid(String userToken);

}
