package com.zhuhaoman.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CollectionTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 18:38
 **/
public class CollectionTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();

        Map<String,String> map = new HashMap<>();
        map.put("aa","AA");
        map.put("bb","BB");
        map.put("cc","CC");
        map.put("dd","DD");
        map.put("ee","EE");

        context.setVariable("map",map);

        Map<String,String> result = (Map<String, String>) parser.parseExpression("#map.?[value>BB]").getValue(context);
        System.out.println(result);
    }
}
