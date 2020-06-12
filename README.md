# Втора лабораториска вежба по Софтверско инженерство

## Едвин Лековиќ, бр. на индекс 183131

### Група на код:

Ја добив групата на код 1

### Control Flow Graph

![alt text](https://github.com/EdvinLekovic/SI_Lab2_183131/blob/master/Control%20Flow%20Diagram%20Group%201.png)


### Цикломатска комплексност 

Цикломатската комплексност на овој код е 10 поради тоа што овој код има 10 региона или тоа можеме да го пресметаме преку формулата E-V+2 Каде Е ни преставува бројот на ребра а V бројот на темиња каде во овој случај имаме V=17 и Е=25 доколку ги замениме добиваме 25-17+2=10 или преку предикатните јазли кој во овој случај се P=9 и според формулата P+1 добиваме 10 

### Тест случаи според критериумот Multiple Conditions

----Multiple Condition 1 ----

Првиот Multiple Conditional ни е (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))
Во овој код ги имаме следните можни комбинации кој можат да настанат за дадениот код:

1. FXX -> user.getUsername() = null ; X (небитно) ; Х (небитно) ;

2. TFX -> user.getUsername() = "Edvin" ; user.getEmail() = null ; X (небитно) ;

3. TTF -> user.getUsername() = "Edvin" ; user.getEmail() = "edvin.lekovikj@students.finki.ukim.mk" ; allUsers.contains(user.getUsername()) = true 

4. TTT -> user.getUsername() = "Edvin" ; user.getEmail() = "edvin.lekovikj@students.finki.ukim.mk" ; allUsers.contains(user.getUsername()) = false 

----Multiple Condition 2 ----

Вториот Multiple Condition ни е (atChar && dotChar)
И за овој multiple condition ги имаме следните комбинации кој можат да настанат за овој услов:

1. FX -> atChar = false ; X (Небитно)

2. TF -> atChar = true ; dotChar = false

3. ТТ -> atChar = true ; dotChar = true

### Тест случаи според критериумот Every Branch 

Со Еvery Branch критериумот треба да ги поминеме сите можни разгранувања или гранки (25 гранки) кој се наоѓаат во дадениот код.

Следуваат сите тест случаи кој ќе ги покријат сите разгранувања:

1. User(username="Edvin",password="можеме да ставиме било што па дури и null",email="edvin.lekovikj@students.finki.ukim.mk") и за allUsers = emptyList или полна листа која не го содржи username-от на User-от.

2. User = null и за allUsers = не е битно дали е null, празна или полна листа. 

3. User(username=null,password="не битно",email="не битно") , allUsers = небитно.

4. Users(username="Edvin",password="не битно",еmail=null) , allUsers = небитно.

5. Users(username="Edvin",password="не битно",email="edvin.lekovikj@students.finki.ukim.mk") , allUsers = полна листа која го содржи името како и на објектот User.

6. User(username="Edvin",password="не битно",email="edvinlekovikj") и за allUsers = emptyList или полна листа која не го содржи username-от на User-от.

7. User(username="Edvin",password="не битно",email="edvinlekovikj@studentsfinkiukimmk") и за allUsers = emptyList или полна листа која не го содржи username-от на User-от.

### Oбјаснување на напишаните unit tests

----Multiple Condition----

За multiple condition во нашиот код имаме 2 multiple conditions од кој едниот е 
(user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))

1. ( F && X && X ) -> во овој случај кога првиот израз од вкупно три ни е грешен тогаш тука завршува програмата и поради тоа за останатите два изразистои X поради тоа што е небитно каков израз ќе се добие понатаму секако целиот услов ќе биде не точен.Кодот кој го задоволува овој услов е assertFalse(siLab2.function(new User(null,null,null),null)); мораме да имаме иницијализација за класата поради причината што тој мора да отиде од јазол А0,A1 во B1 и од B1 се разгранува до јазолот К

2. (T && F && X) -> Кога првиот израз е точен , а вториот грешен тогаш третиот не е битен. Moжеме да го погледнеме дадениот аssert
assertFalse(siLab2.function(new User("Edvin",null,null),null)); Кај Userot првата аргумент е за username , вториот е за password и третиот е за мејл а аргументот после User е листа allUsers која не е битно што содржи или е null поради што до тој дел програмата нема да стигне и поради таа причина е означена со Х . Откако ќе види дека првиот израз е точен вториот е неточен и ќе скокне програмата до соодветното место односно ќе се разграни  B1-B2 и B2-K. 

3. (T && T && F) -> Првите два изрази се точни а третиот не е точен , поради тоа што !true ќе стане false и целиот израз ќе биде false
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@students.finki.ukim.mk"), Arrays.asList("Edvin","Sarko","Marko")));
Првиот аргумент за класата User ни е валиден , password-от не ни е биден и имаме валиден мејл додека во листата се појавува истото име како и во објектот од класата User поради тоа целиот израз ни е повторно false. Тука ќе ни се случи следниве разгранувања B1-B2 ; B2-B3 и B3-K

