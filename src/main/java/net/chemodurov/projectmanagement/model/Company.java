package net.chemodurov.projectmanagement.model;

import java.util.Set;

public class Company extends BaseEntity {
    private String name;
    private Set<Project> set;

    public Company(String name, Set<Project> set) {
        this.name = name;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
