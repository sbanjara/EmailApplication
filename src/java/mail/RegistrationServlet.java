
package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("application/text;charset=UTF-8");
        PrintWriter out = response.getWriter();

        SendEmail email = new SendEmail();
        String e = request.getParameter("email");
        String session = request.getParameter("session");
        String name = request.getParameter("name");
        String displayname = request.getParameter("displayname");
        String comment = request.getParameter("comment");
        
        if(e.isEmpty() || session.isEmpty() || name.isEmpty() || displayname.isEmpty()) {
            
        }
        else {
            email.sendEmail(e, name, displayname, session, comment);
        }

  
    }

   
    @Override
    public String getServletInfo() {
        return "It gets the input fields from a registration form and sends the email confirmation.";
    }
}
