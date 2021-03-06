

Spring AOP 특징

```
1. Runtime 기반
2. Proxy 기반
3. 인터페이스 기반
```

## Spring AOP  Introduction

규모가 있는 사이트를 구축하고 싶을 때 변화에 민감하지 않도록 만들어 유지보수에 유리하도록 하는 것이다. 

중복되는 코드가 많을 때, 다른 모든 코드를 변경해줘야 하는 번거로움이 있다. 


### 기존 OOP 방식의 한계

- 중복되는 코드 발생 : 복사, 붙이기
- 지저분한 코드  :핵심 기능 이외의 공통기능의 코드, 가독성이 안 좋아짐
- 생산성의 저하
- 재활용의 어려움
- 변화의 어려움



### AOP의 목적

- 관심의 분리 : 공통 관심사항과 핵심 관심사항의 분리
  - 공통 관심사항 : 전체 시스템에서 사용되는 기능

  - 핵심 관심사항 : 일반 업무 프로세스

- 핵심 관심사항은 기존의 OOP 기술로 쉽게 분리가 가능하나 공통 관심사항은 기존의 OOP 기술로 분리가 쉽지 않다. 

- 프로그램 전반에 사용되는 공통 모듈 적용의 효율성을 높여준다.

- 각 소스에 들어있던 공통 모듈을 설정을 통하여 적용한다. 

- 공통 기능의 변경사항이 있을 경우 사용하는 쪽은 변경할 필요가 없도록 만들기 위함이다. 


### AOP 기술

1. 컴파일 시점에 코드에 공통 기능 추가하는 방법
2. 클래스 로딩 시점에 바이트 코드에 공통  기능 추가하는 방법
3. 실행 시에 프록시 객체를 생성해서 공통 기능 추가하는 방법 => 스프링은 프록시 기반


### AOP 용어


|이름|설명|
|---|----|
|Joinpoint      |기능이 삽일되어 동작할 위치                   |
|포인트컷        |어떤 핵심 코드를 실행할려고 할지?             |
|Advice         |어느 시점에 삽입시킬지? (코드 전, 중간, 후 등) |
|Aspect         | 주입시킬 공통 기능(포인트컷 + 어드바이스)     |

공통의 코드 안에 포인트컷과 어드바이스를 설정해야 한다. 

포인트컷과 어드바이스를 Aspect라고 한다. 전체적인 환경 설정 파일들이다. 

조인 포인트 : 삽입되면서 필요한 정보들이 조인 포인트에 들어가는 것이다. (매개변수 등)


### Advice 용어



|Before         | 메서드 호출 전
|After Returning| 
|After Throwing |
|After          |
|Around         |

## AspectJ Pointcut
어던 핵심코드가 실행될때 공통코드가 삽입될지/
![image](https://user-images.githubusercontent.com/77392444/127590547-6db8bfbd-6583-4096-b698-7f2e6c77acba.png)
![image](https://user-images.githubusercontent.com/77392444/127590641-ff7815e0-9fe8-4656-926d-3545e273d493.png)



## Schema Based AOP

| <aop:config>    |
| <aop:aspect>    |
| <aop:pointcut>  |
|




## Annotation Based AOP



