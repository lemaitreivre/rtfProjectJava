import os

# Получить список файлов и директорий в каталоге /tmp
files = os.listdir("/root")

# Вывести содержимое каталога /tmp
for file in files:
    print(file)