4. (T && T && T) -> Тука сите изрази ни се точни со што кодот ќе навлезе во овој if 
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
Како аргументи на објектот од класата User сите се валидни и праќаме празна листа која исто така е валидна. Овде разгранувањето ќе ни биде B1-B2 ; B2-B3 ; B3-C1


Другиот multiple condition ни е изразот atChar && dotChar
Во овој condition имаме 3 комбинации кој можат да се случат со овој израз

1. (F && X) првата комбинација е кога првиот израз atChar ја има вредноста false со тоа другиот израз нема потреба да го проверуваме будејки целиот услов ќе биде false и поради таа причина за вториот израз ставаме Х.
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
Гледаме дека во кодот мора сите аргументи мора да ни бидат соодветно иницијализирани за објектот User но е-маилот треба да биде без точка и без @  и треба дадената листа да биде или празна или да не го сочинува username-от што се наоѓа во објектот User.
Разгранувањето тука ќе ни биде I1-K

2. (T && F) во овој израз може да погледнеме дека првиот израз atChar ни е true но вториот израз dotChar ни е false поради таа причина целиот израз повторно ни е false.
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@gmailcom"),Collections.emptyList()));
Во овој израз како и во претходниот треба сите аргументи од класата User да ни бидат иницијализирани но за е-маилот треба да имаме @ но да немаме точка и исто како и за претходниот случај е правилото за листата дека треба да биде или празна или да биде наполнета но да не го сочинува името што се наоѓа во објектот User. Разгранувањата за овој тест случај ќе бидат I1-I2 и I2-K

3. (T && Т) во овој услов и двата израза ни се вистинити со што целиот услов е вистинит со тоа би можеле да навлеземе во дадениот if
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Sarko","Darko","Marko")));
Сите аргументи се валидно пратени во User објектот со тоа што во овој случај во е-маилот имаме и точка и @ а за листата важи истото правило. Разгранувањата тука ни се I1-I2 и I2-J

----Every Branch----

Тука ни се прикажани 7 тест случаи со кој се опфаќаат сите ребра . Во секој тест случај се опфаќаат нови ребра и со цел да ги одвојам од останатите ребра тие се болдирани.

1. assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
Со овој тест случај гледам што повеќе од дадените ребра да ги опфатам за што помалку да ни останат. 
Се иницијализира Објект User кој како што гледате сите аргументи се валидни немаме null и праќаме празна листа која може да биде и полна но да не го содржи името на корисникот кој се наоѓа во Објектот User
Со овој тест пример ги поминуваме ребрата: **A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-C0,C1 ; C0,C1-C2 ; C2-D ; C2-I1 ; D-E ; D-F ; E-F ; F-G ; F-H ; G-H ; H-C3 ; C3-C2 ; I1-I2 ; I2-J ; J-L**

2. assertFalse(siLab2.function(null,null));
Во овој тест случај на функцијата и праќаме параметар null за аргументот објект User а другиот аргумент allUsers не ни е битен бидејки нема да се искористи во овој тест случај. Тука ни е целта да се опфатат останати ребра кој не беа опфатени во претходниот тест случај. Ги изминуваме ребрата **A0,A1-K ; K-L** .

3. assertFalse(siLab2.function(new User(null,null,null),null));
Овој тест случај иницијализираме првата вредност null а останатите не ни се битни како ќе ги иницијализираме бидејки како и да ги иницијализираме програмата ќе го има истото разгранување кое е A0,A1-B1 ; **B1-K** ; K-L

4. assertFalse(siLab2.function(new User("Edvin","SuperSum123",null),null));
Во овој тест случај како аргументи за објектот User праќаме username , password не е битен и аргументот за мејлот да биде null и листата allUsers не е битно што ќе и дадеме како аргумент.
Се изминуваат ребрата A0,A1-B1 ; B1-B2 ; **B2-K** ; K-L

5. assertFalse(siLab2.function(new User("Edvin","SuperSUm123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Edvin","Darko","Sarko")));
Во овој тест случај програмата треба да се аргументите за User-от да бидат валидни а за allUsers да пратиме листа која ќе го сочинува името на корисникот.
Со овие аргументи сега фунцијата ни се разгранува A0,A1-B1 ; B1-B2 ; B2-B3 ; **B3-K** ; K-L

6. assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
Во овој тест случај ни е битен само аргументот за email на објектот User го ставаме да биде грешен со што немаме нитѕ @ ниту точка се со цел да ги опфатиме не разгранетите гранки.
Се опфаќаат гранките  A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-C0,C1 ; C0,C1-C2 ; C2-D ; C2-I1 ; D-F ; F-H ; H-C3 ; C3-C2 ; **I1-K** ; K-L

7. assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@studentsfinkiukimmk"),Arrays.asList("Darko","Sarko","Marko")));
Праќаме повторно грешен email како аргумент на објектот User но сега само со @ , a без точка.
Разгранувањата кој ќе се случат во овој тест случај се A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-C0,C1 ; C0,C1-C2 ; C2-D ; C2-I1 ; D-E ; D-F ; E-F ; F-H ; H-C3 ; C3-C2 ; I1-I2 ; **I2-K** ; K-L
