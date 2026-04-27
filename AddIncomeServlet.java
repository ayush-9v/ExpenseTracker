package com.expense.controller;

import com.expense.dao.DataDAO;
import com.expense.model.Income;
import com.expense.util.DBConnect;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddIncomeServlet")
public class AddIncomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        String source = request.getParameter("source");
        String inc_date = request.getParameter("inc_date"); 
        double amount = Double.parseDouble(request.getParameter("amount"));

        Income inc = new Income(sno, source, inc_date, amount);
        DataDAO dao = new DataDAO(DBConnect.getConnection());
        dao.addincome(inc);

        response.sendRedirect("ViewExpenseServlet");
    }
}