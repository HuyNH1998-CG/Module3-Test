package Service;

import Connector.Connect;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "")
public class main extends HttpServlet {

    ProductDAO DAO;
    Connect connect = new Connect();

    @Override
    public void init() throws ServletException {
        DAO = new ProductDAO(connect.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> showCreateProduct(req, resp);
            case "edit" -> showEditProduct(req, resp);
            case "delete" -> deleteProduct(req, resp);
            default -> views(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> createProduct(req, resp);
            case "edit" -> editProduct(req, resp);
            case "search" -> searchProduct(req,resp);
        }
    }

    private void views(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> list = (ArrayList<Product>) DAO.getProduct();
        req.setAttribute("products", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Category> categories = (ArrayList<Category>) DAO.getCategory();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int category = Integer.parseInt(request.getParameter("category"));
            DAO.insertProduct(name, amount, color, description, category, price);
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product editPrd = DAO.getProductById(id);
        request.setAttribute("product", editPrd);
        ArrayList<Category> categories = (ArrayList<Category>) DAO.getCategory();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int category = Integer.parseInt(request.getParameter("category"));
            DAO.editProduct(id, name, amount, color, description, category, price);
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        DAO.deleteProduct(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        ArrayList<Product> list = (ArrayList<Product>) DAO.getProductByName(name);
        request.setAttribute("products", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
