package cc.ensor.maven.service;

import cc.ensor.maven.service.twitter.TwitterResult;

import java.util.List;

public interface TwitterSearch {

    List<TwitterResult> searchByName(String searchTerm);

}
