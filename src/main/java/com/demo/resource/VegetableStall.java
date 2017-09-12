package com.demo.resource;

import com.demo.common.Stall;
import com.demo.common.StallQualifier;
import com.demo.common.StallType;

@StallQualifier(StallType.VEGE)
public class VegetableStall implements Stall{

	public String getName() {
		return "Vege";
	}

}
