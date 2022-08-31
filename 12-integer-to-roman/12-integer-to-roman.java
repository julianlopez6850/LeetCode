class Solution {
    public String intToRoman(int num) {
        
        String roman = "";
        
        
        while(num >= 1000)
        {
            roman += "M";
            num -= 1000;
        }
        while(num >= 900)
        {
            roman += "CM";
            num -= 900;
        }
        while(num >= 500)
        {
            roman += "D";
            num -= 500;
        }
        while(num >= 400)
        {
            roman += "CD";
            num -= 400;
        }
        while(num >= 100)
        {
            roman += "C";
            num -= 100;
        }
        while(num >= 90)
        {
            roman += "XC";
            num -= 90;
        }
        while(num >= 50)
        {
            roman += "L";
            num -= 50;
        }
        while(num >= 40)
        {
            roman += "XL";
            num -= 40;
        }
        while(num >= 10)
        {
            roman += "X";
            num -= 10;
        }
        while(num >= 9)
        {
            roman += "IX";
            num -= 9;
        }
        while(num >= 5)
        {
            roman += "V";
            num -= 5;
        }
        while(num >= 4)
        {
            roman += "IV";
            num -= 4;
        }
        while(num >= 1)
        {
            roman += "I";
            num -= 1;
        }
        return roman;
    }
}