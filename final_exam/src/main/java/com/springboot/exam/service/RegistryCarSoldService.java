package com.springboot.exam.service;

import com.springboot.exam.domain.Buyer;
import com.springboot.exam.domain.Car;
import com.springboot.exam.domain.RegistryCarSold;
import com.springboot.exam.domain.Seller;
import com.springboot.exam.repository.BuyerRepository;
import com.springboot.exam.repository.CarRepository;
import com.springboot.exam.repository.RegistryCarSoldRepository;
import com.springboot.exam.repository.SellerRepository;
import com.springboot.exam.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 17/6/2017.
 */
@Service
public class RegistryCarSoldService {

    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private CarRepository carRepository;

    public List<RegistryCarSold> getRegistries() {
        return registryCarSoldRepository.findAll();
    }

    public HashMap<String, Object> getRegistriesBySeller(String sellerId) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        RegistryCarSold registry = registryCarSoldRepository.findRegistriesBySeller(sellerId);

        if (null != registry) {
            response.put("name", registry.getSeller().getName());
            response.put("ci", registry.getSeller().getCi());
            response.put("CarsSoldNumber", registry.getSeller().getNumCarsSold());
        }
        return response;
    }

    public RegistryCarSold addNewRegistry(RegistryCarSoldController.RegistryCarSoldRequestDTO registryDTO) {

        Seller seller = sellerRepository.findOne(registryDTO.getSellerId());
        Buyer buyer = buyerRepository.findOne(registryDTO.getBuyerId());
        Car car = carRepository.findOne(registryDTO.getCarId());

        RegistryCarSold registryCarSold = new RegistryCarSold();
        registryCarSold.setSellDate(registryDTO.getSellDate());
        registryCarSold.setBuyer(buyer);
        registryCarSold.setSeller(seller);
        registryCarSold.setCar(car);

        registryCarSoldRepository.save(registryCarSold);

        updateSellerCounter(seller);

        return registryCarSold;
    }

    public RegistryCarSold deleteRegistry(String id) {
        RegistryCarSold registryCarSold = registryCarSoldRepository.findOne(id);

        registryCarSoldRepository.delete(registryCarSold);

        return registryCarSold;
    }

    public RegistryCarSold updateRegistry(String id, RegistryCarSoldController.RegistryCarSoldRequestDTO registryDTO) {
        Seller seller = sellerRepository.findOne(registryDTO.getSellerId());
        Buyer buyer = buyerRepository.findOne(registryDTO.getBuyerId());
        Car car = carRepository.findOne(registryDTO.getCarId());

        RegistryCarSold registryCarSold = new RegistryCarSold();
        registryCarSold.setSellDate(registryDTO.getSellDate());
        registryCarSold.setBuyer(buyer);
        registryCarSold.setSeller(seller);
        registryCarSold.setCar(car);
        registryCarSold.setId(id);

        registryCarSoldRepository.save(registryCarSold);

        return registryCarSold;
    }

    private void updateSellerCounter(Seller seller) {
        long soldNumber = seller.getNumCarsSold() + 1;
        seller.setNumCarsSold(soldNumber);
        sellerRepository.save(seller);
    }
}
