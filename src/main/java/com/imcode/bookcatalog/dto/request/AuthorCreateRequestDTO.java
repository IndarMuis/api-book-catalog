package com.imcode.bookcatalog.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AuthorCreateRequestDTO(
		String authorName,
		Long birthDate
) {
}
