package com.webwalker.pattern.Behavioral.Mediator;

// "Mediator" 
public abstract class Mediator {
	public abstract void Send(String message, Colleague colleague);
}
