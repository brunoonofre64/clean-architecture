package com.github.brunoonofre64.api.v1;

import com.github.brunoonofre64.app.dtos.PasswordDTO;
import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.dtos.UserUpdateDTO;
import com.github.brunoonofre64.app.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponseDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public UserResponseDTO update(@RequestParam String username,
                                  @RequestBody UserUpdateDTO updateDTO) {
        return userService.update(username, updateDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@RequestParam String username, @RequestBody PasswordDTO password) {
        userService.delete(username, password);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserResponseDTO> findAll() {
        return userService.findAll();
    }
}
