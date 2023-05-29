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
    public int getPhanThuongDaTrao(@RequestParam(name = "tieuchi", defaultValue = "SoVo") String tieuchi) {
        return hocSinhService.getPhanThuong(tieuchi);
    }
}
