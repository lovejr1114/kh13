List와 명령문은 같으나 이름 형태와 저장되는 순서가 다르다.  
List는 선형 구조, Set은 비선형구조  
Set은 탐색을 위한 구조. (전체를 빠르게)  
구조적으로 중복이 불가능  
구조적으로 정해진 저장 순서를 따른다  
둘 다 빠르게 찾지만 정렬이 좀 필요하면 TreeSet, 정렬이 필요하지 않는다면 HashSet

#  
선형구조 (시작과 끝이 명확한 구조)   
- 정리를 안하는 구조  
- List  
	- ArrayList  
	- LinkedList (수정 삭제가 빠름)  
- 장점  
	- 만들기가 쉽다  
- 단점  
	- 탐색이 느리다(최소 1회, 최대 6회 탐색 필요)  


비선형구조 (시작 또는 끝이 명확하지 않은 구조)  
- Set  
- Map  
- TreeSet 탐색 최소 1회, 최대 3회 탐색 필요, 목록 출력이 필요한 경우  
- HashSet(HashTable) 탐색 최소 1회, 최대 2회 탐색 필요,여부 확인만 할 경우  
- 전체 관리  


#  
Map  
- K = key (식별값, 이름)  
- V = value (데이터, 값)  
- 회원가입할 때 아이디가 K역할, 비밀번호는 V역할  
- 개별 관리  
- Key를 가지고 Value는 알 수 있지만, Value로 Key를 알 수는 없다.  



#  
boolean 검사에서, 있을지 없을지 불확실하다면 무엇보다도 null을 먼저 검사해야한다.  

#  


<정리>  -많이 나올것이니 공부할것

데이터 1개   
- Collection  

데이터 2개  
- Map  

List<E> (순서)  
- add(E)  
- size()  
- contains(E)  
- remove(E)  
- get(I)  

Set<E> (전체 탐색)  
- add(E)  
- size()  
- contains(E)  
- remove(E)  

Map<K,V> (개별탐색)  
- put(K,V)  
- size()  
- containsKey(K)  
- containsValue(V)  
- remove(K)  
- get(K)  
