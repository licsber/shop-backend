package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import site.licsber.shop.model.entity.ItemImages;

public interface ItemImagesRepository extends CrudRepository<ItemImages, Integer> {

    @Override
    <S extends ItemImages> Iterable<S> saveAll(Iterable<S> iterable);

}
