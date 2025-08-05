package buck.accountservices.service.client;


import buck.accountservices.model.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:3006/notification/", fallback = NotificationServiceImpl.class)
public interface NotificationService {
    @PostMapping("/create")
    public void sendNotification(@RequestBody MessageDTO messageDTO) throws Exception;
}

@Component
class NotificationServiceImpl implements NotificationService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendNotification(MessageDTO messageDTO) throws Exception{
        try {
            logger.error("Notification server is slow");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
