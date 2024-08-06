package todo.todolist.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import todo.todolist.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/* helps in creating complex objects with a clear and concise API */
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    @JsonIgnore /* to not show this info when converting to json */
    private List<CategoryDto> category;

    public static User toEntity(UserDto userDto)
    /* when we send info from server to client (we don't include everything) */ {
        final User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCategory(
                userDto.getCategory() != null
                        ? userDto.getCategory().stream().map(CategoryDto::toEntity).collect(Collectors.toList())
                        : null);

        return user;
    }

    public static UserDto fromEntity(User user)
    /* when we send info from client to server */ {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .category(
                        user.getCategory() != null
                                ? user.getCategory().stream().map(CategoryDto::fromEntity).collect(Collectors.toList())
                                : null)
                .build();
    }
}