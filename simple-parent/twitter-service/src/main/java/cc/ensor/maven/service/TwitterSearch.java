package cc.ensor.maven.service;

import cc.ensor.maven.service.model.TwitterResult;

import java.util.List;

public interface TwitterSearch {

    /**
     * Returns a list of TwitterResults based on search name
     *
     * @param searchTerm String
     * @return List<TwitterResult>
     */
    List<TwitterResult> searchByName(String searchTerm);

}
