import csv
import psycopg2

# Данные для подключения к БД
db_config = {
    "host": "localhost",
    "port": 5433,
    "dbname": "hakaton",
    "user": "admin",
    "password": "admin"
}

# Имя входного CSV-файла
input_filename = "epg_stat_2024_10.csv"

# SQL-запрос для вставки данных
insert_query = """
INSERT INTO stat (client, device, time_ch, channel_id, epg_name, time_epg, time_to_epg, duration, category, subcategory)
VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
"""

try:
    # Подключение к БД
    connection = psycopg2.connect(**db_config)
    
    # Отключение режима транзакций
    connection.autocommit = True
    cursor = connection.cursor()

    # Открытие CSV-файла
    with open(input_filename, mode='r', encoding='utf-8') as infile:
        reader = csv.reader(infile, delimiter=';')
        
        # Пропускаем заголовок
        header = next(reader)
        count = 0
        
        for row in reader:
            count += 1
            print(count)

            if count >= 100000:
                break

            # Разбираем строку
            client = row[0]
            device = row[1]
            time_ch = row[2]
            ch_id = int(row[3])
            epg_name = row[4]
            time_epg = row[5]
            time_to_epg = row[6]
            duration = int(row[7])
            category = row[8]
            subcategories = row[9].split(", ")  # Разделяем подкатегории
            
            # Используем первую подкатегорию или пустую строку
            subcategory = subcategories[0] if subcategories else ""
            
            # Выполняем SQL-запрос
            cursor.execute(insert_query, (
                client, device, time_ch, ch_id, epg_name,
                time_epg, time_to_epg, duration, category, subcategory
            ))

    print("Данные успешно добавлены в базу данных.")

except Exception as e:
    print(f"Ошибка при работе с базой данных: {e}")

finally:
    # Закрываем соединение
    if cursor:
        cursor.close()
    if connection:
        connection.close()
