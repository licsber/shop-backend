package site.licsber.shop.dto;

import lombok.Data;
import site.licsber.shop.model.entity.ItemCategory;
import site.licsber.shop.model.entity.ItemImages;

import java.math.BigInteger;
import java.util.List;

@Data
public class FullItemDTO {

    private Integer id;

    private String title;
    private String subtitle;
    private BigInteger price;
    private BigInteger originPrice;

    // 邮费
    private BigInteger postage;
    private String primaryImg;

    private List<ItemImages> imgUrls;
    private String info;

    // 0-实物商品 1-电子商品
    private Integer type;

    // 0-未发布 1-正常上架 2-已卖出
    private Integer state;

    private ItemCategory category;

    private SellerInfoDTO user;

    private Integer star;

}
