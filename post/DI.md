## 1. 생성자 주입

## 2. setter 주입

## 3. 자동 주입

```
1) 변수 설정할 때 (*기존과의 차이점*) 
2) 생성자 설정할 때
3) set 메소드 설정할 때 사용할 수 있다. 
```

- 장점 : 
  - xml코드가 길어지는 것을 방지할 수 있다.
  - 스프링컨테이너가 주입하려는 객체를 자동으로 선택해서 넣어줄 수 있다. 
  - 

### 3-1. XML파일에 <context:annotaion-config/> 설정을 추가하기

- beans 태그가 먼저 올 수도 있고, context 태그가 먼저 올 수도 있다.

### 3-2. Java 파일에 의존주입대상에 어노테이션 설정

#### 스프링에서 만든 어노테이션
- @Autowired

```
1) 변수 설정할 때 (*기존과의 차이점*) 
2) 생성자 설정할 때
3) set 메소드 설정할 때 사용할 수 있다. 
```

- type 매칭 먼저 -> name 매칭

#### 순수 자바에서 구성된 어노테이션 (스프링이 아닌 프레임워크를 사용할때도 사용 가능함)


- @Resource 

<del>생성자 설정할 때 사용 불가!!!!</del>

https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api/1.3.2 

- name 매칭 먼저 -> type 매칭

- @Inject

https://mvnrepository.com/artifact/javax.inject/javax.inject 

- type 매칭 먼저 -> name 매칭


### Autowired할 객체가 2개일때?

에러가 발생한다. 







component-scan을 활용하면, xml에 등록했던 bean태그도 줄일 수 있다. 
  - @Controller, @Component, @Service, @Repository




@Component가 bean태그를 대신한다. 이때 bean태그에서의 id는 별도의 설정값이 없으면 해당 클래스의 앞글자만 소문자로 바꾼 것이 id로 등록된다. 

@Controller, @Component, @Service, @Repository 이 네 개 중에 하나의 어노테이션만 붙어도 스프링이 자동으로 객체를 만들어준다. 

네 개의 용도가 같은데 이름이 다 다른 이유는? 스프링은 대규모 사이트를 구축할때 사용이 된다. 이때 클래스를 구분하기 위해 다양한 어노테이션을 만들어둔 것이다. 






환경설정을 왜 xml에서 해야할까? 모두 자바에서 설정할 순 없을까?
