java.lang을 제외한 패키지는 모두 Import해줘야 사용가능하다.  

Date 생성자는 출력하면 날짜,시간정보가 나온다.(근데 거꾸로 나옴)  
- SimpleDateFormat 을 사용하여 원하는 정보 추출(시간형식 참고)  

요일 영어로 = Day of week  


Calendar는 Date클래스에 비해 계산식이 가능하다  
추상클래스이다.(abstract) 그래서 직접 객체 생성이 불가능.  
캘린더의 장점은 계산이 가능한것.  

Date는 보여주기 위한 형식  
Calendar는 형식에 계산을 포커스를 맞춤  


# 여태까지 배운 날짜 관련된 클래스 / 메소드  

1.System.currentTimeMillis()  
- 시간 측정을 위해서 사용  
- 1970년 1월 1일 0시 0분 0초부터의 밀리초  
- 시차 외에 정확한 시간을 알기가 어려움  

2.java.util.Date  
- 시간을 원하는 형식으로 보여주고 싶을 때 사용  
- SimpleDateFormat과 결합하여 사용  
- 1900년을 기준으로 만들어져서 시간 설정 / 확인에 문제가 있음(Y2K, 밀레니엄버그 해결 X)  

3.java.util.Calendar  
- 시간을 직접 변경하거나 계산하여 원하는 값을 만들 때 사용(d-day계산 등..)  
- Date와 호환이 가능  
- 월을 설정 할 때에 0~11로 설정해야함. (Date도 마찬가지)  
- 가변 객체이다 (가변은 한 명하고 일을 할 때 제대로 일 함)  

4.java.time 패키지  
- 기존의 문제점들을 개선하여 별도의 패키지로 제공되는 시간 도구  
- 현존하는 자바의 시간 도구 중 가장 최신  
- LocalDate, LocalTime, LocalDateTime  


### next, nextInt, nextDouble 등.. 다음에 nextLine이 온다면 sc.nextLine();으로 남아있는 \n을 제거해준 뒤 nextLine을 사용할 수 있게 한다.  

