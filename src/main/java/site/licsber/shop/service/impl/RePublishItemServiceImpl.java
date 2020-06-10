package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.RePublishItemService;

import java.util.Optional;

@Service
public class RePublishItemServiceImpl implements RePublishItemService {

    public final ItemRepository itemRepository;

    public RePublishItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Res rePublishItem(Integer itemId) {
        Res res = new Res(400, "此id不存在商品", null);
        Optional<Item> item = itemRepository.findById(itemId);
        item.ifPresent(value -> {
            value.setState(Item.state.NORMAL.getNum());
            itemRepository.save(value);
            res.setCode(200);
            res.setMsg("重新上架成功");
        });
        return res;
    }

}
