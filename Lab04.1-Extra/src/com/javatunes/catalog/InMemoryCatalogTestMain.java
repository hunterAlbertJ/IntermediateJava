/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTestMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        //testFindById();
        // testFindByKeyword();
         testFindByCategory();
        // testSize();
        // testGetAll();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicItem found = catalog.findById(4L);
        System.out.println(found);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> keywordFound = catalog.findByKeyword("Hysteria");
        System.out.println(keywordFound);

    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        System.out.println(popItems);
    }

    private static void testSize() {
    }

    private static void testGetAll() {
    }

    private static void findSelfTitled(){
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> self = catalog.findSelfTitled();
        System.out.println(self);
    }
}