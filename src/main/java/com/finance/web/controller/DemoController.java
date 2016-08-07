package com.finance.web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private static final String template = "Hello %s!";
	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/world")
	public @ResponseBody Person getPerson() {
		Person p = new Person();
		p.setName("zhang san");
		p.setAge(20);
		return p;
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.getAndIncrement(), String.format(template, name));
	}

	@RequestMapping("/greeting1")
	public Result<Greeting> greeting1(@RequestParam(value="name", defaultValue="World") String name) {
		return Result.error(500, "Inner error");
	}

	@RequestMapping("/greeting2")
	public Result<Greeting> greeting2(@RequestParam(value="name", defaultValue="World") String name) {
		Greeting greeting = new Greeting(counter.getAndIncrement(), String.format(template, name));
		return Result.success(greeting);
	}
}
