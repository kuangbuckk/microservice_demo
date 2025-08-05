package buck.accountservices.service.client;

import buck.accountservices.model.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service", url = "http://localhost:3002", fallback = StatisticServiceImpl.class)
public interface StatisticService {
    @PostMapping("/statistics")
    void addStatistic(@RequestBody StatisticDTO statisticDTO);
}

@Component(value = "statisticServiceImpl")
class StatisticServiceImpl implements StatisticService{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addStatistic(StatisticDTO statisticDTO){
        logger.error("Statistic service is slow");
    }
}
