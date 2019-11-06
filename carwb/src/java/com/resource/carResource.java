
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author holah
 */
@Path("/car")
public class carResource {

    car c = new car();
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("getCar/{id}")
    public List<car> getCar(@PathParam("id") int ID) throws SQLException {

        Connection conn = null;
        List eRRlistPerson = new ArrayList(); 
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restful", "root", "12345");

            String stmt = "SELECT * FROM car c WHERE c.id=?";
            System.out.println(stmt);
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
           
            
            List listPerson = new ArrayList();  
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setBrand(rs.getString("brand"));
                c.setModel(rs.getString("model"));
                c.setPrice(rs.getDouble("price"));
                c.setWheels(rs.getInt("wheels"));
                listPerson.add(c);
            }
            //System.out.println("<<<<<<<"+c.getModel());
            //String message = c.getId() +" "+ c.getBrand() +" "+ c.getModel() +" "+ c.getPrice() +" "+ c.getWheels();
           // return Response.status(Response.Status.OK).entity(listPerson).build();
           return listPerson;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(carResource.class.getName()).log(Level.SEVERE, null, ex);
        }
       // return Response.status(Response.Status.NOT_FOUND).build();
       return eRRlistPerson;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({"application/json"})
    @Path("postCar")
    public List<car> postCar(car cp)
    {
        //System.out.println("------------in here------------");
        List listPerson1 = new ArrayList();    
        listPerson1.add(cp.getId());
        listPerson1.add(cp.getBrand());
        listPerson1.add(cp.getModel());
        listPerson1.add(cp.getPrice());
        listPerson1.add(cp.getWheels());
        return listPerson1;
    }
}
