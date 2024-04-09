package org.summer.tiger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("security")
    public String security() {
        return "security";
    }

    @GetMapping("security/do")
    public String securityDo() {
        return "security do";
    }

    @GetMapping("security/dont")
    public String securityDont() {
        return "security don't";
    }
}
