package com.sumanth;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Params {
    private Map<String, Object> map  = new HashMap<>();

    private Params() {
    }

    public Params(Map<String, Object> map2) {
        this.map = map2;
    }

    public Object get(String key) {
        return map.get(key);
    }
}
