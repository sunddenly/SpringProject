package org.hebut.scse.design.create.protype.clone.deep;

import java.util.Date;

/**
 * Created by jxy on 2016/8/30.
 */
public class Person implements Cloneable{
    private int age;//自动前拷贝
    private Date birth = new Date();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person=(Person)super.clone();
        person.birth=(Date)this.getBirth().clone();//深拷贝

        return person;
    }
}
