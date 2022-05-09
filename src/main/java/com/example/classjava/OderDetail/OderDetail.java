package com.example.classjava.OderDetail;

import com.example.classjava.Oder.Oder;
import com.example.classjava.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "oder_detail")
public class OderDetail{

    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("oderId")
    @JoinColumn(name = "oder_id",referencedColumnName = "id",nullable = false)
    private Oder oder;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
    private Product product;

    private int quantity;
    private double unitPrice;
}
