package com.github.yusufyilmazfr.podcast4j.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HttpRequestUtilTests {

    @Test
    public void toQueryParams_returnEmptyQuery_whenParametersAreEmpty() {
        // Arrange
        Map<String, Object> map = Map.of();

        // Actual
        String actualQueryParams = HttpRequestUtil.toQueryParams(map);

        // Assert
        assertEquals("", actualQueryParams);
    }

    @Test
    public void toQueryParams_returnNonNullQueryParams_whenParametersHaveNullValue() {
        // Arrange
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", "yusuf");
        map.put("lastName", "yilmaz");
        map.put("userName", "yusufyilmazfr");
        map.put("age", null);

        String expectedQueryParameters = "firstName=yusuf&lastName=yilmaz&userName=yusufyilmazfr";

        // Actual
        String actualQueryParams = HttpRequestUtil.toQueryParams(map);

        // Assert
        assertEquals(expectedQueryParameters, actualQueryParams);
    }
}
