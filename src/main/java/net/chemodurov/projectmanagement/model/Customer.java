package net.chemodurov.projectmanagement.model;

import java.util.Set;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
