package testcase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.JsonDataResult;
import pojo.UserVo;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test001 {

    @BeforeClass
    public void setUp(){
         RestAssured.reset();
    }


    @Test
    public void test0011() {
        UserVo user = new UserVo(1, "zhangsan", new Date(), false);

        given().
                // 直接传入对象
                body(user).
                // 两种设置入参类型
                header("Content-Type", "application/json; charset=utf-8").
                // contentType("application/json; charset=utf-8");
                log().all().
                when().
                post("/api/user/createUserByParam").
                then().
                log().body();

        // 这里没有设置baseurl，但是依然请求成功了。因为框架有默认的url：http://localhost:8080
        Response response = get("/api/user/3");
        System.out.println("======"+response.asString());
        // 使用 as 将响应转化为我们需要的对象
        JsonDataResult j = response.as(JsonDataResult.class);
        // 拿到响应后也可以用testng本身的断言
        Assert.assertEquals(j.isSuccess(),false);
    }
}
