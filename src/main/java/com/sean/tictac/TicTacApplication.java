package com.sean.tictac;

import com.sean.tictac.view.View;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicTacApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(TicTacApplication.class).headless(false).run(args);
		context.getBean(View.class);
	}
}
