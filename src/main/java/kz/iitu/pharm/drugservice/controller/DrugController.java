package kz.iitu.pharm.drugservice.controller;

import kz.iitu.pharm.drugservice.entity.Drug;
import kz.iitu.pharm.drugservice.repository.DrugRepository;
import kz.iitu.pharm.drugservice.service.impl.DrugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@RestController
@RequestMapping("/drugs")
@Api(value = "Drug Controller class", description = "This class is used for editing, accessing drug details")
public class DrugController {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private DrugServiceImpl drugService;

    @ApiOperation(value = "Method to get list of all drugs", response = List.class)
    @GetMapping("")
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("/find/")
    public Drug findByName(@RequestParam("drugname") String name) {
        return drugRepository.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Drug getDrugById(@PathVariable("id") Long id) {
        return drugRepository.findById(id).get();
    }
}
