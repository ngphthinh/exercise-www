package iuh.fit.se.de01.util;

import iuh.fit.se.de01.model.Course;
import iuh.fit.se.de01.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Repository {

    public List<User> getUsers() {
        return List.of(
                User.builder().role("ADMIN").username("admin").password("admin").build(),
                User.builder().role("USER").username("user").password("user").build()
        );
    }


    private final static List<Course> courses;


    public List<Course> getCourses() {
        return courses;
    }

    static {
        courses = new ArrayList<>(List.of(
                Course.builder()
                        .id(1)
                        .courseName("WWW")
                        .instructor("Nguyễn Thanh Tâm")
                        .instructorEmail("nguyenthanhtam@gmmail.com")
                        .category("Lập trình")
                        .level("Cơ bản")
                        .price(2000000)
                        .duration(48)
                        .startDate("2026-09-09")
                        .featured(false)
                        .build(),
                Course.builder()
                        .id(2)
                        .courseName("English")
                        .instructor("Trần Hồng Vân")
                        .instructorEmail("tranhongvan@gmmail.com")
                        .category("Ngoại ngữ")
                        .level("Cơ bản")
                        .price(2400000)
                        .duration(38)
                        .startDate("2026-09-09")
                        .featured(true)
                        .build(),
                Course.builder()
                        .id(3)
                        .courseName("Spring boot")
                        .instructor("Hồ Duy Nam")
                        .instructorEmail("donamho@gmmail.com")
                        .category("Lập trình")
                        .level("Nâng cao")
                        .price(3000000)
                        .duration(58)
                        .startDate("2026-09-01")
                        .featured(true)
                        .build(),
                Course.builder()
                        .id(4)
                        .courseName("Tư duy thiết kế")
                        .instructor("Hồ Đại Hán")
                        .instructorEmail("hanthong@gmmail.com")
                        .category("Thiết kế")
                        .level("Cơ bản")
                        .price(2000000)
                        .duration(48)
                        .startDate("2026-09-09")
                        .featured(false)
                        .build(),
                Course.builder()
                        .id(5)
                        .courseName("Toán đại cương")
                        .instructor("Lý Thế Dân")
                        .instructorEmail("dandaicca@gmmail.com")
                        .category("Toán")
                        .level("Cơ bản")
                        .price(1000000)
                        .duration(28)
                        .startDate("2026-09-09")
                        .featured(false)
                        .build()

        ));
    }

}
