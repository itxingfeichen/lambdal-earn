package com.github.lambda.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author chenxingfei
 * 用户基础模型类，用于辅助测试
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {



    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户邮箱
     */
    private String email;


}
