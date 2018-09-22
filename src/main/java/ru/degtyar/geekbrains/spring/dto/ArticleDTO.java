package ru.degtyar.geekbrains.spring.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.degtyar.geekbrains.spring.model.Article;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
@NoArgsConstructor
public class ArticleDTO {

    @Nullable
    private String id;

    @Nullable
    private String name;

    @Nullable
    private String phoneNumber;

    @Nullable
    private String noticeText;

    @Nullable
    private String companyId;

    public ArticleDTO(final Article article) {
        if(article == null) return;
        id = article.getId();
        name = article.getName();
        phoneNumber = article.getPhoneNumber();
        noticeText = article.getNoticeText();
        companyId = article.getCompany();
    }
}
