package org.training.spring.springtraining20240603.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.training.spring.springtraining20240603.rest.models.Customer;
import org.training.spring.springtraining20240603.rest.models.HelloResponse;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/hello")
public class MyFirstRestWebService {

    // http://127.0.0.1:9090/hello/hello1
    // @RequestMapping(method = RequestMethod.GET,path = "/hello/hello1")
    @GetMapping("/hello1")
//    @PostMapping
//    @PutMapping("/hello/hello1")
//    @DeleteMapping
//    @PatchMapping
    public String hello1() {
        return "hello1";
    }

    @PostMapping("/hello1")
    public String hello2() {
        return "hello2";
    }

    @DeleteMapping("/hello1")
    public String hello3() {
        return "hello3";
    }

    @GetMapping("/hello2")
    public String hello4() {
        return "hello4";
    }

    // http://127.0.0.1:9090/hello/hello3?isim=osman
    @GetMapping("/hello3")
    public String hello5(@RequestParam("isim") String name) {
        return "hello5 " + name;
    }

    // http://127.0.0.1:9090/hello/hello3?isim=osman&soy=yay
    @GetMapping("/hello4")
    public String hello6(@RequestParam("isim") String name,
                         @RequestParam("soy") String surname) {
        return "hello6 " + name + " " + surname;
    }

    // http://127.0.0.1:9090/hello/hello5?name=osman&surname=yay
    @GetMapping("/hello5")
    public String hello7(@RequestParam String name,
                         @RequestParam String surname) {
        return "hello7 " + name + " " + surname;
    }
    // http://127.0.0.1:9090/hello/hello6/osman/surname/yay
    @GetMapping("/hello6/{isim}/surname/{soyisim}")
    public String hello8(@PathVariable("isim") String name,
                         @PathVariable("soyisim") String surname) {
        return "hello8 " + name + " " + surname;
    }

    // http://127.0.0.1:9090/hello/hello7/ali?surname=veli
    @GetMapping("/hello7/{name}")
    public String hello9(@PathVariable String name,
                         @RequestParam String surname) {
        return "hello9 " + name + " " + surname;
    }

    @PostMapping("/hello8")
    public String hello9(@RequestBody Customer customerParam) {
        return "hello9a " + customerParam;
    }

    @PostMapping(value = "/hello10",produces = {MediaType.APPLICATION_XML_VALUE})
    public HelloResponse hello10(@RequestBody Customer customerParam) {
        return new HelloResponse("Customer alındı", "sms dönecek");
    }

}

