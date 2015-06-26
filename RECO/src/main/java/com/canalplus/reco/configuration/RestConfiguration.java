package com.canalplus.reco.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 *
 * @author faagni classe permettant de configurer le mapping de sortie en json.
 */
@Configuration
@PropertySource("classpath:recoParameters.properties")
public class RestConfiguration {

	/**
	 * Resolves ${...} placeholders against local properties and/or system
	 * properties and environment variables.
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Spring MVC View that renders JSON content by serializing the model for
	 * the current request using Jackson 2's ObjectMapper.
	 * 
	 * @return
	 */
	@Bean
	public View jsonTemplate() {
		final MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}

	/**
	 * Interface to be implemented by objects that can resolve views by name.
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		return new BeanNameViewResolver();
	}
}
