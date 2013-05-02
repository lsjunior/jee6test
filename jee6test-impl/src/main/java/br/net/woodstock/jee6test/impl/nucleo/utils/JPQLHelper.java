package br.net.woodstock.jee6test.impl.nucleo.utils;

public abstract class JPQLHelper {

	private JPQLHelper() {
		//
	}

	public static String getLikeValue(final String value, final boolean nullIfEmpty) {
		if ((value == null) || (value.trim().isEmpty())) {
			if (nullIfEmpty) {
				return null;
			}
			return "%";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("%");
		builder.append(value);
		builder.append("%");
		return builder.toString();
	}

	public static String getEqualsValue(final String value, final boolean nullIfEmpty) {
		if ((value == null) || (value.trim().isEmpty())) {
			if (nullIfEmpty) {
				return null;
			}
			return "";
		}
		return value;
	}

	public static <T> T getValue(final T value, final T defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

}
