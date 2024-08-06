package todo.todolist.handlers;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todolist.exception.ErrorCodes;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Holds error details including the HTTP status code, application-specific error code, and related messages.")
public class ErrorDto {

    @ApiModelProperty(value = "The HTTP status code representing the error.", required = true)
    private Integer httpCode;

    @ApiModelProperty(value = "The application-specific error code.", required = true)
    private ErrorCodes code;

    @ApiModelProperty(value = "A detailed message describing the error.")
    private String message;

    @ApiModelProperty(value = "List of input fields related to the error, if any.")
    @Builder.Default
    private List<String> errors = new ArrayList<>();
}
