package com.doublev2v;

import com.doublev2v.integralmall.util.MapPointDistance;

public class EasyTest {

	public static void main(String[] args) {
		double d=MapPointDistance.getPointsDistance(116.509922,39.925419,116.515786,39.925590);
		System.out.println(d);//500m
		
	}
}
