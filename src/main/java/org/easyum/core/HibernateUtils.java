/**
 * Утилитарный класс для работы с Hibernate SessionFactory.
 */
package org.easyum.core;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

/**
 * Утилитарный класс для создания Hibernate SessionFactory.
 */
public final class HibernateUtils {

    /**
     * Имя файла конфигурации Hibernate по умолчанию.
     */
    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    /**
     * Приватный конструктор, чтобы предотвратить создание экземпляров этого класса.
     */
    private HibernateUtils() {
    }

    /**
     * Создает SessionFactory на основе переданной конфигурации и аннотированных классов.
     *
     * @param configuration    Конфигурация Hibernate.
     * @param annotatedClasses Аннотированные классы сущностей.
     * @return SessionFactory для работы с Hibernate.
     */
    public static SessionFactory buildSessionFactory(Configuration configuration, Class<?>... annotatedClasses) {
        MetadataSources metadataSources = new MetadataSources(createServiceRegistry(configuration));
        Arrays.stream(annotatedClasses).forEach(metadataSources::addAnnotatedClass);

        Metadata metadata = metadataSources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    /**
     * Создает SessionFactory на основе файла конфигурации и аннотированных классов.
     *
     * @param configResourceName Имя файла конфигурации Hibernate.
     * @param annotatedClasses   Аннотированные классы сущностей.
     * @return SessionFactory для работы с Hibernate.
     */
    public static SessionFactory buildSessionFactory(String configResourceName, Class<?>... annotatedClasses) {
        Configuration configuration = new Configuration().configure(configResourceName);
        return buildSessionFactory(configuration, annotatedClasses);
    }

    /**
     * Создает SessionFactory на основе файла конфигурации по умолчанию и аннотированных классов.
     *
     * @param annotatedClasses Аннотированные классы сущностей.
     * @return SessionFactory для работы с Hibernate.
     */
    public static SessionFactory buildSessionFactory(Class<?>... annotatedClasses) {
        Configuration configuration = new Configuration().configure(HIBERNATE_CFG_FILE);
        return buildSessionFactory(configuration, annotatedClasses);
    }

    /**
     * Создает реестр сервисов на основе переданной конфигурации.
     *
     * @param configuration Конфигурация Hibernate.
     * @return Реестр сервисов для Hibernate.
     */
    private static StandardServiceRegistry createServiceRegistry(Configuration configuration) {
        return new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
    }
}