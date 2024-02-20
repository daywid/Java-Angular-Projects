package com.daywid.Spring.Studies.services;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
/*
 * Custom HTTP message converter for YAML format using Jackson library
 */
public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter
{
    /*
	 * Constructor with custom ObjectMapper for YAML format.
	 * @param objectMapper the custom ObjectMapper for YAML.
	 */
   protected YamlJackson2HttpMessageConverter(ObjectMapper objectMapper)
   	{
        super(objectMapper);
	}
	public YamlJackson2HttpMessageConverter() 
	{
		super(
			new YAMLMapper()
				.setSerializationInclusion(
					JsonInclude.Include.NON_NULL),
					MediaType.parseMediaType("application/x-yaml")
				);
	}
}
