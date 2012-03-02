package cc.ensor.maven.web.controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeControllerTest {

    @Test
    public void testShowHomePage() throws Exception {
        HomeController controller = new HomeController();
        assertThat(controller.showHomePage(), is("home/home"));
    }
}
