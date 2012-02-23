package cc.ensor.maven.service;

import cc.ensor.maven.service.twitter.TwitterResponse;
import cc.ensor.maven.service.twitter.TwitterResult;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Service("twitterSearch")
public class TwitterSearchImpl implements TwitterSearch {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterSearchImpl.class);
    private static final String TWITTER_URL = "http://search.twitter.com/search.json";

    private final RestTemplate restTemplate;

    @Autowired
    public TwitterSearchImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<TwitterResult> searchByName(String searchTerm) {

        try {
            TwitterResponse object = restTemplate.getForObject(buildTwitterSearchURL(searchTerm), TwitterResponse.class);
            // for demo purposes, no error checking on response object
            return object.getResults();
        } catch (RestClientException e) {
            LOG.error("exception happened", e);
            throw Throwables.propagate(e);
        }
    }

    private String buildTwitterSearchURL(String searchTerm) {
        return TWITTER_URL + "?q=" + constructEncodedName(searchTerm) + "&rpp=10";
    }

    private String constructEncodedName(String searchTerm) {
        String encode = null;
        try {
            encode = URLEncoder.encode(searchTerm, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("Problem encoding {}", searchTerm);
        }
        return encode;
    }

}
