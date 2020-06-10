package site.licsber.shop.utils;

import org.springframework.beans.BeanUtils;
import site.licsber.shop.model.entity.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DTOMapUtils {

    public static <T> List<T> parseItemsList(List<Item> list, Class<T> tClass) {
        List<T> dtos = new ArrayList<>();
        for (Item item : list) {
            T dto = null;
            try {
                dto = tClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                return null;
            }
            BeanUtils.copyProperties(item, dto);
            dtos.add(dto);
        }
        return dtos;
    }

}
