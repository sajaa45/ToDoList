package todo.todolist.Controllers.api;

import static todo.todolist.utils.Constants.*;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import todo.todolist.dto.UserDto;

@Api("authApi")
public interface AuthApi {

        @ApiOperation(value = "Login user", notes = "Creates a new user ", response = UserDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The connected user."),
                        @ApiResponse(code = 401, message = "Unauthorized: Invalid credentials") })
        @PostMapping(value = APP_ROOT
                        + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        ResponseEntity<UserDto> loginUser(
                        @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);
}
