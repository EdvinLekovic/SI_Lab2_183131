# Втора лабораториска вежба по Софтверско инженерство

## Едвин Лековиќ, бр. на индекс 183131

### Група на код:
Ја добив групата на код 1

### Control Flow Graph

![alt text](https://github.com/EdvinLekovic/SI_Lab2_183131/blob/master/Control%20Flow%20Diagram%20Group%201.png)


### Цикломатска комплексност 
Цикломатската комплексност на овој код е 5 поради тоа што овој код има 5 региона или тоа можеме да го пресметаме преку формулата E-V+2 Каде Е ни преставува бројот на ребра а V бројот на темиња каде во овој случај имаме V=12 и Е=15 доколку ги замениме добиваме 15-12+2=5 

### Тест случаи според критериумот Multiple Conditions

----Multiple Condition 1 ----
Првиот Multiple Conditional ни е (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))
Во овој код ги имаме следните можни комбинации кој можат да настанат за дадениот код:

1. FXX -> user.getUsername() = null ; X (небитно) ; Х (небитно) ;

2. TFX -> user.getUsername() = "Edvin" ; user.getEmail() = null ; X (небитно) ;

3.TTF -> user.getUsername() = "Edvin" ; user.getEmail() = "edvin.lekovikj@students.finki.ukim.mk" ; allUsers.contains(user.getUsername()) = true 

4.TTT -> user.getUsername() = "Edvin" ; user.getEmail() = "edvin.lekovikj@students.finki.ukim.mk" ; allUsers.contains(user.getUsername()) = false 

----Multiple Condition 2 ----
Вториот Multiple Condition ни е (atChar && dotChar)
И за овој multiple condition ги имаме следните комбинации кој можат да настанат за овој услов:

1. FX -> atChar = false ; X (Небитно)

2.TF -> atChar = true ; dotChar = false

3.ТТ -> atChar = true ; dotChar = true

### Тест случаи според критериумот Every Branch 

Со Еvery Branch критериумот треба да ги поминеме сите можни ребра (15 ребра) кој се наоѓаат во дадениот код.

Следуваат сите тест случај кој ќе ги покријат сите ребра

1. User(userName = "Edvin" , email = "edvin.lekovikj@students.finki.ukim.mk" ,password = било што) и allUsers(EmptyList или листа кој не го содржи името "Edvin")
Првиот тест случај ги покрива следниве ребра: A-B , B-C1 , C1-C2 , C2-D , D-E , E-F , F-G , G-C3 , C3-C2 , C2-I , I-J

2. User = null и allUsers (било што) 
Ја опфаќа само гранката A-K

3. User(username=null,password =било што , email= било што) и allUsers (било што)
Ги опфаќа гранките A-B , B-K

4.User(username="Edvin",password=било што,email="edvinlekovikj") и allUsers (празна листа или со елементи без username "Edvin")
Ги опфаќа гранките A-B , B-C1 , C1-C2 , C2-D , D-F , F-C3 , C2-I , I-K

### Oбјаснување на напишаните unit tests

----Multiple Condition----
За multiple condition во нашиот код имаме 2 multiple conditions од кој едниот е 
(user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))

1. ( F && X && X ) -> во овој случај кога првиот израз од вкупно три ни е грешен тогаш тука завршува програмата и поради тоа за останатите два изразистои X поради тоа што е небитно каков израз ќе се добие понатаму секако целиот услов ќе биде не точен.Кодот кој го задоволува овој услов е assertFalse(siLab2.function(new User(null,null,null),null)); мораме да имаме иницијализација за класата поради причината што тој мора да отиде од јазол А во B и од B се разгранува до јазолот К

2. (T && F && X) -> Кога првиот израз е точен , а вториот грешен тогаш третиот не е битен. Moжеме да го погледнеме дадениот аssert
assertFalse(siLab2.function(new User("Edvin",null,null),null)); Кај Userot првата аргумент е за username , вториот е за password и третиот е за мејл а аргументот после User е листа allUsers која не е битно што содржи или е null поради што до тој дел програмата нема да стигне и поради таа причина е означена со Х . Откако ќе види дека првиот израз е точен вториот е неточен и ќе скокне програмата до соодветното место односно ќе се разграни од B до К. 

