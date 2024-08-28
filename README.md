# 1. API 설계
<hr>

## 1.1 일정
| Function  | Method | URI                | Request                                      | Response                                                                                                                |
|-----------|--------|--------------------|----------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| 일정 저장     | POST   | /api/todo          | {"user": "string", "title": "string", "content": "string"} | { "id": 1, "user": "string", "title": "string", "content": "string", "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473" } |
| 일정 조회     | GET    | /api/todo/{todoId} | (없음)                                       | { "id": 1, "user": "string", "title": "string", "content": "string", "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473" } |
| 일정 수정     | PATCH  | /api/todo/{todoId} | {"user": "string", "title": "string", "content": "string"} | { "id": 1, "user": "string", "title": "string", "content": "string", "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473" } |
| 일정 페이징 조회 | PATCH  | /api/todo/{todoId} | {"user": "string", "title": "string", "content": "string"} | { "id": 1, "user": "string", "title": "string", "content": "string", "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473" } |


## 1.2 댓글
| Function | Method | URI                      | Request                                                   | Response                                                                                                                                                 |
|----------|--------|--------------------------|-----------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 댓글 저장    | POST   | /api/comment/{todoId}    | {"user": "user", "content": "content"}                    | {"id": 1, "user": "user", "content": "content", "created": "2024-08-28T07:55:33.950068","modified": "2024-08-28T07:55:33.950068"}                        |
| 댓글 조회    | GET    | /api/comment/{commentId} | (없음)                                                      | {"id": 1, "user": "user", "content": "content", "created": "2024-08-28T08:33:37.106856", "modified": "2024-08-28T08:33:37.106856"}                       |
| 댓글 목록 조회 | GET    | /api/comments | (없음) | [{"id": 1, "user": "user", "content": "content", "created": "2024-08-28T08:33:37.106856", "modified": "2024-08-28T08:33:37.106856"}]                     |
| 댓글 수정    | PATCH  | /api/comment/{commentId} | {"user": "string", "title": "string", "content": "string"} | { "id": 1, "user": "string", "title": "string", "content": "string", "created": "2024-08-28T06:35:03.580473", "modified": "2024-08-28T06:35:03.580473" } |
| 댓글 삭제    | DELETE | /api/comment/{commentId} | (없음) | (없음)                                                                                                                                                     |