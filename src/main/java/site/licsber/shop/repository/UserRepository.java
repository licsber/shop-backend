package site.licsber.shop.repository;

import org.springframework.data.repository.CrudRepository;
import site.licsber.shop.model.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByTel(String tel);

    @Override
    <S extends User> S save(S s);

    Optional<User> findByToken(String token);

}
