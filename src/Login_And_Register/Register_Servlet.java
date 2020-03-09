import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by pc on 3/3/2020.
 */
public class Register_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fname = request.getParameter("first_name");
        String lname = request.getParameter("last_name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phone");
        String password = request.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO register VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,birthday);
            ps.setString(4,gender);
            ps.setString(5,email);
            ps.setString(6,phonenumber);
            ps.setString(7,password);
            int status = ps.executeUpdate();

            //Send email
            int code= (int) ((Math.random()*99999)+11111);
            sent_email.send(email,"Hello:","Welcome to our Book store .Your code here:"+code,sent_email.Text_email);

            if (status > 0) {

                request.getSession().setAttribute("confirm_email",code);
                request.getRequestDispatcher("Email_Confirmation.jsp").forward(request, response);
            }
            else {

                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
