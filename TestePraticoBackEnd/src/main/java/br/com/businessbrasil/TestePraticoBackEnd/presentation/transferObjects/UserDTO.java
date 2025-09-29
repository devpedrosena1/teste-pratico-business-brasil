package br.com.businessbrasil.TestePraticoBackEnd.presentation.transferObjects;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@Builder
public class UserDTO {

    private UUID id;

    @NotBlank(message = "This field is required.")
    @Size(max = 50, message = "The name must have a maximum of 50 characters")
    private String name;

    @NotBlank(message = "This field is required.")
    @Email(message = "E-mail must be valid.")
    @Size(max = 100, message = "The name must have a maximum of 50 characters")
    private String email;

    @NotNull(message = "This field is required.")
    @PastOrPresent(message = "The creation date cannot be in the future")
    private LocalDate creationDate;

    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .creationDate(user.getCreationDate())
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .creationDate(userDTO.getCreationDate())
                .build();
    }

}
