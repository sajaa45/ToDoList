package todo.todolist.services;

import java.util.List;

import todo.todolist.dto.UserDto;

public interface UserService {

    UserDto save(UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void delete(Long id);

    UserDto login(UserDto user);
}
