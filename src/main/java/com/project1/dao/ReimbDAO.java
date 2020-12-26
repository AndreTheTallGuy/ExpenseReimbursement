package com.project1.dao;

import com.project1.models.Reimbursement;

import java.util.List;

public interface ReimbDAO {
    
    boolean addReimb(Reimbursement reimb);
    List<Reimbursement> getAllReimbPendingByID(int id);
    List<Reimbursement> getAllReimbPending();
    List<Reimbursement> getAllReimbResolved();
    List<Reimbursement> getAllReimbResolvedByID(int id);
    void updatePending(int id, String resolved);
    
}
