package com.example.demo.service;

import com.example.demo.entity.BookDto;
import jakarta.persistence.AttributeConverter;

import java.util.UUID;

public class CalculationDtoJpaConverter implements AttributeConverter<BookDto, String> {

    @Override
    public String convertToDatabaseColumn(BookDto calculationDto) {

//        calculationDto.setRandom(UUID.randomUUID().toString());

        return JsonUtil.toJson(calculationDto);
    }

    @Override
    public BookDto convertToEntityAttribute(String jsonCalculation) {
        BookDto dto = JsonUtil.toObject(jsonCalculation, BookDto.class);

//        dto.setAuthor(null);
        return dto;
    }
}
