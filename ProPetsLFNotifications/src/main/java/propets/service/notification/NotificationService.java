package propets.service.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import propets.configuration.notification.NotificationsConfiguration;
import propets.dto.notification.NotificationDTO;

@EnableBinding(Sink.class)
public class NotificationService {

	@Autowired
	NotificationsConfiguration configuration;

	@Autowired
	JavaMailSender emailSender;

	@StreamListener(Sink.INPUT)
	public void notification(NotificationDTO notification) {
		if (notification == null) {
			return;
		}
		String urlNotification = configuration.getUrlNotification() + notification.getId();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(configuration.getSubject());
		message.setText(configuration.getText() + urlNotification);
		notification.getUsers().forEach((user) -> {
			message.setTo(user);
			emailSender.send(message);
		});
	}
}
