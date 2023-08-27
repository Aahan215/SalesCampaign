package org.saleCampaign.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages ="org.saleCampaign.controller")
@PropertySources({ //
		@PropertySource(value = "file:./application.properties", ignoreResourceNotFound = true) //
})
public class SpringConfig {


}
