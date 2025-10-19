/*
 * Copyright 2003-2025 OneVizion, Inc. All rights reserved.
 */

package my.samples.springsecurity.web.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {

    @EventListener
    public void onFailure(AuthorizationDeniedEvent<?> failure) {
        System.out.println("EVENT_AUTH_DENIED: " + failure.getSource());
    }
}
