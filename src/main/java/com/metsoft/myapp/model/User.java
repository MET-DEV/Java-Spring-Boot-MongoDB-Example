package com.metsoft.myapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;
    private String password;
    private String email;
    private LocalDateTime registerDate;
    private LocalDate birthDate;

}
