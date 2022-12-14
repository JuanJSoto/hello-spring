package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@ResponseBody
//@RequestMapping("hello") //just hello to work its
public class HelloController {
    @RequestMapping(value= "hello", method = {RequestMethod.GET, RequestMethod.POST})
   // @ResponseBody
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    //@ResponseBody
    public String helloAgain(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";    }
    // Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
//lives at /hello/goodbye
//    @GetMapping("goodbye")
//    //@ResponseBody covered by responseBody on line 7 in the beginning to cover all methods
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }
//
//    //handles request of the form /hello?name=LaunchCode
//    //lives at /hello/hello
////s   @RequestMapping(method={RequestMethod.GET,RequestMethod.POST}) /* value="hello" to reduce redundancy*/
//    //@ResponseBody
//    public String helloWithQueryParam(@RequestParam String coder) {
//        return "Hello, " + coder + "!!!";
//    }
//
//    //handles request of the form /hello/LaunchCode
//    @GetMapping(/* hello (removed to reduce redundancy*/ "{name}")
//    //@ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return "hello, " + name + "!!!!!";
//    }
//lives at hello/form
    @GetMapping("form")
    //@ResponseBody templates don't require responseBody
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names", names);
        return "hello-list";
    }

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }

}
