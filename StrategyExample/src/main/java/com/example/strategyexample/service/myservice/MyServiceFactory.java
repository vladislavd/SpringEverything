package com.example.strategyexample.service.myservice;

import com.example.strategyexample.service.myservice.enums.ServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyServiceFactory {

   private final List<MyService> services;
   private static final Map<ServiceType, MyService> myServiceCache = new HashMap<>();

   @PostConstruct
   public void initMyServiceCache() {
      services.forEach(s -> myServiceCache.put(s.getType(), s));
   }

   public static MyService getService(ServiceType type) {
       MyService myService = myServiceCache.get(type);
       if (myService == null) {
           throw new UnsupportedOperationException("Unknown MyService type: " + type);
       }
       return myService;
   }
}
