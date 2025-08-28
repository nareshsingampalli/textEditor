package com.example.textEditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.textEditor",
		"model",
		"service",
		"controller"
})
public class TextEditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextEditorApplication.class, args);
	}

}
