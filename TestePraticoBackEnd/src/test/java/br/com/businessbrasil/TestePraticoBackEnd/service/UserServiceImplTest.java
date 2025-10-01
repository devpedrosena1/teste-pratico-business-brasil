package br.com.businessbrasil.TestePraticoBackEnd.service;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;
import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserServiceImplTest {

    private final LocalDate fixedTime = LocalDate.of(2025, 5, 10);

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final UUID userId = UUID.randomUUID();
    private final User testUser = User.builder()
            .id(userId)
            .name("Teste User")
            .email("teste@email.com")
            .creationDate(fixedTime)
            .build();

    @Test
    void whenFindById_shouldReturnUser() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(testUser));
        Optional<User> foundUser = userService.findById(userId);
        assertTrue(foundUser.isPresent(), "Must find user.");
        assertEquals(userId, foundUser.get().getId(), "The ID found must be the same as the one searched.");
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void whenFindAll_shouldReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(List.of());
        List<User> foundUsers = userService.findAll();
        assertTrue(foundUsers.isEmpty(), "Should return an empty list when the DB is empty");
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void whenCreateUser_shouldReturnTheSavedUser() {
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        User newUser = User.builder()
                .name("Novo Usuário")
                .email("novo@teste.com")
                .creationDate(fixedTime)
                .build();

        User createdUser = userService.create(newUser);

        assertNotNull(createdUser, "The user cannot be null");
        assertNotNull(createdUser.getId(), "The returned user must have a generated ID");
        verify(userRepository, times(1)).save(newUser);
    }

}