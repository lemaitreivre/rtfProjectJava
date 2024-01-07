1. Для начала смотрим запись в тимсе с вашим решением моего варианта,чтобы получить примерное понимание работы с sqllite и в целом со структурой проекта :)
2. Берем нужную нам csv-таблицу и помещаем ее в наш проект, который уже заранее создан(на основе maven):
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/6859b759-9a81-4f16-8d63-8a79fbb57452)
3.Создаем класс Country.java, который будет хранить все наши данные(13 штук):
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/c4a2d691-6ab1-4f7d-a81b-ff27a051efa4)
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/2515440a-5494-4753-b30f-0595ae8fe82d)
4. Далее парсим csv файл в классе Parser.java, доставая из него все необходимое(используем библиотеку opencsv,которая вписана в pom.xml):
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/181c9e1e-78d2-43c9-866c-3bbebb6f50f3)
5. В виду того, что у меня нет таких же расширений, которые демонстрировали Вы, я ручками вписал все таблицы и столбцы в нашу бд через класс Database.java:
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/fcc569bf-05d3-4e4b-aab3-103fd2d8d970)
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/ba16e8f4-3135-4bdd-8522-1540177c7690)
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/d6d59a68-9c43-4c89-a730-c07c0386b0a9)
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/83f6d747-86d7-421d-b9c2-f4db1a25ac79)







