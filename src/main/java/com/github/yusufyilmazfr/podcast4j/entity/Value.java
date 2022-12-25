package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Value {
    private ValueModel model;
    private List<ValueDestination> destinations;
}
