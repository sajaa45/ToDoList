package todo.todolist.Controllers;

import static todo.todolist.utils.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.todolist.Controllers.api.AuthApi;
import todo.todolist.dto.UserDto;
import todo.todolist.services.UserService;

@RestController
@RequestMapping(APP_ROOT + "/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController implements AuthApi {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
}
