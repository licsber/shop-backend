package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.ItemCategory;
import site.licsber.shop.model.entity.ItemImages;
import site.licsber.shop.model.form.ItemAddForm;
import site.licsber.shop.repository.CategoryRepository;
import site.licsber.shop.repository.ItemImagesRepository;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.ItemAddService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemAddServiceImpl implements ItemAddService {

    final private CategoryRepository categoryRepository;
    final private ItemRepository itemRepository;
    final private ItemImagesRepository itemImagesRepository;

    public ItemAddServiceImpl(CategoryRepository categoryRepository,
                              ItemRepository itemRepository,
                              ItemImagesRepository itemImagesRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.itemImagesRepository = itemImagesRepository;
    }

    @Override
    @Transactional
    public Res addItem(ItemAddForm form) {
        Res res = new Res(400, "添加商品失败", null);
        Optional<ItemCategory> category = categoryRepository.findByName(form.getCategoryName());
        if (category.isEmpty()) {
            res.setMsg("商品类别不存在");
        } else if (form.getType() != 0 && form.getType() != 1) {
            res.setMsg("商品类型不合法");
        } else if (!form.getPrimaryImg().startsWith("http")) {
            res.setMsg("主图地址不合法");
        } else {
            if (form.getPrice() == null) {
                form.setPrice(new BigDecimal("1"));
            }
            if (form.getOriginPrice() == null) {
                form.setOriginPrice(new BigDecimal("1"));
            }
            if (form.getPostage() == null) {
                form.setPostage(new BigDecimal("0"));
            }

            Item item = new Item();
            BeanUtils.copyProperties(form, item);
            item.setCategory(category.get());
            item.setState(1);
            item.setStar(0);
            item.setUser(form.getUser());

            itemRepository.save(item);

            List<ItemImages> list = new ArrayList<>();
            for (String img : form.getImgUrls()) {
                ItemImages itemImg = new ItemImages();
                itemImg.setItem(item);
                itemImg.setUrl(img);
                list.add(itemImg);
            }
            itemImagesRepository.saveAll(list);
            res.setCode(200);
            res.setMsg("添加商品成功");
            res.setData(item.getId());
        }
        return res;
    }

}
