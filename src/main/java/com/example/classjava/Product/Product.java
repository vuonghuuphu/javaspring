package com.example.classjava.Product;

import com.example.classjava.BaseEntity;
import com.example.classjava.Category.Category;
import com.example.classjava.OderDetail.OderDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int categortId;
    @ManyToOne
    @JoinColumn(name = "CategoryId",insertable = false,updatable = false)
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<OderDetail> orderDetailSet;
}
