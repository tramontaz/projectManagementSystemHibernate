package net.chemodurov.projectmanagement.model;

import java.util.Set;

public class Project extends BaseEntity{
    private String name;
    private Set<Team> set;

    public Project(String name, Set<Team> set) {
        this.name = name;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
