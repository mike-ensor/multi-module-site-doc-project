package cc.ensor.maven.web.model;

import cc.ensor.maven.service.model.TwitterResult;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

public class TwitterPageModel {

    @NotNull(message = "{twitter.search.term.missing}")
    @Size(min = 1, max = 20, message = "{twitter.search.term.size}")
    private String searchTerm;

    private List<TwitterResult> results;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<TwitterResult> getResults() {
        List<TwitterResult> returnResults;
        if (results == null) {
            returnResults = Collections.emptyList();
        } else {
            returnResults = results;
        }
        return returnResults;
    }

    public void setResults(List<TwitterResult> results) {
        this.results = results;
    }
}
