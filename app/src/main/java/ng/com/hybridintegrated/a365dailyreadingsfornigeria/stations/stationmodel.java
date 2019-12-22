package ng.com.hybridintegrated.a365dailyreadingsfornigeria.stations;

public class stationmodel {
    private String title,body;
    public stationmodel(String title, String body) {
        this.title=title;
        this.body=body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
