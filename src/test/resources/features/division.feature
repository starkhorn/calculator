Feature: Division

	Scenario Outline: Divide two numbers
		Given the input "<input>"
		When the calculator is run
		Then the output should be "<output>"
		
		Examples:
			| input    | output                     |
			| 10/5     | 2                          |
			| 10/0     | Error: invalid input       |
			| 5/2      | 2.5                        |
			| 6.25/2   | 3.125                      | 
			| 7/3      | 2.33333                    |
			| 11/3     | 3.66667                    |
			| 0/5      | 0                          |
			| 0/0      | Error: invalid input       |