package com.example.lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    // первый эндпоинт - возвращает текст
    @GetMapping("/hello")
    public String hello() {
        return "Привет! Это моя первая лабораторная на Spring Boot";
    }

    // второй эндпоинт - возвращает числа от 1 до count
    // пример: /numbers?count=5 -> [1, 2, 3, 4, 5]
    @GetMapping("/numbers")
    public List<Integer> numbers(@RequestParam(defaultValue = "10") int count) {
        // ограничение, чтобы нельзя было запросить слишком много чисел
        if (count < 1) {
            count = 1;
        }
        if (count > 100) {
            count = 100;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(i);
        }
        return list;
    }

}
