package site.licsber.shop.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 12)
    private String name;

}
