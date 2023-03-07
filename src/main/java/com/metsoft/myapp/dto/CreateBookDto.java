package com.metsoft.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBookDto {
    private String name;
    private String description;
    private String authorName;
    private double price;
    private String category;

}
