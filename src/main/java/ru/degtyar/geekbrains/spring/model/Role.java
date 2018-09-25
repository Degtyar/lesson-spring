package ru.degtyar.geekbrains.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.degtyar.geekbrains.spring.enume.RoleType;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Role extends AbstractModel {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;

    public Role(User user, RoleType roleType) {
        this.user = user;
        this.roleType = roleType;
    }

    @Override
    public String toString(){
        return roleType.name();
    }
}
