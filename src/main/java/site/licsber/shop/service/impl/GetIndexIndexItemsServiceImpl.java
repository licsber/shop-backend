package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.dto.IndexItem;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.GetIndexItemsService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GetIndexIndexItemsServiceImpl implements GetIndexItemsService {

    final ItemRepository itemRepository;

    public GetIndexIndexItemsServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Res getItems() {
        Res res = Res.builder().code(500).msg("未知错误").build();
        List<Item> items = itemRepository.findAllByState(1);
        List<IndexItem> indexItems = new ArrayList<>();
        if (items != null) {
            for (Item item : items) {
                IndexItem indexItem = new IndexItem();
                BeanUtils.copyProperties(item, indexItem);
                indexItems.add(indexItem);
            }
            res.setCode(200);
            res.setMsg("获取列表成功");
            res.setData(indexItems);
        }
        return res;
    }

}
