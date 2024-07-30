package Controllers;

import Controllers.api.UserApi;
import dto.UserDto;
import services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*Indicates that this class handles REST API requests */
@CrossOrigin(origins = "*", maxAge = 3600)
/*Allows cross-origin requests from any origin (origins = "*") with a maximum age of 3600 seconds (1 hour). */
public class UserController implements UserApi {

    @Autowired
    /* allows Spring to resolve and inject collaborating beans (dependencies) into your bean */
    private UserService userService;

    @Override
    /*tell Java you're replacing a parent class method with a new version in the child class. */
    public ResponseEntity<UserDto> createUser(UserDto user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long id, UserDto user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
