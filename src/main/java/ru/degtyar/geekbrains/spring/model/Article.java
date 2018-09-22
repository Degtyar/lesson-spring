package ru.degtyar.geekbrains.spring.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Article extends AbstractModel {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String noticeText;

    @OneToMany
    private List<Category> category;

    @OneToOne
    private Company company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getCompany() {
        return company.getId();
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

