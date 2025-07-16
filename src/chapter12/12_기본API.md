## 12. 기본 API

### 1. 패키지(Package)
- 클래스의 성격이나 역할이 유사한 클래스들을 관리하기 쉽게 모아놓은 디렉토리 구조
- 패키지는 생성하는 클래스의 상단에 package 키워드를 사용하요 정의함
- 다른 패키지의 클래스를 호출하여 사용하는 경우 import 명령어를 사용함

예) import [상위패키지].[하위패키지].클래스; <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;import [상위패키지].[하위패키지].*; 

### 2. 자바 패키지
1) java.lang : 자주 사용하는 클래스들의 그룹으로 import를 하지 않아도 사용 가능<br>
2) java.awt / javax.swing : 자바의 GUI 환경을 구성하는 패키지 <br>
3) java.io : 자바의 JVM에서 데이터 입출력을 위해 생성한 클래스 패키지 <br>
4) java.util : 컬렉션(ArrayList, HashMap ... ) 클래스들과 기타 유용한 클래스 패키지 <br>
5) java.sql : 데이터베이스 접근 및 SQL을 실행하여 CRUD를 <br>
6) java.texg : 문자열 처리를 담당하는 패키지

### 3. java.lang 패키지
- wrapper 클래스 : 기본(Primitive) 데이터 타입에 대한 클래스를 내부적으로 정의한다.
- byte : Byte
- short : Short
- int : Integer
- long : Long
- float : Float
- double : Double
- boolean : Boolean
- char : Character
- String 클래서 : 문자열을 나타내는 클래스로 기본데이터, 참조데이터 타입으로 모두 사용됨<br>

``` java
String name = "홍길동"; // 기본형
String name2 = new String("홍길동");
```

### 4. java.util 패키지
1) ArrayList 클래스 : <br>
&nbsp;&nbsp;&nbsp;&nbsp;배열의 단점을 보완하여 객체형태로 사용이 편리한 클래스이며, 크기 조정도 가능<br>

2) Array(배열) 단점 
- 크기가 고정되므로, 크기를 조정하기 위해서는 새로 생성해야 함
- 동일한 데이터타입만 저장이 가능<br>

3) ArrayList 장점
- 크기 조정이 가능하며, 인덱스 관리를 자동으로 해줌
- 다양한 데이터들을 저장 가능함, 하지만 실 사용시에는 제너릭<E>을 이용하여 타입을 고정시킴
예) ArrayList<String> : 문자열만 저장가능 , ArrayList : 모든 데이터 저장가능<br>

4) HashMap 클래스
- 크기에 상관없이 이름, 값을 쌍으로 저장하는 클래스
- <key, value> 값이 별도로 저장되며, put(key, value), get(key).. 등의 메소드가 정의된다.<br>

5) HashSet 클래스
- 다양한 데이터를 사이즈 제한없이 사용 가능
- Iterator 인터페이스를 활용하여 다양하게 사용<br>

6) Date 클래스 : 날짜와 시간정보를 저장하는 클래스<br>

7) Calendar 클래스 : 날짜와 시간정보를 추출하는 클래스<br>

8) Random 클래스 : 다양한 데이터 타입으로 난수를 발생시키는 클래스<br>

9) UUID 클래스 : 64바이트 기준으로 유니크한 문자와 숫자를 혼합한 난수를 발생시키는 클래스<br>
























	