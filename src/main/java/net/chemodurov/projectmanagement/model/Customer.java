package net.chemodurov.projectmanagement.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private Set<Project> set;

    public Customer(String firstName, String lastName, String address, Set<Project> set) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.set = set;
    }

    public Customer() {
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

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "customer_projects",
            joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    public Set<Project> getSet() {
        return set;
    }

    public void setSet(Set<Project> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Customer:\n" +
                "\nid=" + getId() +
                "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\'' +
                "\naddress='" + address + '\'' +
                "\nProjects:" + set +
                "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
    }
}
