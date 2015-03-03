package com.webwalker.pattern.Behavioral.Visitor;

// "Element" 
public abstract class Element {
	public abstract void Accept(Visitor visitor);
}
