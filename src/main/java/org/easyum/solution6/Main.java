package org.easyum.solution6;


import org.easyum.core.HibernateUtils;
import org.easyum.solution6.model.Avatar;
import org.easyum.solution6.model.Course;
import org.easyum.solution6.model.EMail;
import org.easyum.solution6.model.Student;


public class Main {
    public static void main(String[] args) {
        HibernateUtils.buildSessionFactory(Student.class, Avatar.class, EMail.class, Course.class);
    }
}
