package ru.degtyar.geekbrains.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Category extends AbstractModel {

    @Id
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
