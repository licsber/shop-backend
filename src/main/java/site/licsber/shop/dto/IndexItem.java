package site.licsber.shop.dto;

import lombok.Data;
import site.licsber.shop.model.entity.ItemCategory;

import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Data
public class IndexItem {

    private Integer id;

    private String title;
    private BigInteger price;
    private BigInteger originPrice;

    // 邮费
    private BigInteger postage;
    private String primaryImg;

    // 0-实物商品 1-电子商品
    private Integer type;

    @ManyToOne
    private ItemCategory category;

}
