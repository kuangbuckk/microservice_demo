package jmaster.io.statisticservice.controller;

import jmaster.io.statisticservice.model.StatisticDTO;
import jmaster.io.statisticservice.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    @PostMapping("/statistics")
    public void addStatistic(@RequestBody StatisticDTO statisticDTO) {
        statisticService.add(statisticDTO);
    }

    @GetMapping("/statistics")
    public List<StatisticDTO> getAll(){
        //List<StatisticDTO> statisticDTOS = statisticService.getAll();
        return statisticService.getAll();
    }
}
