import os

# Получить список файлов и директорий в каталоге /root
files = os.listdir("/root")

# Перенаправить вывод в файл /tmp/123.txt
with open("/tmp/123.txt", "w") as f:
    # Вывести содержимое каталога /tmp в файл
    for file in files:
        f.write(file + "\n")
