package org.ngphthinh.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private int id;
    private String model;
    private double price;
    private int quantity;
    private String description;
    private String imgUrl;
}
