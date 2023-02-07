package com.sagroup.schoolservice.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    private String id;
    private String name;

    private Adress adress;
    private Contact contact;

}
