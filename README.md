# TestTask
Тестовое задание

При написании программы основной упор был сделан на концепции "clear code", "OOP" и "SOLID". 
Для упрощения создания сложного объекта "User" был использован шаблон проектирования "Builder". 
При проектировании была выбрана 3-х уровневая архитектура.

С данными, находящимися в файле, работает уровень DAO, обеспечивая возможность добавления, сохранения и удаления пользователей.

Доменная модель представлена двумя классами "User" и "ReferenceBook". 
Класс "User" служит для хранения и первичной обработки данных об отдельном пользователе. 
Класс "ReferenceBook" содержит в себе коллекцию пользователей и методы для работы с ней. 
Для работы с данными в программе существует 2 сервиса "UserService" и "UiService", а так же несколько классов обеспечивающих валидацию вводимых данных. 
"UserService" служит для обработки класса "User", и выполняет такие функции как: добавление, удаление, создание пользователя, а так же вызов функций из DAO слоя для записи в файл. 
"UiService" служит для получения данных из консоли, валидации, и последующей их передачи в функции класса "UserService". 

Слой ui представлен классами "StartMenu" и "UserCreateMenu", которые отвечают за вывод изначального меню и за получения информации о классе "User" соответственно. 

При проектировании программы была предусмотрена возможность расширения уже написанного кода, например: изменение способа хранения данных, расширение класса "User", добавление новых валидаторов, вариантов ввода, новых функций работы с данными. 

При выполнении задачи, в соответствии с требованиями, была использована Java без сторонних библиотек и фреймворков. Только Java Core (версия джавы 8+). 
