package marchly.datn.backend.controller.trahang_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TraHangController {
    @GetMapping("/traHang")
    public String show(){
        return "pages/TraHang/TraHang";
    }
}
