package br.com.businessbrasil.TestePraticoBackEnd.presentation.controller;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;
import br.com.businessbrasil.TestePraticoBackEnd.presentation.transferObjects.UserDTO;
import br.com.businessbrasil.TestePraticoBackEnd.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "Users", description = "User operations")
public class UserApiController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = this.userService.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") UUID id) {
        return this.userService.findById(id)
                .map(user -> ResponseEntity.ok(UserDTO.fromEntity(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        User newUser = this.userService.create(UserDTO.toEntity(userDTO));
        return ResponseEntity.ok(UserDTO.fromEntity(newUser));
    }

}
