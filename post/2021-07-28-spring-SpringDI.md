Spring IoC


IoC (Inversion of Control) : 제어역행

- 기존 : 개발자가 new를 통해 필요할때마다 필요한 객체를 만들어서 메소드를 호출해서 개발을 하다가 어떤 메소드가 필요하면 또 그 클래스를 이용해서 일을 수행했다. 
- 기존 : 객체가 만들어지는 시점을 개발자가 결정했다. Block Scope에 따라 인스턴스 생명주기가 결정된다. 

- IoC : 객체가 만들어지는 시점을 개발자에게 주는 것이 아니다. 스프링이 A라는 객체를 미리 만든다. 
- IoC : 인스턴스의 생명주기 관리를 개발자가 아닌 컨테이너가 처리한다. 


방식 2 가지
1. setter 방식
2. 



Container

Spring Container
- 스프링 프레임워크에서 Container 기능을 제공해주는 클래스를 의미
- Container : Bean 클래스를 관리(생성, 삭제 등) 하는 주체
- xml안에 `<bean>`이라는 태그가 있으면 Container에 bean이 올라간다는 뜻?

Container의 종류
1. BeanFactory
2. ApplicationContext
- 환경 설정의 xml을 읽어와서 컨테이너에 

![image](https://user-images.githubusercontent.com/77392444/127269052-86f14aa5-509b-4d8e-923a-af941697bce3.png)

- 


Dependency

Annotation
