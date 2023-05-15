package com.example.testTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootApplication
@RestController
@RequestMapping("/calculacte")
public class TestTaskApplication {
	@GetMapping(value ="/{averageSalary}/{daysAmount}",produces = "application/json")
	public String getSimpleCals(@PathVariable String averageSalary,@PathVariable String daysAmount){
		return "{Money:"+
				new BigDecimal(averageSalary)
						.divide(new BigDecimal("29.3"), 2, RoundingMode.HALF_UP)
						.multiply(new BigDecimal(daysAmount)).setScale(2, RoundingMode.HALF_UP)
				+"}";
	}

	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
	}

}
