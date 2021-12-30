package testcase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;
// 官方推荐静态引用
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC4 {

    @Test
    public void testParams() {
        // 1、given() 是RestAssured类下一个方法，官方文档强烈推荐使用静态导入语句
        // 2、when().
        // 3、get方法，对应GET请求，这一步已经请求完成了
        // 4、then() 为后面对response消息做判断时做准备
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("userId", "2");
        params.put("id", "14");

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("accept-encoding", "gzip,deflate");
        headers.put("accept-language", "zh-CN");

        given().
                // 调用效果：http://jsonplaceholder.typicode.com/posts?id=14&userId=2
                // 这个貌似和params一样的效果
                queryParams(params).
                // params(params).
                // param只能设置一个参数，多调用几次可以多设置几个参数，下面的header类似
                // param("userId", 2).
                // 多个头字段
                headers(headers).
                // header("accept-encoding", "gzip,deflate").
            when().
                // 请求前的log 是打印请求参数信息
                // log().all().
                    get("http://jsonplaceholder.typicode.com/posts").
            then().
                // 请求后的log 是打印响应参数信息
                    log().body();
    }

    @Test
    public void testPost() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", "Anthony123");
        params.put("job", "tester");

        given().
                // 参数在 Request params下面
                // param("name", "Anthony123").
                // param("job", "tester").
                        params(params).
                // 参数在 Form params （表单提交）下面，不知道和上面的有什么区别， 虽然请求结果和上面相同
                // formParams(params).
                        header("Content-Type", "text/html").
                when().post("https://reqres.in/api/users").
                then().log().body();
    }

    @Test
    public void testAssert() {
        given().
                    pathParam("section", "posts").
                    pathParam("id", "3").
                when().
                    get("http://jsonplaceholder.typicode.com/{section}/{id}").
                then().
                // 下面的断言是线性断言，一旦某个断言失败，后面就不会继续执行
                //断言200
                    statusCode(200).
                // 断言返回的格式对象，例如XML、HTML、TEXT等
                    contentType(ContentType.JSON).
                // 断言响应头字段，header单个，headers多个
                    header("Content-Type", "application/json; charset=utf-8").
                    headers("Content-Type", "application/json; charset=utf-8", "Connection", "keep-alive").
                // Matchers提供了很多匹配方式，equalTo、containsString。hasItem、hasItems这2个我没用成功
                    body(containsString("ea molestias quasi exercitationem")).
                    body("userId", equalTo(1)).

                // body("title", hasItem("ea molestias quasi exercitationem repellat qui ipsa sit aut")).
                // 不同节点相同的key有对应的value，例如：{{"title": "value1"},{"title": "value2"}}，
                // 则不能使用equalTo、hasItem，可以使用hasItems（要求把所有的value列出来）
                // body("title", hasItems("ea molestias quasi exercitationem repellat qui ipsa sit aut")).

                // 断言响应时间小于2000毫秒，参数类型是long
                        time(lessThan(2000L)).
                log().body();
    }

    @Test
    public void testResponse() {
        // 在没有参数设置的前提下，可以直接请求，拿到响应
        Response r = get("https://reqres.in/api/users/2");
        // 响应结果转化为类对象
//        ResponseClass rc=r.as(ResponseClass.class);

        System.out.println("直接获取的响应结果：" + r.asString());
        System.out.println("获取请求头：" + r.getHeaders());
        System.out.println("获取请求头某个字段：" + r.getHeader("Content-Type"));
        System.out.println("获取cookies：" +r.cookies());
        System.out.println("毫秒：" + r.time());
        System.out.println("毫秒，会损失精度：" + r.timeIn(TimeUnit.SECONDS));

        Integer id = r.
                then().
                // json、xm都可以使用xpath路径
                body("data.id", is(2)).
                // 通过extract().path() 摘取内容
                extract().
                path("data.id");

        Response response = r.
                then().
                extract().
                response();
        System.out.println("间接获取到的响应和直接获取的响应比较：" + ( response == r ));
        System.out.println("间接获取到的id和直接获取的id比较：" + ( id == r.path("data.id") ));
    }
}
