
package com.dao;

import com.model.RegisterStudent;
import org.hibernate.*;

public class RegisterDao {
   
    public void registerStudent(RegisterStudent registerStudent){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       
        session.save(registerStudent);
        tx.commit();
        session.close();
    }
}
