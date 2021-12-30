package testcase;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TC41 {
    RequestSpecification requestSpc;
    ResponseSpecification responseSpc;

    @BeforeClass
    public void setup() {
        // 这里设置了 baseURI、basePath，后面get则不需要再填这2个信息
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        // RestAssured.port = 80;
        RestAssured.basePath = "/posts";
        // 恢复成默认设置
        // RestAssured.reset();

        //  利用RequestSpecification对象来封装一些请求数据
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addParam("userId", "2");
        builder.addHeader("Accept-Encoding", "gzip, deflate");
        requestSpc = builder.build();

        //  利用ResponseSpecification对象来封装一些响应判断的数据
        ResponseSpecBuilder rb = new ResponseSpecBuilder();
        rb.expectStatusCode(200);
        rb.expectHeader("Content-Type", "application/json; charset=utf-8");
        rb.expectHeader("Cache-Control", "max-age=43200");
        responseSpc = rb.build();
   }

    @Test
    public void test1() {
        given().
                spec(requestSpc).log().all().
                when().
                get().
                then().
                spec(responseSpc).
                // 如果错误就打印日志
                log().ifError();
    }
}
