package net.chemodurov.projectmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {
    private String name;
    private Set<Project> set;

    public Company(String name, Set<Project> set) {
        this.name = name;
        this.set = set;
    }

    public Company() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "company_projects",
            joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    public Set<Project> getSet() {
        return set;
    }

    public void setSet(Set<Project> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Company:\n" +
                "\nid=" + getId() +
                "\nname=" + name + '\'' +
                "\nProjects:" + set +
                "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n";
    }
}
