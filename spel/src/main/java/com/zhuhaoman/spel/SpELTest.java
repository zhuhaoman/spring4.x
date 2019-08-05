package com.zhuhaoman.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @ClassName SpELTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 17:35
 **/
public class SpELTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
//        Expression expression = parser.parseExpression("'hello'+'world'");
//        String message = (String) expression.getValue();
//        System.out.println(message);
        //T操作符可以从类路径加载指定类名称的Class对象
        Class clazz = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(clazz == java.lang.String.class);
        //T(全限定类名).静态方法
        Object object = parser.parseExpression("T(java.lang.Math).random()").getValue();
        System.out.println(object);
//        Address address = new Address();
//        List<Address> addresses = new ArrayList<>();
//        address.setPhone("1888888888");
//        address.setAddress("1111");
//        addresses.add(address);
//        user.setAddresses(addresses);
//
//        String userName = (String) parser.parseExpression("userName").getValue(context);
//        //通过xx.yy.zz获取嵌套属性值
//        String phone = (String) parser.parseExpression("addresses?.address").getValue(context);
//        System.out.println(userName);
//        System.out.println(phone);
        User user = new User();
        user.setUserName("kkkkk");
        user.setCredits(100000000);

        //user为根对象
        //变量：可使用”#变量名“来引用
        EvaluationContext context = new StandardEvaluationContext(user);
        context.setVariable("newUserName","zhuhaoman");

        parser.parseExpression("userName=#newUserName").getValue(context);
        System.out.println(user.getUserName());
    }
}
