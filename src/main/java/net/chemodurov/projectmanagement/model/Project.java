package net.chemodurov.projectmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity{
    private String name;
    private Set<Team> set;

    public Project(String name, Set<Team> set) {
        this.name = name;
        this.set = set;
    }

    public Project() {
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
            name = "project_teams",
            joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    public Set<Team> getSet() {
        return set;
    }

    public void setSet(Set<Team> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Project: " +
                "\nid=" + getId() +
                "\nname ='" + name + '\'' +
                "\nteams:\n" + set +
                "\n========================================\n";
    }
}
