package com.kharitonov.gym.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The type Request attributes wrapper.
 * Encapsulates Request attributes
 */
public class RequestAttributesWrapper {
    private final Map<String, Object> attributesMap = new HashMap<>();

    /**
     * Put object in map.
     *
     * @param key   the key
     * @param value the value
     * @return the object
     */
    public Object put(String key, Object value) {
        return attributesMap.put(key, value);
    }

    /**
     * Get object from map.
     *
     * @param key the key
     * @return the object
     */
    public Object get(Object key) {
        return attributesMap.get(key);
    }

    /**
     * Entry set set.
     *
     * @return the set
     */
    public Set<Map.Entry<String, Object>> entrySet() {
        return attributesMap.entrySet();
    }
}
