package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.repository.UserRepository;
import site.licsber.shop.service.CheckUserTokenService;

import java.util.Optional;

@Service
public class CheckUserTokenServiceImpl implements CheckUserTokenService {

    final private UserRepository userRepository;

    public CheckUserTokenServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User valid(String userToken) {
        Optional<User> user = userRepository.findByToken(userToken);
        return user.orElse(null);
    }

}
