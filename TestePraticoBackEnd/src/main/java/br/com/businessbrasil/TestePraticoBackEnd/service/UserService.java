package br.com.businessbrasil.TestePraticoBackEnd.service;

import br.com.businessbrasil.TestePraticoBackEnd.domainmodel.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    /*
        1. Criar um usuário
        2. Listar todos os usuários
        3. Buscar usuário por ID
    */

    User create(User user);
    List<User> findAll();
    User findById(UUID id);
    boolean existsById(UUID id);

}
