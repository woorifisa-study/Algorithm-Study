# 알고리즘 스터디

<br>

### 매일 1문제씩 꾸준히!

<br>

### 📜 운영 규칙

- **주 6일(월~토)** 1일 1문제 풀이 필수
- 문제 풀이 후 **Commit** & **Pull Request** 로 제출 인증
- 매주 1회 오프라인 리뷰

<br>

### 📖 문제 리스트
[코딩테스트 대비 문제집 with Baekjoon](https://github.com/tony9402/baekjoon?tab=readme-ov-file)

<br>

**Week 01**

| 요일 | 문제 번호 | 문제 이름 | 난이도 (Tier) |
| --- | --- | --- | --- |
| 화 | [18258](https://www.acmicpc.net/problem/18258) | [큐 2](https://www.acmicpc.net/problem/18258) | **실버 4** |
| 화 | [10828](https://www.acmicpc.net/problem/10828) | [스택](https://www.acmicpc.net/problem/10828) | **실버 4** |
| 수 | [20154](https://www.acmicpc.net/problem/20154) | [이 구역의 승자는 누구야?!](https://www.acmicpc.net/problem/20154) | **브론즈 1** |
| 수 | [10866](https://www.acmicpc.net/problem/10866) | [덱](https://www.acmicpc.net/problem/10866) | **실버 4** |
| 목 | [9012](https://www.acmicpc.net/problem/9012) | [괄호](https://www.acmicpc.net/problem/9012) | **실버 4** |
| 금 | [1158](https://www.acmicpc.net/problem/1158) | [요세푸스 문제](https://www.acmicpc.net/problem/1158) | **실버 4** |
| 토 | [4659](https://www.acmicpc.net/problem/4659) | [비밀번호 발음하기](https://www.acmicpc.net/problem/4659) | **실버 5** |


<br>

### 📂 Repository 구조

스터디는 **`주차/이름/문제.언어`** 구조로 관리합니다.

매주 해당 주차 폴더 안에 **본인의 이름(ID)으로 된 폴더**를 생성해주세요.

```text
Algorithm-Study/
├── week01/
│   ├── noiskk/                <-- 본인 이름 폴더 생성
│   │   ├── boj_1000.py        <-- 문제 소스코드
│   │   └── boj_1001.py
│   └── member1/
│       ├── boj_1000.java
│       └── boj_1001.java
├── week02/
│   ├── noiskk/
│   └── ...
└── ...

```

<br>

### 💾 참여 방법 (Git Workflow)

1. 이 저장소를 `clone` 합니다.
2. 매주 본인의 브랜치를 생성합니다. (규칙: `이름/주차`)
* 예: `git checkout -b noiskk/week1`


3. 해당 주차 폴더(`weekXX`) 안에 **본인의 이름으로 폴더를 생성**합니다.
* 예: `week01/noiskk/`


4. 문제를 풀고 소스코드를 업로드합니다.
* **파일명 규칙**: `출처_문제번호.확장자` (소문자 권장)
* 예: `boj_1001.java`, `pgs_42888.py`


5. 커밋 후 원격 저장소로 `push` 합니다.
* **Commit Message**: `[Week1] 문제번호_문제이름`
* 예: `git commit -m "[Week1] BOJ_1000_A+B"`
* 예: `git push origin noiskk/week1`


6. Github에서 **Pull Request(PR)**를 생성합니다.
7. 스터디 모임 전 서로의 코드를 리뷰(Comment)하고 `Merge` 합니다.



<br>

### 🚀 커리큘럼 (Schedule)

| 주차 | 주제 (Topic) | 핵심 키워드 | 태그(#) |
| :--: | :--- | :--- | :--- |
| **1주** | **자료구조 1 & 문자열** | 배열, 연결 리스트, 문자열 처리 | #00, #16 |
| **2주** | **자료구조 2** | 스택, 큐, 덱 (Stack/Queue/Deque) | #01 |
| **3주** | **구현 & 시뮬레이션** | 배열 돌리기, 좌표 이동, 구현 | #08, #11 |
| **4주** | **구현 & 시뮬레이션** | 배열 돌리기, 좌표 이동, 구현 | #08, #11 |
| **5주** | **완전 탐색** | 재귀함수, 모든 경우의 수, N-Queen | #10 |
| **6주** | **백트래킹** | 재귀함수, 모든 경우의 수, N-Queen | #13 |
| **7주** | **수학** | 소수 판별, GCD/LCM | #03 |
| **8주** | **🧩 중간 점검 (Buffer)** | **밀린 문제 풀이 & 취약 유형 복습** | |
| **9주** | **그래프 탐색 (1)** | **BFS/DFS 기초**, 미로 탐색, 영역 구하기 | #09 |
| **10주** | **그래프 탐색 (2)** | **BFS/DFS 응용**, 벽 부수고 이동하기 등 | #09 |
| **11주** | **탐욕법 (Greedy)** | 동전 교환, 회의실 배정, 최적해 찾기 | #04 |
| **12주** | **이분 탐색 & 투 포인터** | 정렬된 배열 탐색, 두 용액, 수열 합 | #12, #07 |
| **13주** | **동적 계획법 (DP) 1** | 피보나치, 타일링, 1로 만들기 (기초 점화식) | #05 |
| **14주** | **동적 계획법 (DP) 2** | 배낭 문제(Knapsack), LCS (심화 응용) | #06 |
| **15주** | **🏆 실전 모의고사** | **실전처럼 시간 재고 풀기** | |


<br>

### Reference

* [백준 온라인 저지](https://www.acmicpc.net/)
* [Solved.ac](https://solved.ac/)
* [코딩테스트 공부 방법1](https://lover-orpheus.tistory.com/entry/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%AC%B4%EC%A1%B0%EA%B1%B4-%ED%95%A9%EA%B2%A9%EC%8B%9C%EC%BC%9C%EC%A3%BC%EB%8A%94-7%EB%8B%A8%EA%B3%84-%ED%95%99%EC%8A%B5%EB%B2%95)
* [코딩테스트 공부 방법2](https://lover-orpheus.tistory.com/entry/F%ED%95%99%EC%A0%90-%EB%B0%9B%EB%8D%98-%EB%82%B4%EA%B0%80-%EB%8C%80%EA%B8%B0%EC%97%85-%ED%95%A9%EA%B2%A9%ED%95%9C-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EA%B3%B5%EB%B6%80-%EB%B0%A9%EB%B2%95)
