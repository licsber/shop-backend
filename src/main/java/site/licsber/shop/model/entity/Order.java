package site.licsber.shop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_info")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private User buyer;

    private Long createTime = new Date().getTime();

    // 0-未发货 1-已自动发货 2-已发货（运送途中）
    // 3-待评价 4-订单完成（买家确认） 5-订单关闭（退款等）
    // 6-自动发货失败
    private Integer type = 0;

    public enum type {
        WAIT_DELIVERY(0),
        AUTO(1),
        DELIVERED(2),
        WAIT_COMMENT(3),
        FINISH(4),
        CLOSE(5),
        AUTO_FAIL(6);

        private final int num;

        public int getNum() {
            return num;
        }

        type(int i) {
            num = i;
        }
    }

}
