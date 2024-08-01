package model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;/*let classes be connected */
import java.util.List;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity/*class is an entity and should be put in a database */
@AllArgsConstructor/*writes constructors for you without getters setters */
@NoArgsConstructor/*writes the constructors without args */
@Data
public class Todo implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private ZonedDateTime startDate;
    private boolean done;
    private boolean favorite;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;
}
