package marchly.datn.backend.controller.giamgia_controller.PhieuGiamGia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPhieuGiamGiaController {
    @GetMapping("/ADDphieuGiamGia")
    public String show(){

        return "add-phieu-giam-gia";
    }
}
