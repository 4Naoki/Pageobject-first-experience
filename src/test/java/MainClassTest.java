import org.junit.*;

public class MainClassTest {

//    @BeforeClass
//    public void beforeClassMethod() {
//
//    }
//
//    @Before
//    public void setUp() {
//
//    }
//
//
//    @After
//    public void tearDown() {
//
//    }

    @Test
    public void  method1(){
        Assert.assertTrue("Values aren't equal!", 1 + 1 == 3);
        Assert.assertFalse(1 + 1 == 10);
    }

//    @Test
//    @Ignore
//    public void  method2(){
//        Assert.assertNull();
//        Assert.assertNotNull();
//    }

    @Test
    public void  method3(){
        Assert.assertEquals(20, 5 + 5);
        Assert.assertNotEquals(10, 2 + 2);

    }

//    @AfterClass
//    public void afterClassMethod() {
//
//    }


}
