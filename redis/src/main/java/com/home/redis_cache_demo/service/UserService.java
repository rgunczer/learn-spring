package com.home.redis_cache_demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.home.redis_cache_demo.domain.User;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UserService {

    private final Map<Long, User> db = new ConcurrentHashMap<>(); // our DB for brevity, right!?


    public UserService() {
        db.put(1L, new User(1L, "Alice"));
        db.put(2L, new User(2L, "Bob"));
    }

    @Cacheable(cacheNames = "users", key = "#userId")
    public User getUser(final Long userId) {
        simulateSlowIO();
        return db.get(userId);
    }

    /////////////////////////////////////////////////////////
    // utils

    private void simulateSlowIO() {
        try {
            log.info("Slow...");
            Thread.sleep(3000);
        } catch (final InterruptedException ex) {
            // do nothing!
        }
    }

}
