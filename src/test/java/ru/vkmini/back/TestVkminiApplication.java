package ru.vkmini.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestVkminiApplication {

	public static void main(String[] args) {
		SpringApplication.from(VkminiApplication::main).with(TestVkminiApplication.class).run(args);
	}

}
