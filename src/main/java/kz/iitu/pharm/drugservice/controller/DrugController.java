package kz.iitu.pharm.drugservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.pharm.drugservice.entity.Drug;
import kz.iitu.pharm.drugservice.repository.DrugRepository;
import kz.iitu.pharm.drugservice.service.impl.DrugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/drugs")
@Api(value = "Drug Controller class", description = "This class is used for editing, accessing drug details")
public class DrugController {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private DrugServiceImpl drugService;


    @GetMapping("")
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @HystrixCommand(fallbackMethod = "getFallBackProduct",
            threadPoolKey = "productInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            }
    )
    @GetMapping("/find/")
    public Drug findByName(@RequestParam("drugname") String name) {
        return drugRepository.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Drug getDrugById(@PathVariable("id") Long id) {
        return drugRepository.findById(id).get();
    }

    public Drug getFallBackProduct(@PathVariable String name) {
        return new Drug("No products", null);
    }


    @ApiOperation(value = "Method for adding new drug")
    @PostMapping("/add/")
    public void addDrug(@RequestBody Drug drug){
        if(drugService.addDrug(drug)){
            System.out.println("Drug added");
        }
        else{
            System.out.println(
                    "drug already exists"
            );
        }
    }
}
