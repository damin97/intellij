package com.damin._sb0401.controller;

import com.damin._sb0401.entity.Memo;
import com.damin._sb0401.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    MemoService memoService;

    @GetMapping("/")
    public Memo root() {
        memoService.emInsert();
        return memoService.emSelectOne(11L);
    }
}
