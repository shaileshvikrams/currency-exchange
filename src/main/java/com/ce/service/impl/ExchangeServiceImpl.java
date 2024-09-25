package com.ce.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ce.dto.ExchangeDto;
import com.ce.service.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService {

	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public double exchangeCurrency(double amount, String inCurrency, String outCurrency) {
		ExchangeDto dto = findCurrencyPriceFromExchange(inCurrency);
		return dto.getRates().get(outCurrency);
	}

	//@Cacheable("currency-exchange")
	@CacheEvict(value="currency-exchange-cache", allEntries=true)
	public ExchangeDto findCurrencyPriceFromExchange(String baseCurrency) {
		LOG.info("In findCurrencyPriceFromExchange");
		ResponseEntity<ExchangeDto> res = restTemplate
				.getForEntity("https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=test", ExchangeDto.class);
		return res.getBody();
	}

}
