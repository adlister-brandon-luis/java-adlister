package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }



    @Override
    public List<Ad> searchByTitle(String title) {
        List<Ad> searchResults = new ArrayList<>();

        try {
            String query = "SELECT * FROM ads WHERE title LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + title + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long adId = rs.getLong("id");
                long userId = rs.getLong("user_id");
                String adTitle = rs.getString("title");
                String description = rs.getString("description");

                Ad ad = new Ad(adId, userId, adTitle, description);
                searchResults.add(ad);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }



    public List<Ad> findByUserId(long userId) {
        List<Ad> userAds = new ArrayList<>();

        try {
            String query = "SELECT * FROM ads WHERE user_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long adId = rs.getLong("id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                Ad ad = new Ad(adId, title, description);
                userAds.add(ad);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userAds;
    }


    @Override
    public Ad findById(long id) {
        try {
            String query = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractAd(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }




}
