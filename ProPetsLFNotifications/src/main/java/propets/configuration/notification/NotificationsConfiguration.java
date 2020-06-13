package propets.configuration.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@RefreshScope
@Getter
public class NotificationsConfiguration {

	@Value("${urlNotification}")
	String urlNotification;
	
	@Value("${subject}")
	String subject;
	
	@Value("${text}")
	String text;
}
