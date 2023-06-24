package com.project.dispatchdelivery.db;

import com.project.dispatchdelivery.db.entity.User;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.db.request.userRequest.UserRegisterRequest;
import com.project.dispatchdelivery.db.response.GetCustomerResponse;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


@Repository
public class UsersRepository  {
    @Autowired
    private SessionFactory sessionFactory;

    // create
    public UsersEntity createCustomer(UserRegisterRequest userRegisterRequest) {
        Session session = null;
        UsersEntity user = new UsersEntity();
        user.setEmailAddress(userRegisterRequest.getEmail());
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setPassword(userRegisterRequest.getPassword());
        user.setPassword(userRegisterRequest.getPhoneNumber());
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    // get by id
    public UsersEntity getUserProfile(int UID) {
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        UsersEntity user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(UsersEntity.class, (long)UID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public UsersEntity findByUsername(String username) {
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        UsersEntity user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(UsersEntity.class, (String)username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public UsersEntity getCustomerProfile(int UID){
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        UsersEntity user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(UsersEntity.class, (long)UID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    // update
    public UsersEntity updateUser(User updatedUser) {
        Session session = null;
        UsersEntity dbuser = null;
        long dbuserID = 0;
        try {
            session = sessionFactory.openSession();
            try{
                dbuserID = Integer.parseInt(updatedUser.getUID());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            dbuser = session.get(UsersEntity.class, dbuserID);
            if (dbuser != null) {
                dbuser.setEmailAddress(updatedUser.getEmail());
                dbuser.setFirstName(updatedUser.getFirstName());
                dbuser.setLastName(updatedUser.getLastName());
                dbuser.setPhoneNumber(updatedUser.getPhone());
            }
            session.merge(updatedUser);
            session.beginTransaction();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dbuser;
    }

    public UsersEntity checkUserPassword(String email, String password) {
        Session session = null;
        UsersEntity customer = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            // String hql = "from UsersEntity c where c.email=:e and c.password=:w";
            Query query = session.createQuery("from UsersEntity.class c where c.email=:e and c.password=:w", UsersEntity.class);
            query.setParameter("e",email);
            query.setParameter("w",password);
            List<UsersEntity> list = query.list();
            System.out.println(list.size());
            if (list.size()!=0){
                customer = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }


}
