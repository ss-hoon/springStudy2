package com.study.project.springstudy2.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RenameNotPermittedExcpetion extends RuntimeException{
    private static final String MESSAGE = "이름 변경을 허용하지 않습니다.";

    public RenameNotPermittedExcpetion(){
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
