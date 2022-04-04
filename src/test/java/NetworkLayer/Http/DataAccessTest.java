package NetworkLayer.Http;

import java.io.IOException;
import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DataAccessTest {
    DataAccess dataCorrect = new DataAccess("http://sam-user-activity.eu-west-1.elasticbeanstalk.com/");

    DataAccessTest() throws MalformedURLException {
    }

    @Test
    void testGetDataFromApi() throws IOException {
        String dataToTest = dataCorrect.getDataFromApi();
        assertNotNull(dataToTest);
        assertEquals(dataToTest.getClass(),String.class);
        assertEquals(dataCorrect.getUrl().toString(),"http://sam-user-activity.eu-west-1.elasticbeanstalk.com/");
    }
}

