package com.dc.design.test.prototype;

import lombok.Data;

/**
 * @author DCZhang
 * @title Resume
 * @date 2023/8/1 13:34
 * @description 简历
 */
@Data
public class Resume implements Cloneable{

    private String name;

    private String age;

    private Experience experience;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume clone = (Resume)super.clone();
        // 注意这里的深拷贝,如果不深拷贝,那么修改clone的experience,原对象的experience也会被修改
        clone.setExperience((Experience)experience.clone());
        return clone;
    }
}
