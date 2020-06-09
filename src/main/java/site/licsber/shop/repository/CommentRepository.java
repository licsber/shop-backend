package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import site.licsber.shop.model.entity.Comment;
import site.licsber.shop.model.entity.Item;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    Iterable<Comment> findAllByItem(Item item);

}
