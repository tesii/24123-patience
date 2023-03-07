
package com.dao;

import com.model.SignUp;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author sethr
 */
public class SignUpDao {
    
    public void saveStudent(SignUp signUp){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        ss.save(signUp);
        ts.commit();
        ss.close();
    }
    
    public void updateStudent(SignUp signUp){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        ss.update(signUp);
        ts.commit();
        ss.close();
    }
    public SignUp findStudent(SignUp signUp){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        SignUp getStudent = (SignUp) ss.get(SignUp.class, signUp.getEmail());
        ss.close();
        return getStudent;
    }
    
    public SignUp findStudentByEmail(String email){
       Session ss = HibernateUtil.getSessionFactory().openSession();
        String query = "from SignUp where email = :email";
       Query usr;
        usr = ss.createQuery(query);
        usr.setParameter("email", email);
            
       SignUp sign = (SignUp) usr.uniqueResult();
       
       
        return sign;
    }
}
