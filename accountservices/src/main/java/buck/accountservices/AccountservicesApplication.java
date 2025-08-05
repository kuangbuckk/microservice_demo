package buck.accountservices;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AccountservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountservicesApplication.class, args);
	}

//	@Bean
//	// topic name, num of partitions, num of replication
//	NewTopic notification(){
//		return new NewTopic("notification", 2, (short) 3);
//	}
//
//	@Bean
//	NewTopic statistic(){
//		return new NewTopic("statistic", 1, (short) 3);
//	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true)
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
				.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
