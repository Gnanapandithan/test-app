package com.demo.resource;

import com.demo.common.Stall;
import com.demo.common.StallQualifier;
import com.demo.common.StallType;

@StallQualifier(StallType.FRUIT)
public class FruitStall implements Stall{

	public String getName() {
		return "world fruitstall ";
	}
}
