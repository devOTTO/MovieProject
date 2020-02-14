package main.java.web;

import main.java.domain.Director;
import main.java.domain.DirectorService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.util.Status;

@WebServlet("/showdirectordata")
public class DirectorServlet extends HttpServlet {

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

        int dirId = Integer.parseInt(request.getParameter("dirId"));

        Director director = null;

        try {

            DirectorService dirieservice = new DirectorService();

            director = dirieservice.selectedDirector(dirId);

            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("DirectorList.jsp");
                view.forward(request, response);
                return;
            }

            request.setAttribute("director", director);

            view = request.getRequestDispatcher("DirectorData.jsp");
            view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("DirectorList.jsp");
            view.forward(request, response);
        }
    }
}