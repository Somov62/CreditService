package com.SberTech.CreditService.Audit.Aspect;

import com.SberTech.CreditService.Audit.Services.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private AuditService service;


    @Pointcut("@annotation(Auditable) && execution(public * save(..))")
    public void savePointCut() {}

    @Pointcut("@annotation(Auditable) && execution(public * delete(..))")
    public void deletePointCut() {}

    @AfterReturning(pointcut = "savePointCut()", returning = "result")
    public void saveAdvice(JoinPoint jp, Object result) {
        service.auditSave(result);
    }

    @AfterReturning(pointcut = "deletePointCut()")
    public void deleteAdvice(JoinPoint jp) {
        service.auditDelete(jp.getArgs()[0]);
    }
}
