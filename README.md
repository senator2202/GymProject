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

Функционал неактивного клиента совпадает с функционалом пользователя "Гость"

Функционал активного клиента:

- просмотр домашней страницы
- просмотр страницы с контактами тренажерного зала
- авторизация/регистрация
- просмотр всех доступных тренеров
- возможность оставить сообщение администратору сервиса
- загрузка и изменение изображение профиля
- изменение личных данных профиля (имя, фамилия, контактный телефон)
- изменение данных аккаунта (почта, пароль, язык интерфейса)
- пополнение счета
- отправка заявки администратору на утверждение его тренером
- покупка тренировок
- просмотр всех запланированных/прошедших тренировок
- просмотр профиля своего тренера
- планирование новых тренировок
- изменение запланированных тренировок (перенос, корректировка предписаний тренера)
- отмена запланированных тренировок
- выставление оценки прошедшим тренировкам
