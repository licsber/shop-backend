package site.licsber.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.licsber.shop.model.Res;

import java.util.Map;

@V1RestController
public class HoleController {

    @RequestMapping("/hole")
    public Res hole(@RequestParam Map<String, String> all) {
        Res res = new Res(200, "黑洞请求成功", all);
        System.out.println(res);
        return res;
    }

}
