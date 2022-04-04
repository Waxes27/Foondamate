import Graph.GraphDrawer;
import NetworkLayer.Http.DataAccess;
import NetworkLayer.Model.UserBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

public class CLI {

    public static void main(String[] args) throws IOException, ParseException {
        DataAccess data = getData();

        String resultsAsString = data.getDataFromApi();

        UserBase userBase = getUserBase(resultsAsString);


        GraphDrawer graph = new GraphDrawer(userBase);
    }

    private static DataAccess getData() throws MalformedURLException {
        return new DataAccess("http://sam-user-activity.eu-west-1.elasticbeanstalk.com/");
    }

    private static UserBase getUserBase(String results){
        return new UserBase(results);
    }
}
