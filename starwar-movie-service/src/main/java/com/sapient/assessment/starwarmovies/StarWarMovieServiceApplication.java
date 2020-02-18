package com.sapient.assessment.starwarmovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sapient.assessment.starwarmovies.domain.StarWarMoviesDO;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class StarWarMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarMovieServiceApplication.class, args);
	}

@FeignClient(name="planets-service",url="localhost:8100")
public interface PlanetsClient{
	
	@GetMapping("/v1/planets/{name}")
	StarWarMoviesDO getPlanetsByName(@PathVariable("name") String name);
}
@FeignClient(name="vehicles-service",url="localhost:8200")
public interface VehiclesClient{
	
	@GetMapping("/v1/vehicles/{name}")
	StarWarMoviesDO getVehiclesByName(@PathVariable("name") String name);
}
@FeignClient(name="peoples-service",url="localhost:8300")
public interface PeoplesClient{
	
	@GetMapping("/v1/people/{name}")
	StarWarMoviesDO getPeoplesByName(@PathVariable("name") String name);
}
}
