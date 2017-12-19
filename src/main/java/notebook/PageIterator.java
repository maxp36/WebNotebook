package notebook;

import notebook.dao.ContactRepository;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PageIterator implements Iterator<Long> {

    private Long cursor;
    private final Long end;
    private final Long num;
    private ContactRepository contactRepository;

    public PageIterator(Long start, Long end, ContactRepository contactRepository) {
        this.cursor = start;
        this.end = end;
        this.contactRepository = contactRepository;
        num = end - start;
    }

    @Override
    public boolean hasNext() {
        if (cursor < end && contactRepository.exists(cursor))
        return cursor < end && contactRepository.exists(cursor);
    }

    @Override
    public Long next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor++;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
