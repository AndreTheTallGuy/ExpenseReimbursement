package com.project1.servlets;

import com.project1.dao.UserDAOImpl;
import com.project1.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

    public static final Logger logger = LogManager.getLogger(SignUp.class.getName());

    /**
     * Loads the Signup page
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {


        req.getRequestDispatcher("signUp.jsp").forward(req, res);
    }

    /**
     * adds a new user to the db
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(false, fname, lname, email, password, phone, username);
        UserDAOImpl impl = new UserDAOImpl();
        impl.addUser(user);
        logger.info("New Employee Signup!");
        res.sendRedirect(req.getContextPath() + "/home");

    }
}