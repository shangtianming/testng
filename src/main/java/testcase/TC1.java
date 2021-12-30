package testcase;

import org.testng.Assert;
import org.testng.annotations.*;

public class TC1 {
    @BeforeSuite
    public void suiteBefore(){ System.out.println("测试BeforeSuite"); }
    @AfterSuite
    public void suiteAfter(){ System.out.println("测试AfterSuite"); }

    @BeforeClass
    public void beforeClass() { System.out.println("BeforeClass，开始执行一次"); }
    @AfterClass
    public void afterClass() { System.out.println("AfterClass，结束执行一次");}

    @BeforeMethod
    public void beforeTest() { System.out.println("BeforeMethod，每个用例前执行一次"); }
    @AfterMethod
    public void afterMethod() { System.out.println("AfterMethod，每个用例后执行一次"); }

    @BeforeGroups("mark")
    public void beforeGroups() { System.out.println("BeforeGroups，group前执行一次"); }
    @AfterGroups("mark")
    public void afterGroups() { System.out.println("AfterGroups，group后执行一次"); }

    @Test(groups = "mark", priority = 2) // 将该case 的groups标注为 mark；priority表示运行顺序
    public void case1() { Assert.assertEquals(1, 1); }
    @Test(dataProvider = "dp", priority = 1) // dataProvider 获取数据驱动
    public void case2(Integer n, String s) { System.out.println("case2："+n+s); }

    @DataProvider // 做数据驱动,数据源文件可以是EXCEL，XML，甚至可以是TXT文本
    public Object[][] dp() {
        System.out.println("Inside @DataProvider");
        return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" },};
    }
}
