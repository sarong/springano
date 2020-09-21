package com.myspring.conditions;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"myspring.beans.Black","myspring.beans.Red"};
    }
}
