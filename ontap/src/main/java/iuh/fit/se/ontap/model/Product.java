package iuh.fit.se.ontap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private String productName;
    private double price;
    private String urlImg;
    private String category;
    private boolean isAvailable;
    private String description;
    private LocalDate expiryDate;
}

