package net.chemodurov.projectmanagement.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String specialty;
    private Set<Skill> set;
    private BigDecimal salary;

    public Developer(String firstName, String lastName, String specialty, Set<Skill> set, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.set = set;
        this.salary = salary;
    }

    public Developer(Long id, String firstName, String lastName, String specialty, Set<Skill> set, BigDecimal salary) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.set = set;
        this.salary = salary;
    }

    public Developer() {
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "specialty")
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "developer_skills",
            joinColumns = @JoinColumn(name = "dev_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id")  )
    public Set<Skill> getSet() {
        return set;
    }

    public void setSet(Set<Skill> set) {
        this.set = set;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void addSkill(Skill skill){
        this.set.add(skill);
    }

    @Override
    public String toString() {
        return "\nDeveloper: " +
                "\nid=" + getId() +
                "\nfirstName= " + firstName +
                "\nlastName= " + lastName +
                "\nspecialty= " + specialty +
                "\nSkill set=" + set +
                "\nsalary=" + salary +
                "\n========================\n";
    }
}
