package com.kv.genericenum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class GenericEnum<K extends Enum<K>, V> {

	private static final String METHOD_WITH_GET = "get";
	private static final String TO_STRING = "toString";
	private Map<K, V> enumMapGeneric;
	private Class<?> type;
	private V value;


	public GenericEnum() {
	}

	@SuppressWarnings("unchecked")
	public GenericEnum(Class<K> type, V value) throws Exception {
		this.type = type;
		this.value = value;

		enumMapGeneric = new EnumMap<K, V>(type);
		type = (Class<K>) Class.forName(type.getName());
		if (type.isEnum()) {
			addValues();
		} else {
			throw new Exception("Class isn't an Enum.");
		}
	}


	@SuppressWarnings({ "unchecked" })
	private void addValues() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final Method[] methods = type.getDeclaredMethods();
		Method getMethod = null;

		// Select the first getMethod from the Enum
		for (Method method : methods) {
			if (method.getName().contains(METHOD_WITH_GET) || method.getName().contains(TO_STRING)) {
				getMethod = method;
				break;
			}
		}

		final Object[] enumConstant = type.getEnumConstants();
		String value = null;
		if (enumConstant != null) {
			if (getMethod != null) {
				for (int i = 0; i < enumConstant.length; i++) {
					value = (String) getMethod.invoke(enumConstant[i]);
					enumMapGeneric.put((K) enumConstant[i], (V) value);
				}
				value = null;
				getMethod = null;
			} else {
				for (int i = 0; i < enumConstant.length; i++) {
					value = enumConstant[i].toString();
					enumMapGeneric.put((K) enumConstant[i], (V) value);
				}
				value = null;
			}
		}
	}


	@SuppressWarnings({ "hiding", "unchecked" })
	public <K extends Enum<K>> K getKeyByValue() {
		K keyToReturn = null;
		final Set<K> keys = ((Set<K>) enumMapGeneric.keySet());
		for (K key : keys) {
			if (value.equals(enumMapGeneric.get(key)) || 
				value.toString().equalsIgnoreCase(enumMapGeneric.get(key).toString())){
				keyToReturn = key;
				break;
			}
		}
		return keyToReturn;
	}
}
