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

	public String run(String input) throws ScriptException {
		return evaluate(input);
	}

	private String evaluate(String input) throws ScriptException {
		return jsEngine.eval(input).toString();
	}

}
