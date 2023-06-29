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

@WebServlet(name = "controllers.DetailsServlet", urlPatterns = "/details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        long adId = Long.parseLong(request.getParameter("adId"));
        Ads adsDao = DaoFactory.getAdsDao();
        Ad ad = adsDao.findById(adId);
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/detailsPage.jsp").forward(request, response);
    }
}
