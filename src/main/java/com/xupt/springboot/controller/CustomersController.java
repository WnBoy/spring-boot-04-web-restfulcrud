package com.xupt.springboot.controller;

import com.xupt.springboot.dao.DepartmentDao;
import com.xupt.springboot.dao.EmployeeDao;
import com.xupt.springboot.entities.Department;
import com.xupt.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-22 19:31
 */
@Controller
public class CustomersController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 查询所有员工
     * @param map
     * @return
     */
    @GetMapping("/emps")
    public String list(Map<String,Object>map){
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps",employees);
        //thymeleaf拼串：classpath:/templates/xxx.html
        return "/emp/list";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/emp")
    public String getaddPage(Map<String,Object>map){
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "emp/add";
    }

    /**
     * 员工添加的方法
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String saveEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转到修改页面
     * @param map
     * @return
     */
    @GetMapping("/emp/{id}")
    public String getUpdatePage(@PathVariable("id") Integer id,Map<String,Object>map){
        Employee employee = employeeDao.get(id);
        map.put("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "emp/add";
    }

    /**
     * 修改员工的方法
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
