package com.sagroup.schoolservice.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    private String street;
    private String city;
    private  int zip;
    private String state;

}
