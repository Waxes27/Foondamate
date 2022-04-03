import NetworkLayer.Http.DataAccess;
import NetworkLayer.Model.UserBase;

import java.io.IOException;

public class CLI {

    public static void main(String[] args) throws IOException {
        DataAccess data = new DataAccess("http://sam-user-activity.eu-west-1.elasticbeanstalk.com/");
        String resultsAsString = data.getDataFromApi();

        UserBase userBase = new UserBase();
         ;
        System.out.println(userBase.asMap(resultsAsString));
    }
}
