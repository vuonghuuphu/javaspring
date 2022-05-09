package com.example.classjava.OderDetail;

import com.example.classjava.Oder.Oder;
import com.example.classjava.Product.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {
    @Column(name = "oder_id")
    private int orderId;
    @Column(name = "product_id")
    private int productId;
}


