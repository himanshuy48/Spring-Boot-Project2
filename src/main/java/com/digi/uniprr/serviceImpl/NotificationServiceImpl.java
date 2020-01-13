package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.model.Notification;
import com.digi.uniprr.repository.NotificationRepo;
import com.digi.uniprr.service.NotificationService;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationRepo notificationRepo;
	
	@Override
	public List<Notification> getNotificationByUserId(IDVO id) {
		List<Notification> notificationData = notificationRepo.getNotificationByUserId(id.getId());
		return notificationData;
	}

	@Override
	public void createNotification(Notification notification) {
		notification.setIsSeen(0);
		notification.setIsActive(1);
		notificationRepo.save(notification);
	}

}
