package com.open.featurechecklib.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.open.featurechecklib.annotation.FeatureCheck;
import com.open.featurechecklib.exception.FeatureAccessException;
import com.open.featurechecklib.model.FeatureUsage;
import com.open.featurechecklib.model.FeatureUsageProvider;
import com.open.featurechecklib.model.PlanProvider;
import com.open.featurechecklib.service.FeatureAccessService;

@Aspect
@Component
public class FeatureCheckAspect {

    @Autowired
    private FeatureAccessService featureAccessService;
    
    @Pointcut("@annotation(com.open.featurechecklib.annotation.FeatureCheck)")
    public void featureProcessingMethods() {}
    
    @Around("featureProcessingMethods()")
    public Object checkFeatureAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        FeatureCheck featureCheck = method.getAnnotation(FeatureCheck.class);

        String featureName = featureCheck.featureName();
        String constraintKey = featureCheck.constraintKey();

        Object[] args = joinPoint.getArgs();
        
        FeatureUsage featureUsage = getFeatureUsage(args);
        if (featureUsage == null || !featureName.equals(featureUsage.getFeatureName())) {
            throw new FeatureAccessException("Feature " + featureName + " is not properly specified.");
        }
        
        String planName = getPlan(args);;
        
        int usage = featureUsage.getUsage();
        int maxAllowed = (int) featureAccessService.getFeatureConstraint(planName, featureName, constraintKey);
        
        if (usage > maxAllowed) {        	
            throw new FeatureAccessException("Usage of feature " + featureName + " exceeds the allowed limit for plan " + planName);
        }

        return joinPoint.proceed();
    }

	private FeatureUsage getFeatureUsage(Object[] args) {
		FeatureUsage featureUsage = null;
		for (Object arg : args) {
            if (arg instanceof FeatureUsageProvider) {
                featureUsage = ((FeatureUsageProvider) arg).getFeatureUsage();
                break;
            }
        }
		        
		return featureUsage;
	}

	private String getPlan(Object[] args) {
		String plan = null;
		for (Object arg : args) {
            if (arg instanceof PlanProvider) {
            	plan = ((PlanProvider) arg).getPlan();
            }
        }
		
        if (plan == null) {
            throw new FeatureAccessException("Plan is not properly specified.");
        }
        
		return plan;
	}
}

