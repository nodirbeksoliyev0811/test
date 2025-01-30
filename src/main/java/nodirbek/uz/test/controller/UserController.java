package nodirbek.uz.test.controller;

import lombok.RequiredArgsConstructor;
import nodirbek.uz.test.dto.MessageResponse;
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

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        if (usersRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(usersRepository.findById(id));
        } else {
            return ResponseEntity.ok(new MessageResponse("User not found"));
        }
    }

    @PostMapping("/update_user")
    public ResponseEntity<MessageResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserResponse response) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.updateById(response.getName(), response.getSurname(), response.getId());
            return ResponseEntity.ok(new MessageResponse("User updated"));
        } else {
            return ResponseEntity.ok(new MessageResponse("User not found"));
        }
    }

    @DeleteMapping("/delete_user")
    public ResponseEntity<MessageResponse> deleteUser(@RequestParam("id") Long id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("User deleted"));
        } else {
            return ResponseEntity.ok(new MessageResponse("User not found"));
        }
    }
}
