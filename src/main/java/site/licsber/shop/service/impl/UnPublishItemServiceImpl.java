package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.UnPublishItemService;

import java.util.Optional;

@Service
public class UnPublishItemServiceImpl implements UnPublishItemService {

    public final ItemRepository itemRepository;

    public UnPublishItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Res unPublishItem(Integer itemId) {
        Res res = new Res(400, "此id不存在商品", null);
        Optional<Item> item = itemRepository.findById(itemId);
        item.ifPresent(value -> {
            value.setState(Item.state.UNPUBLISHED.getNum());
            itemRepository.save(value);
            res.setCode(200);
            res.setMsg("下架成功");
        });
        return res;
    }

}
