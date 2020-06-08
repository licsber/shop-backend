package site.licsber.shop.model.form;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ItemAddForm {

    private String title;
    private String subtitle;
    private BigInteger price;
    private BigInteger originPrice;

    // 邮费
    private BigInteger postage;
    private String primaryImg;

    private String[] imgUrls;
    private String info;

    // 0-实物商品 1-电子商品
    private Integer type;

    private String categoryName;

    private String userToken;

}
