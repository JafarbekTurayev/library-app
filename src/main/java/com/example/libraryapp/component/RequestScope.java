package com.example.libraryapp.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@AllArgsConstructor
public class RequestScope {

    private String name = "Request Scope";

    public RequestScope() {
        System.out.println("DataRequestScope Constructor Called");
    }
}
