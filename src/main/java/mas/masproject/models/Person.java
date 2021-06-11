package mas.masproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Size(min=2, max=30, message = "Pole powinno zawierać 2-30 znaków")
    //@NotBlank(message = "Pole wymagane")
    @Column(name = "firstName")
    private String firstName;

    //@Size(min=2, max=40, message = "Pole powinno zawierać 2-40 znaków")
    //@NotBlank(message = "Pole wymagane")
    @Column(name = "lastName")
    private String lastName;


    @Column(name = "birthDate")
    private LocalDate birthDate;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
