package propets.dto.notification;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class NotificationDTO {
	
	String id;
	
	@Singular("users")
	Set<String> users;
	

}
