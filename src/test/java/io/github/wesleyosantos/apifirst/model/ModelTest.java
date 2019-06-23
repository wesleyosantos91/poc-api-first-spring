package io.github.wesleyosantos.apifirst.model;

import io.github.wesleyosantos.apifirst.utils.GetterAndSetterTester;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by wesleyosantos91 on 2019-06-22.
 */
public class ModelTest {

    Set<Class<? extends Serializable>> allClasses;
    GetterAndSetterTester tester;

    @Before
    public void setUp() {
        tester = new GetterAndSetterTester();
        Reflections reflections = new Reflections("io.github.wesleyosantos.apifirst.model");
        allClasses = reflections.getSubTypesOf(Serializable.class);
    }

    @Test
    public void testarTodasEntidades() {
        for (Class<? extends Object> clazz : allClasses)
            tester.testClass(clazz);
    }
}
