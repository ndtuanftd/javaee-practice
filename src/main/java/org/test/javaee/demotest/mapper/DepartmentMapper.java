package org.test.javaee.demotest.mapper;

import org.apache.ibatis.session.SqlSession;
import org.test.javaee.demotest.model.Department;
import org.test.javaee.demotest.util.MyBatisUtil;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DepartmentMapper {

//    get
//    getAllDepartments
    public List<Department> getAllDepartments() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Department> departmentsList = session.selectList("selectAllDepartments");
        session.commit();
        session.close();
        return departmentsList;
    }
    public Department getDepartmentObjectById(int theId){
//        getDepartmentById
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Department department = (Department) session.selectOne("getDepartmentById", theId);
        session.commit();
        session.close();
        return department;
    }
//    save
    public void saveDepartmentObject(Department department){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("insertDepartment", department);
        session.commit();
        session.close();
    }

//    get Department by Name
    public Department getDepartmentObjectByName(String deptValue){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Department department = (Department) session.selectOne("getDepartmentByName", deptValue);
        session.commit();
        session.close();
        return department;
    }
//    update
    public void updateDepartmentObject(Department department){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("updateDepartment", department);
        session.commit();
        session.close();
    }
//    delete
    public void deleteDepartmentObject(int theId){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("deleteDepartment", theId);
        session.commit();
        session.close();
    }
}
