package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import site.licsber.shop.model.entity.ItemCategory;

import java.util.List;

public interface CategoryRepository extends CrudRepository<ItemCategory, Integer> {

    List<ItemCategory> findAll();

}
