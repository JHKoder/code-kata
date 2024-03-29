# 한글 시계
![Java_11](https://img.shields.io/badge/java-11-green)

## 콘솔 요구사항

---
- 1초마다 출력을 한다.
- 현재 시간은 [ ] 으로 나타 낸다.
- [한글 시계 ](https://hangulclock.today/#/main) 사이트 기반 으로 제작 한다.


## 웹 요구사항

---
- 여러 국가 시간을 가져올수 있어야한다.
- Json 타입으로 반환 한다

###출력 예시

```text
(11:23 출력 예시) 

한  두  세   네  다  섯
여  섯  일   곱  여  덟
아  홉 [열] [한] 두 [시]
자 [이] 삼   사  오 [십]
정 [일] 이  [삼] 사  육
오  오  칠   팔  구 [분]

```
      
## 프로그래밍 요구사항

---
1. 한 메서드에 오직 한 단계의 들여쓰기만 한다.
2. else 예약어(keyword)는 쓰지 않는다.
3. 모든 원시값과 문자열을 포장한다.
4. 일급(first-class) 콜렉션을 쓴다. 
5. 한 줄에 점을 하나만 찍는다.
6. 줄여쓰지 않는다(축약 금지).
7. 모든 엔티티(entity)를 작게 유지한다. 
8. 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
9. 세터(setter)를 쓰지 않는다.
10. 메소드 내용 7중 이내 


## 한글 시계

---
한글 시계 패턴 파악 

![screensh](https://raw.githubusercontent.com/oiNeh/code-kata/main/korean-clock/korean_clock.png)
