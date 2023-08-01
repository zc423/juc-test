package com.dc.design.test.prototype;

/**
 * @author DCZhang
 * @title PrototypeTest
 * @date 2023/8/1 13:34
 * @description 原型模式本质上是深拷贝
 * 在代码运行过程中复制一个对象,并且可以对其进行修改,而不影响原对象
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume = new Resume();
        resume.setName("小明");
        resume.setAge("18");
        Experience experience = new Experience();
        experience.setCompany("腾讯");
        experience.setDuration("2020-2023");
        resume.setExperience(experience);

        Resume clone = (Resume)resume.clone();
        clone.setName("小红");
        clone.getExperience().setCompany("阿里巴巴");

        System.out.println(resume.getName());
        System.out.println(resume.getExperience().getCompany());
    }
}
