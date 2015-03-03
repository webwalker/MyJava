package com.webwalker.spring.annotations;

import org.springframework.stereotype.Component;

import com.webwalker.spring.Interface.Axe;

@Component
public class StoneAxe implements Axe {
	public String chop() {
		return "石斧砍柴好慢";
	}
}