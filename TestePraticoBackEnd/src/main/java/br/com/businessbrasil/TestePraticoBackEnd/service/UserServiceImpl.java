package br.com.businessbrasil.TestePraticoBackEnd.service;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;
import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public Optional<User> findById(UUID id) {
        return this.userRepository.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return this.userRepository.existsById(id);
    }
}
