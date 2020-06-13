package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.entity.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Override
    <S extends Order> S save(S s);

    Optional<Order> findByItem(Item item);

}
