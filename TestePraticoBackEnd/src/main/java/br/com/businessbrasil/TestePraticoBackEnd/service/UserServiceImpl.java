package br.com.businessbrasil.TestePraticoBackEnd.service;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;
import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(
                this.userRepository.findAll()
        );
    }

    @Override
    public User findById(UUID id) {
        if (!this.userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found.");
        }
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(UUID id) {
        return this.userRepository.existsById(id);
    }
}
