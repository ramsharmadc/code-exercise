import numpy
# from sympy import plot, mathematica_code
from pandas.tools.plotting import _plot


def simple_graph():
    x = [2, 3, 1, 8, 1.5]
    y = [12, 20, 50, 25, 50, 30]

    # plot(x, y)
    _plot(x,y)

simple_graph()
