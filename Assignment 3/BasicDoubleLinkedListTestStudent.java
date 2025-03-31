import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.ListIterator;

class BasicDoubleLinkedListTestStudent {
    private BasicDoubleLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new BasicDoubleLinkedList<>();
    }

    @Test
    void testAddToEnd() {
        list.addToEnd(10);
        list.addToEnd(20);
        assertEquals(20, list.getLast());
        assertEquals(10, list.getFirst());
        assertEquals(2, list.getSize());
    }

    @Test
    void testAddToFront() {
        list.addToFront(10);
        list.addToFront(20);
        assertEquals(20, list.getFirst());
        assertEquals(10, list.getLast());
        assertEquals(2, list.getSize());
    }

    @Test
    void testRetrieveFirstElement() {
        list.addToEnd(10);
        list.addToEnd(20);
        assertEquals(10, list.retrieveFirstElement());
        assertEquals(20, list.getFirst());
        assertEquals(2, list.getSize());
    }

    @Test
    void testRetrieveLastElement() {
        list.addToEnd(10);
        list.addToEnd(20);
        assertEquals(20, list.retrieveLastElement());
        assertEquals(10, list.getLast());
        assertEquals(2, list.getSize());
    }

    @Test
    void testRemove() {
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        Comparator<Integer> comparator = Integer::compare;
        
        assertNotNull(list.remove(20, comparator));
        assertEquals(2, list.getSize());
        assertNull(list.remove(40, comparator));
    }

    @Test
    void testIterator() {
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        
        ListIterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertThrows(java.util.NoSuchElementException.class, iterator::next);
    }
}
