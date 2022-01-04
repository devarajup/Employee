package com.cjss.Employee.service;

import com.cjss.Employee.entity.EmployeeEntity;
import com.cjss.Employee.model.EmployeeModel;
import com.cjss.Employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public Integer save(EmployeeModel model) {
        EmployeeEntity entity = getEntity(model);
        return repo.save(entity).getId();
    }

    public void saveAll(List<EmployeeModel> modelList) {
        List<EmployeeEntity> employeeEntityList = modelList.stream().map(model -> getEntity(model)).collect(Collectors.toList());
        repo.saveAll(employeeEntityList);
    }

    public List<EmployeeModel> findByIdAndName(Integer id, String name) {
        return repo.findByIdAndName(id, name).stream().map(entity -> getModel(entity)).collect(Collectors.toList());

    }

    public List<EmployeeModel> findByIdAndDesignation(Integer id, String de) {
        return repo.findByIdAndDesignation(id, de).stream().map(entity -> getModel(entity)).collect(Collectors.toList());
    }

    public void updateDetails(EmployeeModel model) {

        EmployeeEntity entity = getEntity(model);

        repo.updateById(entity.getName(), entity.getDesignation(), entity.getId());
    }

    public List<EmployeeModel> getAll() {
        return repo.findAll().stream().map(entity -> getModel(entity)).collect(Collectors.toList());
    }

    public List<EmployeeModel> getAll(String name) {
        Sort s = Sort.by(name);
        return repo.findAll(s).stream().map(entity -> getModel(entity)).collect(Collectors.toList());
    }

    public void deleteAll() {
        repo.deleteAll();
    }
    public  void  deleteOne(Integer id){
        repo.deleteById(id);
    }


    private EmployeeEntity getEntity(EmployeeModel empModel) {
        return new EmployeeEntity(empModel.getId(), empModel.getName(), empModel.getDept(), empModel.getSalary(), empModel.getLocation(), empModel.getPhoneNumber(), empModel.getDesignation());
    }

    private EmployeeModel getModel(EmployeeEntity empEntity) {
        return new EmployeeModel(empEntity.getId(), empEntity.getName(), empEntity.getDept(), empEntity.getSalary(), empEntity.getLocation(), empEntity.getPhoneNumber(), empEntity.getDesignation());
    }


}
