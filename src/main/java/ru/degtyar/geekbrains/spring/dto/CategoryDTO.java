package ru.degtyar.geekbrains.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.degtyar.geekbrains.spring.model.Category;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@NoArgsConstructor
public class CategoryDTO {

    @Nullable
    private String id;

    @Nullable
    private String name;

    public CategoryDTO(final Category category) {
        if(category == null) return;
        this.id = category.getId();
        this.name = category.getName();
    }
}
