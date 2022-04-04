package Util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class DateCompareTest {
    @Test
    @Disabled("TODO: This test is incomplete")
    void testCompare() {
        List<String> stringList = new ArrayList<>(List.of(
                "01-01-2022", "01-05-2022",
                "01-04-2022", "01-03-2022"
        ));
        stringList.sort(new DateCompare());

        assertEquals(List.of("01-01-2022", "01-03-2022", "01-04-2022", "01-05-2022"),stringList);


    }
}

