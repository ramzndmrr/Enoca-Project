package com.enoca.enocaproject.repository;

import com.enoca.enocaproject.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "  select * from Category as ct left join Product as p on p.catgory_id = ct.id " +
            "where p.name %like = a group by  ",nativeQuery = true)
    public Employee getEmployeesByTextile(@Param("textileId") Long textileId);


}
