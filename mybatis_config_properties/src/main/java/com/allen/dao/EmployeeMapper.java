package com.allen.dao;

import com.allen.domain.Employee;

/**
 * @author allen
 * @date 2018/8/8
 */
public interface EmployeeMapper {
    Employee selectEmployeeById(int id);

    void addEmployee(Employee employee);

    void  updateEmployee(Employee employee);
    void  deleteEmployeeById(int id);

}
