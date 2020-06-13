package site.licsber.shop.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.dto.DeliveryDTO;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.Order;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.repository.OrderRepository;
import site.licsber.shop.service.ConsumeOrderService;

@Service
public class ConsumeManualOrderServiceImpl implements ConsumeOrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public ConsumeManualOrderServiceImpl(OrderRepository orderRepository,
                                         ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Res consume(Order order) {
        order.getItem().setState(Item.state.FINISH.getNum());
        itemRepository.save(order.getItem());
        order.setType(Order.type.DELIVERED.getNum());
        orderRepository.save(order);
        DeliveryDTO dto = new DeliveryDTO();
        BeanUtils.copyProperties(order.getBuyer(), dto);
        return Res.builder()
                .code(200)
                .msg("查询买家发货信息成功")
                .data(dto)
                .build();
    }

}
