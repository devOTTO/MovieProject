package main.java.web;
import main.java.domain.Director;
import main.java.domain.DirectorService;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.util.Status;

@WebServlet("/createdirector")
public class CreateDirectorServlet extends HttpServlet {

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

        String dirName = request.getParameter("dirName");

        int dirAge = Integer.parseInt(request.getParameter("dirAge"));
        Director director = new Director(dirName, dirAge);
        
        try {

            DirectorService directorservice = new DirectorService();
            int ID = directorservice.Insert(director);
            System.out.println(ID);
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("NewDirector.jsp");
                view.forward(request, response);
                return;
            }

            director = new Director(dirName, dirAge);
            request.setAttribute("director", director);

            view = request.getRequestDispatcher("main.jsp");
            view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("NewDirector.jsp");
            view.forward(request, response);
        }
    }
}