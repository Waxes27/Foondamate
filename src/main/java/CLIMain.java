import CLI.Cli;
import Graph.GraphDrawer;
import NetworkLayer.Http.DataAccess;
import NetworkLayer.Model.UserBase;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class CLIMain {
    public static Cli start;

    public static void main(String[] args) throws IOException, ParseException {

        try {
            start = new Cli(args);
        }catch (ArrayIndexOutOfBoundsException e){
            start = new Cli();
        }

        UserBase userBase = start.getUserBase();
        GraphDrawer graph = new GraphDrawer(start.filterDates());
        graph.draw();
    }


}
