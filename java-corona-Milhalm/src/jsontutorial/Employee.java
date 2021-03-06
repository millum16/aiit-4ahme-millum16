package jsontutorial;

import java.util.Date;
import java.util.List;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private List<String> roles;

    /**
     *
     * @author lukasmilhalm
     */
    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getters and setters
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", "
                + "lastName=" + lastName + ", roles=" + roles + "]";

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getRoles() {
        return roles;
    }
}
