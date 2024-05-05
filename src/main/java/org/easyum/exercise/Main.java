package org.easyum.exercise;


import org.easyum.core.HibernateUtils;
import org.easyum.exercise.model.Avatar;
import org.easyum.exercise.model.Course;
import org.easyum.exercise.model.EMail;
import org.easyum.exercise.model.Student;

public class Main {
    public static void main(String[] args) {
        HibernateUtils.buildSessionFactory(Student.class, Avatar.class, EMail.class, Course.class);
    }
}
