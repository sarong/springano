package myspring.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCon implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment str = context.getEnvironment();

        System.out.println(str);
        if (str.containsProperty("ment"))
            return true;
        return false;
    }
}
