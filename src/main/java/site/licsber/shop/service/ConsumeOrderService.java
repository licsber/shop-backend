package site.licsber.shop.service;

import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Order;

public interface ConsumeOrderService {

    Res consume(Order order);

}
