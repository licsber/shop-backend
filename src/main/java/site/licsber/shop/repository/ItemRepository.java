package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.ItemCategory;
import site.licsber.shop.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Override
    List<Item> findAll();

    List<Item> findAllByState(Integer state);

    Optional<Item> findById(Integer id);

    List<Item> findAllByCategory(ItemCategory category);

    List<Item> findAllByUser(User user);

}
