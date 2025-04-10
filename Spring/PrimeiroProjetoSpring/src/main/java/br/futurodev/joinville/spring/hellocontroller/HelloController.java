package br.futurodev.joinville.spring.hellocontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("hello")
public class HelloController
{
    @GetMapping // representa a raiz "...8080/hello"
    public String sayHello()
    {
        return "Hello Controller";
    }
    @GetMapping("emportugues") // representa "...8080/hello/emportugues"
    public String sayHello2()
    {
        return "Olá controlador";
    }

    @GetMapping("say/{name}") // representa "...8080/hello/say/(variavel name)"
    public String sayHelloTo(@PathVariable String name)
    {
        return "Hello " + name;
    }

    @GetMapping("say2/{name}") // representa "...8080/hello/say2/(variavel name)?message="
    public String sayHelloTo(@PathVariable String name, String message)
    {
        return "Helloooooo " + name + " " + message;
    }




}
