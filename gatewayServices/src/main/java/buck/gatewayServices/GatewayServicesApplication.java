package buck.gatewayServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServicesApplication.class, args);
	}

//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
//		return routeLocatorBuilder.routes()
//				.route(p -> p.path("/account/**")
////						.filters()
////						lb: Load balancer, tell gateway to do client side load balancer with the help of
////						spring cloud balancer
//						.uri("lb://ACCOUNT-SERVICES"))
//				.route(p -> p.path("/buck/statistics/**")
//						.filters(f -> f.rewritePath("/buck/statistics/(?<segment>.*)", "/${segment}"))
//						.uri("lb://STATISTIC-SERVICES"))
//				.route(p -> p.path("/buck/notification/**")
//						.filters(f -> f.rewritePath("/buck/notification/(?<segment>.*)", "/${segment}"))
//						.uri("lb://NOTIFICATION-SERVICES"))
//				.build();
//	}
}
