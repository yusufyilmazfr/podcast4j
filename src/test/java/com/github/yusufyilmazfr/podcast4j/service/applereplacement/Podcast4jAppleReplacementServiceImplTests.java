package com.github.yusufyilmazfr.podcast4j.service.applereplacement;

import com.github.yusufyilmazfr.podcast4j.constant.TestConfig;
import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_iTUNES_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Podcast4jAppleReplacementServiceImplTests {
    private final Podcast4jServiceFactory serviceFactory;

    public Podcast4jAppleReplacementServiceImplTests() {
        serviceFactory = Podcast4jServiceFactory.with(TestConfig::getTestConfig);
    }

    @Test
    public void search_shouldReturnMatchedSearchResults() throws IOException, InterruptedException {
        // Arrange
        Podcast4jAppleReplacementService appleReplacementService = serviceFactory.getAppleReplacementService();

        // Actual
        List<AppleReplacementSearch> searches = appleReplacementService.search("batman");

        // Assert
        assertNotNull(searches);
        assertTrue(searches.size() > 0);
    }

    @Test
    public void lookup_shouldReturnMatchedSearchResults() throws IOException, InterruptedException {
        // Arrange
        Podcast4jAppleReplacementService appleReplacementService = serviceFactory.getAppleReplacementService();

        // Actual
        List<AppleReplacementSearch> searches = appleReplacementService.lookup(CODEFICTION_iTUNES_ID, null);

        // Assert
        assertNotNull(searches);
        assertTrue(searches.size() > 0);
    }
}
