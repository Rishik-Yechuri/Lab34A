class CountAndSay {
    public static void main(String[] args) {
        try {
            CountAndSay obj = new CountAndSay();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) {
        int numToSay = 5;
        System.out.println(countAndSay(numToSay));
    }

    public String countAndSay(int n) {
        String finalString = "";
        for (int x = 1; x <= n; x++) {
            if (x == 1) {
                finalString = "1";
            } else {
                finalString = convertIntToString(finalString);
            }
        }
        return finalString;
    }

    public String convertIntToString(String n) {
        int currentLength = 0;
        int previousInt = -1;
        String stringToReturn = "";
        char[] holdValues = n.toCharArray();
        int lengthOfArray = holdValues.length;
        for (int x = 0; x <= lengthOfArray; x++) {
            if (x == lengthOfArray) {
                stringToReturn += currentLength + "" + previousInt;
            } else {
                int currentInt = Character.getNumericValue(holdValues[x]);
                if (previousInt == -1) {
                    previousInt = currentInt;
                    currentLength++;
                } else if (currentInt == previousInt) {
                    currentLength++;
                } else {
                    stringToReturn += currentLength + "" + previousInt;
                    currentLength = 1;
                    previousInt = currentInt;
                }
            }
        }
        return stringToReturn;
    }
}