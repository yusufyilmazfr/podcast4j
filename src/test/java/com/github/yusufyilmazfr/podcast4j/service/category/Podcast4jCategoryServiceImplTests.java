package com.github.yusufyilmazfr.podcast4j.service.category;

import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.Category;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class Podcast4jCategoryServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jCategoryServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void getAll_shouldReturnAllCategory() throws IOException, InterruptedException {
        // Arrange
        Podcast4jCategoryService categoryService = serviceFactory.getCategoryService();

        // Actual
        List<Category> categories = categoryService.getAll();

        // Assert
        assertNotNull(categories);
        assertNotEquals(0, categories.size());
    }
}
