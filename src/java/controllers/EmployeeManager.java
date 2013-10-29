/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entity.Employee;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ayemi
 */
@ManagedBean
@RequestScoped
public class EmployeeManager {

    /** Creates a new instance of EmployeeManager */
    private Employee selectedEmployee;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }
    public EmployeeManager() {
    }

}
