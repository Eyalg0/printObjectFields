package print.object;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	private static final List<Class<? extends Object>> LEAVES = Arrays.asList(
	        Boolean.class, Character.class, Byte.class, Short.class,
	        Integer.class, Long.class, Float.class, Double.class, Void.class,
	        String.class);
	
	private static final List<Object> objectsPrinted = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Address address = new Address("Tel aviv", 12345);
		Person eyal = new Person("Israel I", 38, address);
		
		Address address2 = new Address("haifa", 4324);
		Person eyal2 = new Person("Haim x", 50, address2);
		eyal.setSibling(eyal2);
		eyal2.setSibling(eyal);
		System.out.println(printObj(eyal, new StringBuilder("")));

	}
	
	
	
	public static String printObj(Object classz, StringBuilder space) throws Exception {
		if (objectsPrinted.contains(classz)) {
			return space.append("already printed").toString();
		}
		objectsPrinted.add(classz);
		if (classz == null) {
	        return space.append("null").toString();
		}

	    if (LEAVES.contains(classz.getClass())) {
	    	String result = classz.toString();
	    	if	(classz.getClass() == String.class) {
	    		result =  "\"" + result + "\"";
	    	}
	        return result;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append(space).append("object of class \"").append(classz.getClass().getSimpleName()).append("\"");
	    sb.append(System.getProperty("line.separator"));
	    sb.append(space).append("----------------------------");
	    sb.append(System.getProperty("line.separator"));
	    space.append("	"); 
		Field[] declaredFields = classz.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			sb.append(space).append(field.getName()).append(": ");
			if (!field.getType().isPrimitive() && !LEAVES.contains(field.getType())) {
				sb.append(System.getProperty("line.separator"));
			}
			sb.append(printObj(field.get(classz), new StringBuilder(space))).append(" ");
	        sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
