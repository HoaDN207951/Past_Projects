import pickle
import numpy as np
from sklearn.preprocessing import LabelBinarizer
from sklearn.preprocessing import LabelEncoder
from keras.src.utils.numerical_utils import to_categorical
from sklearn.model_selection import train_test_split
from keras.src.models.sequential import Sequential
from keras.src.layers.rnn.lstm import LSTM
from keras.src.layers.core.dense import Dense
from keras.src.layers.regularization.dropout import Dropout
from keras.src.callbacks.early_stopping import EarlyStopping
from sklearn.metrics import accuracy_score
from sklearn.neural_network import MLPClassifier
from sklearn.preprocessing import StandardScaler

data_dict = pickle.load(open('./data.pickle', 'rb'))

data = np.asarray(data_dict['data'], dtype="object")
labels = np.asarray(data_dict['labels'], dtype="object")

X_clean = [np.array(sample).flatten() for sample in data if sample is not None and len(sample) == len(data[0])]
data = np.array(X_clean, dtype=np.float32)

labels = [label for sample, label in zip(data, labels) if sample is not None and len(sample) == len(data[0])]

# lb = LabelBinarizer()
lb = LabelEncoder()
lables_encoded = lb.fit_transform(labels)
# labels_categorical = to_categorical(lables_encoded)

X_train, X_test, y_train, y_test = train_test_split(data, lables_encoded, test_size=0.2, random_state=42, stratify=labels)

sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.fit_transform(X_test)

clf = MLPClassifier(hidden_layer_sizes=(128, 64), max_iter=500)
clf.fit(X_train, y_train)

accuracy = clf.score(X_test, y_test)
print(f"Accuracy: {accuracy:.2f}")

with open("mlp_model.pkl", "wb") as f:
    pickle.dump(clf, f)

with open("scaler.pkl", "wb") as f:
    pickle.dump(sc, f)


with open("label_encoder.pkl", "wb") as f:
    pickle.dump(lb, f)
# model = Sequential([
# LSTM(64, return_sequences=True, input_shape=(data.shape[1], data.shape[2])),
# Dropout(0.5),
# LSTM(64),
# Dropout(0.5),
# Dense(64, activation='relu'),
# Dense(len(np.unique(labels)), activation='softmax')])

# model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])

# early_stop = EarlyStopping(monitor='val_loss', patience=5, restore_best_weight=True)

# model.fit(X_train, y_train, epochs=100, batch_size=32, validation_data=(X_test, y_test), callbacks=[early_stop])

# y_predict = model.predict(X_test)

# score = accuracy_score(y_predict, y_test)

# print('{}% of samples were classified correctly! '.format(score*100))

# model.save('asl_lstm_model.h5')

# with open('label_encoder.pickle', 'wb') as f:
#     pickle.dump(lb, f)