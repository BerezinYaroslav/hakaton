import requests
from sklearn.preprocessing import StandardScaler
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

response = requests.get('http://localhost:8080/stats')
data_json = response.json()

# print(data)
genders = []
durations = []
ages = []
packages = []

count = 0
for row in data_json:
    genders.append(row['client']['gender'])
    durations.append(row['duration'])
    ages.append(row['client']['age'])
    packages.append(row['channelId'])


df = pd.DataFrame({'gender': genders, 'duration': durations,
                   'age': ages, 'package': packages})

df['gender'] = df['gender'].astype('category').cat.codes
df['duration'] = df['duration'].astype('category').cat.codes
df['age'] = df['age'].astype('category').cat.codes
df['package'] = df['package'].astype('category').cat.codes

# Стандартизация данных
# scaler = StandardScaler()
# standardized_data = scaler.fit_transform(df)

model = KMeans(n_clusters=5)
model.fit(df)

# colors = ["red", "green", "blue", "orange", "pink"]
# plt.figure(figsize=(15,15))
# plt.xlabel("Возраст")
# plt.ylabel("Продолжительность просмотра")
# plt.title("Зависимость возраста от продолжительности просмотра")
# for i in range(1, 1000):
#   plt.scatter(df['age'][i],
#               df['duration'][i],
#               color = colors[model.labels_[i]])
# plt.show()
#
# plt.figure(figsize=(15,15))
# plt.xlabel("Пол")
# plt.ylabel("Продолжительность просмотра")
# plt.title("Зависимость возраста от продолжительности просмотра")
# for i in range(1, 1000):
#   plt.scatter(df['gender'][i],
#               df['duration'][i],
#               color = colors[model.labels_[i]])
# plt.show()
#
# plt.figure(figsize=(15,15))
# plt.xlabel("Пол")
# plt.ylabel("Канал")
# plt.title("Зависимость пола от просматриваемого канала")
# for i in range(1, 1000):
#   plt.scatter(df['gender'][i],
#               df['package'][i],
#               color = colors[model.labels_[i]])
# plt.show()
#
# plt.figure(figsize=(15,15))
# plt.xlabel("Продолжительность просмотра")
# plt.ylabel("Канал")
# plt.title("Зависимость Продолжительности просмотра от просматриваемого канала")
# for i in range(1, 1000):
#   plt.scatter(df['gender'][i],
#               df['package'][i],
#               color = colors[model.labels_[i]])
# plt.show()