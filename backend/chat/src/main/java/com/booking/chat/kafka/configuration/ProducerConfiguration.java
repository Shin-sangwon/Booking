package com.booking.chat.kafka.configuration;

import com.booking.chat.kafka.domain.KafkaMessage;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@EnableKafka
@Configuration
public class ProducerConfiguration {

    @Bean
    public ProducerFactory<String, KafkaMessage> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfigurations());
    }

    @Bean
    public Map<String, Object> producerConfigurations() {
        return ImmutableMap.<String, Object>builder()
                           .put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.45.98:9092")
                           .put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class)
                           .put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class)
                           .build();
    }

    @Bean
    public KafkaTemplate<String, KafkaMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
