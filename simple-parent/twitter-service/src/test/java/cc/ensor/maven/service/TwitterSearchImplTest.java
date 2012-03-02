package cc.ensor.maven.service;

import cc.ensor.maven.service.model.TwitterResponse;
import cc.ensor.maven.service.model.TwitterResult;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwitterSearchImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private TwitterSearch twitterSearch;
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        restTemplate = mock(RestTemplate.class);
        twitterSearch = new TwitterSearchImpl(restTemplate);
    }

    @Test
    public void testSearchByName() throws Exception {
        String searchTerm = "SearchTerm";
        TwitterResponse mockedTwitterResponse = mock(TwitterResponse.class);
        TwitterResult element = mock(TwitterResult.class);
        String searchResults = "SearchResults";

        when(element.getText()).thenReturn(searchResults);
        List<TwitterResult> twitterResponseList = ImmutableList.of(element);
        when(mockedTwitterResponse.getResults()).thenReturn(twitterResponseList);
        when(restTemplate.getForObject(contains(searchTerm), eq(TwitterResponse.class))).thenReturn(mockedTwitterResponse);

        List<TwitterResult> twitterResults = twitterSearch.searchByName(searchTerm);
        assertThat(twitterResults.get(0).getText(), is(searchResults));
    }

    @Test
    public void RestClientException() {
        String exception = "Mocked Exception";

        thrown.expect(RestClientException.class);
        thrown.expectMessage(exception);

        when(restTemplate.getForObject(anyString(), eq(TwitterResponse.class))).thenThrow(new RestClientException(exception));

        twitterSearch.searchByName("MySearch");
    }
}
