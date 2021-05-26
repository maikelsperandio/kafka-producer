package br.com.maikelsoft.poc.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import br.com.maikelsoft.poc.kafkaproducer.config.ConfigurationBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OnlineSalesPublisher {

	private @Autowired ConfigurationBean configBean;
	private @Autowired KafkaTemplate<String, Object> kafkaTemplate;

	public void publishOnlineSales(String message) {
		ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(configBean.getProducerTopic(), message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

			@Override
			public void onSuccess(SendResult<String, Object> result) {
				log.info("The message ".concat(message).concat(" has been sent to topic: ").concat(configBean.getProducerTopic()).concat(" with offset: ").concat(String.valueOf(result.getRecordMetadata().offset())));
				
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("It was unable to send the message: ".concat(message).concat(" to the topic: ").concat(configBean.getProducerTopic()).concat(" due to: ").concat(ex.getMessage()));
			}
			
		});
	}
}
