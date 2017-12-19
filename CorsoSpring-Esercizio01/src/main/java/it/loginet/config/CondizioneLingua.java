package it.loginet.config;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class CondizioneLingua implements Condition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> ann = metadata.getAllAnnotationAttributes(Bean.class.getName());
		
		String name = ((String[])((List)ann.get("name")).get(0))[0];
		
		return name.endsWith(Locale.getDefault().getLanguage());
		
		
//		if ("it".equals(l.getLanguage()))
//			
//		else if ("fr".equals(l.getLanguage()))
//			ctx.getBean(Saluta.class);
//		else if ("en".equals(l.getLanguage()))
//			ctx.getBean(Saluta.class);
//		else if ("es".equals(l.getLanguage()))
//			ctx.getBean(Saluta.class);	
	}

}
