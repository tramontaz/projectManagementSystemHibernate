package net.chemodurov.projectmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill extends BaseEntity{
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public Skill(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Skill() {
        super();
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID:" + getId() + "\nSkill name: " + getName() + "\n====================\n";
    }
}
