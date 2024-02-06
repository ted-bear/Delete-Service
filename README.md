# Реализация второй части тестового задания

## В данном проекте был создан API с использованием так технологий как:
1. Java 17
2. Spring boot v3.2.2
3. Spring Data Jpa
4. Lombok
5. PostgreSQL
6. Maven

## Структура проекта является классической реализацией MVC
1. Controller отвечает за обработку запросов: BatchController, CarController, DocumentController, UserController
2. Service - промежуточный слой между контроллером и базой данных, в котором может храниться бизнес логика
3. Repository - слой доступа к данным

### !Прежде чем тестировать приложение необходимо указать путь до источника данных в application.yaml файле

## Для тестирования API было создано нескольких сущностей
1. User содержит поля id, Username, Registration Date
2. Car содержит поля id, Brand, Start Exploitation Date
3. Document содержит поля id, number, issuance date

## Для заполнения таблицы тестовыми данными используются следующие endpoint
1. localhost:8080/batch/update/users - добавляет 4 миллиона тестовых сущностей пользователей
2. localhost:8080/batch/update/cars - добавляет 4 миллиона тестовых сущностей машин
3. localhost:8080/batch/update/documents - добавляет 4 миллиона тестовых сущностей документов

## Endpoint вызывается с помощью Post запроса, тело которого содержит Json вида:
```
{
    "beforeDate": "2005-03-26 00:00"
}
```

## Для удаления используются следующие endpoint
1. localhost:8080/user/delete - удаляет всех пользоваталей, у которых дата регистрации раньше, полученной в DTO DateBeforeDeleteDto
2. localhost:8080/car/delete - удаляет все машины, у которых дата начала эксплуатации раньше, полученной в DTO DateBeforeDeleteDto
3. localhost:8080/document/delete - удаляет все документы, у которых дата выдачи раньше, полученной в DTO DateBeforeDeleteDto
