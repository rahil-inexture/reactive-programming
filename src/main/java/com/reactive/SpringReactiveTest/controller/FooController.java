package com.reactive.SpringReactiveTest.controller;

import com.reactive.SpringReactiveTest.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.SpringReactiveTest.entity.Foo;

import reactor.core.publisher.Flux;

@RestController
public class FooController {
	@Autowired
	private FooService fooService;

	/**
	 * Fetch foo information
	 * @return Flux<Foo>
	 */
	@GetMapping(path = "/foo-info", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Foo> getFoo() {
		return fooService.getFooInfo();
	}
}
