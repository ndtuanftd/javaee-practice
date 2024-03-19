package org.test.javaee.demotest.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.test.javaee.demotest.model.Department;
import org.test.javaee.demotest.model.Student;

import javax.inject.Inject;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DepartmentMapperTest {
    @Inject
    private DepartmentMapper departmentMapper;

    @BeforeEach
    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        when(myBatisUtil.getSqlSessionFactory().openSession()).thenReturn(sqlSession);
        departmentMapper = new DepartmentMapper();
    }


    @Test
    public void testSaveDepartmentObject() {
        Department department = new Department();
        department.setDeptValue("IT");
        departmentMapper.saveDepartmentObject(department);

    }

    @Test
    public void testDeleteDepartmentObject() {
        Integer id = 3;
        departmentMapper.deleteDepartmentObject(id);

    }
}
