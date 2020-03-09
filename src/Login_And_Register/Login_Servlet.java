import org.omg.CORBA.Request;

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
 * Created by pc on 3/3/2020.
 */
public class Login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM register WHERE email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();

            //int status=ps.executeQuery();
            if (rs.next())
            {
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("Signin.jsp").forward(request,response);
            }

//            while (rs.next()){
//                request.getRequestDispatcher("success.jsp").forward(request,response);
//            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
