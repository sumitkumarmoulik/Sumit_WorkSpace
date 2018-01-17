package backend.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ApplicationController {
@RequestMapping("/")
   public String sayHello() {
      return "Hello Spring Boot!!";
   }
   
    private String server = "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/" + System.getenv("OPENSHIFT_APP_NAME") + "";
    private String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    private String pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    private Connection conn;

    @RequestMapping("/conn")
    public Connection conectar() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(server, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex + ex.getMessage());
        }

        return this.conn;
    }
}
