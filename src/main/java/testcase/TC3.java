package testcase;

import constants.Constants;
import utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC3 {

//    @Test
//    public void testGet() throws IOException {
//        String rsp = HttpUtils.get(Constants.Url.MAPPING_URL);
//        System.out.println(rsp);
//    }
//
//    @Test(dataProvider = "test")
//    public void testPost(String params) throws IOException {
//        String rsp = HttpUtils.post(Constants.Url.SEARCH_URL, params);
//        System.out.println(rsp);
//    }
//
//    @DataProvider(name = "test")
//    public Object[] data() {
//        return new Object[]{"{\"query\":{\"bool\":{\"must\":[{\"match_all\":{}}],\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":10,\"sort\":[],\"aggs\":{}}"};
//    }
}