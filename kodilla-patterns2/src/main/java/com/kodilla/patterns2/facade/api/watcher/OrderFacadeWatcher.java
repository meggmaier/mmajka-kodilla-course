package com.kodilla.patterns2.facade.api.watcher;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger((OrderFacadeWatcher.class));

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId)")
    public void logEvent(OrderDto order, Long userId) {
        LOGGER.info("Processing order for: " + userId.toString());
    }

}
