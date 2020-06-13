package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.dto.IndexItemDTO;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.ItemCategory;
import site.licsber.shop.repository.CategoryRepository;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.GetItemsByCategoryService;
import site.licsber.shop.utils.DTOMapUtils;

import java.util.List;
import java.util.Optional;

@Service
public class GetItemsByCategoryServiceImpl implements GetItemsByCategoryService {

    final private ItemRepository itemRepository;
    final private CategoryRepository categoryRepository;

    public GetItemsByCategoryServiceImpl(ItemRepository itemRepository,
                                         CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Res getItemsByCategory(Integer id) {
        Res res = Res.builder().code(500).msg("未知错误").build();

        Optional<ItemCategory> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            List<Item> items = itemRepository.findAllByCategory(category.get());
            if (items != null) {
                List<IndexItemDTO> indexItemDTOS = DTOMapUtils.parseItemsList(items, IndexItemDTO.class);
                res.setCode(200);
                res.setMsg("获取" + category.get().getName() + "类别列表成功");
                res.setData(indexItemDTOS);
            }
        } else {
            res.setCode(404);
            res.setMsg("所查类别不存在");
        }

        return res;
    }
}
