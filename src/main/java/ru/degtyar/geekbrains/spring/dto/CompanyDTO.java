package ru.degtyar.geekbrains.spring.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.degtyar.geekbrains.spring.model.Company;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@NoArgsConstructor
public class CompanyDTO {

    @Nullable
    private String id;

    @Nullable
    private String name;

    @Nullable
    private String address;

    public CompanyDTO(final Company company) {
        if (company == null) return;
        id = company.getId();
        name = company.getName();
        address = company.getAdress();
    }
}
