package br.com.businessbrasil.TestePraticoBackEnd.domainmodel.repositories;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
