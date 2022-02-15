package com.example.libraryapp.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    private String name;

    @Autowired
    RequestScope requestScope;

    @Autowired
    SessionScope sessionScope;

    public RequestScope getRequestScope() {
        return requestScope;
    }

    public SessionScope getSessionScope() {
        return sessionScope;
    }

}
