package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
//lives at /hello/goodbye
    @GetMapping("goodbye")
    //@ResponseBody covered by responseBody on line 7 in the beginning to cover all methods
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode
    //lives at /hello/hello
   @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},/* value="hello" to reduce redundancy*/)
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String coder) {
        return "Hello, " + coder + "!!!";
    }

    //handles request of the form /hello/LaunchCode
    @GetMapping(/* hello (removed to reduce redundancy*/ "{name}")
    //@ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "hello, " + name + "!!!!!";
    }
//lives at hello/form
    @GetMapping("form")
    //@ResponseBody
    public String helloForm(){
        String html =
            "<html>" +
                "<body>" +
                    "<form method='get' action='/hello'>" + //submit a request to /hello was form action
                    "<input type='text' name='coder'>" +
                    "<input type='submit' value='Greet me!'" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        return html;
    }

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }

}
