package validator.csvcleaner.service;


public class NumberStringSanitizer {

    public String removeThousandsSeparators(String value) {
        if (value == null) return null;
        return value.replace(".", "").replace(",", "");
    }
}
