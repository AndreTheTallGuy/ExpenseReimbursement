package com.project1.servlets;

import com.project1.dao.UserDAOImpl;
import com.project1.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class LoginServlet extends HttpServlet {
    UserDAOImpl impl = null;
    User user = UserDAOImpl.user;
    /**
     * loads the login page
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {


        req.getRequestDispatcher("login.jsp").forward(req, res);
    }

    /**
     * Post request that takes a user's username and checks their password with the database
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        user = null;
        impl = new UserDAOImpl();
        user = impl.getUserByUserName(username);

        req.setAttribute("user", user);

        if(user.getPassword().equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            if(user.getIsManager()){
                res.sendRedirect(req.getContextPath() + "/manager");

            }else{
                res.sendRedirect(req.getContextPath() + "/employee");
            }
        }else{
            req.getRequestDispatcher("loginFail.jsp").forward(req, res);
        }

    }

}
