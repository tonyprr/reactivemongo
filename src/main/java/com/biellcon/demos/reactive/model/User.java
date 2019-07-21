package com.biellcon.demos.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @NotEmpty
    @NotBlank
    private String firstName;

    private String lastName;

    @Email
    @NotEmpty
    @NotBlank
    private String email;

}
