package com.khay.ecommerce.models.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    private String imageName;
    private String ImageType;

    @Lob
    private byte[] imageData;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
