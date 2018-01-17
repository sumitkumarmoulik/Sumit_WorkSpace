package backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
 
    public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
        
    String server = "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/" + System.getenv("OPENSHIFT_APP_NAME") + "";
    String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    String pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    System.out.println("Server :" + server);
    
    System.out.println("Server :" + user);
    
    System.out.println("Server :" + pass);
    } 
    
}

