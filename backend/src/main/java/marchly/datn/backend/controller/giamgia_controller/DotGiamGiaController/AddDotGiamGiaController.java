package marchly.datn.backend.controller.giamgia_controller.DotGiamGiaController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AddDotGiamGiaController {
    @GetMapping("/ADDdotGiamGia")
    public String show(){

        return "pages/QuanLyGiamGia/DotGiamGiaView/AddDotGiamGia";
    }
}
