package cc.ensor.maven.service.twitter;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterResponse {
    private Long completed_in;
    private Long max_id;
    private String max_id_str;
    private String next_page;
    private Integer page;
    private String query;
    private String refresh_url;
    private List<TwitterResult> results;

    private TwitterResponse() {

    }

    public Long getCompleted_in() {
        return completed_in;
    }

    public void setCompleted_in(Long completed_in) {
        this.completed_in = completed_in;
    }

    public Long getMax_id() {
        return max_id;
    }

    public void setMax_id(Long max_id) {
        this.max_id = max_id;
    }

    public String getMax_id_str() {
        return max_id_str;
    }

    public void setMax_id_str(String max_id_str) {
        this.max_id_str = max_id_str;
    }

    public String getNext_page() {
        return next_page;
    }

    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRefresh_url() {
        return refresh_url;
    }

    public void setRefresh_url(String refresh_url) {
        this.refresh_url = refresh_url;
    }

    public List<TwitterResult> getResults() {
        return results;
    }

    public void setResults(List<TwitterResult> results) {
        this.results = results;
    }
}
