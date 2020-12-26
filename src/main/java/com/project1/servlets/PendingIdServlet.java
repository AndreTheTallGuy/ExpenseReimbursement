package com.project1.servlets;

import com.google.gson.Gson;
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
import java.util.List;

@WebServlet("/pendingId")
public class PendingIdServlet extends HttpServlet {
    User user = UserDAOImpl.user;

    /**
     * Gets all pending reimbursements by id 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ReimbDAOImpl impl = new ReimbDAOImpl();
        List<Reimbursement> list = impl.getAllReimbPendingByID(user.getId());

        String json = new Gson().toJson(list);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
    }
}
