package com.artur.estoqueapi.controllers.stock;

import com.artur.estoqueapi.domain.dto.stock.UserCreationDto;
import com.artur.estoqueapi.domain.entities.auth.RoleEntity;
import com.artur.estoqueapi.domain.entities.auth.UserEntity;
import com.artur.estoqueapi.repositories.RoleRepository;
import com.artur.estoqueapi.repositories.UserRepository;
import com.artur.estoqueapi.service.stock.RoleService;
import com.artur.estoqueapi.service.stock.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;


    @Transactional
    @PostMapping("/users")
    public ResponseEntity<Void> createNewBasicUser(@RequestBody UserCreationDto newUserDto) {
        UserEntity newUser = userService.createNewBasicUser(newUserDto);
        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public ResponseEntity<List<UserEntity>> listAllUsers() {
        List<UserEntity> usersList = userRepository.findAll();
        return ResponseEntity.ok(usersList);
    }



}
