package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
//@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_num;

    @Column
    private String product_name;

    @Column
    private int product_price;

    @Column
    private String product_img;

    @Column
    private String product_txt;

    @Column
    private String product_color;

    @Column
    private String product_size;
}
