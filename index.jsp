<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.expense.model.Expense" %>
<%@ page import="com.expense.model.Income" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expense Tracker - Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body style="background-color:orange;">

<nav>
    <a href="ViewExpenseServlet">Dashboard</a>
    <a href="add-income.html">Add Income</a>
    <a href="add-expense.html">Add Expense</a>
    <a href="about.html">About</a>
</nav>

<div class="container">
    <h2>Financial Overview</h2>
    
    <div class="dashboard-summary">
        <div class="card" style="background-color:yellow;">
            <h3>Total Income</h3>
            <p>Rs <span id="total-income"><%= request.getAttribute("total-income") != null ? request.getAttribute("total-income") : "0.0" %></span></p>
        </div>
        <div class="card" style="background-color:aqua;">
            <h3>Total Expense</h3>
            <p>Rs <span id="total-expense"><%= request.getAttribute("total-expense") != null ? request.getAttribute("total-expense") : "0.0" %></span></p>
        </div>
        <div class="card" style="background-color: pink">
            <h3>Available Balance</h3>
            <p>Rs <span id="balance">0.0</span></p>
        </div>
    </div>

    <h3>Income History</h3>
    <table>
        <thead>
            <tr>
                <th>S.No</th>
                <th>Date</th>
                <th>Source</th>
                <th>Amount (Rs)</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Income> incomes = (List<Income>) request.getAttribute("incomeList");
                if (incomes != null && !incomes.isEmpty()) {
                    for (Income inc : incomes) { 
            %>
            <tr>
                <td><%= inc.getSno() %></td>
                <td><%= inc.getInc_date() %></td>
                <td><%= inc.getSource() %></td>
                <td style="color: green;">+<%= inc.getAmount() %></td>
                <td>
                    <a href="DeleteIncomeServlet?sno=<%= inc.getSno() %>" class="delete-btn" onclick="return confirm('Are you sure you want to delete this income?');">Delete</a>
                </td>
            </tr>
            <%      }
                } else { %>
            <tr><td colspan="5" style="text-align:center;">No income records found.</td></tr>
            <% } %>
        </tbody>
    </table>

    <br><br>

    <h3>Expense History</h3>
    <table>
        <thead>
            <tr>
                <th>S.No</th>
                <th>Date</th>
                <th>Item</th>
                <th>Category</th>
                <th>Price (₹)</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Expense> expenses = (List<Expense>) request.getAttribute("expenseList");
                if (expenses != null && !expenses.isEmpty()) {
                    for (Expense exp : expenses) { 
            %>
            <tr>
                <td><%= exp.getSno() %></td>
                <td><%= exp.getExp_date() %></td>
                <td><%= exp.getItem() %></td>
                <td><%= exp.getCategory() %></td>
                <td style="color: red;">-<%= exp.getPrice() %></td>
                <td>
                    <a href="DeleteExpenseServlet?sno=<%= exp.getSno() %>" class="delete-btn" onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
                </td>
            </tr>
            <%      }
                } else { %>
            <tr><td colspan="6" style="text-align:center;">No expenses found.</td></tr>
            <% } %>
        </tbody>
    </table>
</div>

<script src="script.js"></script>
</body>
</html>