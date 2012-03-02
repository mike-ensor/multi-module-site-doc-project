package cc.ensor.maven.web.controller;

import cc.ensor.maven.service.TwitterSearch;
import cc.ensor.maven.web.model.TwitterPageModel;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/twitter")
public class TwitterController {

    @Autowired
    @VisibleForTesting
    TwitterSearch twitterSearch;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String searchByName(@ModelAttribute("model") TwitterPageModel model) {
        return "twitter/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String searchByName_post(@Valid @ModelAttribute("model") TwitterPageModel model, BindingResult bindingResult) {
        String view = "twitter/home";

        if (bindingResult.hasErrors()) {
            view = "twitter/home";
        } else {
            model.setResults(twitterSearch.searchByName(model.getSearchTerm()));
        }

        return view;
    }

    @ModelAttribute("model")
    private TwitterPageModel getPageModel() {
        return new TwitterPageModel();
    }
}
