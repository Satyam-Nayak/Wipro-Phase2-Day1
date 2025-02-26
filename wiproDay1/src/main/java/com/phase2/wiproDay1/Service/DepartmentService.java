package com.phase2.wiproDay1.Service;

import com.phase2.wiproDay1.Model.Department;
import com.phase2.wiproDay1.Model.College;
import com.phase2.wiproDay1.Repository.DepartmentRepo;
import com.phase2.wiproDay1.Repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepository;

    @Autowired
    private CollegeRepo collegeRepository;

    public Department saveDepartment(Department department) {
        College college = collegeRepository.findById(department.getCollege().getId())
                .orElseThrow(() -> new RuntimeException("College not found"));

        department.setCollege(college);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
