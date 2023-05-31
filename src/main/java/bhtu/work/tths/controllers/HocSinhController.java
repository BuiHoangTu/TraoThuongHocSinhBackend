package bhtu.work.tths.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.HocSinh;
import bhtu.work.tths.models.enums.EGetStudents;
import bhtu.work.tths.services.HocSinhService;

@RestController
@RequestMapping(path = "hocsinh")
public class HocSinhController {
    private final HocSinhService hocSinhService;

    @Autowired
    public HocSinhController(HocSinhService hocSinhService) {
        this.hocSinhService = hocSinhService;
    }

    @GetMapping("get")
    public HocSinh getHocSinh(@RequestParam(name = "id") String id) {
        return hocSinhService.getHocSinhById(id);
    }

    @GetMapping("find")
    public List<HocSinh> findHocSinh(@RequestParam(name = "category", defaultValue = "ID") String categoryStr,
            @RequestParam(name = "filter") String filter) {

        EGetStudents category = EGetStudents.valueOf(categoryStr.toUpperCase());
        return hocSinhService.findHocSinh(category, filter);

    }

    public void addHocSinh(HocSinh idlessHocSinh) {
        hocSinhService.addHocSinh(idlessHocSinh);
    }
}
