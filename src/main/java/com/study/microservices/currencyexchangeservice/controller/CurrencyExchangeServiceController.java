package com.study.microservices.currencyexchangeservice.controller;

import com.study.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.study.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeServiceController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to
    ) {
//        return new CurrencyExchange(
//                100L,
//                from,
//                to,
//                BigDecimal.valueOf(1000),
//                getEnvironmentPort()
//        );
        return currencyExchangeRepository.findByFromAndTo(from,to);
    }

    private String getEnvironmentPort() {
        return environment.getProperty("local.server.port");
    }
}
