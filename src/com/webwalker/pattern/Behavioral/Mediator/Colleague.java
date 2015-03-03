package com.webwalker.pattern.Behavioral.Mediator;

// "Colleague" 
public abstract class Colleague {
	protected Mediator mediator;

	// Constructor
	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
}