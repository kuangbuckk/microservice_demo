package buck.gatewayServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServicesApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p -> p.path("/buck/accounts/**")
						.filters(f -> f.rewritePath("/buck/accounts/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
//						lb: Load balancer, tell gateway to do client side load balancer with the help of
//						spring cloud balancer
						.uri("lb://ACCOUNT-SERVICES"))
				.route(p -> p.path("/buck/statistics/**")
						.filters(f -> f.rewritePath("/buck/statistics/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://STATISTIC-SERVICES"))
				.route(p -> p.path("/buck/notification/**")
						.filters(f -> f.rewritePath("/buck/notification/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://NOTIFICATION-SERVICES"))
				.build();
	}
}
