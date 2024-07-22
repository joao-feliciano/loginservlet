package com.servlet.login.loginservletexample.Controller;

import com.servlet.login.loginservletexample.DAO.ClientDAO;
import com.servlet.login.loginservletexample.Model.Client;
import com.servlet.login.loginservletexample.Service.ClientAuthenticator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/teste", "/index", "/login", "/addNewClient", "/listAllClients", "/logout"})
public class ClientController extends HttpServlet {
    private ClientDAO clientDAO;

    public void init() {
        clientDAO = new ClientDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        ClientAuthenticator authenticator = new ClientAuthenticator();
        Client client;

        switch (action) {
            case "/login": {
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                Client authClient = authenticator.authenticate(email, password);
                if (authClient != null) {
                    request.getSession().setAttribute("client", authClient);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                } else {
                    request.getSession().setAttribute("client", authClient);
                    request.getRequestDispatcher("loginFail.jsp").forward(request, response);
                }
                break;
            }
            case "/addNewClient": {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                Client existingClient = clientDAO.findByEmail(email);
                if (existingClient != null) {
                    request.setAttribute("client", new Client(name, email, password));
                    request.getRequestDispatcher("addFail.jsp").forward(request, response);
                } else {
                    client = Client.builder().name(name).password(password).email(email).build();
                    clientDAO.save(client);
                    request.getSession().setAttribute("client", client);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                }

                System.out.println(name);
                break;
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/index":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/listAllClients": {
                List<Client> clients = clientDAO.findAll();
                request.setAttribute("clients", clients);
                request.getRequestDispatcher("listAllClients.jsp").forward(request, response);
                break;
            }
            case "/login":
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "/logout": {
                request.getSession().invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            }
        }
    }
}
