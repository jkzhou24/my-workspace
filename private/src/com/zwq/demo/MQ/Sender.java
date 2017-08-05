package com.zwq.demo.MQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(  
                ActiveMQConnection.DEFAULT_USER,  
                ActiveMQConnection.DEFAULT_PASSWORD,  
                "tcp://192.168.199.101:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);  
		
		Destination des = session.createQueue("test-queue");
		
		MessageProducer producer = session.createProducer(des);
		
		for(int i=0;i<10;i++){
			TextMessage message = session.createTextMessage("test message[" + i + "]");
			producer.send(message);
		}
		
		session.commit();
		session.close();
		connection.close();
		
	}
}
