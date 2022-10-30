import org.example.StringList;
import org.example.StringMethods;
import org.example.WrongIndexException;
import org.example.WrongItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class SpringMethodsTest {

    StringList stringList = new StringMethods(10);

    @BeforeEach
    void clearList() {
        stringList.clear();
    }

    @Test
    void checkAdd() {
        String actual1 = stringList.add("five");
        String actual2 = stringList.add("three");

        assertEquals("five", actual1);
        assertEquals("three", actual2);

        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("five"));
        assertTrue(stringList.contains("three"));
        assertEquals(1, stringList.lastIndexOf("three"));
        assertEquals(-1, stringList.lastIndexOf("two"));
    }

    @Test
    void checkAddByIndex() {

        String actual1 = stringList.add(0, "zero");
        assertTrue(Objects.equals(stringList.get(0), "zero"));

    }

    @Test
    void testByErrorMessages() {

        assertThrows(WrongIndexException.class,()-> stringList.add(11,"eleven"));
        assertThrows(WrongIndexException.class,()-> stringList.set(15,"15"));
        assertThrows(WrongIndexException.class,()-> stringList.remove(15));
        assertThrows(WrongItemException.class,()-> stringList.add(0,null));
        assertThrows(WrongItemException.class,()-> stringList.set(0,null));

    }

    @Test
    void checkSet() {
        stringList.add(0, "zero");
        String actual1 = stringList.set(0, "eleven");
        assertTrue(Objects.equals(stringList.get(0), "eleven"));

    }

    @Test
    void checkRemove() {
        stringList.add(0, "zero");
        stringList.add(1, "one");
        stringList.add(2, "two");
        assertFalse(stringList.isEmpty());
        String actual1 = stringList.remove(2);
        System.out.println(stringList.get(2));
        String actual2 = stringList.remove(1);
        String actual3 = stringList.remove(0);
        assertTrue(stringList.isEmpty());
    }

    @Test
    void checkListsEqual() {
        stringList.add("one");
        stringList.add("two");
        StringList otherList = new StringMethods(10);
        otherList.add("one");
        otherList.add("two");

        assertTrue(stringList.equals(otherList));
    }
}