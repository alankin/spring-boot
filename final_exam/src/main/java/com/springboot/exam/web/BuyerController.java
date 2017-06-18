package com.springboot.exam.web;

import com.springboot.exam.domain.Buyer;
import com.springboot.exam.service.BuyerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alan on 17/6/2017.
 */
@RestController
@RequestMapping("/buyers")
@Api(value = "buyers", description = "Operations related to buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getBuyers() {
        return buyerService.getBuyers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Buyer addBuyer(@RequestBody BuyerRequestDTO buyerDTO) {
        return buyerService.addNewBuyer(buyerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Buyer deleteBuyer(@PathVariable String id) {
        return buyerService.deleteBuyer(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Buyer updateBuyer(@PathVariable String id, @RequestBody BuyerRequestDTO buyerDTO) {
       return buyerService.updateBuyer(id, buyerDTO);
    }


    public static class BuyerRequestDTO {
        private String name;
        private String ci;
        private String profession;
        private long cellphone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCi() {
            return ci;
        }

        public void setCi(String ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public long getCellphone() {
            return cellphone;
        }

        public void setCellphone(long cellphone) {
            this.cellphone = cellphone;
        }
    }
}
