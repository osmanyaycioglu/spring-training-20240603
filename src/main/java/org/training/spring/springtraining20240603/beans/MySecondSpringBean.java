package org.training.spring.springtraining20240603.beans;import a.b.c.OutterBean;import jakarta.annotation.PostConstruct;import jakarta.annotation.PreDestroy;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.stereotype.Component;@Componentpublic class MySecondSpringBean {    // Field Injection    @Autowired    private MyFirstSpringBean myFirstSpringBean1;    private MyFirstSpringBean myFirstSpringBean2;    private MyFirstSpringBean myFirstSpringBean3;    @Autowired    // @Qualifier("greetingsTur")    @Qualifier("dynamicGreetings")    private IGreetings greetings;    @Autowired    @Qualifier("anotherDynamicGreetings")    private IGreetings greetings2;    @Autowired    private OutterBean outterBean;    // Constructor Injection    @Autowired    public MySecondSpringBean(final MyFirstSpringBean myFirstSpringBean3Param) {        myFirstSpringBean3 = myFirstSpringBean3Param;        System.out.println("early init");    }    public MySecondSpringBean() {    }    public void sayHello(String name){        myFirstSpringBean1.myMethod(name);        myFirstSpringBean2.myMethod(name);        myFirstSpringBean3.myMethod(name);        greetings.sayHello(name, "yay");        greetings2.sayHello(name, "yay");    }    // Method Injection    @Autowired    public void method(MyFirstSpringBean myFirstSpringBean){        myFirstSpringBean2 = myFirstSpringBean;    }    @PostConstruct    public void xyz(){        System.out.println("Init");    }    @PreDestroy    public void abc(){        System.out.println("Destroy");    }}