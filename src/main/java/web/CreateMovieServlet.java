package main.java.web;

import main.java.domain.Movie;
import main.java.domain.MovieService;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.util.Status;

@WebServlet("/createmovie")
public class CreateMovieServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher view = null;
        Status status = new Status();
        request.setAttribute("status", status);

        String movName = request.getParameter("movName");
        Date movDate = java.sql.Date.valueOf(request.getParameter("movDate"));
        int movRate = Integer.parseInt(request.getParameter("movRate"));
        int dirId = Integer.parseInt(request.getParameter("dirId"));

        Movie movie = new Movie(movName, movDate, movRate, dirId);
        
        try {

            MovieService movieservice = new MovieService();
            int ID = movieservice.Insert(movie);
            System.out.println(ID);
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("NewMovie.jsp");
                view.forward(request, response);
                return;
            }

            movie = new Movie(movName, movDate, movRate, dirId);
            request.setAttribute("movie", movie);

            view = request.getRequestDispatcher("main.jsp");
            view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("NewMovie.jsp");
            view.forward(request, response);
        }
    }
}