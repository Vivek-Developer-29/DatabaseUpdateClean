package com.DatabaseClean.service;

import com.DatabaseClean.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CleanupService {
    @Autowired
    private DataRepository dataRepository;

    @Scheduled(cron = "0 */1 * * * *")
    public void cleanupOldData(){
        try {
            LocalDate yesterday = LocalDate.now().minusDays(1);
            Date yesterdayDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());

            System.out.println("Cleanup Start with arg - " + yesterdayDate.toString());
            dataRepository.deleteByCreatedAtBefore(yesterdayDate);
            System.out.println("Cleanup Completed");
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
