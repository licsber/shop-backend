package site.licsber.shop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "boolean default false")
    private boolean isDel;

    private String title;
    private String subtitle;
    private BigDecimal price;
    private BigDecimal originPrice;

    // 邮费
    private BigDecimal postage;
    private String primaryImg;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<ItemImages> imgUrls;
    private String info;

    // 0-实物商品 1-电子商品
    private Integer type;

    public enum type {
        REAL,
        VIRTUAL
    }

    // 0-未发布 1-正常上架 2-已卖出
    private Integer state;

    public enum state {
        UNPUBLISHED(0),
        NORMAL(1),
        SOLD_OUT(2),
        BAN(3);

        private final int num;

        public int getNum() {
            return num;
        }

        state(int i) {
            num = i;
        }
    }

    @ManyToOne
    private ItemCategory category;

    @ManyToOne
    private User user;

    private Integer star;

}
