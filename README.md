## Сервис по организации персональных тренировок в тренажерном зале

**Автор - Алексей Харитонов**

------

**Общая информация**

Веб приложение предоставляет возможность клиенту заказать и назначить тренировку у любого из доступных тренеров, предварительно купив ее купив. После бронирования тренировки клиентом, тренер делает назначение клиенту (упражнения, снаряды). Клиент может отказаться и/или заменить часть назначений. По окончании тренировок клиент может выставлять оценки своим тренировкам. Клиентам тренажерного зала, на усмотрение администратора, могут назначаться скидки.

------

**Пользователи**

Для разграничения функциональных возможностей пользователей сервиса, были введены следующие роли:

**Гость (неавторизованный пользователь)**

Функционал:

- просмотр домашней страницы
- просмотр страницы с контактами тренажерного зала
- авторизация/регистрация
- просмотр всех доступных тренеров
- возможность оставить сообщение администратору сервиса

**Клиент** 

У клиента есть два статуса: активный/неактивный. Сразу после регистрации, пользователь получает статус неактивного клиента и становится активным после перехода по ссылке, отправленной на почту, указанную им при регистрации.

Функционал неактивного клиента совпадает с функционалом пользователя "Гость".

Функционал активного клиента:

- просмотр домашней страницы
- просмотр страницы с контактами тренажерного зала
- авторизация/регистрация
- выход из аккаунта
- просмотр всех доступных тренеров
- возможность оставить сообщение администратору сервиса
- загрузка и изменение изображение профиля
- изменение личных данных профиля (имя, фамилия, контактный телефон)
- изменение данных аккаунта (почта, пароль, язык интерфейса)
- просмотр баланса счета и его пополнение
- отправка заявки администратору на утверждение его тренером
- покупка тренировок
- постраничный просмотр всех запланированных/прошедших тренировок
- сортировка тренировок по всем доступным параметрам
- поиск по таблицам с тренировками
- просмотр профиля своего тренера
- планирование новых тренировок
- изменение запланированных тренировок (перенос, корректировка предписаний тренера)
- отмена запланированных тренировок
- выставление оценки прошедшим тренировкам

**Тренер** 

Функционал тренера в рамках приложения во многом совпадает  функционалом клиента, но имеет свои особенности.

Функционал тренера со статусом "неактивный" совпадает с функционалом пользователя "Гость".

Функционал тренера со статусом "активный":

- просмотр домашней страницы
- просмотр страницы с контактами тренажерного зала
- авторизация/регистрация
- выход из аккаунта
- просмотр всех доступных тренеров
- возможность оставить сообщение администратору сервиса
- загрузка и изменение изображение профиля
- изменение описания своего профиля
- изменение личных данных профиля (имя, фамилия, контактный телефон, ссылка на инстаграм)
- изменение данных аккаунта (почта, пароль, язык интерфейса)
- постраничный просмотр всех заказанных/проведенных тренировок
- сортировка тренировок по всем доступным параметрам
- поиск по таблицам с тренировками
- просмотр профиля своих клиентов
- составление тренировочной программы своим клиентам
- проведение тренировок (изменение статуса)
- отмена заказанных тренировок
- просмотр оценок каждой из проведенных тренировок

**Администратор**

Функционал:

- постраничный просмотр всех заявок на тренерство (сортировка, поиск по таблице, просмотр профилей пользователей)
- утверждение/отказ в заявке на тренерство
- постраничный просмотр всех регистраций за конкретный период (сортировка, поиск по таблице, просмотр профилей пользователей)
- блокировка/разблокировка пользователей
- постраничный просмотр всех сообщений, оставленных пользователями
- отправка ответных сообщений пользователям, на их реальные email адреса
- смена языка интерфейса
- выход из аккаунта

