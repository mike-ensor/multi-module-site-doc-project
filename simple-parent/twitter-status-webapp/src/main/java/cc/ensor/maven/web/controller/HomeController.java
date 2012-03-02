package cc.ensor.maven.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
/**
 * Home Controller sample
 *
 * All Request to "/home" start here
 */
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    /**
     * No additional request value mapping, but forces to only GET requests
     *
     * @return String viewForInternalViewResolver
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage() {
        LOG.debug("Hitting the home page");
        return "home/home";
    }

}
