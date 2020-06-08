package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.ItemAddForm;
import site.licsber.shop.service.ItemAddService;

@Slf4j
@Service
public class ItemAddServiceImpl implements ItemAddService {

    @Override
    public Res addItem(ItemAddForm form) {
        Res res = new Res(400, "请求表单不完整", null);
        return res;
    }

}
