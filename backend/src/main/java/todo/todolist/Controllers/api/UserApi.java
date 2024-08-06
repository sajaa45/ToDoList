package todo.todolist.Controllers.api;

import static todo.todolist.utils.Constants.*;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import todo.todolist.dto.UserDto;

@Api(APP_ROOT + "/users")
public interface UserApi {

        @PostMapping(value = APP_ROOT
                        + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Create user", notes = "Creates a new user", response = UserDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 201, message = "The newly created user.")
        })
        ResponseEntity<UserDto> createUser(
                        @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

        @PatchMapping(value = APP_ROOT
                        + "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Update user", notes = "Updates an existing user", response = UserDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The updated user.")
        })
        ResponseEntity<UserDto> updateUser(
                        @ApiParam(value = "User ID", required = true) @PathVariable Long id,
                        @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

        @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "User Details", notes = "Returns the list of all users", responseContainer = "List<UserDto>")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "List of users"),
        })
        ResponseEntity<List<UserDto>> getAllUsers();

        @GetMapping(value = APP_ROOT + "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "User Details", notes = "Returns the details of a specific user", response = UserDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The user"),
                        @ApiResponse(code = 404, message = "User not found")
        })
        ResponseEntity<UserDto> getUser(
                        @ApiParam(value = "User ID", required = true) @PathVariable Long id);

        @DeleteMapping(value = APP_ROOT + "/users/delete/{id}")
        @ApiOperation(value = "Delete a user", notes = "Deletes a user by ID")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "User successfully deleted"),
                        @ApiResponse(code = 404, message = "User not found")
        })
        ResponseEntity<Void> deleteUser(
                        @ApiParam(value = "User ID", required = true) @PathVariable Long id);
}
