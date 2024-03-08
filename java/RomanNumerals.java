public class RomanNumerals {

    private static class SymbolValue {
        String symbol;
        int value;

        public SymbolValue(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
        
    }

    private static final SymbolValue[] ROMAN_SYMBOL_VALUES = {
            new SymbolValue("M", 1000),
            new SymbolValue("CM", 900),
            new SymbolValue("D", 500),
            new SymbolValue("CD", 400),
            new SymbolValue("C", 100),
            new SymbolValue("XC", 90),
            new SymbolValue("L", 50),
            new SymbolValue("XL", 40),
            new SymbolValue("X", 10),
            new SymbolValue("IX", 9),
            new SymbolValue("V", 5),
            new SymbolValue("IV", 4),
            new SymbolValue("I", 1)
    };

    public static String toRoman(int arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();
        for (SymbolValue symbolValue : ROMAN_SYMBOL_VALUES) {
            while (arabicNumber >= symbolValue.value) {
                romanNumeral.append(symbolValue.symbol);
                arabicNumber -= symbolValue.value;
            }

        }
        return romanNumeral.toString();
    }

    public static int fromRoman(String romanNumeral) {
        int arabicNumber = 0;
        int index = 0;
        for (SymbolValue symbolValue : ROMAN_SYMBOL_VALUES) {
            while (romanNumeral.startsWith(symbolValue.symbol, index)) {
                arabicNumber += symbolValue.value;
                index += symbolValue.symbol.length();
            }

        }
        return arabicNumber;
    }

}
