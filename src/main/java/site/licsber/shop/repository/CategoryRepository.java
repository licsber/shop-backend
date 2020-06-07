package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import site.licsber.shop.model.entity.ItemCategory;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<ItemCategory, Integer> {

    List<ItemCategory> findAll();

    Optional<ItemCategory> findById(Integer id);

}
