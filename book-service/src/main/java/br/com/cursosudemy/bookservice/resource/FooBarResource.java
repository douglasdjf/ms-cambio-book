package br.com.cursosudemy.bookservice.resource;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Tag(name = "FooBar endpoint")
@Slf4j
@RestController
@RequestMapping("book")
public class FooBarResource {

    /**
     * Opção 1 @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
     * Opção 2 @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
     * Opção 3  @RateLimiter(name = "default") requisições por segundo
     *
     * @return
     */

    @Operation(summary = "Especifica foo-bar-bulkhead")
    @GetMapping("foo-bar-bulkhead")
    @Bulkhead(name = "default")
    public String fooBarBulkhead(){
        log.info("Request to foo-bar-bulkhead is received!");
        return "Foo-Bar!!";
    }

    @Operation(summary = "Especifica foo-bar-limit")
    @GetMapping("foo-bar-limit")
    @RateLimiter(name = "default")
    public String fooBarLimit(){
        log.info("Request to foo-bar-limit is received!");
        return "Foo-Bar!!";
    }

    @Operation(summary = "Especifica foo-bar-error")
    @GetMapping("foo-bar-error")
    //@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    public String fooBarError(){
        log.info("Request to foo-bar-error is received!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar",String.class);
       // return "Foo-Bar!!";
        return response.getBody();
    }

    public String fallbackMethod(Exception ex){
        return "fallbackMethod foo-bar !!";
    }

}
