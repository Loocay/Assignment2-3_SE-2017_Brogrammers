package com.example.teamapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * Team: Brogrammers
 * Members: Akhmer Yersultan, Baktygereev Bek, Kaskarauov Adilet, Sembaev Nurbakyt
 * Group: SE-2017
 * Teacher: Kyzyrkanov Abzal
 */


@RestController
public class TestController {
    @GetMapping("/getJson")
    public Map<String, String> getJson(){
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }
}
