package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Order;
import site.licsber.shop.repository.OrderRepository;
import site.licsber.shop.service.ConsumeOrderService;

@Service
public class ConsumeAutoOrderServiceImpl implements ConsumeOrderService {

    private final OrderRepository orderRepository;
    private final SendMailServiceImpl sendMailService;

    public ConsumeAutoOrderServiceImpl(OrderRepository orderRepository,
                                       SendMailServiceImpl sendMailService) {
        this.orderRepository = orderRepository;
        this.sendMailService = sendMailService;
    }

    @Override
    public Res consume(Order order) {
        Res res = new Res(400, "自动发货失败", null);
        String to = order.getBuyer().getMail();
        String subject = order.getItem().getTitle();
        String content = order.getItem().getAutoDelivery();
        boolean foo = sendMailService.sendSimpleMail(to, subject, content);
        if (foo) {
            order.setType(Order.type.AUTO.getNum());
            orderRepository.save(order);
            res.setCode(200);
            res.setMsg("自动发货成功");
        } else {
            order.setType(Order.type.AUTO_FAIL.getNum());
            orderRepository.save(order);
            res.setMsg("自动发货失败");
        }
        return res;
    }

}
