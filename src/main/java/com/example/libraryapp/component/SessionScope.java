package com.example.libraryapp.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//@Bean
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@AllArgsConstructor
public class SessionScope {

    private String name = "Session Scope";

    public SessionScope() {
        System.out.println("Session Constructor Called");
    }
}
