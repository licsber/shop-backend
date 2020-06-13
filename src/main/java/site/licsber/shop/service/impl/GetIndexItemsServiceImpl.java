package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.licsber.shop.dto.IndexItemDTO;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.GetIndexItemsService;
import site.licsber.shop.utils.DTOMapUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetIndexItemsServiceImpl implements GetIndexItemsService {

    final private ItemRepository itemRepository;

    public GetIndexItemsServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Res getItems() {
        Res res = Res.builder().code(500).msg("未知错误").build();
        List<Item> items = itemRepository.findAllByState(1);
        if (items != null) {
            items = items.stream().filter(i -> i.getState() == 1 && !i.isDel()).collect(Collectors.toList());
            List<IndexItemDTO> indexItemDTOS = DTOMapUtils.parseItemsList(items, IndexItemDTO.class);
            res.setCode(200);
            res.setMsg("获取列表成功");
            res.setData(indexItemDTOS);
        }
        return res;
    }

}
