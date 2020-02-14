package main.java.web;

import main.java.domain.Director;
import main.java.domain.DirectorService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.util.Status;

@WebServlet("/searchdirector")
public class SearchDirectorServlet extends HttpServlet {
	

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
        request.setCharacterEncoding("UTF-8");
        String dirName = request.getParameter("dirName");

        ArrayList<Director> directors = new ArrayList<Director>();

        try {

            DirectorService directorservice = new DirectorService();

            directors = directorservice.getSearchedDirectors(dirName);
            StringBuffer result = new StringBuffer("");
            result.append("[");
            //result.append("{\"result\":[");
            for(int i = 0; i<directors.size(); ++i) {
            	result.append("{\"dirId\":" + directors.get(i).getDirId() + ",");
            	result.append("\"dirName\":\"" + directors.get(i).getDirName() + "\"}");
            	if(i+1 != directors.size()) result.append(",");
            }
            result.append("]");
     
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("DirectorList.jsp");
                view.forward(request, response);
                return;
            }
            //response.setContentType("text/html;charset=UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(result);
            response.getWriter().flush();
            System.out.println(result.toString());
            //view = request.getRequestDispatcher("DirectorData.jsp");
            //view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            //view = request.getRequestDispatcher("DirectorList.jsp");
            //view.forward(request, response);
        }
    }
}