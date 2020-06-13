package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.dto.UserItemDTO;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.GetItemsByUserService;
import site.licsber.shop.utils.DTOMapUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetItemsByUserServiceImpl implements GetItemsByUserService {

    final private ItemRepository itemRepository;

    public GetItemsByUserServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Res getItemsByUser(User user) {
        Res res = new Res(400, "用户存在异常", null);
        List<Item> items = itemRepository.findAllByUser(user);
        if (items != null) {
            items = items.stream().filter(i -> !i.isDel()).collect(Collectors.toList());
            List<UserItemDTO> userItemDTOS = DTOMapUtils.parseItemsList(items, UserItemDTO.class);
            res.setCode(200);
            res.setMsg("获取用户发布商品列表成功");
            res.setData(userItemDTOS);
        }
        return res;
    }

}
