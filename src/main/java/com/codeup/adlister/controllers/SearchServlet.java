package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.searchServlet", urlPatterns = "/searchResults")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title"); // Retrieve the search parameter from the request

        // Call the DAO to search by title
        Ads userAds = DaoFactory.getAdsDao();
        List<Ad> searchResults = userAds.searchByTitle(title);

        // Store the search results in a request attribute
        request.setAttribute("searchResults", searchResults);

        // Forward the request to the JSP for displaying the search results
        request.getRequestDispatcher("WEB-INF/searchResults.jsp").forward(request, response);
    }
}