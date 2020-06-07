package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.dto.FullItemDTO;
import site.licsber.shop.dto.SellerInfoDTO;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.GetItemInfoService;

import java.util.Optional;

@Slf4j
@Service
public class GetItemInfoServiceImpl implements GetItemInfoService {

    final private ItemRepository itemRepository;

    public GetItemInfoServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Res getItemInfo(Integer id) {
        Res res = new Res();
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            res.setCode(200);
            res.setMsg("获取对象成功");

            FullItemDTO fullItemDTO = new FullItemDTO();
            fullItemDTO.setUser(new SellerInfoDTO());

            BeanUtils.copyProperties(item.get(), fullItemDTO);
            BeanUtils.copyProperties(item.get().getUser(), fullItemDTO.getUser());

            res.setData(fullItemDTO);
        } else {
            res.setCode(400);
            res.setMsg("对象不存在");
        }
        return res;
    }

}
