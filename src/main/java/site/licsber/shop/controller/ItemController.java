package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import site.licsber.shop.model.Res;
import site.licsber.shop.service.impl.GetIndexIndexItemsServiceImpl;
import site.licsber.shop.service.impl.GetItemInfoServiceImpl;

@V1RestController
public class ItemController {

    final private GetIndexIndexItemsServiceImpl getItemsService;
    final private GetItemInfoServiceImpl getItemInfoService;

    public ItemController(GetIndexIndexItemsServiceImpl getItemsService,
                          GetItemInfoServiceImpl getItemInfoService) {
        this.getItemsService = getItemsService;
        this.getItemInfoService = getItemInfoService;
    }

    @GetMapping("/indexItem")
    public Res getIndexItems() {
        return getItemsService.getItems();
    }

    @GetMapping("/item")
    public Res getItemInfo() {
        return getItemInfoService.getItemInfo();
    }

}