package amch.labs.spring.dockercompose.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ClockConfig {
    /**
     * SystemClock : l’implémentation de base, qui retournera toujours l’instant présent
     * TickClock :   horloge dont la précision est ajustable,
     *               il est par exemple possible de ne regarder que la minute si les secondes,
     *               les millisecondes ou les nanosecondes
     * FixedClock : retourne toujours le même instant
     * OffsetClock : ajoute un décalage à une horloge sous-jacente
     * @return
     */
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}