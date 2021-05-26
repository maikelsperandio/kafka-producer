package br.com.maikelsoft.poc.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.maikelsoft.poc.kafkaproducer.producer.OnlineSalesPublisher;

@RestController
@RequestMapping("/api/v1/sale")
public class OnlineSalesController {

	private @Autowired OnlineSalesPublisher publisher;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void sell(@RequestBody String message) {
		publisher.publishOnlineSales(message);
	}
}
