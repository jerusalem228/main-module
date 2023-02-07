package com.sagroup.schoolservice;

import com.sagroup.schoolservice.Domain.Adress;
import com.sagroup.schoolservice.Domain.Contact;
import com.sagroup.schoolservice.Domain.School;
import com.sagroup.schoolservice.Repo.SchoolRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.sagroup.schoolservice.config.ConfigFileExternalizationConfig;


@SpringBootApplication
public class SchoolServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolServiceApplication.class);

	public static void main(String[] args) {
		if (ConfigFileExternalizationConfig.createConfigFiles()
				!= ConfigFileExternalizationConfig.CONFIG_FILES_ERROR_STATE) {
			ConfigurableApplicationContext app = new SpringApplicationBuilder(
					SchoolServiceApplication.class)
					.build().run(ConfigFileExternalizationConfig.enhanceArgs(args));
			Environment env = app.getEnvironment();
			String protocol = "http";
			if (env.getProperty("server.ssl.key-store") != null) {
				protocol = "https";
			}
			LOGGER.info("\n----------------------------------------------------------\n\t"
							+ "Application '{}' is running! Access URLs:\n\t"
							+ "Local: \t\t{}://localhost:{}\n\t"
							+ "Profile(s): \t{}\n----------------------------------------------------------",
					env.getProperty("spring.application.name"),
					protocol,
					env.getProperty("server.port"),
					env.getActiveProfiles());
		} else {
			LOGGER.error("Please proceed to manually creation of configuration files!");
		}

	}

//	@Bean
//	public CommandLineRunner start(SchoolRepo schoolRepo) {
//		return args -> {
//			schoolRepo.save(new School(null,
//					"SchoolA",
//					new Adress("1000 N 4th St", "Fairfield", 52557, "Iowa"),
//					new Contact("aaaa@gmail.com", "641-555-8787")));
//			schoolRepo.save(new School(null,
//					"SchoolA",
//					new Adress("555 N 4th St", "Fairfield", 52557, "Iowa"),
//					new Contact("aaaa@gmail.com", "641-885-8787")));
//			schoolRepo.save(new School(null,
//					"SchoolA",
//					new Adress("333 N 4th St", "Fairfield", 52557, "Iowa"),
//					new Contact("aaaa@gmail.com", "641-333-8787")));
//			schoolRepo.findAll().forEach(school -> {
//				System.out.println(school);
//			});
//		};
//	}

}
