package main.java.web;

import main.java.domain.Movie;
import main.java.domain.MovieService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.util.Status;

@WebServlet("/showmoviedata")
public class MovieServlet extends HttpServlet {

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

        int movId = Integer.parseInt(request.getParameter("movId"));

        Movie movie = null;

        try {

            MovieService movieservice = new MovieService();

            movie = movieservice.selectedMovie(movId);

            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("MovieList.jsp");
                view.forward(request, response);
                return;
            }

            request.setAttribute("movie", movie);

            view = request.getRequestDispatcher("MovieData.jsp");
            view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("MovieList.jsp");
            view.forward(request, response);
        }
    }
}