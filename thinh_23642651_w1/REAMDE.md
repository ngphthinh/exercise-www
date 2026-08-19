### Bài tập WWW Tuần 1

## Hiện thực các bài tập 4 5 6 7 8 ở tuần 1

## Các thư viện sử dụng
| Thư viện                       |            Version |
| ------------------------------ | -----------------: |
| `jakarta.servlet-api`          |              6.1.0 |
| `junit-jupiter-api`            | `${junit.version}` |
| `jakarta.servlet.jsp.jstl-api` |              3.0.2 |
| `jakarta.servlet.jsp.jstl`     |              3.0.1 |
| `junit-jupiter-engine`         | `${junit.version}` |
| `mariadb-java-client`          |              3.4.1 |
| `angus-mail`                   |              2.0.3 |

---
## Yêu cầu

- JDK 21+
- Tomcat 11+
- MariaDB 10.5+
- Maven 3.9+

## Cách chạy

1. Tạo file .env và thêm vào các biến môi trường sau:

```
MAIL_PASSWORD=xxxx xxxx xxxx xxxx
MAIL_EMAIL=youremail@gmail.com
```

- MAIL_PASSWORD tạo tại: https://myaccount.google.com/
- Set biến môi trường trong config ở intellij hoặc của máy
- Đặt file .env tại thư mục root của tuần 1

2. Run tomcat

- username: admin
- password: 123

---

- **Upload file to database** cần tạo database
- Run
``
src/**/resources/script.sql 
``
để tạo database và bảng

- Username, password, tên database thay đổi tại ``src/**/config/DatabaseUtil.java``



