package com.project1.servlets;

import com.project1.dao.ReimbDAOImpl;
import com.project1.dao.UserDAOImpl;
import com.project1.models.Reimbursement;
import com.project1.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reimb")
public class CreateReimbursement extends HttpServlet {
    User user = UserDAOImpl.user;

    /**
     * Gets user input and creates a new reimbursement
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int userId = user.getId();
        String amount = req.getParameter("amount");
        String reason = req.getParameter("reason");
        String result = "Pending";
        int reviewedBy = 6;
        System.out.println(amount);
        
        Reimbursement reimb = new Reimbursement(userId, amount ,reason, result, reviewedBy);

        ReimbDAOImpl impl = new ReimbDAOImpl();
        impl.addReimb(reimb);


//        res.sendRedirect(req.getContextPath() + "/employee");
        req.getRequestDispatcher("employeeHome.jsp").forward(req, res);
    }
}
