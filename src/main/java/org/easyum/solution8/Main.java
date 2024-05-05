package org.easyum.solution8;


import org.easyum.core.HibernateUtils;
import org.easyum.solution8.model.Avatar;
import org.easyum.solution8.model.Course;
import org.easyum.solution8.model.EMail;
import org.easyum.solution8.model.Student;


public class Main {
    public static void main(String[] args) {
        HibernateUtils.buildSessionFactory(Student.class, Avatar.class, EMail.class, Course.class);
    }
}
