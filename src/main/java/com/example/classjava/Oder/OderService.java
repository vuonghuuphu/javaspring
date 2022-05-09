package com.example.classjava.Oder;

import com.example.classjava.OderDetail.OderDetail;
import com.example.classjava.OderDetail.OrderDetailId;
import com.example.classjava.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OderService {
    @Autowired
    OderRepository oderRepository;

    public List<Oder> findAll() {
        return oderRepository.findAll();
    }

    public Optional<Oder> findById(int id) {
        return oderRepository.findById(id);
    }

    public Oder save(Oder oder) {
        return oderRepository.save(oder);
    }

    public void deleteById(int id) {oderRepository.deleteById(id); }

    public boolean Addoderdetail(Oder oder, Product product,int quantity){
        try {
            Set<OderDetail> oderDetails = oder.getOrderDetailSet();
           if (oderDetails == null){
               oderDetails = new HashSet<>();
           }else {
               System.out.println("ok");
           }
            OderDetail oderDetail = new OderDetail();
            oderDetail.setId(new OrderDetailId(oder.getId(),product.getId()));
            oderDetail.setOder(oder);
            oderDetail.setProduct(product);
            oderDetail.setQuantity(quantity);
            oderDetail.setUnitPrice(product.getPrice()*quantity);
            oderDetails.add(oderDetail);
            oder.setOrderDetailSet(oderDetails);
            oderRepository.save(oder);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}

