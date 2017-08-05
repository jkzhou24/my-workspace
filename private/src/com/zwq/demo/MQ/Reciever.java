package com.zwq.demo.MQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Reciever {
	private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,  
		          ActiveMQConnection.DEFAULT_PASSWORD, "tcp://192.168.199.101:61616");
	public static void main(String[] args) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Destination des = session.createQueue("test-queue");
		
		MessageConsumer consumer = session.createConsumer(des);
		
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message msg) {
				try {  

                    TextMessage message = (TextMessage) msg;  
                    System.out.println("consumer收到消息： "+message.getText());  
                    session.commit();  
                } catch (JMSException e) {                
                    e.printStackTrace();  
                }  
			}
		});
		
		MessageConsumer consumer2 = session.createConsumer(des);
		
		consumer2.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message msg) {
				try {  
					
					TextMessage message = (TextMessage) msg;  
					System.out.println("consumer2收到消息： "+message.getText());  
					session.commit();  
				} catch (JMSException e) {                
					e.printStackTrace();  
				}  
			}
		});
		
	}
}
