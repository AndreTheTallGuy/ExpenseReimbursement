package com.project1.servlets;

import com.google.gson.Gson;
import com.project1.dao.UserDAOImpl;
import com.project1.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getemployees")
public class EmployeeServlet extends HttpServlet {

    /**
     * Gets all employees from the db
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        UserDAOImpl impl = new UserDAOImpl();
        List<User> list = impl.getAllEmployees();

        String json = new Gson().toJson(list);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
    }
}
