package site.licsber.shop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString(exclude = "item")
public class ItemImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @ManyToOne
    @JsonIgnore
    private Item item;

}
