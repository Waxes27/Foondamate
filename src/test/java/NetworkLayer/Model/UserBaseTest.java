package NetworkLayer.Model;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import NetworkLayer.Http.DataAccess;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserBaseTest {
    String dataToTest = new DataAccess("http://sam-user-activity.eu-west-1.elasticbeanstalk.com/").getDataFromApi();

    UserBaseTest() throws IOException {
    }

    @Test
    void testAsMap() {
        UserBase base = new UserBase(dataToTest);
        assertEquals(base.asMap().getClass(),HashMap.class);
    }

    @Test
    void testAsMap2() {
        assertNull((new UserBase(null)).asMap());
        assertNull((new UserBase("")).asMap());
    }

    @Test
    void testFilterDates() {
        UserBase userBase = new UserBase("");
        HashMap<String, Date> data = new HashMap<>();
        assertNull(userBase.filterDates(data, new HashMap<>()));
    }
}

