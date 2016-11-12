package pagination;

import constant.ConfigParameter;
import java.util.List;

public class Page {
    private List<?> content;
    private String baseUrl;
    private int currentPageIndex;

    public Page(List<?> content) {
        this.content = content;
    }

    public List<Object> getContent() {
        int startIndex = (currentPageIndex - 1) * ConfigParameter.NUM_OF_LINE_PER_PAGE;
        int endIndex = ((startIndex + ConfigParameter.NUM_OF_LINE_PER_PAGE) > content.size() - 1) ? content.size() : (startIndex + ConfigParameter.NUM_OF_LINE_PER_PAGE);
        return (List<Object>) content.subList(startIndex, endIndex);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getCurrentIndex() {
        return currentPageIndex;
    }

    public int getEndIndex() {
        int maxPage = (int) Math.ceil((double)content.size() / ConfigParameter.NUM_OF_LINE_PER_PAGE);
        int offset = ((maxPage - currentPageIndex) > 5) ? 5 : (maxPage - currentPageIndex);
        return currentPageIndex + offset;
    }
    
    public int getLastPageIndex(){
        return (int) Math.ceil((double)content.size() / ConfigParameter.NUM_OF_LINE_PER_PAGE);
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setCurrentIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }
}
