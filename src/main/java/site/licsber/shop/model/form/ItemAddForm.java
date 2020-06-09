package site.licsber.shop.model.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import site.licsber.shop.model.entity.User;

import java.math.BigDecimal;

@Data
public class ItemAddForm {

    private String title;
    private String subtitle;
    private BigDecimal price;
    private BigDecimal originPrice;

    // 邮费
    private BigDecimal postage;
    private String primaryImg;

    private String[] imgUrls;
    private String info;

    // 0-实物商品 1-电子商品
    private Integer type;

    private String categoryName;

    private String userToken;

    @JsonIgnore
    private User user;

}
