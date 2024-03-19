package org.test.javaee.demotest.bean;

import org.test.javaee.demotest.mapper.StudentMapper;
import org.test.javaee.demotest.model.Student;
import org.test.javaee.demotest.model.StudentSearch;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="studentBean")
@SessionScoped
public class StudentBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Student> studentList;
    private Student tempStudent;

    @Inject
    private StudentMapper studentMapper;


    public StudentBean() {
        studentMapper = new StudentMapper();
        studentList = studentMapper.getStudents();
        tempStudent = new Student(); // Initialize tempStudent

    }

    @PostConstruct
    public void init() {
        studentMapper = new StudentMapper();
        studentList = studentMapper.getStudents();
        tempStudent = new Student(); // Initialize tempStudent
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    public Student getTempStudent() { // Add this getter method
        return tempStudent;
    }

    public void setTempStudent(Student tempStudent) { // Add this setter method
        this.tempStudent = tempStudent;
    }

    private void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

//    addStudent
    public String addStudent(Student student) {
        studentMapper.saveStudentObject(student);
//        update student list
        studentList = studentMapper.getStudents();
        clearTempStudent();
        return "index.xhtml?faces-redirect=true";
    }

    public String editStudent(int id) {
        Student student = studentMapper.getStudent(id);
        this.tempStudent = student;
        return "editStudent.xhtml";
    }

    public String  editStudent(Student student) {
        // Edit student
        student.setId(tempStudent.getId());
        studentMapper.updateStudentObject(student);
        studentList = studentMapper.getStudents();
        clearTempStudent();
        return "index.xhtml?faces-redirect=true"; // Redirect back to the index page
    }

    public String deleteStudent(int id) {
        studentMapper.deleteStudentObj(id);
        studentList = studentMapper.getStudents();
        clearTempStudent();
        return "index.xhtml?faces-redirect=true";
    }

    private void clearTempStudent() {
        tempStudent = new Student();
    }

}
