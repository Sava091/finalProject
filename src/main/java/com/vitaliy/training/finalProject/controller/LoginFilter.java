package com.vitaliy.training.finalProject.controller;

import com.vitaliy.training.finalProject.dao.ClientDao;
import com.vitaliy.training.finalProject.dao.ClientDaoImpl;
import com.vitaliy.training.finalProject.model.Client;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LoginFilter implements Filter {
    public static final String USER_ID = "userId";
    public static final String LOGIN = "login";
    public static final String PASS = "pass";

    private ClientDao clientDao = ClientDaoImpl.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Map<String, String[]> session = ((HttpServletRequest) request).getParameterMap();
        if (!auth(request, response)) {
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean auth(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null && session.getAttribute(USER_ID) != null) {
            return true;
        }
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASS);
        if (login == null || login.isEmpty()) {
            error(request, response, "Login can't be empty");
            return false;
        }
        if (pass == null || pass.isEmpty()) {
            error(request, response, "Password can't be empty");
            return false;
        }

        Client client = clientDao.readByName(login);
        if (client == null || !pass.equals(client.getPassword())) {
            error(request, response, "Login/password incorrect");
            return false;
        }
        session = ((HttpServletRequest) request).getSession();
        session.setAttribute(USER_ID, client.getId());
        return true;
    }

    private void error(ServletRequest request, ServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("errorMessage", message);
        request.getRequestDispatcher("/login_page.jsp").forward(request, response);

    }

    @Override
    public void destroy() {

    }
}
