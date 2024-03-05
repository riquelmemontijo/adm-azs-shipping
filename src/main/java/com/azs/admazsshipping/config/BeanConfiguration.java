package com.azs.admazsshipping.config;

import com.azs.admazsshipping.adapter.FreteAdapterImpl;
import com.azs.admazsshipping.domain.ports.inbound.FreteUseCasePort;
import com.azs.admazsshipping.domain.usecase.FreteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public FreteUseCasePort freteUseCasePort(FreteAdapterImpl freteAdapter){
        return new FreteUseCaseImpl(freteAdapter);
    }

}
