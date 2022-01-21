package com.mytool.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author duankd
 * @ClassName TestModel
 * @date 2021-01-13 9:53:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TestModelOver extends TestModel {
    private String context1;

    @Override
    public String toString() {
        return "TestModelOver{" +
                super.toString()+
                "context1='" + context1 + '\'' +
                '}';
    }
}
