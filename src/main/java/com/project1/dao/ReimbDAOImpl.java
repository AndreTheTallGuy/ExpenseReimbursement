package com.project1.dao;

import com.project1.models.Reimbursement;
import com.project1.models.User;
import com.project1.utilities.DAOUtilities;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReimbDAOImpl extends DAOUtilities implements ReimbDAO{
    public static User user;
    Session session = null;

    /**
     * Adds a reimbursement to the database
     * @param reimb
     * @return
     */
    @Override
    public boolean addReimb(Reimbursement reimb) {
        Transaction t = null;
        try {
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            System.out.println(reimb);
            session.save(reimb);
            t.commit();
        }
        finally {
            session.close();
        }

        return true;
        
    }

    /**
     * gets all reimbursements from the database based on an id
     * @param id
     * @return List of Reimbursements
     */

    @Override
    public List<Reimbursement> getAllReimbPendingByID(int id) {
        DAOUtilities.config();
        List<Reimbursement> reimbs;
        try{
            session = sessionFactory.openSession();

            String hql = "from com.project1.models.Reimbursement where result = 'Pending' and userId = :i";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setInteger("i", id);

            reimbs = query.list();
            
            t.commit();
            
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return reimbs;
    }

    /**
     * Gets all pending reimbursements from the database
     * @return List of Reimbursements
     */
    @Override
    public List<Reimbursement> getAllReimbPending() {
        DAOUtilities.config();
        List<Reimbursement> reimbs;
        try{
            session = sessionFactory.openSession();

            String hql = "from com.project1.models.User as u, com.project1.models.Reimbursement r " +
                    "where u.id = r.userId and r.result = 'Pending'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);

            reimbs = query.list();

            t.commit();

        }finally {
            if (session != null) {
                session.close();
            }
        }
        return reimbs;
    }

    /**
     * Gets all resolved reimbursements
     * @return List of Reimbursements
     */

    @Override
    public List<Reimbursement> getAllReimbResolved() {
        DAOUtilities.config();
        List<Reimbursement> reimbs;
        try{
            session = sessionFactory.openSession();

            String hql = "from com.project1.models.User as u, com.project1.models.Reimbursement r " +
                    "where u.id = r.userId and r.result != 'Pending'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);

            reimbs = query.list();

            t.commit();

        }finally {
            if (session != null) {
                session.close();
            }
        }
        return reimbs;

    }

    /**
     * Gets all reimbursements by ID
     * @param id
     * @return List of reimbursements
     */
    @Override
    public List<Reimbursement> getAllReimbResolvedByID(int id) {
        DAOUtilities.config();
        List<Reimbursement> reimbs;
        try{
            session = sessionFactory.openSession();

            String hql = "from com.project1.models.User as u, com.project1.models.Reimbursement r " +
                    "where u.id = r.userId and r.result != 'Pending' and u.id = :i";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setInteger("i", id);
            reimbs = query.list();

            t.commit();

        }finally {
            if (session != null) {
                session.close();
            }
        }
        return reimbs;

    }

    /**
     * Updates pending reimbursements to either 'Approved' or 'Denied'
     * @param num
     * @param resolved
     */
    @Override
    public void updatePending(int num, String resolved) {
        DAOUtilities.config();

        try{
            session = sessionFactory.openSession();

            String sql = "update reimbursement set result= :res where id = :i";
            Transaction t = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setString("res", resolved);
            query.setInteger("i", num);

            int exe = query.executeUpdate();
            t.commit();

        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
