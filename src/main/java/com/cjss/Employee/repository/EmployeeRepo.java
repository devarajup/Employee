package com.cjss.Employee.repository;

import com.cjss.Employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE EmployeeEntity SET name=:name,designation=:designation WHERE id=:id")
    void updateById(@Param(value = "name") String name, @Param(value = "designation") String designation ,@Param(value = "id") Integer id);

    List<EmployeeEntity> findByIdAndName(Integer id, String name);
    List<EmployeeEntity> findByIdAndDesignation(Integer id, String Designation);


}
