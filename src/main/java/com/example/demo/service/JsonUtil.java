package com.example.demo.service;


import com.example.demo.entity.BookDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(BookDto.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JSR310Module());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static <T> T toObject(String jsonObject, TypeReference<T> type) {
        T object = null;
        try {
            object = objectMapper.readValue(jsonObject, type);
        } catch (IOException e) {
            logger.error("", e);
        }

        return object;
    }

    public static <T> T toObject(String jsonObject, Class<T> dstClass) {
        T object = null;
        try {
            object = objectMapper.readValue(jsonObject, dstClass);
        } catch (IOException e) {
            logger.error("", e);
        }

        return object;
    }

    public static String toJson(Object src) {
        try {
            return objectMapper.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            logger.error("", e);
        }

        return null;
    }

}
