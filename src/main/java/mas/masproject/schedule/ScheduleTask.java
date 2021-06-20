package mas.masproject.schedule;

import mas.masproject.services.EOrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    private EOrderService eOrderService;

    public ScheduleTask(EOrderService eOrderService) {
        this.eOrderService = eOrderService;
    }

    // wykonywane pierwszego dnia każdego miesiąca o godz 12:00
    @Scheduled(cron="0 0 12 1 * ?")
    public void removeCanceledEOrders(){
        eOrderService.removeCanceledEOrders();
    }
}
