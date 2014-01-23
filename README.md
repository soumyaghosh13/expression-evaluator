Expression-Evaluator
====================

## Release 0.1

### Evaluator allows user to perform addition,subtraction,multiplication,division and power of two positive integers.

* User has to give two operands and one operator.
    eg. `25 + 22` , `25 - 22` , `25 * 2`, `24 / 2` , `2 ^ 10`

* Without Space expression is not allowed.
    eg. `25+22`

* Float Answer round up in Integer.
    eg. ` 22 / 3` give 7 instead of 7.33

* Evaluator only works for positive integers.

* NOTE : Evaluator does not handle Single Value.

## How To Use ExpressionEvaluator On Your System :-

* Extract the provided `exp-eval_0.1.zip`

* Create an environment variable as `EVALUATOR_HOME` with the address to your unzipped directory.

* Put this environment variable to your path as :- `%EVALUATOR_HOME%/bin`

* Run shell-script on command :-
    eg. `sgEval.sh "2 + 3"


## Release 0.2

### Evaluator allows user to perform Multiple Operation At a Time.

* User can give multiple Operator.
    eg. `"25 + 22 + 27"` , `"25 - 21 / 2"` , `"25 * 4 ^ 2"`

* Handels Negetive Integers.
    eg. `22 - 25` give `-3`

* Run shell-script on command :-
    eg. `sgEval.sh "10 + 15 - 5 * 5 / 2 ^ 2"`


## Release 0.2

### One Pair of Bracket Supported.

* User can give one pair of bracket in expression.
	eg.  `10 + (2 + 3)`

* Handels Single Value.
	eg. `1`

* Run shell-script on command :-
    eg. `sgEval.sh "10 + (15 - 5)"`
