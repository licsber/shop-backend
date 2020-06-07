package site.licsber.shop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String subtitle;
    private BigInteger price;
    private BigInteger originPrice;

    // 邮费
    private BigInteger postage;
    private String primaryImg;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<ItemImages> imgUrls;
    private String info;

    // 0-实物商品 1-电子商品
    private Integer type;

    // 0-未发布 1-正常上架 2-已卖出
    private Integer state;

    @ManyToOne
    private ItemCategory category;

    @ManyToOne
    private User user;

    private Integer star;

}
