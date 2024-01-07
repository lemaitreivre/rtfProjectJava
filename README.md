1. Для начала смотрим запись в тимсе с вашим решением моего варианта,чтобы получить примерное понимание работы с sqllite и в целом со структурой проекта :)
2. Берем нужную нам csv-таблицу и помещаем ее в наш проект, который уже заранее создан(на основе maven):
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/6859b759-9a81-4f16-8d63-8a79fbb57452)
3. Создаем класс Country.java, который будет хранить все наши данные(13 штук):
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/c4a2d691-6ab1-4f7d-a81b-ff27a051efa4)
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/2515440a-5494-4753-b30f-0595ae8fe82d)
4. Далее парсим csv файл в классе Parser.java, доставая из него все необходимое(используем библиотеку opencsv,которая вписана в pom.xml):<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/181c9e1e-78d2-43c9-866c-3bbebb6f50f3)<br>
5. В виду того, что у меня нет таких же расширений, которые демонстрировали Вы, я ручками вписал все таблицы и столбцы в нашу бд через класс Database.java:<br>
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/fcc569bf-05d3-4e4b-aab3-103fd2d8d970)
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/ba16e8f4-3135-4bdd-8522-1540177c7690)
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/d6d59a68-9c43-4c89-a730-c07c0386b0a9)
6. Чтобы проверить все ли работает выведем в консоль получившуюся бд:
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/83f6d747-86d7-421d-b9c2-f4db1a25ac79)
   ![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/ba1b273c-98d7-47cf-b8f7-298a7a0791e7)
Так как csv нормально распарсилось и все данные записались в бд, можно выполнить запросы к базе и построить нужный график:
<b>Задание №1</b><br>
Обратимся к бд, выводя парами страну и ее экономику,<br> сортируя это все по экономике, а затем вызовем этот метод в классе Main.java:
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/d46f0b60-74cb-4ae1-979c-c774f6432f65)
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/1f5be407-dbdf-4728-8696-49ef0b40b7f8)<br>
В проекте появляется нужная нам картинка с графиком:<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/900c53ca-d52d-41eb-8394-3370dcd3fddb)
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/8f994ee3-93a0-418f-b170-1a361931c756)
<b>Задание №2</b><br>
Вновь обратимся к бд, а именно к нужным нам регионам, и найдем страну с лучшей экономикой:
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/18fde0fd-2b0f-48da-8bdc-07bc68fbc887)<br>
Затем выведем в консоль ответ:<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/05eff936-d685-4ece-adfe-7c711a892ec1)
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/d440ddc1-3faa-4e1f-a123-38601f7b43b5)<br>
<b>Задание №3</b><br>
В данном задании я взял все аттрибуты, которые не являются идентификаторами,<br> сложил между собой и нашел что-то вроде среднего значения, которое можно сравнить с другими странами
<br>и найти самую "среднюю" страну среди стран в регионе "Western Europe" и "North America":<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/9042701b-4d83-4db6-8916-8606264aa201)<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/e77b4d07-5ef0-464a-ba5a-267dce2fdb91)<br>
Получился ответ:<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/d0fe7198-da8f-4aca-88d6-d21009d79672)<br>
После завершения работы программы мы видим ответы:<br>
![image](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/fafd3418-35e4-41e6-98c7-2a88ab175f87)<br>
![number1](https://github.com/lemaitreivre/rtfProjectJava/assets/98763514/240ebb18-3234-4d61-9fa1-30b5dce4e813)
















   








