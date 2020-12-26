package com.project1.dao;

import com.project1.models.User;
import com.project1.utilities.DAOUtilities;
import org.hibernate.*;

import java.util.List;

public class UserDAOImpl extends DAOUtilities implements UserDAO {
    Session session = null;
    public static User user = null;

    /**
     * Gets a user by username
     * @param username
     * @return User object
     */
    @Override
    public User getUserByUserName(String username) {
        DAOUtilities.config();
        try{
            user = null;
            session = sessionFactory.openSession();

            String hql = "from com.project1.models.User as u where u.username = '" + username + "'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);

            @SuppressWarnings("unchecked")
            List<User> result = query.list();

            t.commit();
            for(User u:result) {
                user = u;
            }
            }finally{
            if (session != null) {
                session.close();
            }
        }

        return user;
    }

    /**
     * Gets a user by id
     * @param id
     * @return User object
     */
    @Override
    public User getUserByID(int id) {
        session = sessionFactory.openSession();
        user = (User) session.get(User.class, id);
        return user;
    }

    /**
     * Adds a user to the db
     * @param user
     * @return returns true
     */
    @Override
    public boolean addUser(User user) {
        DAOUtilities.config();
        Transaction t = null;
        try {
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            session.save(user);
            t.commit();
        }
        finally {
            if(session != null){
            session.close();
            }
        }
        
        return true;
    }

    /**
     * Gets all employees from the db
     * @return
     */
    @Override
    public List<User> getAllEmployees() {
        DAOUtilities.config();
        List<User> employees= null;
        try {
            session = sessionFactory.openSession();

            String hql = "from com.project1.models.User where firstName != 'noone'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);

            employees = query.list();

            t.commit();

        } finally {
            if (session != null) {
                session.close();
            }

        }
        return employees;
    }

    /**
     * Deletes a user from the db by username
     * @param username
     * @return boolean
     */
    @Override
    public boolean deleteUser(String username) {
        DAOUtilities.config();
        try {
            session = sessionFactory.openSession();

            String hql = "delete from com.project1.models.User where username = '" + username + "'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.executeUpdate();

            t.commit();

        } finally {
            if (session != null) {
                session.close();
            }

        }
        return true;
    }
}
