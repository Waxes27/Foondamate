package NetworkLayer.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DataAccess implements DataAccessIntereface {
//    "http://sam-user-activity.eu-west-1.elasticbeanstalk.com/");

    private URL url;

    public DataAccess(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    @Override
    public String getDataFromApi() throws IOException {
        String inputLine;
        StringBuilder data = new StringBuilder();


        URLConnection api = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(api.getInputStream()));

        while ((inputLine = in.readLine()) != null) {
            data.append(inputLine);
        }
        in.close();


        return data.toString().replace(" ","");
    }
}
