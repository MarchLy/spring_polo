package marchly.datn.backend.controller.giamgia_controller.DotGiamGiaController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DotGiamGiaController {
@GetMapping("/dotGiamGia")
public String show(){

    return "pages/QuanLyGiamGia/DotGiamGiaView/DotGiamGia";
}
}
