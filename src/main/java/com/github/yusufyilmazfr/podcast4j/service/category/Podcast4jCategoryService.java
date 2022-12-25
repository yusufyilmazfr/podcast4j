package com.github.yusufyilmazfr.podcast4j.service.category;

import com.github.yusufyilmazfr.podcast4j.entity.Category;

import java.io.IOException;
import java.util.List;

public interface Podcast4jCategoryService {
    List<Category> getAll() throws IOException, InterruptedException;
}
