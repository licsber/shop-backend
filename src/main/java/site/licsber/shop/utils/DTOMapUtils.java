package site.licsber.shop.utils;

import org.springframework.beans.BeanUtils;
import site.licsber.shop.dto.IndexItemDTO;
import site.licsber.shop.model.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class DTOMapUtils {

    public static List<IndexItemDTO> parseItemsList(List<Item> list) {
        List<IndexItemDTO> indexItemDTOS = new ArrayList<>();
        for (Item item : list) {
            IndexItemDTO indexItemDTO = new IndexItemDTO();
            BeanUtils.copyProperties(item, indexItemDTO);
            indexItemDTOS.add(indexItemDTO);
        }
        return indexItemDTOS;
    }

}
