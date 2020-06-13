package site.licsber.shop.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.Order;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.repository.OrderRepository;
import site.licsber.shop.service.BuyItemService;

import java.util.Optional;

@Service
public class BuyItemServiceImpl implements BuyItemService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final ConsumeAutoOrderServiceImpl consumeAutoOrderService;

    public BuyItemServiceImpl(ItemRepository itemRepository,
                              OrderRepository orderRepository,
                              ConsumeAutoOrderServiceImpl consumeAutoOrderService) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.consumeAutoOrderService = consumeAutoOrderService;
    }

    @Override
    public Res buyItem(Integer itemId, User buyer) {
        Res res = new Res(400, "所选商品不存在", null);
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            Order order = new Order();
            order.setItem(item.get());
            order.setBuyer(buyer);
            if (item.get().getType() == Item.type.REAL.getNum()) {
                if (item.get().getState() == Item.state.SOLD_OUT.getNum()) {
                    res.setCode(400);
                    res.setMsg("手慢了 商品已售出");
                } else {
                    orderRepository.save(order);
                    item.get().setState(Item.state.SOLD_OUT.getNum());
                    itemRepository.save(item.get());
                    res.setCode(200);
                    res.setMsg("购买成功 请等待卖家发货");
                }
            } else {
                Res auto = consumeAutoOrderService.consume(order);
                BeanUtils.copyProperties(auto, res);
            }
        }
        return res;
    }

}
