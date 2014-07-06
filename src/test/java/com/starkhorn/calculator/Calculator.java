package com.starkhorn.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

	private final ScriptEngineManager scriptManager;
	private final ScriptEngine jsEngine;

	public Calculator() {
		scriptManager = new ScriptEngineManager();
		jsEngine = scriptManager.getEngineByName("js");
	}

	public String run(String input) throws Throwable {
		String output = null;
		
		try {
			output = evaluate(input);
		} catch (ScriptException e) {
			output = e.getMessage();
		}
		
		return output;
	}

	private String evaluate(String input) throws ScriptException {
		Object output = jsEngine.eval(input);
		boolean isFinite = (Boolean) jsEngine.eval("isFinite(" + output + ")");
		
		if (!isFinite) {
			throw new ScriptException("Error: invalid input");
		}
		
		return output.toString();
	}

}
