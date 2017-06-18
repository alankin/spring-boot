package com.springboot.exam.web;

import com.springboot.exam.domain.Seller;
import com.springboot.exam.service.SellerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alan on 17/6/2017.
 */
@RestController
@RequestMapping("/sellers")
@Api(value = "sellers", description = "Operations related to sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getSellers() {
        return sellerService.getSellers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Seller addSeller(@RequestBody SellerRequestDTO sellerDTO) {
        return sellerService.addNewSeller(sellerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Seller deleteSeller(@PathVariable String id) {
        return sellerService.deleteSeller(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Seller updateSeller(@PathVariable String id, @RequestBody SellerRequestDTO sellerDTO) {
        return sellerService.updateSeller(id, sellerDTO);
    }

    public static class SellerRequestDTO {
        private String name;
        private long age;
        private long ci;
        private long numCarsSold;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getAge() {
            return age;
        }

        public void setAge(long age) {
            this.age = age;
        }

        public long getCi() {
            return ci;
        }

        public void setCi(long ci) {
            this.ci = ci;
        }

        public long getNumCarsSold() {
            return numCarsSold;
        }

        public void setNumCarsSold(long numCarsSold) {
            this.numCarsSold = numCarsSold;
        }
    }
}
