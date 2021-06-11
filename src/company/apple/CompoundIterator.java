package company.apple;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=666662
 * https://opensource.apple.com/source/JBoss/JBoss-731/jboss-all/common/src/main/org/jboss/util/collection/CompoundIterator.java.auto.html
 */
public class CompoundIterator implements Iterator {
    private final Iterator[] iterators;
    private int index;
    
    public CompoundIterator(Iterator[] iterators) {
        if (iterators == null || iterators.length == 0) {
            throw new IllegalArgumentException("array is null or empty");
        }
        this.iterators = iterators;
    }

    public boolean hasNext() {
        for (; index < iterators.length; index++) {
            if (iterators[index] != null && iterators[index].hasNext()) {
                return true;
            }
        }
        return false;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterators[index].next();
    }

    public void remove() throws UnsupportedOperationException {
        iterators[index].remove();
    }
}
