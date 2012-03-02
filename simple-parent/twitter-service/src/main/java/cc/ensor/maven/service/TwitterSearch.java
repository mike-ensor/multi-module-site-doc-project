package cc.ensor.maven.service;

import cc.ensor.maven.service.model.TwitterResult;

import java.util.List;

public interface TwitterSearch {

    List<TwitterResult> searchByName(String searchTerm);

}
