package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.ItemCategory;
import site.licsber.shop.repository.CategoryRepository;
import site.licsber.shop.service.GetAllCategoriesService;

import java.util.List;

@Slf4j
@Service
public class GetAllCategoriesServiceImpl implements GetAllCategoriesService {

    final private CategoryRepository categoryRepository;

    public GetAllCategoriesServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Res getAllCategories() {
        Res res = new Res(400, "数据库查询失败", null);
        List<ItemCategory> categories = categoryRepository.findAll();
        if (categories != null) {
            res.setCode(200);
            res.setMsg("查询成功");
            res.setData(categories);
        }
        return res;
    }

}