3. (T && T && F) -> Првите два изрази се точни а третиот не е точен , поради тоа што !true ќе стане false и целиот израз ќе биде false
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@students.finki.ukim.mk"), Arrays.asList("Edvin","Sarko","Marko")));
Првиот аргумент за класата User ни е валиден , password-от не ни е биден и имаме валиден мејл додека во листата се појавува истото име како и во објектот од класата User поради тоа целиот израз ни е повторно false. Повторно како и во претходните примери ова разгранување ќе ни биде B-K

4. (T && T && T) -> Тука сите изрази ни се точни со што кодот ќе навлезе во овој if 
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
Како аргументи на објектот од класата User сите се валидни и праќаме празна листа која исто така е валидна. Овде разгранувањето ќе ни биде B-C1


Другиот multiple condition ни е изразот atChar && dotChar
Во овој condition имаме 3 комбинации кој можат да се случат со овој израз

1.(F && X) првата комбинација е кога првиот израз atChar ја има вредноста false со тоа другиот израз нема потреба да го проверуваме будејки целиот услов ќе биде false и поради таа причина за вториот израз ставаме Х.
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
Гледаме дека во кодот мора сите аргументи мора да ни бидат соодветно иницијализирани за објектот User но е-маилот треба да биде без точка и без @  и треба дадената листа да биде или празна или да не го сочинува username-от што се наоѓа во објектот User. 

2.(T && F) во овој израз може да погледнеме дека првиот израз atChar ни е true но вториот израз dotChar ни е false поради таа причина целиот израз повторно ни е false.
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@gmailcom"),Collections.emptyList()));
Во овој израз како и во претходниот треба сите аргументи од класата User да ни бидат иницијализирани но за е-маилот треба да имаме @ но да немаме точка и исто како и за претходниот случај е правилото за листата дека треба да биде или празна или да биде наполнета но да не го сочинува името што се наоѓа во објектот User

3.(T && Т) во овој услов и двата израза ни се вистинити со што целиот услов е вистинит со тоа би можеле да навлеземе во дадениот if
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Sarko","Darko","Marko")));
Сите аргументи се валидно пратени во User објектот со тоа што во овој случај во е-маилот имаме и точка и @ а за листата важи истото правило.

----Every Branch----

1.  assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
Со оваа иницијализација на финкцијата  каде што гледаме да ги опфатиме на почеток што повеќе гранки и потоа да ги опфатиме сите можни гранки од кој е составен самиот код .Гранките кој се опфаќаат се следниве: A-B , B-C1 , C1-C2 , C2-D , D-E , E-F , F-G , G-C3 , C3-C2 , C2-I , I-J

2.  assertFalse(siLab2.function(null,null));
Со овие аргументи кој се праќаат на самата функција сакаме да ја опфатиме гранката А-К а доколку ја опфатиме оваа гранка другите гранки не е можно да се опфатат и поради таа причина во овој тест пример ова е единствената гранка која се опфаќа во овој случај

3.  assertFalse(siLab2.function(new User("Edvin","superSum123",null),Collections.emptyList()));
Со следниве аргументи треба јазолот B да направи разгранување до К а еднинствениот начин е да не биде задоволен условот кој го преставува јазолот B поради тоа еден од параматрите за username или email треба да биде null или пак да го имаме името и тоа да се содржи во листата allUsers која ја праќаме како аргумент.Овде разгранувањата кој ги прави ова тестирање се А-B и B-K

4. assertFalse(siLab2.function(new User("Edvin","SuperSUm123","edvinlekovikj"),Arrays.asList("Darko","Vlatko","Ratko")));
Со ова тестирање ги опфаќаме сите останати јазли кој претходно не беа опфатени со тоа што како аргумент на објектот му праќаме невалидна адреса. Сите јазли кој се опфатени во ова тестирање се A-B , B-C1 , C1-C2 , C2-D , D-F , F-C3 , C2-I , I-K.

Со овие 4 тест случаја ги опфатив сите гранки односно разгранувања во кодот што е даден. 
