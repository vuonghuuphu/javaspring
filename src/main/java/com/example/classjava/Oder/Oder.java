package com.example.classjava.Oder;

import com.example.classjava.BaseEntity;
import com.example.classjava.OderDetail.OderDetail;
import com.example.classjava.OderDetail.OrderDetailId;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oders")
public class Oder extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private double totalPrice;

    @OneToMany(mappedBy = "oder",cascade = CascadeType.ALL)
    private Set<OderDetail> orderDetailSet;
}
