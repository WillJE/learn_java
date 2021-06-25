package com.will.annotation;

@TestAnnotation(test = "AnnotationUse")
public class AnnotationUse {

    @TestAnnotation(test = "annotationUse", number = 566)
    public void annotationUse(){
        System.out.println("oneself define annotation use..");
    }
}
