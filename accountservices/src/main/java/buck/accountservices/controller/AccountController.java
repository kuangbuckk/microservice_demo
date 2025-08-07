package buck.accountservices.controller;

import buck.accountservices.entity.Account;
import buck.accountservices.model.AccountDTO;
import buck.accountservices.model.MessageDTO;
import buck.accountservices.model.StatisticDTO;
import buck.accountservices.service.AccountService;
import buck.accountservices.service.client.NotificationService;
import buck.accountservices.service.client.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private AccountService accountService;

//    @Qualifier("buck.accountservices.service.client.StatisticService")
//    @Autowired
//    private StatisticService statisticService;
//
//    @Qualifier("buck.accountservices.service.client.NotificationService")
//    @Autowired
//    private NotificationService notificationService;

    @PostMapping("/new")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) throws Exception {
        accountService.add(accountDTO);

        StatisticDTO statisticDTO = new StatisticDTO("Account " + accountDTO.getName() + " is created ", new Date());
        //statisticService.addStatistic(statisticDTO);

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTo("kuangbuckk159@gmail.com");
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Welcome");
        messageDTO.setContent("Test");
//        for (int i = 0; i < 100;i++)

        kafkaTemplate.send("notification", messageDTO);
        kafkaTemplate.send("statistic", statisticDTO);

        //notificationService.sendNotification(messageDTO);
        return accountDTO;
    }

    @GetMapping("")
    public List<AccountDTO> getAll(){
        return accountService.getAll();
    }
}
