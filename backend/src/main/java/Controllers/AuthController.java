package Controllers;

import Controllers.api.AuthApi;
import dto.UserDto;
import services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/authApi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController implements AuthApi {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping(APP_ROOT + "/auth/login")
    public ResponseEntity<UserDto> loginUser(UserDto user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
}