package com.reactive.SpringReactiveTest.controller;

import com.reactive.SpringReactiveTest.service.FooService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.reactive.SpringReactiveTest.entity.Foo;



@WebFluxTest(FooController.class)
@AutoConfigureWebTestClient(timeout = "50000")
@Import(FooService.class)
class FooControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testFlux() {

        webClient.get().uri("/foo-info").exchange().expectStatus()
                .isOk().expectBodyList(Foo.class);

    }

}
