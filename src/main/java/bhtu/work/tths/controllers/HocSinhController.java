package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.services.HocSinhService;

@RestController
@RequestMapping(path = "api/hocsinh")
public class HocSinhController {
    private final HocSinhService hocSinhService;


    @Autowired
    public HocSinhController(HocSinhService hocSinhService) {
        this.hocSinhService = hocSinhService;
    }


    @GetMapping("phanthuong")
    public String getPhanThuongDaTrao(@RequestParam(name = "tieuChiStr", defaultValue = "SoVo") String tieuChiStr) {
        tieuChiStr.toLowerCase();
        HocSinhService.TieuChi tieuChi;
        switch (tieuChiStr) {
            case "sovo" -> tieuChi = HocSinhService.TieuChi.SoVo;
            case "giatri" -> tieuChi = HocSinhService.TieuChi.GiaTri;
            default -> {
                return null;
                // Todo: redirect to /error page
            }
        }
        return String.valueOf(hocSinhService.getPhanThuongDaTrao(tieuChi));
    }
}
