<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
      table{
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
      }
      table td, table th{
        border: 1px solid #ddd;
        padding: 8px;
      }
      table tr:nth-child(even){
        background-color: #f2f2f2;
      }
      table tr:hover{
        background-color: #ddd;
      }
      table th{
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #04AA6D;
        color: white;
      }
    </style>
  </head>
  <body>
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <a href="/?action=create" class="btn btn-primary">Create</a>
      </div>
      <div class="col-md-6"></div>
      <div class="col-md-4">
        <form action="/?action=search" method="post">
          <input type="text" name="name">
          <button type="submit" class="btn btn-primary">Search</button>
        </form>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="container">
      <h1>Product List</h1>
      <table>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Price</th>
          <th>Amount</th>
          <th>Colour</th>
          <th>Description</th>
          <th>Category</th>
          <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
          <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.amount}</td>
            <td>${product.colour}</td>
            <td>${product.description}</td>
            <td>${product.category}</td>
            <td>
              <a href="/?action=edit&id=${product.id}"class="btn btn-primary">Edit</a>
              <a href="/?action=delete&id=${product.id}"class="btn btn-danger" onclick="return confirm('Do you want to delete?')">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  </body>
</html>
