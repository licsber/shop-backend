package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.licsber.shop.model.Res;
import site.licsber.shop.service.GetAllCategoriesService;
import site.licsber.shop.service.impl.GetAllCategoriesServiceImpl;
import site.licsber.shop.service.impl.GetIndexIndexItemsServiceImpl;
import site.licsber.shop.service.impl.GetItemInfoServiceImpl;

@V1RestController
public class ItemController {

    final private GetIndexIndexItemsServiceImpl getItemsService;
    final private GetItemInfoServiceImpl getItemInfoService;
    final private GetAllCategoriesServiceImpl getAllCategoriesService;

    public ItemController(GetIndexIndexItemsServiceImpl getItemsService,
                          GetItemInfoServiceImpl getItemInfoService,
                          GetAllCategoriesServiceImpl getAllCategoriesService) {
        this.getItemsService = getItemsService;
        this.getItemInfoService = getItemInfoService;
        this.getAllCategoriesService = getAllCategoriesService;
    }

    @GetMapping("/indexItem")
    public Res getIndexItems() {
        return getItemsService.getItems();
    }

    @GetMapping("/item/{id}")
    public Res getItemInfo(@PathVariable("id") Integer id) {
        return getItemInfoService.getItemInfo(id);
    }

    @GetMapping("/category")
    public Res getAllCategory() {
        return getAllCategoriesService.getAllCategories();
    }

}
