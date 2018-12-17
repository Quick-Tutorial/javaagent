package com.hsahu.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * This is simple class that can calculate the size of any object. This class is
 * analogous to sizeof() operator in C++
 * 
 * @author himanshu.sahu
 *
 */
public class ObjectSizeCalculatorAgent {
	private static volatile Instrumentation instrumentation;

	public static void premain(final String agentArgs, final Instrumentation instrumentation) {
		ObjectSizeCalculatorAgent.instrumentation = instrumentation;
		System.out.println("instrumentation agent initialized.....");
	}

	public static long getObjectSize(final Object object) {
		if (instrumentation == null) {
			throw new IllegalStateException("Agent not initialized.");
		}
		return instrumentation.getObjectSize(object);
	}
}