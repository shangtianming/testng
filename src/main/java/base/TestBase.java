package base;


import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

public class TestBase {

    public static RequestSpecification httpRequest;
    public static Response response;
    public Logger logger;

    public static String serverHost;
    public static String port;

    // 静态代码块，随着类的加载而执行，而且只执行一次
    static {
        // 用于加载properties文件，入参不需要文件扩展名.properties
        ResourceBundle rb = ResourceBundle.getBundle("config");
        serverHost = rb.getString("Host");
        port = rb.getString("Port");

    }

    @BeforeClass
    public void setup() {
        String className = this.getClass().getName();
        logger = Logger.getLogger(className);


//        PropertyConfigurator.configure("log4j.properties");
//        logger.setLevel(Level.DEBUG);
//        logger.info("host: " + serverHost);
//        logger.info("port: " + port);
    }

}


