package com.webwalker.pattern.Structural.Proxy;

// "Proxy" 
public class Proxy extends Subject {
	RealSubject realSubject;

	public void Request() {
		// Use 'lazy initialization'
		if (realSubject == null) {
			realSubject = new RealSubject();
		}

		realSubject.Request();
	}
}
