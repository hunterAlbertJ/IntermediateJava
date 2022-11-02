package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    //business object under test called a fixture
    private InMemoryCatalog catalog;
    @Before
    public void setUp(){
        catalog = new InMemoryCatalog();
    }
    /**
     * TASK: find all "rock" items whose price is less than or equal to the specified price.
     */

    @Test
    public void findByCollection_shouldReturnPopulatedCollection_whenValidArgumentPassed(){
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        System.out.println(items.size());
        assertEquals(4, items.size());
    }

    @Test
    public void findRockItems_shouldReturnEmptyCollection_whenInvalidDouble(){
        Collection<MusicItem> items = catalog.maxRockValue(2.0);
        assertTrue(items.isEmpty());

    }

    @Test
    public void findRockItems_shouldReturnPriceLessThanEqualToArgument_whenValidDouble(){
        Collection<MusicItem> items = catalog.maxRockValue(12.0);
        for(MusicItem item : items){
            assertEquals(MusicCategory.ROCK, item.getMusicCategory());
            assertTrue(item.getPrice() < 12.0);
        }
        assertEquals(2, items.size());
    }

    @Test
    public void findSelfTitled_shouldReturnPopulatedCollection_validNamePassed() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        assertEquals(2, items.size());
        List<MusicItem> itemsList = new ArrayList<>(items);
        assertEquals(Long.valueOf(6L), itemsList.get(0).getId());
        assertEquals(Long.valueOf(7L), itemsList.get(1).getId());
    }

    @Test
    public void findById_shouldReturnMusicItem_idFound(){
        MusicItem item = catalog.findById(3L);
        assertEquals(Long.valueOf(3), item.getId());
        assertEquals(3L, item.getId().longValue());
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(-1L);
        assertNull(item);
    }
}