  package com.hyrookin01.hyrookin001.service;

  import com.hyrookin01.hyrookin001.entity.Employee;
  import java.util.List;

  public interface EmployeeService {
      Employee addEmployee(Employee employee);
      List<Employee> getAllEmployees();
      Employee updateEmployee(Employee employee);
      void deleteEmployee(int id);
    Employee findById(int id);
  }
