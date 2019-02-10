package com.hnuc.api;

import com.hnuc.common.util.JSONResult;
import com.hnuc.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bgm")
public class BgmController extends BaseController{

    @Autowired
    private BgmService bgmService;

    @GetMapping("/list")
    public JSONResult queryAllBgm(){
        return JSONResult.retOK(bgmService.queryAllBgm());
    }
}
