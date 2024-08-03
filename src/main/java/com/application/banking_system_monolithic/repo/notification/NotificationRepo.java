package com.application.banking_system_monolithic.repo.notification;

import com.application.banking_system_monolithic.entity.notification.NotificationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationDetails, Long> {
}
