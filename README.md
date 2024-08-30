# 1. API 설계

## 1.1 일정
| Function       | Method | URI                                | Request                                                                                        | Response                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
|----------------|--------|------------------------------------|------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 저장          | POST   | /api/todos                         | {"user": "user name", "userIds": [1, 2], "title": "example title", "content": "example content"} | {"id": 1, "userIds": [1, 2], "title": "title", "content": "content", "commentCnt": 0, "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473"}                                                                                                                                                                                                                                                                                             |
| 일정 조회(단건)      | GET    | /api/todos/{todoId}                | (없음)                                                                                           | {"id": 1,"userResponseDtos":[{"id": 1,"name": "user name","email": "user@example.com","created": "2024-08-28T18:14:35.167887","modified": "2024-08-28T18:14:35.167887"},{"id":2,"name": "user name","email": "user1@example.com","created": "2024-08-28T18:14:44.323349","modified": "2024-08-28T18:14:44.323349"}],"title":"example title","content":"example content","commentCnt":1,"created":"2024-08-28T18:18:06.45397","modified":"2024-08-28T18:30:58.41751"} |
| 일정 수정          | PATCH  | /api/todos/{todoId}                | {"user": "user name", "userIds": [1,2], "title": "example title", "content": "example content"}                  | {"id": 1, "userIds": [1, 2], "title": "title", "content": "content", "commentCnt": 0, "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473"}                                                                                                                                                                                                                                                                                             |
| 일정 조회(다건, 페이징) | GET    | /api/todos?page={page}&size={size} | (없음)                                                                                           | [{"id": 1, "userResponseDtos": null, "title": "example title", "content": "example content", "commentCnt": 1, "created": "2024-08-28T18:18:06.45397", "modified": "2024-08-28T18:30:58.41751"}]                                                                                                                                                                                                                                                                      |
| 일정 삭제          | DELETE | /api/todos/{todoId}                | (없음) | (없음)                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |

## 1.2 댓글
| Function | Method | URI                       | Request                                                                       | Response                                                                                                                                                 |
|----------|--------|---------------------------|-------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 댓글 저장    | POST   | /api/comments/{todoId}    | {"user": "user name", "content": "example content"}                           | {"id": 1, "user": "user", "content": "content", "created": "2024-08-28T07:55:33.950068","modified": "2024-08-28T07:55:33.950068"}                        |
| 댓글 조회    | GET    | /api/comments/{commentId} | (없음)                                                                          | {"id": 1, "user": "user", "content": "content", "created": "2024-08-28T08:33:37.106856", "modified": "2024-08-28T08:33:37.106856"}                       |
| 댓글 목록 조회 | GET    | /api/comments             | (없음)                                                                          | [{"id": 1, "user": "user", "content": "content", "created": "2024-08-28T08:33:37.106856", "modified": "2024-08-28T08:33:37.106856"}]                     |
| 댓글 수정    | PATCH  | /api/comments/{commentId} | {"user": "user name", "title": "example title", "content": "example content"} | { "id": 1, "user": "string", "title": "string", "content": "string", "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473" } |
| 댓글 삭제    | DELETE | /api/comments/{commentId} | (없음)                                                                          | (없음)                                                                                                                                                     |

## 1.3 유저
| Function        | Method | URI               | Request                                      | Response                                                                                                                   |
|-----------------|--------|-------------------|----------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| 유저 저장       | POST   | /api/users        | {"name": "user name", "email": "user@example.com"} | {"id": 1, "name": "user name", "email": "user@example.com", "created": "2024-08-28T07:55:33.950068", "modified": "2024-08-28T07:55:33.950068"} |
| 유저 조회       | GET    | /api/users/{userId} | (없음)                                       | {"id": 1, "name": "user name", "email": "user@example.com", "created": "2024-08-28T08:33:37.106856", "modified": "2024-08-28T08:33:37.106856"} |
| 유저 목록 조회  | GET    | /api/users        | (없음)                                       | [{"id": 1, "name": "user name", "email": "user@example.com", "created": "2024-08-28T08:33:37.106856", "modified": "2024-08-28T08:33:37.106856"}] |
| 유저 수정       | PATCH  | /api/users/{userId} | {"name": "updated name", "email": "updated@example.com"} | {"id": 1, "name": "updated name", "email": "updated@example.com", "created": "2024-08-28T07:55:33.950068", "modified": "2024-08-28T07:55:33.950068"} |
| 유저 삭제       | DELETE | /api/users/{userId} | (없음)                                       | (없음)                                                                                                                     |
| 회원 가입 | POST | api/users/signup | {"name": "updated name", "email": "updated@example.com", "password": "password"} | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTtmITsp4QiLCJhdXRoIjoi7IKs7Jqp7J6QIOq2jO2VnCIsImV4cCI6MTcyNDg2NzcxNCwiaWF0IjoxNzI0ODY0MTE0fQ.vCc3dEOTAEE_SI4-kn1NO7b83IIl60On3V6ZfEE9tV0 |

<br><br>
# 2. ERD 작성


## 2.1 연관 관계
![image](https://github.com/user-attachments/assets/fc622a30-0699-4a8a-ad30-8ad0b8cfd0da)


## 2.2 ERD
<img width="587" alt="image" src="https://github.com/user-attachments/assets/54419f25-f7c6-4368-b6fc-9b080fdb393c">

