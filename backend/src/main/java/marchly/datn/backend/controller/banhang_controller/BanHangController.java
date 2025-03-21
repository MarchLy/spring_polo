package marchly.datn.backend.controller.banhang_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BanHangController {
    @GetMapping("/BanHangTQ")
    public String show(){
        return "pages/BanHangTaiQuay/BanHangTaiQuay";
    }
}
