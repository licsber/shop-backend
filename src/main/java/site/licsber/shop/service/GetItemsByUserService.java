package site.licsber.shop.service;

import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.User;

public interface GetItemsByUserService {

    Res getItemsByUser(User user);

}
