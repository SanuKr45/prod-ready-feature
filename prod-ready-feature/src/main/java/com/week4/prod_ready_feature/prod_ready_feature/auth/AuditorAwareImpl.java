package com.week4.prod_ready_feature.prod_ready_feature.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Akash Gupta");
    }
}
