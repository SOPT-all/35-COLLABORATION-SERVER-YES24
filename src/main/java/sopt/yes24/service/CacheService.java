package sopt.yes24.service;

import java.util.concurrent.ConcurrentHashMap;

public class CacheService {
    private ConcurrentHashMap<String, Object> cache;

    public CacheService() {
        this.cache = new ConcurrentHashMap<>();
    }
    
    public Object getFromCache(String key) {
        return cache.get(key);
    }

    public void addToCache(String key, Object value) {
        cache.put(key, value);
    }

    public void updateToCache(String key, Object value) {
        cache.put(key, value);
    }

    public void removeFromCache(String key) {
        cache.remove(key);
    }

    public void clearCache() {
        cache.clear();
    }
}
