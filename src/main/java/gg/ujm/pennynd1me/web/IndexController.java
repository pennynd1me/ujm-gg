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
    public String search(@RequestParam("name") String name) throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode(name, "UTF-8");
        encoded = encoded.replaceAll(" ", "%20");
        return "redirect:summoner/" + encoded;
    }

}
