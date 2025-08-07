package jmaster.io.statisticservice.service;

import jmaster.io.statisticservice.model.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StatisticKafkaService {
    public Logger logger = LoggerFactory.getLogger(StatisticKafkaService.class);
    @Autowired
    public KafkaTemplate<String, Object> kafkaTemplate;
    @Autowired
    private StatisticServiceImpl statisticServiceImpl;

    @KafkaListener(id = "statisticGroup", topics = "statistic")
    public void listen(StatisticDTO statisticDTO){
        logger.info("Received: ", statisticDTO.getMessage());
        statisticServiceImpl.add(statisticDTO);
    }
}
