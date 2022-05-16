package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
public class BorrowAspect {

    @Pointcut("execution(* com.example.controller.BookController.showBorrowBook(..))")
    public void allMethodPointCutConfirmBorrow() {}

    @AfterReturning("allMethodPointCutConfirmBorrow()")
    public void confirmBorrow(JoinPoint joinPoint) {
        System.err.println("After method name (Confirm borrow): "
                + joinPoint.getSignature().getName()
                + ". Time: "
                + LocalDate.now());
    }

    @Pointcut("execution(* com.example.controller.BookController.saveBB(..))")
    public void allMethodPointCutBorrow() {}

    @AfterReturning("allMethodPointCutBorrow()")
    public void afterBorrow(JoinPoint joinPoint) {
        System.err.println("After method name (Borrow): "
                + joinPoint.getSignature().getName()
                + ". Time: "
                + LocalDate.now());
    }

    @Pointcut("execution(* com.example.controller.BorrowBookController.giveBackBook(..))")
    public void allMethodPointCutGiveBack() {}

    @AfterReturning("allMethodPointCutGiveBack()")
    public void afterGiveBack(JoinPoint joinPoint) {
        System.err.println("After method name (Give back book): "
                            + joinPoint.getSignature().getName()
                            + ". Time: " + LocalDate.now());
    }

    @Pointcut("execution(* com.example.controller.BookController.goListBook(..))")
    public void totalPeopleSeeList() {}

    private int number = 0;

    @AfterReturning("totalPeopleSeeList()")
    public void totalPeople(JoinPoint joinPoint) {
        number++;
        System.err.println(number + " People see list: "
                + joinPoint.getSignature().getName()
                + ". Time: " + LocalDateTime.now());
    }
}
