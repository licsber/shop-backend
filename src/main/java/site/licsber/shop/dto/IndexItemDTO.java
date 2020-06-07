package site.licsber.shop.dto;

import lombok.Data;
import site.licsber.shop.model.entity.ItemCategory;

import java.math.BigInteger;

@Data
public class IndexItemDTO {

    private Integer id;

    private String title;
    private BigInteger price;
    private BigInteger originPrice;

    // 邮费
    private BigInteger postage;
    private String primaryImg;

    // 0-实物商品 1-电子商品
    private Integer type;

    private ItemCategory category;

}
