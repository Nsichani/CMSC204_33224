import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ListIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedListTestStudent {

    SortedDoubleLinkedList<String> sortedLinkedString;
    StringComparator comparator;

    @Before
    public void setUp() throws Exception {
        comparator = new StringComparator();
        sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
    }

    @After
    public void tearDown() throws Exception {
        comparator = null;
        sortedLinkedString = null;
    }

    @Test
    public void testAddToEnd() {
        try {
            sortedLinkedString.addToEnd("Nima");
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Threw an exception other than UnsupportedOperationException");
        }
    }

    @Test
    public void testAddToFront() {
        try {
            sortedLinkedString.addToFront("Nima");
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Threw an exception other than UnsupportedOperationException");
        }
    }

    @Test
    public void testIteratorSuccessfulStringPrevious() {
        sortedLinkedString.add("Nima");
        sortedLinkedString.add("Sichani");
        sortedLinkedString.add("Did");
        sortedLinkedString.add("This");

        ListIterator<String> iterator = sortedLinkedString.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Did", iterator.next());
        assertEquals("Nima", iterator.next());
        assertEquals("Sichani", iterator.next());
        assertEquals("This", iterator.next());
        assertFalse(iterator.hasNext());

        assertTrue(iterator.hasPrevious());
        assertEquals("This", iterator.previous());
        assertEquals("Sichani", iterator.previous());
        assertEquals("Nima", iterator.previous());
        assertEquals("Did", iterator.previous());
        assertFalse(iterator.hasPrevious());
    }

    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }
    }
}
