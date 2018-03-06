package net.chemodurov.projectmanagement.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
