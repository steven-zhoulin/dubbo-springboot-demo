package com.topsail.crm.order.framework.harley.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @program: crm
 * @description: spel动态表达式工具
 * @author: jinnian
 * @create: 2020-02-09 00:28
 **/
public class SPELExecutor {

    private SpelParserConfiguration configuration;

    private ExpressionParser parser;

    private EvaluationContext ctx;

    /**
     * 初始化，进行编译模式设置
     */
    public SPELExecutor() {
        this.configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,SpelParserConfiguration.class.getClassLoader());
        this.parser = new SpelExpressionParser(configuration);
        this.ctx = new StandardEvaluationContext();
    }

    /**
     * 解析上下文变量
     * @param objects
     */
    public void parse(Object... objects) {
        if (objects == null || objects.length <= 0) {
            return;
        }

        for (Object object : objects) {
            String simpleName = object.getClass().getSimpleName();
            String variableName = StringUtils.firstCharToLower(simpleName);
            ctx.setVariable(variableName, object);
        }
    }

    /**
     * 执行逻辑表达式
     * @param boolExpression
     * @return
     */
    public boolean executeBool(String boolExpression) {
        boolean isMatch = (Boolean)parser.parseExpression(boolExpression).getValue(this.ctx);
        return isMatch;
    }

    /**
     * 执行逻辑表达式
     * @param boolExpression
     * @param objects
     * @return
     */
    public boolean executeBool(String boolExpression, Object... objects) {
        this.parse(objects);
        return this.executeBool(boolExpression);
    }
}
