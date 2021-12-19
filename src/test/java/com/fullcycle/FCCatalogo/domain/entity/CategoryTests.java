package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class CategoryTests {

    @Test
    public void createCategoty(){
            final Category entity = new Category("Category 1");
            assertNotNull(entity);
            assertEquals(entity.getName(), "Category 1");
            assertTrue(entity.isValidUUID(entity.getId().toString()));
    }


    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull(){
            assertThrows(IllegalArgumentException.class, () -> new Category((String) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank(){
            assertThrows(IllegalArgumentException.class, () -> new Category(""));
    }


    @Test
    public void throwIllegalArgumentExceptionWhenUUIDIsNull(){
            assertThrows(IllegalArgumentException.class, () -> new Category((UUID) null));
    }
    
}
