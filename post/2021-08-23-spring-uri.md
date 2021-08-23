
## uri를 축소하는 방법

REST 방식의 URI는 `method + uri` 로 구성되어 있다.

post방식은 테이블 기반으로 살펴보았을 때, 일반적으로 뭔가를 등록하겠다는 의미가 강하다. 


- 기존의 URI
  - `/board/selectOne.do?no=5`


- Spring방식의 uri
  - `/board?no=5` OR `/board/5`
    - GET방식이면? 조회
    - POST방식이면? 수정
    - DELETE 방식이면? 삭제
