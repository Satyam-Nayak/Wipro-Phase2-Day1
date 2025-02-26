package com.phase2.wiproDay1.Repository;

import com.phase2.wiproDay1.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    // Custom queries can be added here if needed
}
