package zone.yue.t

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "t")
class TConfiguration {
    lateinit var salt: String
}