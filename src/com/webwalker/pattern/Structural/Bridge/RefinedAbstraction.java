package com.webwalker.pattern.Structural.Bridge;

// "RefinedAbstraction"
public class RefinedAbstraction extends Abstraction {
	public void Operation() {
		implementor.Operation();
	}
}
