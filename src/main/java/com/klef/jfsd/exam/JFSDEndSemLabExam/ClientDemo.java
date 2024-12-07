package com.klef.jfsd.exam.JFSDEndSemLabExam;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        insertDepartment(factory, "CSE", "C-Block", "Dr. Senthil");
        insertDepartment(factory, "CSIT", "R-Block", "Dr. Amarendra");
        insertDepartment(factory, "CSE-R", "C-Block", "Dr. Pawan Kumar");
        deleteDepartmentById(factory, 1);
        factory.close();
    }
    public static void insertDepartment(SessionFactory factory, String name, String location, String hodName) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String insertSQL = "INSERT INTO department (name, location, hod_name) VALUES (:n, :l, :h)";
        Query query = session.createSQLQuery(insertSQL);
        query.setParameter("n", name);
        query.setParameter("l", location);
        query.setParameter("h", hodName);

        query.executeUpdate(); 

        tx.commit();
        session.close();

        System.out.println("Inserted Department: " + name);
    }
    public static void deleteDepartmentById(SessionFactory factory, int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String deleteHQL = "DELETE FROM Department WHERE deptID = :id";
        Query query = session.createQuery(deleteHQL);
        query.setParameter("id", id);

        int result = query.executeUpdate(); 

        tx.commit();
        session.close();

        if (result > 0) {
            System.out.println("Deleted Department with ID: " + id);
        } else {
            System.out.println("No Department found with ID: " + id);
        }
    }
}
