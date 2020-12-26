package com.project1.dao;

import com.project1.models.Reimbursement;
import com.project1.models.User;
import com.project1.servlets.*;
import com.project1.utilities.DAOUtilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOImplTest {
    User user = null;
    UserDAOImpl impl = new UserDAOImpl();
    ReimbDAOImpl rimpl = new ReimbDAOImpl();

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setConnection(){
        DAOUtilities.config();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void a_addUser(){
        User user = new User(true, "first", "last", "no@no.com", "pass", "1234567890", "username" );
        boolean test = impl.addUser(user);
        Assert.assertTrue(test);
    }

    @Test
    public void b_getUserByUserName(){
        User user = impl.getUserByUserName("username");
        Assert.assertNotNull(user);
    }
    @Test
    public void c_getUserById(){
        User user = impl.getUserByID(1);
        Assert.assertNotNull(user);

    }

    @Test
    public void d_getAllEmployees(){
        List<User> list = impl.getAllEmployees();
        Assert.assertNotNull(list);
    }

    @Test
    public void e_addReimb(){
        Reimbursement reimb = new Reimbursement(1, "amount", "reason", "result", 1);
        boolean test = rimpl.addReimb(reimb);
        Assert.assertTrue(test);
    }

    @Test
    public void f_getAllReimbPendingByIDTest(){
        List<Reimbursement> r = rimpl.getAllReimbPendingByID(11);
        Assert.assertNotNull(r);

    }
    @Test
    public void f_getAllReimbPendingTest(){
        List<Reimbursement> r = rimpl.getAllReimbPending();
        Assert.assertNotNull(r);
    }

    @Test
    public void f_getAllReimbResolvedTest(){
        List<Reimbursement> r = rimpl.getAllReimbResolved();
        Assert.assertNotNull(r);
    }

    @Test
    public void f_getAllReimbResolvedByIDTest(){
        List<Reimbursement> r = rimpl.getAllReimbResolvedByID(11);
        Assert.assertNotNull(r);
    }

/*
Servlets
 */

    @Test
    public void f_LoginServletTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher rs = mock(RequestDispatcher.class);

        when(request.getParameter("username")).thenReturn("username");
        when(request.getParameter("password")).thenReturn("password");
        when(request.getRequestDispatcher("loginFail.jsp")).thenReturn(rs);
        
        LoginServlet ls = new LoginServlet();
        ls.doPost(request, response);
        Assert.assertNotNull(request.getParameter("username"));
        Assert.assertNotNull(request.getParameter("password"));
        
    }

    @Test
    public void g_CreateReimbursementTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher rs = mock(RequestDispatcher.class);

        when(request.getParameter("amount")).thenReturn("amount");
        when(request.getParameter("reason")).thenReturn("reason");
        when(request.getRequestDispatcher("employeeHome.jsp")).thenReturn(rs);
        
        CreateReimbursement ls = new CreateReimbursement();
        ls.doPost(request, response);
        Assert.assertNotNull(request.getParameter("amount"));
        Assert.assertNotNull(request.getParameter("reason"));

    }

    @Test
    public void h_signUpTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher rs = mock(RequestDispatcher.class);

        when(request.getParameter("fname")).thenReturn("fname");
        when(request.getParameter("lname")).thenReturn("lname");
        when(request.getParameter("email")).thenReturn("email");

        when(request.getRequestDispatcher("login.jsp")).thenReturn(rs);

        SignUp ls = new SignUp();
        ls.doPost(request, response);
        Assert.assertNotNull(request.getParameter("fname"));
        Assert.assertNotNull(request.getParameter("lname"));
        Assert.assertNotNull(request.getParameter("email"));

    }

    @Test
    public void i_EmployeeHomeServletTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher rs = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("employeeHome.jsp")).thenReturn(rs);

        EmployeeHomeServlet ems = new EmployeeHomeServlet();
        ems.doGet(request, response);

    }

    @Test
    public void j_ManagerHomeServletTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher rs = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("managerHome.jsp")).thenReturn(rs);

        ManagerHomeServlet ems = new ManagerHomeServlet();
        ems.doGet(request, response);

    }




//    @Test
//    public void LogOutServletTest() throws ServletException, IOException {
//        RequestDispatcher rs = mock(RequestDispatcher.class);
//        when(request.getRequestDispatcher("/logout"))
//        new LogoutServlet().doGet(request,response);
//
//    }


}




