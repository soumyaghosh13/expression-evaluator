Expression-Evaluator
====================

### How To Use ExpressionEvaluator On Your System :-

* Extract the provided `expression-evaluator.zip`

* Create an environment variable as `EVALUATOR_HOME` with the address to your unzipped directory.

* Put this environment variable to your path as :- `%EVALUATOR_HOME%/bin`

# Release Notes

## Release 0.1

* Evaluator allows user to perform addition,subtraction,multiplication,division and power of two positive integers.
* User has to give two operands and one operator.
    eg. `25 + 22` , `25 - 22` , `25 * 2`, `24 / 2` , `2 ^ 10`
* Without Space expression is not allowed.
    eg. `25+22`
* Float Answer round up in Integer.
    eg. ` 22 / 3` give 7 instead of 7.33
* Evaluator only works for positive integers.
* NOTE : Evaluator does not handle Single Value.
* Run shell-script on command :-
    eg. `sgEval.sh "2 + 3"


## Release 0.2

* Evaluator allows user to perform Multiple Operation At a Time.
* User can give multiple Operator.
    eg. `"25 + 22 + 27"` , `"25 - 21 / 2"` , `"25 * 4 ^ 2"`
* Handels Negetive Integers.
    eg. `22 - 25` give `-3`
* Run shell-script on command :-
    eg. `sgEval.sh "10 + 15 - 5 * 5 / 2 ^ 2"`


## Release 0.3

* One Pair of Bracket Supported.
* User can give one pair of bracket in expression.
	eg.  `10 + (2 + 3)`
* Handels Single Integer.
	eg. `1`
* Run shell-script on command :-
    eg. `sgEval.sh "10 + (15 - 5)"`


## Release 0.4 Canceled.


## Release 0.5

* Multiple Pair of Bracket Supported.
* Float Value Supported.
* User can give more than one pair of bracket in expression.
	eg.  `(10 + 5) + (2 + 3)`
* Run shell-script on command :-
    eg. `sgEval.sh "(10.5 + 4.5) + (15.3 - 5.7)"`


## Release 0.6

* Multiple Space are trimmed.
* Without Space Expression are Allowed.
* Run shell-script on command :-
    eg. `sgEval.sh "(10+4)+(15-5.7)"`


## Release 0.7

* Negetive Number Handeled Properly.
* Bug Fixed of Minus Operand and Negetive Number. Example - `-2 - -2`
* Run shell-script on command :-
      eg. `sgEval.sh "-2 - -2"`

## Release 0.8

* evaluating expressions containing nested brackets.
* Run shell-script on command :-
      eg. `sgEval.sh "(1 + (4 + 2) + 1)"`
