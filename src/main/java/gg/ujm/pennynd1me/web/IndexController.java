package gg.ujm.pennynd1me.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/summoner")
    public String search(@RequestParam(value = "name", required = false) String name) throws UnsupportedEncodingException {
        if (name == null || name.isEmpty()) {
            return "redirect:/";
        }
        String encoded = URLEncoder.encode(name, "UTF-8");
        return "redirect:summoner/" + encoded;
    }

}
