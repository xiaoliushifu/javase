package com.example.hello;

import java.util.concurrent.atomic.AtomicLong;

import com.example.hello.Util.HttpClientUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Worl22d") String name) {
        //自己找同一个包下的类，该文件Greeting无需import
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    /**
     * 测试java版本的http请求
     * @param url
     * @return
     */
    @RequestMapping("/urlget")
    public String get(@RequestParam(value="url",defaultValue = "http://www.baidu.com") String url) {
        return HttpClientUtil.doGet(url);
    }

}