## eclipse 설정

![image](https://user-images.githubusercontent.com/77392444/127248565-26de41bf-1866-4325-a674-dccf9bdad747.png)




## maven 다운로드

https://maven.apache.org/download.cgi

![image](https://user-images.githubusercontent.com/77392444/127248640-ca2d7b9b-3e47-4311-ac24-87629a53e8c3.png)


## 환경변수 설정


### 시스템변수

![image](https://user-images.githubusercontent.com/77392444/127250302-488b4317-81e5-4cb1-989f-a973fcd50f85.png)



### PATH
![image](https://user-images.githubusercontent.com/77392444/127250223-b9bf5911-b352-452d-bf17-bc80121e87c6.png)


### 확인 방법

![image](https://user-images.githubusercontent.com/77392444/127250414-40a54cb2-844f-4922-a94f-c8214c74dea2.png)




## maven repository 설정

- 원래는 사용자 폴더에 `.m2` 폴더 하위로 생성되지만, 버전 관리를 위한 maven-reposirtory 폴더를 원하는 경로로 설정한다. 

![image](https://user-images.githubusercontent.com/77392444/127251999-9ce69ae6-bab2-4812-8d4c-3eac9da8b0ce.png)

![image](https://user-images.githubusercontent.com/77392444/127252049-48ac114a-01bf-4e96-a524-e31a3eef2138.png)


## maven 프로젝트 생성

![image](https://user-images.githubusercontent.com/77392444/127252166-b9fd983a-be31-4f2c-9aa3-7027e57fadd8.png)


- 콘솔모드에서 개발할때는 jar, 웹 개발할때는 war

![image](https://user-images.githubusercontent.com/77392444/127252345-b31035e8-497f-402b-af50-089764677893.png)


- finish 버튼 누르면, 설정한 maven-repository 파일에 설정 파일들이 다운로드된다. 

![image](https://user-images.githubusercontent.com/77392444/127252445-6e02eede-1fc0-485f-bd10-6bc1b832297d.png)

- 만약 이클립스에서 에러가 발생하면, 이 maven-repository 폴더를 삭제 후 다시 설정하는 것이 좋다. 


## pom.xml

프로젝트에 대한 설정 파일이다. 

필요한 라이브러리는 dependencies를 통해 받아오면 된다. 

- 다운로드 받는 사이트 : https://mvnrepository.com/

![image](https://user-images.githubusercontent.com/77392444/127253882-d8de1956-264a-49cb-a201-dfc6d0953ddd.png)


- `<dependencies>` 태그 사이에 복사한 내용을 붙여넣는다. 

![image](https://user-images.githubusercontent.com/77392444/127253763-8fae2146-3a65-498c-8594-5009a1647e41.png)

- 다운로드 내역 확인 : maven-repository 폴더

![image](https://user-images.githubusercontent.com/77392444/127254045-e67fc535-01cc-4629-a1e1-8c677fba6a15.png)
