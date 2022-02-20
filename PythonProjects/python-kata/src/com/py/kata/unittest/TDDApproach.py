import pytest

def fizzBuzz(value):
    return value


def checkFizzBuzz(retValue, expectedVRetalue):
    retValue = fizzBuzz(retValue)
    assert retValue == expectedVRetalue