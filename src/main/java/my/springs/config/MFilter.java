package my.springs.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类的信息
        ClassMetadata classmetadata = metadataReader.getClassMetadata();
        //获取当前类路径
        Resource resource = metadataReader.getResource();

        System.out.println("处理" + classmetadata + "==>" + annotationMetadata + "==>" + resource);
        return true;
    }
}
