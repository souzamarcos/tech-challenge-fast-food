package com.fiap.burger.domain.entities.product;


import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    public void shouldCreateInstanceWithSimpleConstructor() {
        var category = Category.LANCHE;
        var name = "Product Test";
        var description = "Product description";
        var value = 22.2;

        Product actual = new Product(
            category,
            name,
            description,
            value
        );

        assertEquals(category, actual.getCategory());
        assertEquals(name, actual.getName());
        assertEquals(description, actual.getDescription());
        assertEquals(value, actual.getValue());
    }

    @Test
    public void shouldCreateInstanceWithFullConstructor() {
        var id = 1L;
        var category = Category.LANCHE;
        var name = "Product Test";
        var description = "Product description";
        var value = 22.2;
        var createdAt = LocalDateTime.now();
        var modifiedAt = LocalDateTime.now();

        Product actual = new Product(
            id,
            category,
            name,
            description,
            value,
            createdAt,
            modifiedAt,
            null
        );

        assertEquals(category, actual.getCategory());
        assertEquals(name, actual.getName());
        assertEquals(description, actual.getDescription());
        assertEquals(value, actual.getValue());
        assertEquals(value, actual.getValue());
        assertEquals(createdAt, actual.getCreatedAt());
        assertEquals(modifiedAt, actual.getModifiedAt());
        assertEquals(null, actual.getDeletedAt());
    }
}