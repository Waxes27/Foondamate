package Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import NetworkLayer.Model.UserBase;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class GraphDrawerTest {
    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetSortedArray() throws ParseException {
        UserBase userBase = mock(UserBase.class);
        when(userBase.asMap()).thenReturn(new HashMap<>());
        GraphDrawer graphDrawer = new GraphDrawer(userBase);
        assertTrue(graphDrawer.getSortedKeyArray(new HashMap<>()).isEmpty());
        verify(userBase).asMap();
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetSortedArray2() throws ParseException {
        UserBase userBase = mock(UserBase.class);
        when(userBase.asMap()).thenReturn(new HashMap<>());
        GraphDrawer graphDrawer = new GraphDrawer(userBase);

        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Key", 42);
        List<String> actualSortedArray = graphDrawer.getSortedKeyArray(stringIntegerMap);
        assertEquals(1, actualSortedArray.size());
        assertEquals("Key", actualSortedArray.get(0));
        verify(userBase).asMap();
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetSortedArray3() throws ParseException {

        UserBase userBase = mock(UserBase.class);
        when(userBase.asMap()).thenReturn(new HashMap<>());
        GraphDrawer graphDrawer = new GraphDrawer(userBase);

        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("03-04-2002", 42);
        stringIntegerMap.put("01-04-2022", 42);
        graphDrawer.getSortedKeyArray(stringIntegerMap);
    }
}

