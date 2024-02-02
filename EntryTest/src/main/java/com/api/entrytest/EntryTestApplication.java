package com.api.entrytest;

import com.api.entrytest.api.ApiCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EntryTestApplication {

    public static void main(String[] args) throws Exception {

		SpringApplication.run(EntryTestApplication.class, args);
		ApiCalls api = new ApiCalls();
		System.out.println(api.getProjects());

	}
}
