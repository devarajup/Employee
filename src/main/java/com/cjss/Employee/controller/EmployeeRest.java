package com.cjss.Employee.controller;

import com.cjss.Employee.entity.EmployeeEntity;
import com.cjss.Employee.model.EmployeeModel;
import com.cjss.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRest{
    @Autowired
    private EmployeeService service;

    @PostMapping("/emp-save")
    public  void save(@RequestBody EmployeeModel empModel){
        service.save(empModel); }

        @PostMapping("/emp-save-all")
    public  void saveAll(@RequestBody List<EmployeeModel> empModel){
        service.saveAll(empModel);
    }
    @GetMapping("/emp-all")
    public List<EmployeeModel> getAll(){
        return  service.getAll();
    }
    @GetMapping("/emp-all/{name}")
    public List<EmployeeModel> getAll(@PathVariable String name){
        return  service.getAll(name);
    }
    @GetMapping("/emp-search-id-name/{id}/{name}")
    public  List<EmployeeModel> byIdAndName(@PathVariable Integer id,@PathVariable String name){
      return    service.findByIdAndName(id,name);
    }
    @GetMapping("/emp-search-id-des/{id}/{de}")
    public  List<EmployeeModel> byIdAndDesignation(@PathVariable Integer id,@PathVariable String de){
        return    service.findByIdAndDesignation(id,de);
    }
    @DeleteMapping("/emp-delete-all")
    public void deleteAllEmployee(){
        service.deleteAll();
    }
    @DeleteMapping("/emp-delete-one/{id}")
    public void deleteAllEmployee(@PathVariable Integer id){
        service.deleteOne(id);
    }
    @PatchMapping("/emp-update")
    public  void updateDetails(@RequestBody EmployeeModel model){
        service.updateDetails(model);
    }

}
