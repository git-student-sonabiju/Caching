package com.edstem.caching.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CaffeineCacheManager cacheManager() {
		CaffeineCacheManager manager = new CaffeineCacheManager("products", "prices");
		manager.setCaffeine(
				Caffeine.newBuilder()
						.expireAfterWrite(60, TimeUnit.SECONDS)
						.maximumSize(100)
		);
		return manager;
	}
}
