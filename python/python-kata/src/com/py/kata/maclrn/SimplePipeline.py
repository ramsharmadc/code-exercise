from scipy.spatial import distance


def euc(a, b):
    return distance.euclidean(a, b)


class ScrappyKNN:
    # basic api - 1
    def fit(self, X_train, y_train):
        self.X_train = X_train
        self.y_train = y_train

    # basic api - 2
    def predict(self, X_test):
        predictions = []
        for row in X_test:
            # label = random.choice(self.y_train)
            label = self.closest(row)
            predictions.append(label)
        return predictions

    def closest(self, row):
        best_dist = euc(row, self.X_train[0])
        best_index = 0
        for i in range(1, len(self.X_train)):
            dist = euc(row, self.X_train[i])
            if dist < best_dist:
                best_dist = dist
                best_index = i
        return self.y_train[best_index]


from sklearn import datasets

iris = datasets.load_iris()

X = iris.data
y = iris.target

from sklearn.cross_validation import train_test_split

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=.5)

# using decision tree
from sklearn import tree

my_clasifier = tree.DecisionTreeClassifier()

my_clasifier.fit(X_train, y_train)

predictions = my_clasifier.predict(X_test)

print("Predictions by decision tree classifier")
print(predictions)

from sklearn.metrics import accuracy_score

print("Accuracy of predictions by decision tree :: " + str(accuracy_score(y_test, predictions)))

# using K neighbors
from sklearn.neighbors import KNeighborsClassifier

my_clasifier = KNeighborsClassifier()

my_clasifier.fit(X_train, y_train)

predictions = my_clasifier.predict(X_test)

print("Predictions by K-neighbor classifier")
print(predictions)

from sklearn.metrics import accuracy_score

print("Accuracy of predictions by k-neighbor :: " + str(accuracy_score(y_test, predictions)))

# using Scarppy KNN Classifier ( self made )
my_clasifier = ScrappyKNN()

my_clasifier.fit(X_train, y_train)

predictions = my_clasifier.predict(X_test)

print("Predictions by Scrappy KNN classifier")
print("This is custom classifier")
print(predictions)

from sklearn.metrics import accuracy_score

print("Accuracy of predictions by Scrappy KNN :: " + str(accuracy_score(y_test, predictions)))
