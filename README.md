#Анализ задания

Система, проектируемая в ходе выполнения курсового проекта, является системой автоматизации работы банка, а именно, процессов, связанных с кредитованием: процесс получения кредита и процесс генерации специального предложения для клиентов банка.    

##Роли
 
 **Клиент.**     
1. Клиент подает заявку на получение кредита.   
2. При получении положительного ответа, клиент может согласиться на сделку, если его устраивают предложенные условия (кредитный план) или отказаться.    
3. Клиенты получают специальные предложения кредитования от банка.   
4. Если клиента устраивает специальное предложение, он может согласиться и заключить договор, иначе проигнорировать.  
 
 **Финансист.**     
1. Финансист на основе данных о клиенте  принимает решение об одобрении или отказе заявления клиента.    
2. При одобрении финансист выбирает кредитный план для клиента.    
3. Финансист генерирует специальные предложения кредитования.      
  
 **Менеджер**.    
1. Менеджер принимает заявки от клиента.   
2. Менеджер отправляет клиентам решения финансиста.   
3. Менеджер заключает договоры.   
4. Менеджер отправляет клиентам специальные предложения. 
5. Менеджер отправляет финансистам заявки от клиентов. 

##Разработка вариантов использования
[Use Case diagram] (https://github.com/Nikitina-Ann/design/blob/master/UseCase.PNG)

##Подробное описание вариантов использования 
###Процесс получения кредита
1. Клиент подает заявку на получение кредита.
2. Менеджер принимает заявку.
3. Финансист анализирует данные о клиенте: рейтинг, доходы.
4. Финансист одобряет получение кредита, предлагая определенный кредитный план.
5. Менеджер оглашает решение финансиста клиенту.
6. Клиент соглашается на предложенный кредитный план и заключает с менеджером договор на получение кредита.    

**Альтернатива:** Отказ финансиста      
4. На шаге 4 финансист отказывает клиенту в получении кредита.   
5. Менеджер оглашает решение финансиста клиенту.     
6. Отказ от сделки.      

**Альтернатива:** Отказ клиента   
6. На шаге 6 со стороны клиента поступает отказ от предложенных финансистом условий кредита (кредитного плана). Отказ от сделки.   

###Процесс генерации специального предложения   
1. Финансист генерирует специальное предложение.   
2. Менеджер отправляет специальное предложение клиенту.
3. Клиент получает специальное предложение.   
4. Клиент принимает предложение и  заключает договор с менеджером.

**Альтернатива:** Игнорирование     
5. Клиент игнорирует специальное предложение, процесс завершается.

##Модель предметной области
[Модель предметной области] (https://github.com/Nikitina-Ann/design/blob/master/ClassDiagr.png)

#Реализация задания с помощью технологии «EJB
##Объектно-ориентированное проектирование
###Диаграмма классов
[Диаграмма классов] (https://github.com/Nikitina-Ann/design/blob/master/ClassDiagr.png)
###Описание классов-бизнес-логики
В качестве архитектурного шаблона был выбран шаблон "Модель предметной области". В связи с этим, были выделены сущности предметной области и для каждой из сущностей было решено создать отдельный класс, описывающий данную сущность.    
Реализация слоя бизнесс-логики

Для классов слоя бизнес-логики был создан отдельный пакет (appBank.entity).
Пакет содержит следующие классы    
* Bid - класс, описывающий на заявку получение кредита. Переменные классы:
```
id:Int
date: Date - дата подачи заявки 
responseClient: Bool - ответ клиента
sum :Int - сумма
client: Client - клиент
manager: Manager - менеджер
Financier: financier - финансист
```
Методы класса - конструкторы и методы получения и установки переменных класса.     
* Client - класс, описывающий клиента. Переменные классы:
```
id: Int
name: String - имя клиента
revenue: Int - доход
rating: Int - рейтинг
clientOffers: Set<ClientOffer> - набор сущностей clientOffers
bids: Set<Bid> - набор заявок
```
Методы класса - конструкторы и методы получения и установки переменных класса.      
* Manager- класс, описывающий менеджера. Переменные классы:
```
id: Int
name: String - имя менеджера
bids: Set<Bid> - набор заявок менеджера
```
Методы класса - конструкторы и методы получения и установки переменных класса.    
* Financier- класс, описывающий финансистаю Переменные классы:
```
id: Int
name: String - имя финансиста
responseFinancier: Set<ResponseFinancier> - набор всех ответов финансиста
specialoffers: Set<Specialoffer> -набор специальных предложений, сгенерированных финансистом
bids: Set<Bid> - набор заявок
```
Методы класса - конструкторы и методы получения и установки переменных класса.       
* SpecialOffer - класс, описывающий специальное предложение. Переменные классы:
```
id: Int
sum: Int - сумма
percent: Int - процент
time: Int - время
financier: Financier - финансист
clientOffer: Set<ClientOffer> - набор сущностей clientOffer
```
Методы класса - конструкторы и методы получения и установки переменных класса.      
* ResponceFinancier - класс, описывающий ответ финансиста. Переменные классы:
```
id:Int
answer: Bool - ответ финансиста
percent: int - процент
time: Int - время
bid: Bid - заявка
financier: Financier - финансист
```
Методы класса - конструкторы и методы получения и установки переменных класса.     
* Agreement - класс, описывающий договор. Переменные классы:
```
id: Int
extinguished: Bool - погашен
residualAmount: Int - остаток суммы
bid: Bid - заявка
clientOffer: ClientOffer - специальное предложение
```
Методы класса - конструкторы и методы получения и установки переменных класса.    
* ClientOfer - класс, связывающий клиентов и специальные преложения.  Переменные классы:
```
id: Int
client: Client - клиент
specialOffer: SpecialOffer - специальное предложение
agreement: Agreement - договор
responsClient: Boolean - ответ клиента
```
Методы класса - конструкторы и методы получения и установки переменных класса.    

###Диаграмма последовательностей   
[Получение кредита] (https://github.com/Nikitina-Ann/design/blob/master/SeqDiagr2.png)   
[Специальное предложение] (https://github.com/Nikitina-Ann/design/blob/master/SeqDiagr3.png)   

##Описание программы
###Слой бизнес-логики
В качестве архитектурного шаблона был выбран шаблон "Модель предметной области". В связи с этим, были выделены сущности предметной области и для каждой из сущностей было решено создать отдельный класс, описывающий данную сущность. Описание классов-бизнес-логики было приведено выше.      
Для доступа к переменным и методам классов бизнес-логики  были созданы сеансовые компоненты, по одному на каждую роль: клиент, финансист, менеджер. (ClientSessionBean, FinancierSessionBean, ManagerSessionBean). Каждый сеансовый компонент наследуется от интерфейсов соответственно (ClientSessionBeanLocal, FinancierSessionBeanLocal, ManagerSessionBeanLocal), которые необходимы для локального вызова методов. Интерфейсы имеют аннотацию Local, что говорит о локальном вызове методов. Пример бина  и его интерфейса приведен ниже.    
```
public class ClientSessionBean implements ClientSessionBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    ...
    
@Local
public interface ClientSessionBeanLocal {
    Clients getClientById(int id);
    ...
```
###Слой хранения данных
В качестве СУБД была выбрана MySQL. Для того, чтобы обеспечить хранение необходимо к каждой сущности добавить аннотацию Entity. Также, например, с помощью аннотации Id укажем, что некоторое поле будет являться первичным ключом. Аннотация GeneratedValue указывает на то, что данное поле будет генерироваться автоматически при создании нового экземпляра данного класса. Аннотации связи сущностей: OneToOne - связь один-к-одному, ManyToOne - связь много-к-одному.      
```
@Entity
@Table(name = "specialoffers")
@XmlRootElement
public class Specialoffers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sum")
    private Integer sum;
    @Column(name = "persent")
    private Integer persent;
    @Column(name = "time")
    private Integer time;
    @ManyToOne
    @JoinColumn(name = "financier_id")
    private Financiers financier;
   
    @OneToMany(mappedBy = "specialoffer")
    private Set<ClientOffer> clientOffer = new HashSet<ClientOffer>();
```
###Слой представления
Слой представлен представлен страницами jsp.Для каждой роли реализовано по две страницы, например: client.jsp, clientAction.jsp.    
Страница client.jsp отображает web-страницу клиента. При запросе от пользователя выполнения действий, полученные данные с формы передаются на страницу clientAction.jsp. На странице clientAction.jsp выполняются заданые пользователем действия и происходит возврат на страницу client.jsp. Также для страниц manager.jsp, managerAction.jsp, financier.jsp, financierAction.jsp.
###Тестирование
**Страница клиента**
<table>
    <tr>
        <th>Вариант тестирования</th>
        <th>Ожидаемый результат</th>
        <th>Полученный результат</th>
    </tr>
    <tr>
        <td>Клик на кнопку "Новая заявка" без указания суммы заявки или при указании не числовых значений</td>
        <td>Появится сообщение об ошибке</td>
        <td>Сообщение об ошибке: "Сумма заявки должна быть представлена в виде числового значения!"</td>
    </tr>
    <tr>
        <td>Клик на кнопку "Новая заявка" с указанием числового значения в поле суммы заявки</td>
        <td>Создание новой заявки с указанным значением суммы</td>
        <td>Создание новой заявки с указанным значением суммы</td>
    </tr>
    <tr>
        <td>Выбрать какую-либо заявку с положительным ответом финансиста и не заключенным договорм и нажать кнопку "Принять"</td>
        <td>Выбранная заявка принята клиентом</td>
        <td>Выбранная заявка принята клиентом</td>
    </tr>
     <tr>
        <td>Выбрать какую-либо заявку либо с отрицательным ответом финансиста, либо с уже заключенным договорм, либо совсем не выбирать заявку и нажать кнопку "Принять"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "У выбранной заявки ответ финансиста должен быть положительный  и договор не должен быть заключен"</td>
    </tr>
       <tr>
        <td>Выбрать какую-либо заявку с положительным ответом финансиста и не заключенным договорм и нажать кнопку "Отклонить"</td>
        <td>Выбранная заявка отклонена клиентом</td>
        <td>Выбранная заявка отклонена клиентом</td>
    </tr>
     <tr>
        <td>Выбрать какую-либо заявку либо с отрицательным ответом финансиста, либо с уже заключенным договорм, либо совсем не выбирать заявку и нажать кнопку "Отклонить"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "У выбранной заявки ответ финансиста должен быть положительный  и договор не должен быть заключен"</td>
    </tr>
        <tr>
        <td> На вкладке "Специальные предложения" выбрать специальное предложение, договор на которое еще не был заключен, и нажать кнопку "Принять"</td>
        <td>Выбранное специальное предложение принято клиентом</td>
        <td>Выбранное специальное предложение принято клиентом</td>
    </tr>
     <tr>
        <td>На вкладке "Специальные предложения" выбрать специальное предложение, договор на которое уже был заключен, и нажать кнопку "Принять"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Ответ на специальное предложение не отправлен!"</td>
    </tr>  
      <tr>
        <td> На вкладке "Специальные предложения" выбрать специальное предложение, договор на которое еще не был заключен, и нажать кнопку "Отклонить"</td>
        <td>Выбранное специальное предложение отклонено клиентом</td>
        <td>Выбранное специальное предложение отклонено клиентом</td>
    </tr>
     <tr>
        <td>На вкладке "Специальные предложения" выбрать специальное предложение, договор на которое уже был заключен, и нажать кнопку "Отклонить"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Ответ на специальное предложение не отправлен!"</td>
    </tr>
       <tr>
        <td>Кликнуть на "Вернуться на страницу входа в систему"</td>
        <td>Возврат на страницу входа в систему</td>
        <td>Возврат на страницу входа в систему</td>
    </tr>
</table>

**Страница финансиста**
<table>
    <tr>
        <th>Вариант тестирования</th>
        <th>Ожидаемый результат</th>
        <th>Полученный результат</th>
    </tr>
    <tr>
        <td>Выбрать какую-либо заявку, заполнить поля: "Процент", "Время" и нажать кнопку "Одобрить"</td>
        <td>Выбранная заявка одобрена финансистом с указанным кредитным планом</td>
        <td>Выбранная заявка одобрена финансистом с указанным кредитным планом</td>
    </tr>
    <tr>
        <td>Оставить поля: "Процент", "Время" незаполненными или не выбирать заявку и нажать кнопку "Одобрить"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Не все параметры были выбраны!"</td>
    </tr>
    <tr>
        <td>Выбрать какую-либо заявку и нажать кнопку "Отклонить"</td>
        <td>Выбранная заявка отклонена финансистом</td>
        <td>Выбранная заявка отклонена финансистом</td>
    </tr>
    <tr>
        <td>Не выбирать заявку и нажать кнопку "Отклонить"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Не все параметры были выбраны!"</td>
    </tr>
    
     <tr>
        <td>Заполнить поля: "Сумма", "Процент", "Время" и нажать кнопку "Создать"</td>
        <td>Создастся новое специальное предложение с указанным кредитным планом</td>
        <td>Создастся новое специальное предложение с указанным кредитным планом</td>
    </tr>
    <tr>
        <td>Оставить какое-либо из поле: "Сумма", "Процент", "Время" незаполненным и нажать кнопку "Создать"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Не все параметры были выбраны!"</td>
    </tr>
       <tr>
        <td>Кликнуть на "Вернуться на страницу входа в систему"</td>
        <td>Возврат на страницу входа в систему</td>
        <td>Возврат на страницу входа в систему</td>
    </tr>
</table>


**Страница менеджера**
<table>
    <tr>
        <th>Вариант тестирования</th>
        <th>Ожидаемый результат</th>
        <th>Полученный результат</th>
    </tr>
    <tr>
        <td>Выбрать в выпадающем списке финансиста и выбрать в таблице заявку, которая еще не была отправлена финансисту, нажать кнопку "Отправить финансисту"</td>
        <td>Выбранная завка отправится выбранному финансисту</td>
        <td>Выбранная завка отправится выбранному финансисту</td>
    </tr>
    <tr>
        <td>Выбрать в выпадающем списке финансиста и выбрать в таблице заявку, которая уже была отправлена финансисту, нажать кнопку "Отправить финансисту"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Сообщение об ошибке: "Заявка финансисту не была отправлена!"</td>
    </tr>
        <tr>
        <td>Выбрать в таблице заявку, на которую был дан положительный ответ и со стороны клиента, и со стороны финансиста, нажать кнопку "Заключить договор"</td>
        <td>Заключится договор по выбранной заявке</td>
        <td>Заключится договор по выбранной заявке</td>
    </tr>
    <tr>
        <td>Выбрать в таблице заявку, на которую был дан отрицательный ответ либо со стороны клиента, либо со стороны финансиста, или на которую уже заключен договор, нажать кнопку "Заключить договор"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Сообщение об ошибке: "Договор не был заключен!"</td>
    </tr>
    
    <tr>
        <td>На вкладке "Специальные предложения" выбрать клиента, выбрать из таблицы специальное предложение и нажать кнопку "Отправить клиенту"</td>
        <td>Специальное предложение отправиться клиенту</td>
        <td>Специальное предложение отправиться клиенту</td>
    </tr>
    
    <tr>
        <td>На вкладке "Специальные предложения" выбрать клиента, выбрать из таблицы специальное предложение, которое уже было отправлено данному клиенту, либо не выбирать специальное предложение и нажать кнопку "Отправить клиенту"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Специальное предложение клиенту не было отправлено!"</td>
    </tr>
    <tr>
     <td>На вкладке "Принятые специальные предложения" выбрать из таблицы специальное предложение, на которое дан положительный ответ со стороны клиента и договор еще не заключен и нажать кнопку "Заключить договор"</td>
        <td>Будет заключен договор на выбранное специальное предложение</td>
        <td>Будет заключен договор на выбранное специальное предложение</td>
    </tr>
    
    <tr>
     <td>На вкладке "Принятые специальные предложения" выбрать из таблицы специальное предложение, на которое не дан положительный ответ со стороны клиента или договор уже заключен, и нажать кнопку "Заключить договор"</td>
        <td>Появится сообщение об ошибке</td>
        <td>Появится сообщение об ошибке: "Специальное предложение клиенту не было отправлено!"</td>
    </tr>
    
       <tr>
        <td>Кликнуть на "Вернуться на страницу входа в систему"</td>
        <td>Возврат на страницу входа в систему</td>
        <td>Возврат на страницу входа в систему</td>
    </tr>
</table>

##Инструкция пользователя
Первоначально загружается страница входа в систему. На странице необходимо указать id и нажать на кнопку со своей ролью: клиент, менеджер, финансист. После система загрузит страницу для выбранной роли и указанного id.
###Страница клиента
Чтобы создать новую заявку клиенту необходимо указать сумму заявку (в числовом формате) и нажать кнопку "Новая заявка". При корректных данных система создаст заявку, иначе выводиться сообщение об ошибке.     
Чтобы ответить на заявку, необходимо выбрать ее в таблице заявок и нажать на одну из двух кнопок "Принять", "Отклонить". Система проверяет входные данные на корректность (заявка должна быть выбрана и ответ на нее со стороны финансиста должен быть положительным), при корректных данных ответ клиента будет установлен, иначе выводится сообщение об ошибке.      
Чтобы ответить на специальное предложение, необходимо выбрать его в таблице и нажать на одну из двух кнопок "Принять", "Отклонить". Система проверяет входные данные на корректность (ответ клиента на выбранное специальное предложение не должен быть установлен), при корректных данных ответ клиента будет установлен, иначе выводится сообщение об ошибке.   
Чтобы вернуться на страницу входа в систему, необходимо нажать на "Вернуться к странице входа в систему".    

###Страница финансист
Чтобы финансисту ответить на заявку, необходимо в таблице выбрать заявку, заполнить поля: "Процент", "Время"и нажать на одну из двух кнопок "Одобрить", "Отклонить". Система проверяет входные данные на корректность (все поля были установлены и ответ финансиста на выбранную заявку еще не установлен), при корректных данных ответ клиента будет установлен, иначе выводится сообщение об ошибке.    
Чтобы создать специальное предложения, необходимо перейти на вкладку "Специальные предложения", заполнить поля: "Сумма", "Процент", "Время" и нажать на кнопку "Создать". При корректном заполнении все полей (числовые значения) система создаст новое специальное предложение, иначе выводится сообщение об ошибке.    
Чтобы вернуться на страницу входа в систему, необходимо нажать на "Вернуться к странице входа в систему".    

###Страница менеджера
Чтобы менеджеру отправить заявку финансисту, необходимо в таблице выбрать заявку, в выпадающем списке выбрать финансиста и нажать кнопку "Отправить финансисту". При корректных входных данных (все поля были выбраны и заявка еще не была отправлена финансисту) система отправит заявку финансисту, иначе выводится сообщение об ошибке.     
Чтобы менеджеру заключить договор по заявке, необходимо выбрать в талице заявку и нажать кнопку "Заключить договор". При корректных данных (все поля были выбраны, ответы финансиста  и клиента по заявке положительны и договор еще не заключен) система заключает договор по выбранной заявке иначе отправляется сообщение об ошибке.    
Чтобы менеджеру отправить специальное предложение клиенту, необходимо на вкладке "Специальные предложения" таблице выбрать специальное предложение, в выпадающем списке выбрать клиента и нажать кнопку "Отправить клиенту". При корректных входных данных (все поля были выбраны и данное специальное предложение еще не было отправлено клиенту) система отправит специальное предложение клиенту, иначе выводится сообщение об ошибке.       
Чтобы менеджеру заключить договор по специальному предложению, необходимо выбрать в талице специальное предложение и нажать кнопку "Заключить договор". При корректных данных (все поля были выбраны, ответ клиента по специальному предложению положительный и договор еще не заключен) система заключает договор, иначе отправляется сообщение об ошибке.       
Чтобы вернуться на страницу входа в систему, необходимо нажать на "Вернуться к странице входа в систему".    
##Инструкция системного администратора
