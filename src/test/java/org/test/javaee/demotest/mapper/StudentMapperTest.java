package org.test.javaee.demotest.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.test.javaee.demotest.model.Department;
import org.test.javaee.demotest.model.Student;
import org.test.javaee.demotest.util.MyBatisUtil;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

public class StudentMapperTest {

    @Mock
    private SqlSession sqlSession;

    @Mock
    private MyBatisUtil myBatisUtil;

    @Inject
    private StudentMapper studentMapper;

    @Inject
    private DepartmentMapper departmentMapper;

    @BeforeEach
    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        when(myBatisUtil.getSqlSessionFactory().openSession()).thenReturn(sqlSession);
        studentMapper = new StudentMapper();
        departmentMapper = new DepartmentMapper();
    }

    @Test
    public void testSaveStudentObject() {
        Student student = new Student();
        studentMapper.saveStudentObject(student);
        verify(sqlSession, times(1)).insert("insertStudent", student);
    }

    @Test
    public void testChoi() {
        Student student = new Student();
        // set new user
        student.setFirstName("Choi");
        student.setLastName("Choi");
        student.setEmail("tuan@gmail.com");
        student.setHobbies("Choi");
        student.setCity("Choi");
        // Create a Department object
        Department department = new Department();
        department.setDeptValue("CE"); // Se
        departmentMapper.saveDepartmentObject(department);
        Department savedDepartment = departmentMapper.getDepartmentObjectByName("CE");
        student.setDepartment(savedDepartment);
        studentMapper.saveStudentObject(student);
//        verify(sqlSession, times(1)).insert("insertStudent", student);
    }

    @Test
    public void testDelete() {
        studentMapper.deleteStudentObj(2);
//        verify(sqlSession, times(1)).delete("deleteStudent", 1);
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setId(3); // id to be updated
        student.setFirstName("Test Update");
        student.setLastName("Test Update");
        student.setEmail("Test Update");
        studentMapper.updateStudentObject(student);
    }


    // Add more tests for other methods in StudentMapper
}