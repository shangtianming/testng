package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.User;
import pojo.UserResponse;

import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;

public class TC42 {

    @Test
    public void testSerializationUsingBeanClass() {
        User u = new User();
        u.setAge(18);
        u.setWeight(75);
        u.setHome("China");

        UserResponse as = given().
                contentType("application/json").
                // 传入对象
                        body(u).
                        when().
                        post("http://www.thomas-bayer.com/restnames/countries.groovy").
                // 转为响应对象
                        as(new TypeRef<UserResponse>(){});
        Assert.assertEquals(as.getRegId(),0);
    }
}
