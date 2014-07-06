package com.starkhorn.calculator;

import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

	private final ScriptEngineManager scriptManager;
	private final ScriptEngine jsEngine;
	private final DecimalFormat formatter;

	public Calculator() {
		scriptManager = new ScriptEngineManager();
		jsEngine = scriptManager.getEngineByName("js");
		formatter = new DecimalFormat("0.#####");
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
		String evaluated_output = jsEngine.eval(input).toString();
		Double output_number = Double.valueOf(evaluated_output);
		
		if (isInvalid(output_number)) {
			throw new ScriptException("Error: invalid input");
		}
		
		return formatter.format(output_number);
	}

	private boolean isInvalid(Double output) {
		return output.isInfinite() || output.isNaN();
	}

}
