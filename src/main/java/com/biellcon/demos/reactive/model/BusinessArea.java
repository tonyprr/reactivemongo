package com.biellcon.demos.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessArea {

    @Version
    private Long version;

    @Id
    private String id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    private String description;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant lastModifiedAt;

}
