package ru.degtyar.geekbrains.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@NoArgsConstructor
public class ResultDTO {

    private String message = "success";
}
