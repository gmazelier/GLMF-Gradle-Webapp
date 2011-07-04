package glmf.gradle;

import static org.junit.Assert.assertEquals;

import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;
import org.junit.Before;
import org.junit.Test;

public class TestHelloGradle {

    private static ServletTester tester;
    private static HttpTester response;

    private void doGet(String url) throws Exception {
        String request = "GET /" + url + " HTTP/1.0\r\n\r\n"; 
        String out = tester.getResponses(request);
        response = new HttpTester();
        response.parse(out);
    }

    @Before
    public void setUp() throws Exception {
        tester = new ServletTester();
        tester.setContextPath("/");
        tester.addServlet(HelloGradle.class, "/HelloGradle");
        tester.start();
    }

    @Test
    public void test200GoodUrl() throws Exception {
        doGet("HelloGradle");
	assertEquals(200, response.getStatus());
    }

    @Test
    public void testContentGoodUrl() throws Exception {
        doGet("HelloGradle");
        assertEquals("Hello Gradle!\n", response.getContent());
    }

    @Test
    public void test404BadUrl() throws Exception {
        doGet("BadUrl");
        assertEquals(404, response.getStatus());
    }

}
