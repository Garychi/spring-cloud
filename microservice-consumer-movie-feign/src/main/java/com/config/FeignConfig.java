package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
//        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
//        jacksonConverter.getSupportedMediaTypes().stream().forEach(e->{
//            System.out.println(e);
//        });

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        list.add(MediaType.APPLICATION_JSON_UTF8);
        list.add(MediaType.APPLICATION_XML);
        converter.setSupportedMediaTypes(list);

        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(converter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

//    public ObjectMapper customObjectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        //Customize as much as you want
//        return objectMapper;
//    }
}
