# Import necessary libraries
from sklearn.datasets import load_breast_cancer# type: ignore
from sklearn.model_selection import train_test_split# type: ignore
from sklearn.tree import DecisionTreeClassifier# type: ignore
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix# type: ignore

# Load the Breast Cancer dataset
data = load_breast_cancer()
X = data.data
y = data.target

# Split the dataset into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Initialize the Decision Tree classifier with 'entropy' criterion for information gain and adjust min_samples_split for pruning
clf = DecisionTreeClassifier(criterion="entropy", min_samples_split=4, random_state=42)
clf.fit(X_train, y_train)

# Predict on the test data
y_pred = clf.predict(X_test)

# Evaluate the model
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)
print("Classification Report:\n", classification_report(y_test, y_pred))
print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred))


