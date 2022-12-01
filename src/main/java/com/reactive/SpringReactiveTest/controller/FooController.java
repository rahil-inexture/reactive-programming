package com.reactive.SpringReactiveTest.controller;

import java.time.Duration;
import java.util.List;

import com.reactive.SpringReactiveTest.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.SpringReactiveTest.entity.Foo;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/test")
public class FooController {

	@Autowired
	private FooService fooService;

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Foo> testFlux(){
		return fooService.getFooInfo();
	}
}
