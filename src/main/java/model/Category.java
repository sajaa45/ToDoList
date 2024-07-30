package model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.FetchType;

import java.io.Serializable;/*let classes be connected */
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity/*class is an entity and should be put in a database */
@AllArgsConstructor/*writes constructors for you without getters setters */
@NoArgsConstructor/*writes the constructors without args */
@Data
public class Category implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    /*field or property should be  eagerly loaded */
    private List<Todo> todoList ;
}
