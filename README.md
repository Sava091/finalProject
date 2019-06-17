# FoodTracking
Система Похудения/Трекинга Пищи. Клиент выбирает еду (название,
кол. белки, жиры, углеволы), которую съел (из уже готового списка) и пишет
Количество. Клиент может добавить свой тип Еды (название, калории, кол.
белки, жиры, углеволы). Если Клиент привысил дневную норму, система
сообщит ему об этом и напишет, на сколько была превышена Норма. Норму
брать из параметров Клиент (возраст, рост, вес, образ жизни и т.д.).



## To install:

1) In **Tomcat** go to: *tomcat_home/conf/server.xml*
and set *URIEncoding=”UTF-8″* for *Connector* tagS.

like:

```xml
<Connector
URIEncoding="UTF-8"
port="8080"
redirectPort="8443"
connectionTimeout="20000"
protocol="HTTP/1.1"/>
```

2) in MySQL Create user with name: 'root' and pass: 'root'
```sql
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY 'root';
```
**Or**

Change username and pass in `dbcp.properties` to yours
 *(Your user should have all privileges. In this case program will work fine)*.

3) Run *script.sql* which is located in *resources* of this project.
```sql
mysql -u root -p < script.sql
```
4) Go to root directory of this project and run command `mvn package` to build war file

5) After step 4 maven will create *target* directory with war file inside: *repair-shop.war*. You need to move this file to *tomcat_home/webapps*


## To launch:

1) Navigate to tomcat_home/bin. and run command `./startup.sh`

2) After launch of tomcat you can access home page by path

*http://localhost:8080/site/home_page*

*(if tomcat is launched on port 8080 of course (if it's not, change port in url to what you need))*
