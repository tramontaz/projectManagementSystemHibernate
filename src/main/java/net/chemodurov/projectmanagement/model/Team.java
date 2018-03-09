package net.chemodurov.projectmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
    private String name;
    private Set<Developer> set;


    public Team(String name, Set<Developer> set) {
        this.name = name;
        this.set = set;
    }

    public Team() {
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
            name = "team_developers",
            joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "dev_id"))
    public Set<Developer> getSet() {
        return set;
    }

    public void setSet(Set<Developer> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                "\nname=" + name +
                "\nDevelopers:\n" + set;
    }
}
