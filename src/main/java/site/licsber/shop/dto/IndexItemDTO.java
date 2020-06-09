package site.licsber.shop.dto;

import lombok.Data;
import site.licsber.shop.model.entity.ItemCategory;

import java.math.BigDecimal;

@Data
public class IndexItemDTO {

    private Integer id;

    private String title;
    private BigDecimal price;
    private BigDecimal originPrice;

    // 邮费
    private BigDecimal postage;
    private String primaryImg;

    // 0-实物商品 1-电子商品
    private Integer type;

    private ItemCategory category;

}
