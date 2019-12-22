package ng.com.hybridintegrated.a365dailyreadingsfornigeria.Bulletin;

public class bulletinmodel {
    private String title,body,thumbimage;
    public bulletinmodel(String title, String body,String thumbimage) {
        this.title=title;
        this.body=body;
        this.thumbimage=thumbimage;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getThumbimage() {
        return thumbimage;
    }
}
