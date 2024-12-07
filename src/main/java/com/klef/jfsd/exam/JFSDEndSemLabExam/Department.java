package com.klef.jfsd.exam.JFSDEndSemLabExam;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptID;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "hod_name")
    private String hodName;

    // Constructors
    public Department() {}

    public Department(String name, String location, String hodName) {
        this.name = name;
        this.location = location;
        this.hodName = hodName;
    }

    // Getters and Setters
    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    @Override
    public String toString() {
        return "Department [deptID=" + deptID + ", name=" + name + ", location=" + location + ", hodName=" + hodName + "]";
    }
}
