package org.summer.tiger.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JSON {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }

    @SneakyThrows
    public static <T> T toObject(String value, TypeReference<T> reference) {
        return objectMapper.readValue(value, reference);
    }

    @SneakyThrows
    public static <T> T toObject(String value, Class<T> clazz) {
        return objectMapper.readValue(value, clazz);
    }
}
