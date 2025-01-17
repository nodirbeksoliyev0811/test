package nodirbek.uz.test.controller;

import lombok.RequiredArgsConstructor;
import nodirbek.uz.test.dto.OneResponse;
import nodirbek.uz.test.dto.UserResponse;
import nodirbek.uz.test.entity.UserEntity;
import nodirbek.uz.test.repository.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UsersRepository usersRepository;

    @PostMapping("/add_user")
    public ResponseEntity<OneResponse> addUser(@RequestBody UserResponse response) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(response.getName());
        userEntity.setSurname(response.getSurname());
        usersRepository.save(userEntity);
        return ResponseEntity.ok(new OneResponse("User added", userEntity));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(usersRepository.findAll());
    }
}
