package com.webwalker.spring;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

/**
 * 拦截器
 * 
 * @author Administrator
 * 
 */
public class MessageInterceptor extends AbstractPhaseInterceptor<Message> {

	public MessageInterceptor(String phase) {
		super(phase);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		System.out.println("############handleMessage##########");
		System.out.println(message);
		if (message.getDestination() != null) {
			System.out.println(message.getId() + "#"
					+ message.getDestination().getMessageObserver());
		}
		if (message.getExchange() != null) {
			System.out.println(message.getExchange().getInMessage() + "#"
					+ message.getExchange().getInFaultMessage());
			System.out.println(message.getExchange().getOutMessage() + "#"
					+ message.getExchange().getOutFaultMessage());
		}
	}
}
