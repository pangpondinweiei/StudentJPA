/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author sonon
 */
public class StudentJPA {
    public static void main(String[] args) {
        Student std = new Student(3, "Supawich" , 3.98);
        Student std2 = new Student(4, "Sukkanta" , 3.97);
        
        //StudentTable.insertStudent(std);
        //StudentTable.updateStudent(std);
        StudentTable.removeStudent(std);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
    
}
