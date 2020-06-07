package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.licsber.shop.model.Res;
import site.licsber.shop.service.impl.GetAllCategoriesServiceImpl;
import site.licsber.shop.service.impl.GetIndexIndexItemsServiceImpl;
import site.licsber.shop.service.impl.GetItemInfoServiceImpl;
import site.licsber.shop.service.impl.GetItemsByCategoryServiceImpl;

@V1RestController
public class ItemController {

    final private GetIndexIndexItemsServiceImpl getItemsService;
    final private GetItemInfoServiceImpl getItemInfoService;
    final private GetAllCategoriesServiceImpl getAllCategoriesService;
    final private GetItemsByCategoryServiceImpl getItemsByCategoryService;

    public ItemController(GetIndexIndexItemsServiceImpl getItemsService,
                          GetItemInfoServiceImpl getItemInfoService,
                          GetAllCategoriesServiceImpl getAllCategoriesService,
                          GetItemsByCategoryServiceImpl getItemsByCategoryService) {
        this.getItemsService = getItemsService;
        this.getItemInfoService = getItemInfoService;
        this.getAllCategoriesService = getAllCategoriesService;
        this.getItemsByCategoryService = getItemsByCategoryService;
    }

    @GetMapping("/indexItem")
    public Res getIndexItems() {
        return getItemsService.getItems();
    }

    @GetMapping("/item/{id}")
    public Res getItemInfo(@PathVariable("id") Integer id) {
        return getItemInfoService.getItemInfo(id);
    }

    @GetMapping("/categories")
    public Res getAllCategory() {
        return getAllCategoriesService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Res getItemsByCategory(@PathVariable("id") Integer id) {
        if (id == 0) {
            return getIndexItems();
        }
        return getItemsByCategoryService.getItemsByCategory(id);
    }

}
