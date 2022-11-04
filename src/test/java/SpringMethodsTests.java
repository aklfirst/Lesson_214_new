import org.example.StringList;
import org.example.StringMethods;
import org.example.WrongIndexException;
import org.example.WrongItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class SpringMethodsTest {

    StringList stringList = new StringMethods();

    @BeforeEach
    void clearList() {
        stringList.clear();
    }

    @Test
    void checkAdd() {
        Integer actual1 = stringList.add(456);
        Integer actual2 = stringList.add(549);

        assertEquals(456, actual1);
        assertEquals(549, actual2);

        assertEquals(2, stringList.size());
        assertTrue(stringList.contains(456));
        assertTrue(stringList.contains(549));
        assertEquals(1, stringList.lastIndexOf(549));
        assertEquals(-1, stringList.lastIndexOf(457));
    }

    @Test
    void checkAddByIndex() {

        Integer actual1 = stringList.add(0, 0);
        assertTrue(Objects.equals(stringList.get(0), 0));

    }

    @Test
    void testByErrorMessages() {

        assertThrows(WrongIndexException.class,()-> stringList.add(11,11));
        assertThrows(WrongIndexException.class,()-> stringList.set(15,15));
        assertThrows(WrongIndexException.class,()-> stringList.remove(15));
        assertThrows(WrongItemException.class,()-> stringList.add(0,null));
        assertThrows(WrongItemException.class,()-> stringList.set(0,null));

    }

    @Test
    void checkSet() {
        stringList.add(0, 0);
        Integer actual1 = stringList.set(0, 11);
        assertTrue(Objects.equals(stringList.get(0), 11));

    }

    @Test
    void checkRemove() {
        stringList.add(0, 0);
        stringList.add(1, 1);
        stringList.add(2, 2);
        assertFalse(stringList.isEmpty());
        Integer actual1 = stringList.remove(2);
        Integer actual2 = stringList.remove(1);
        Integer actual3 = stringList.remove(0);
        assertTrue(stringList.isEmpty());
    }

    @Test
    void checkListsEqual() {
        stringList.add(1);
        stringList.add(2);
        StringList otherList = new StringMethods();
        otherList.add(1);
        otherList.add(2);

        assertTrue(stringList.equals(otherList));
    }
}