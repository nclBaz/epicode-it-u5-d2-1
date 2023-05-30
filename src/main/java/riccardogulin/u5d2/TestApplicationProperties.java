package riccardogulin.u5d2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class TestApplicationProperties {
	@Value("${application.supersecret}")
	String supersecret;
}
