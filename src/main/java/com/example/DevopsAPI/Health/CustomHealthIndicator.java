package com.example.DevopsAPI.Health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // Implementa tu lógica de verificación aquí
        if (errorCode != 0) {
            return Health.down()
                    .withDetail("Error Code", errorCode)
                    .withDetail("Description", "El componente ha fallado con un código de error.")
                    .build();
        }
        return Health.up()
                .withDetail("message", "El Health Check está funcionando correctamente.")
                .build();
    }

    private int check() {
        // Lógica para revisar un recurso, como una base de datos
        return 0; // 0 significa que está saludable
    }
}


