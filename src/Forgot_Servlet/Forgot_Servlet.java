import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pc on 3/4/2020.
 */
public class Forgot_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("UPDATE register SET password=? WHERE email=?");
            ps.setString(1,password);
            ps.setString(2,email);
            //ResultSet rs=ps.executeQuery();
            int status=ps.executeUpdate();
            if (status>0){
                request.getRequestDispatcher("Signin.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("forgot.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
