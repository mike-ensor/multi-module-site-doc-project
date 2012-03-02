package cc.ensor.maven.web.controller;

import cc.ensor.maven.service.TwitterSearch;
import cc.ensor.maven.service.model.TwitterResult;
import cc.ensor.maven.web.model.TwitterPageModel;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwitterControllerTest {

    private TwitterController controller;
    private TwitterSearch twitterSearchMock;

    @Before
    public void setUp() {
        controller = new TwitterController();
        twitterSearchMock = mock(TwitterSearch.class);
        controller.twitterSearch = twitterSearchMock;
    }

    @Test
    public void searchByName_post() throws Exception {
        String searchTerm = "SearchTerm";

        List<TwitterResult> twitterResultList = getSearchResults("Tweeted This today!");
        when(twitterSearchMock.searchByName(eq(searchTerm))).thenReturn(twitterResultList);

        TwitterPageModel model = createSearchPost(searchTerm);

        String results = controller.searchByName_post(model, new BeanPropertyBindingResult(TwitterPageModel.class, "model"));
        assertThat(model.getResults().size(), is(1));
        assertThat(results, is("twitter/home"));
    }

    @Test
    public void searchByName_post_postError() throws Exception {
        String searchTerm = "SearchTerm";

        List<TwitterResult> twitterResultList = getSearchResults("Tweeted This today!");
        when(twitterSearchMock.searchByName(eq(searchTerm))).thenReturn(twitterResultList);

        TwitterPageModel model = createSearchPost(searchTerm);

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(TwitterPageModel.class, "model");
        bindingResult.reject("someErrorCode");

        String results = controller.searchByName_post(model, bindingResult);
        assertThat(model.getResults().size(), is(0));
        assertThat(results, is("twitter/home"));
    }

    @Test
    public void testSearchByName() throws Exception {
        String results = controller.searchByName(new TwitterPageModel());
        assertThat(results, is("twitter/home"));
    }

    private TwitterResult twitterResult(String textResult) {
        TwitterResult result = mock(TwitterResult.class);
        when(result.getText()).thenReturn(textResult);
        return result;
    }

    private List<TwitterResult> getSearchResults(String textResult) {
        return ImmutableList.of(twitterResult(textResult));
    }

    private TwitterPageModel createSearchPost(final String searchTerm) {
        TwitterPageModel model = new TwitterPageModel();
        model.setSearchTerm(searchTerm);
        return model;
    }
}
