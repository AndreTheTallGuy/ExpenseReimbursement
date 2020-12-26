package com.project1.servlets;

import com.project1.dao.ReimbDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@WebServlet(name = "approve", urlPatterns = {"/approve"} )
public class ApproveServlet extends HttpServlet {
    /**
     * Receives data from a button on the front end to update a reimbursement to 'Approved' 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletInputStream input = req.getInputStream();

        StringBuilder string = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (input, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                string.append((char) c);
            }
        }
        int id = Integer.parseInt(string.toString());

        ReimbDAOImpl impl = new ReimbDAOImpl();
        impl.updatePending(id, "Approved");
        
    }
}
