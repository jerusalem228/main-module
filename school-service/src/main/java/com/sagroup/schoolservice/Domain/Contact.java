package com.sagroup.schoolservice.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Contact {
    private String email;
    private String phoneNumber;

}
