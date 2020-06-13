package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.DelItemService;

import java.util.Optional;

@Service
public class DelItemServiceImpl implements DelItemService {

    final private ItemRepository itemRepository;

    public DelItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Res delItem(Integer itemId) {
        Res res = new Res(400, "此id不存在商品", null);
        Optional<Item> item = itemRepository.findById(itemId);
        item.ifPresent(value -> {
            value.setDel(true);
            itemRepository.save(value);
            res.setCode(200);
            res.setMsg("删除商品成功");
        });
        return res;
    }

}
