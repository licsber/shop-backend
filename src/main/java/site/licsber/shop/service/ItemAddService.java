package site.licsber.shop.service;

import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.ItemAddForm;

public interface ItemAddService {

    Res addItem(ItemAddForm form);

}
