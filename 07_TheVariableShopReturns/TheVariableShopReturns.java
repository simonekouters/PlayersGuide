public class TheVariableShopReturns {
    public static void main(String[] args) {
        byte myByteNumber = 127;
        myByteNumber = 126;
        System.out.println(myByteNumber);

        short myShortNumber = -10000;
        myShortNumber = -9999;
        System.out.println(myShortNumber);

        int myIntNumber = -2345678;
        myIntNumber = -234567;
        System.out.println(myIntNumber);

        long myLongNumber = 12345678l;
        myLongNumber = 23456789l;
        System.out.println(myLongNumber);

        float myFloatNumber = 1.1234567f;
        myFloatNumber = 1.2345678f;
        System.out.println(myFloatNumber);

        double myDoubleNumber = 1.123456789;
        myDoubleNumber = 1.987654321;
        System.out.println(myDoubleNumber);

        char myLetter = 'S';
        myLetter = 'K';
        System.out.println(myLetter);

        boolean myBoolean = false;
        myBoolean = true;
        System.out.println(myBoolean);

        String myText = "Simone";
        myText = "Kouters";
        System.out.println(myText);
    }
}
