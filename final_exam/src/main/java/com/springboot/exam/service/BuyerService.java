package com.springboot.exam.service;


import com.springboot.exam.domain.Buyer;
import com.springboot.exam.repository.BuyerRepository;
import com.springboot.exam.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 17/6/2017.
 */
@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer addNewBuyer(BuyerController.BuyerRequestDTO buyerRequestDTO) {
        Buyer buyer = new Buyer();
        buyer.setName(buyerRequestDTO.getName());
        buyer.setCellphone(buyerRequestDTO.getCellphone());
        buyer.setCi(buyerRequestDTO.getCi());
        buyer.setProfession(buyerRequestDTO.getProfession());

        buyerRepository.save(buyer);

        return buyer;
    }

    public Buyer deleteBuyer(String id) {
        Buyer buyer = buyerRepository.findOne(id);

        buyerRepository.delete(buyer);

        return buyer;
    }

    public Buyer updateBuyer(String id, BuyerController.BuyerRequestDTO buyerRequestDTO) {
        Buyer buyer = new Buyer();
        buyer.setName(buyerRequestDTO.getName());
        buyer.setCellphone(buyerRequestDTO.getCellphone());
        buyer.setCi(buyerRequestDTO.getCi());
        buyer.setProfession(buyerRequestDTO.getProfession());
        buyer.setId(id);

        buyerRepository.save(buyer);

        return buyer;
    }
}
