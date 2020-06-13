package site.licsber.shop.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.Order;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.repository.OrderRepository;
import site.licsber.shop.service.DeliveryService;

import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final ConsumeManualOrderServiceImpl consumeManualOrderService;

    public DeliveryServiceImpl(ItemRepository itemRepository,
                               OrderRepository orderRepository,
                               ConsumeManualOrderServiceImpl consumeManualOrderService) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.consumeManualOrderService = consumeManualOrderService;
    }

    @Override
    public Res delivery(Integer itemId) {
        Res res = new Res(400, "商品还未售出", null);
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isEmpty()) {
            res.setMsg("商品不存在");
        } else {
            Optional<Order> order = orderRepository.findByItem(item.get());
            if (order.isPresent()) {
                Res foo = consumeManualOrderService.consume(order.get());
                BeanUtils.copyProperties(foo, res);
            }
        }
        return res;
    }

}
