package org.test.javaee.demotest.model;

import java.io.Serializable;

public class Department implements Serializable {

    private Integer id;
    private String deptValue;

    public String getDeptValue() {
        return deptValue;
    }

    public void setDeptValue(String deptValue) {
        this.deptValue = deptValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

