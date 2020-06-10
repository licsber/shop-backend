package site.licsber.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.model.form.ItemAddForm;
import site.licsber.shop.model.form.SubmitCommentForm;
import site.licsber.shop.service.impl.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@V1RestController
public class ItemController {

    final private GetIndexIndexItemsServiceImpl getItemsService;
    final private GetItemInfoServiceImpl getItemInfoService;
    final private GetAllCategoriesServiceImpl getAllCategoriesService;
    final private GetItemsByCategoryServiceImpl getItemsByCategoryService;
    final private SingleImgUploadServiceImpl singleImgUploadService;
    final private ItemAddServiceImpl itemAddService;
    final private CheckUserTokenServiceImpl checkUserTokenService;
    final private GetCommentsServiceImpl getCommentsService;
    final private SubmitCommentServiceImpl submitCommentService;
    final private GetItemsByUserServiceImpl getItemsByUserService;
    final private UnPublishItemServiceImpl unPublishItemService;
    final private RePublishItemServiceImpl rePublishItemService;

    public ItemController(GetIndexIndexItemsServiceImpl getItemsService,
                          GetItemInfoServiceImpl getItemInfoService,
                          GetAllCategoriesServiceImpl getAllCategoriesService,
                          GetItemsByCategoryServiceImpl getItemsByCategoryService,
                          SingleImgUploadServiceImpl singleImgUploadService,
                          ItemAddServiceImpl itemAddService,
                          CheckUserTokenServiceImpl checkUserTokenService,
                          GetCommentsServiceImpl getCommentsService,
                          SubmitCommentServiceImpl submitCommentService,
                          GetItemsByUserServiceImpl getItemsByUserService,
                          UnPublishItemServiceImpl unPublishItemService,
                          RePublishItemServiceImpl rePublishItemService) {
        this.getItemsService = getItemsService;
        this.getItemInfoService = getItemInfoService;
        this.getAllCategoriesService = getAllCategoriesService;
        this.getItemsByCategoryService = getItemsByCategoryService;
        this.singleImgUploadService = singleImgUploadService;
        this.itemAddService = itemAddService;
        this.checkUserTokenService = checkUserTokenService;
        this.getCommentsService = getCommentsService;
        this.submitCommentService = submitCommentService;
        this.getItemsByUserService = getItemsByUserService;
        this.unPublishItemService = unPublishItemService;
        this.rePublishItemService = rePublishItemService;
    }

    @PutMapping("/rePublishItem/{itemId}")
    public Res rePublishItem(@PathVariable("itemId") Integer itemId) {
        return rePublishItemService.rePublishItem(itemId);
    }

    @PutMapping("/unPublishItem/{itemId}")
    public Res unPublishItem(@PathVariable("itemId") Integer itemId) {
        System.out.println(itemId);
        return unPublishItemService.unPublishItem(itemId);
    }

    @GetMapping("/userItems")
    public Res getUserItems(HttpServletRequest request) {
        return getItemsByUserService.getItemsByUser((User) request.getAttribute("user"));
    }

    @PostMapping("/comment")
    public Res submitComment(@RequestBody SubmitCommentForm submitCommentForm,
                             HttpServletRequest request) {
        if ("".equals(submitCommentForm.getMsg())) {
            return Res.builder().code(400).msg("评论不能为空").build();
        }
        submitCommentForm.setUser((User) request.getAttribute("user"));
        return submitCommentService.submitComment(submitCommentForm);
    }

    @GetMapping("/comments/{itemId}")
    public Res getComments(@PathVariable("itemId") Integer itemId) {
        return getCommentsService.getComments(itemId);
    }

    @PostMapping("/itemAdd")
    public Res addItem(@RequestBody ItemAddForm form) {
        log.info(form.toString());
        Res res = new Res(400, "控制层校验不通过", null);
        if (form.getUserToken() == null || "".equals(form.getUserToken())) {
            res.setMsg("非法请求，需附带userToken");
        } else {
            User user = checkUserTokenService.valid(form.getUserToken());
            if (user == null) {
                res.setCode(401);
                res.setMsg("用户已在别地登陆");
            } else if (form.getTitle() == null || "".equals(form.getTitle())) {
                res.setMsg("商品标题不能为空");
            } else if (form.getPrimaryImg() == null || "".equals(form.getPrimaryImg())) {
                res.setMsg("商品主图不能为空");
            } else if (form.getInfo() == null || "".equals(form.getInfo())) {
                res.setMsg("商品描述不能为空");
            } else if (form.getType() == null) {
                res.setMsg("商品类型不能为空");
            } else if (form.getCategoryName() == null || "".equals(form.getCategoryName())) {
                res.setMsg("商品类别不能为空");
            } else {
                form.setUser(user);
                return itemAddService.addItem(form);
            }
        }
        return res;
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
