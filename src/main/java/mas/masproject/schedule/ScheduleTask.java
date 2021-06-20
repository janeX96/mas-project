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

    // wykonanie o 00:00 pierwszego dnia każdego miesiąca
    @Scheduled(cron="0 0 0 1 1/1 *")
    public void removeCanceledEOrders(){
        eOrderService.removeCanceledEOrders();
    }
}
