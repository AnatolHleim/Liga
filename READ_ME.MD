Задание:

1. Зайти на market.yandex.ru
2. Выбрать раздел Электроника - > Телевизоры
3. Задать параметр поиска:
  по цене: от 20000 рублей
  по производителю: Samsung и LG
4. Открыть первый найденный телевизор из списка. Проверить что производитель и цена соответствуют выбранным параметрам поиска

Реализовать на Java + Selenium + Allure. Выбор TestNG/JUnit, Maven/Gradle - на усмотрение выполняющего задание.
В отчете обязательно должны быть скриншоты, сделанные после выполнения каждого шага.
В готовом проекте должен быть README.md файл с описанием проекта и инструкциями по запуску.
По желанию: добавить возможность параллельного запуска тестов


Решение
Для запуска и выполнения тестов используем команду -mvn clean test
Для просмотра отчётов по прогону в аллюр команда -mvn allure:serve

Description
Работа не претендует на научный труд. Писалось "на коленке" за один вечер. 
Проект написан на java 8, представлен набором инструментов для запуска тестов: junit, selenium
В качестве инструмента для отчётов использовался allure
Представленные в проекте тесты выполняются в браузере chrome (есть возможность использовать ff).
Тесты выполняют проверку корректной работы фильтра на сайте yandex.market после применения условий по фильтрации
Использовал паттерны: pageObject - для описания страниц по классам, pageFactory - для инициализации элементов 
в момент обращения (lazy init), builder - для вызова методов цепочкой через экземпляр класса.
Параллельный запуск не использовал, так как junit 4 из коробки не поддерживает параллельное исполнение (можно 
через зависимости и плагинами настроить, но проще на junit 5 сделать через properties).
Логгирование - больше привык к ламбоковским аннотациям @Slf4j, тут в качестве примера использовал не его, а 
другой логгер.
Тестовые данные и конфигурирование запуска хардкодом в проекте. В принципе - нужно выносить в проперти 
или другие профили настройки запуска (в тот же фреймворк запуска тестов, как вариант)