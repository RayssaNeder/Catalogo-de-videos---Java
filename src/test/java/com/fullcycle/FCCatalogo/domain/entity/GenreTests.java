package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GenreTests {

    @Test
    public void createGenreWithNameTest(){
            final Genre entity = new Genre("Genre 1");
            assertNotNull(entity);
            assertEquals(entity.getName(), "Genre 1");
            assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void createGenreWithNameCategoriesTest(){
            
            final Category gategory1 = new Category("Category 1");
            final Category gategory2 = new Category("Category 2");

            List<Category> categories = new ArrayList<Category>();
            categories.add(gategory1);
            categories.add(gategory2);

            final Genre entity = new Genre("Genre 1", categories);

            
            assertNotNull(categories);
            assertNotNull(entity);
            assertEquals(entity.getName(), "Genre 1");
            assertTrue(entity.isValidUUID(entity.getId().toString()));
            assertEquals(gategory1.getName(), "Category 1");
            assertEquals(gategory2.getName(), "Category 2");
            assertTrue(gategory1.isValidUUID(gategory1.getId().toString()));
            assertTrue(gategory2.isValidUUID(gategory2.getId().toString()));
            assertEquals(2, entity.getCategories().size());


           
    }


    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull(){
            assertThrows(IllegalArgumentException.class, () -> new Genre(null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank(){
            assertThrows(IllegalArgumentException.class, () -> new Genre(""));
    }

  
    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNullAndCategoriesIsNull(){
        assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlankAndCategoriesIsNull(){
            assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
    }

    @Test 
    public void addCategoryTGenreTest(){
        final Genre entity = new Genre("Genre 1");
        assertNotNull(entity);
        assertNotNull(entity.getCategories());
        final Category gategory1 = new Category("Category 1");
        final Category gategory2 = new Category("Category 2");
        entity.addCategory(gategory1);
        entity.addCategory(gategory2);
        assertEquals(2, entity.getCategories().size());
        assertNotNull(entity.getCategories());
    }

    @Test 
    public void removeCategoryTGenreTest(){
        final Genre entity = new Genre("Genre 1");
        assertNotNull(entity);
        assertNotNull(entity.getCategories());
        final Category gategory1 = new Category("Category 1");
        final Category gategory2 = new Category("Category 2");
        entity.addCategory(gategory1);
        entity.addCategory(gategory2);
        assertNotNull(entity.getCategories());
        assertEquals(2, entity.getCategories().size());
        entity.removeCategory(gategory1);
        assertEquals(1, entity.getCategories().size());
        entity.removeCategory(gategory2);
        assertEquals(0, entity.getCategories().size());
        assertNotNull(entity.getCategories());
    }



 
    
}
