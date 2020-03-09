import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pc on 3/4/2020.
 */
public class confirmation_email extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email_code=request.getSession().getAttribute("confirm_email").toString();
        String code=request.getParameter("confirm_gmail");
        if (code.equalsIgnoreCase(email_code)){
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }else {
            String message="Wrong Code!! Please Retype your Confirmation code!";
            request.setAttribute("message",message);
            //System.out.println("Testing Message");
            request.getRequestDispatcher("Email_Confirmation.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
