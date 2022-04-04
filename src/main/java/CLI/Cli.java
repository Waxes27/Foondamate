package CLI;

import NetworkLayer.Http.DataAccess;
import NetworkLayer.Model.UserBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Cli {
    private final Map<String, String> arguments;
    private DataAccess data;
    private final String resultsAsString;
    private final UserBase userBase;
    private final String url = "http://sam-user-activity.eu-west-1.elasticbeanstalk.com/";



    public Cli(String[] args) throws IOException {
        arguments = getArgs(args);
        data = getData();
        resultsAsString = data.getDataFromApi();
        userBase = getUserBase(resultsAsString);
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

    public String getResultsAsString() {
        return resultsAsString;
    }

    public String getUrl() {
        return url;
    }

    public UserBase getUserBase() {
        return userBase;
    }

    private DataAccess getData() throws MalformedURLException {
        System.out.println(this.url);
        return new DataAccess(url);
    }

    private UserBase getUserBase(String results){
        return new UserBase(results);
    }

    private Map<String,String> getArgs(String[] args){
        HashMap<String ,String> stringHashMap = new HashMap<>();
        stringHashMap.put("start",args[0]);
        stringHashMap.put("end", args[1]);
        return stringHashMap ;
    }

    public UserBase filterDates() throws ParseException {
        return this.userBase.filterDates(this.getArguments());
    }

}
