package ru.degtyar.geekbrains.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Authority {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private User user;
}
