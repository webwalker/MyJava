package com.webwalker.pattern.Behavioral.Visitor;

// "Visitor" 
public abstract class Visitor {
	public abstract void VisitConcreteElementA(ConcreteElementA concreteElementA);

	public abstract void VisitConcreteElementB(ConcreteElementB concreteElementB);
}
