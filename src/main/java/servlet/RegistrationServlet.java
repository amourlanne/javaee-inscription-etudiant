package servlet;

import entity.Registration;
import exception.InvalidFormException;
import services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        Map<String, List<Registration>> registrations = new HashMap<>();

        for (String level : RegistrationService.getLevels()) {
            registrations.put(level, new ArrayList<>());
        }

        getServletContext().setAttribute("registrations", registrations);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher( "/WEB-INF/jsp/registration.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String level = request.getParameter("level");

        try {

            Map<String,List> allRegistrations = (Map<String, List>) getServletContext().getAttribute("registrations");

            Registration registration = RegistrationService.register(firstName, lastName, level);
            request.setAttribute("registration", registration);

            if(allRegistrations != null) {

                List<Registration> registrations = allRegistrations.get(level);
                registrations.add(registration);
                allRegistrations.put(level,registrations);

                request.setAttribute("level", level);
                request.setAttribute("registrations", registrations);
            }

            this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/registration-success.jsp" ).forward( request, response );
        } catch (InvalidFormException e) {
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);

            request.setAttribute("errors", e.getMessages());
            this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/registration.jsp" ).forward( request, response );
        }
    }
}
