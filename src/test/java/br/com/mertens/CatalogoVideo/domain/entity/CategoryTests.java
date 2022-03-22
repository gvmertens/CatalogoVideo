package br.com.mertens.CatalogoVideo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mertens.CatalogoVideo.domain.Exception.DomainException;
import br.com.mertens.CatalogoVideo.domain.entity.Category;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTests {
    
    @Test
    public void createCategoryWithName() {
        final Category entity = new Category("Name 1", null);

        assertNotNull(entity);
        assertEquals(entity.getName(), "Name 1");
        assertNull(entity.getDescription());
    }
    
    @Test
    public void createCategoryWithNameAndDescription() {
        final Category entity = new Category("Name 1", "Description 1");

        assertNotNull(entity);
        assertEquals(entity.getName(), "Name 1");
        assertEquals(entity.getDescription(), "Description 1");
    }
    
    @Test 
    public void createCategoryAndActive() {
        final Category entity = new Category("Name 1", "Description 1");

        assertNotNull(entity);
        assertTrue(entity.getIsActive());
    }

    @Test 
    public void createCategoryAndDeactive() {
        final Category entity = new Category("Name 1", "Description 1");

        assertNotNull(entity);
        entity.deactivate();
        assertFalse(entity.getIsActive());
    }

    @Test
    public void createCategoryWithNameAndDescriptionAndUpdate() {
        final Category entity = new Category("Name 1", "Description 1");

        assertNotNull(entity);
        assertEquals(entity.getName(), "Name 1");
        assertEquals(entity.getDescription(), "Description 1");
        assertTrue(entity.getIsActive());

        entity.update("Name 2", "Desc", false);

        assertEquals(entity.getName(), "Name 2");
        assertEquals(entity.getDescription(), "Desc");
        assertFalse(entity.getIsActive());
    }
    
    @Test
    public void assertTrhowDomainExceptionWhenNomeIsNull(){
        assertThrows(DomainException.class, () -> new Category(null, "description"));
    }

    @Test
    public void assertTrhowDomainExceptionWhenNomeIsBlank(){
        assertThrows(DomainException.class, () -> new Category("", "description"));
    }
}
