package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.licsber.shop.model.entity.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Override
    List<Item> findAll();

    List<Item> findAllByState(Integer state);

    Optional<Item> findById(Integer id);

    List<Item> findAllByCategory(String category);

}
