package com.webwalker.spring.annotations;

import org.springframework.stereotype.Component;

import com.webwalker.spring.Interface.Axe;

@Component
public class SteelAxe implements Axe {
	public String chop() {
		return "钢斧砍柴真快";
	}
}