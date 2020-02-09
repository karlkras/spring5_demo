package com.jrp.demo.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class HelloController {
    @RequestMapping("/basic")
    public String sayHelloMe() {
        return "<h1>hello me ya</h1>";
    }

    @RequestMapping("/proper")
    public String sayProperHello() {
        return "<h1>hello there how are you?</h1>";
    }

    @RequestMapping("/user_entry")
    public String userEntry() {
        return userForm();
    }

    @RequestMapping(value="/user_greeting", method = RequestMethod.POST)
    public String userGreeting(@RequestParam String firstname,
                               @RequestParam String lastname) {
        return String.format("Hello there, %s %s", firstname, lastname);
    }

    public String userForm() {
        return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"firstname\">\n" +
                "  <br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"lastname\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }

    @RequestMapping("/orders/{id}")
    public String getOrder(@PathVariable String id) {
        return String.format("Order ID: %s", id);
    }
}
