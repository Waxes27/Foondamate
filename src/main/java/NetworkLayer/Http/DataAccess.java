package NetworkLayer.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class DataAccess implements DataAccessInterface {
//    "http://sam-user-activity.eu-west-1.elasticbeanstalk.com/");

    private final URL url;

    public DataAccess(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    @Override
    public String getDataFromApi() throws IOException {
        String inputLine;
        StringBuilder data = new StringBuilder();


        URLConnection api = url.openConnection();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(api.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                data.append(inputLine);
            }
            in.close();
        }catch (UnknownHostException e){
            return "No such host";
        }




        return data.toString().replace(" ","");
    }

    public URL getUrl() {
        return this.url;
    }

}
