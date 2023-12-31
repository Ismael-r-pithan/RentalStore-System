package br.com.cwi.oldflix.config;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DateConfig {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static LocalDateSerializer LOCAL_DATE_SERIALIZER = new LocalDateSerializer(
            DateTimeFormatter.ofPattern(DATE_FORMAT));

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATE_SERIALIZER);
        return new ObjectMapper()
                .registerModule(module);
    }

}