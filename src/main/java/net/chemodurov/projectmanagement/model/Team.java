package net.chemodurov.projectmanagement.model;

import java.util.Set;

public class Team extends BaseEntity{
    private String name;
    private Set<Developer> set;


    public Team(String name, Set<Developer> set) {
        this.name = name;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
