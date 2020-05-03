package com.gitlab.wesleyosantos91.backend.apifirst.model;

import com.gitlab.wesleyosantos91.backend.apifirst.utils.GetterAndSetterTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by wesleyosantos91 on 2019-06-22.
 */
public class ModelTest {

    Set<Class<? extends Serializable>> allClasses;
    GetterAndSetterTester tester;

    @BeforeEach
    public void setUp() {
        tester = new GetterAndSetterTester();
        Reflections reflections = new Reflections("io.github.wesleyosantos.apifirst.model");
        allClasses = reflections.getSubTypesOf(Serializable.class);
    }

    @Test
    @DisplayName("Deve Testar todas as entidades")
    public void testarTodasEntidades() {
        for (Class<? extends Object> clazz : allClasses)
            tester.testClass(clazz);
    }
}
