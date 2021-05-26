package br.com.maikelsoft.poc.kafkaproducer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ConfigurationBean {

	private @Value("${application.params.bootstrap-server}") String bootstrapServer;
	private @Value("${application.params.group-id}") String groupId;
	private @Value("${application.params.client-id}") String clientId;
	private @Value("${application.params.auto-offset-reset}") String autoOffsetReset;
	private @Value("${application.params.producer-topic}") String producerTopic;
}
