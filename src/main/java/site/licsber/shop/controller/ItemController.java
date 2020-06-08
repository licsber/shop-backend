package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.ItemAddForm;
import site.licsber.shop.service.impl.*;

import javax.servlet.http.HttpServletRequest;

@V1RestController
public class ItemController {

    final private GetIndexIndexItemsServiceImpl getItemsService;
    final private GetItemInfoServiceImpl getItemInfoService;
    final private GetAllCategoriesServiceImpl getAllCategoriesService;
    final private GetItemsByCategoryServiceImpl getItemsByCategoryService;
    final private SingleImgUploadServiceImpl singleImgUploadService;
    final private ItemAddServiceImpl itemAddService;

    public ItemController(GetIndexIndexItemsServiceImpl getItemsService,
                          GetItemInfoServiceImpl getItemInfoService,
                          GetAllCategoriesServiceImpl getAllCategoriesService,
                          GetItemsByCategoryServiceImpl getItemsByCategoryService,
                          SingleImgUploadServiceImpl singleImgUploadService,
                          ItemAddServiceImpl itemAddService) {
        this.getItemsService = getItemsService;
        this.getItemInfoService = getItemInfoService;
        this.getAllCategoriesService = getAllCategoriesService;
        this.getItemsByCategoryService = getItemsByCategoryService;
        this.singleImgUploadService = singleImgUploadService;
        this.itemAddService = itemAddService;
    }

    @PostMapping("/itemAdd")
    public Res addItem(@RequestBody ItemAddForm form) {
        System.out.println(form);
        return itemAddService.addItem(form);
    }

    @PostMapping("/imgUpload")
    public Res uploadImg(HttpServletRequest request) {
        Res res = new Res(400, "请求或文件格式不正确", null);
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
            MultipartFile file = req.getFile("file");
            if (file != null) {
                String host = req.getRequestURL()
                        .substring(0, req.getRequestURL().length() -
                                req.getRequestURI().length() + 1);
                return singleImgUploadService.saveImg(file, host);
            }
        }
        return res;
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
