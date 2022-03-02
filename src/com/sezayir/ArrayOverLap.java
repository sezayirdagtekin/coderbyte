package com.sezayir;

import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;

public class ArrayOverLap {

	public static String ArrayChallenge(int[] arr) {
		// code goes here
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Input can not be empty ");
		}
		IntBinaryOperator minBoundFunc = (x, y) -> x > y ? x : y;
		IntBinaryOperator maxBoundFunc = (x, y) -> x < y ? x : y;

		int from = minBoundFunc.applyAsInt(arr[0], arr[2]);
		int to = maxBoundFunc.applyAsInt(arr[1], arr[3]);

		IntSupplier supplier = () -> to - from + 2;

		return (supplier.getAsInt() - arr[4] >= 0) ? "true" : "false";
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 4, 10, 2, 6, 3 };
		System.out.println(ArrayChallenge(arr));

	}

}