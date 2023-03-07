package com.metsoft.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBookDto {
    private String id;
    private String name;
    private double price;
}
