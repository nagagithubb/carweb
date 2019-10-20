
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userid=request.getParameter("UserId");
        String pwd=request.getParameter("Password");
        
        PrintWriter p = response.getWriter();
        p.println("User Id is -"+userid);
        p.println("<br/>");
        p.println("Password is -"+pwd);
        
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root","12345");
            
            String sql = "insert into login.logintable(UserId, Password) values('"+userid+"','"+pwd+"')";
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            p.println("<br/>");
            p.println("Executed Successfully");
            p.println("<br/>");
            p.println("<br/>");
              
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            String sql1 = "select * from login.logintable";
            ResultSet rs = null;
        try {            
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql1);
            p.println("Database details:");
             p.println("----------------");
            while(rs.next())
            {
                p.println("<br/>");
                p.println("UserId is : "+rs.getString("UserId"));
                p.println("<br/>");
                p.println("Password is : "+rs.getString("Password"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
       /* String changed_userid = "Updated";
        userid="qwerty";
        String sql2 = "Update login.logintable set UserId='"+changed_userid+"' where UserId='"+userid+"'";
           
        try {            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql2);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        userid = "Updated";
        String sql3 = "Delete from login.logintable where UserId='"+userid+"'";
           
        try {            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql3);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
