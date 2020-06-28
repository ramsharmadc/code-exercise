import numpy as np
from sklearn import tree
from sklearn.datasets import load_iris

# preparing a data set
iris = load_iris()
print(iris.feature_names)  # feature columns
print(iris.target_names)  # target columns

print(iris.data[0])  # data at first row
print(iris.target[0])  # traget at first row

print("Total datasets => " + str(len(iris.data)))
print("Total targets => " + str(len(iris.target)))

# for i in range(len(iris.target)):
# print("Example %d: Label %s, features %s" % (i, iris.target[i], iris.data[i]))


# Training a classifier
test_idx = [0, 50, 100]

# training data
train_target = np.delete(iris.target, test_idx)
train_data = np.delete(iris.data, test_idx, axis=0)

# testing_data
test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

clf = tree.DecisionTreeClassifier()
clf.fit(train_data, train_target)

print(test_target)
print(clf.predict(test_data))

print(test_data[0], test_target[0])
print(iris.feature_names, iris.target_names)

from sklearn.externals.six import StringIO
import pydot

dot_data = StringIO()
tree.export_graphviz(clf,
                     out_file=dot_data,
                     feature_names=iris.feature_names,
                     class_names=iris.target_names,
                     filled=True,
                     rounded=True,
                     impurity=False)
graph = pydot.graph_from_dot_data(dot_data.getvalue())
graph.write_pdf("iris.pdf")
