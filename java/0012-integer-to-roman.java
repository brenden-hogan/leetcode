class Solution 
{

    public String intToRoman(int num) {
        String roman = "";
        int curNum = num;
        while(curNum >= 1) {
            if (curNum >= 1000) {
                roman += "M";
                curNum -= 1000;
            } else if (curNum >= 900){
                roman += "CM";
                curNum -= 900;
            } else if (curNum >= 500){
                roman += "D";
                curNum -= 500;
            } else if (curNum >= 400){
                roman += "CD";
                curNum -= 400;
            } else if (curNum >= 100){
                roman += "C";
                curNum -= 100;
            } else if (curNum >= 90){
                roman += "XC";
                curNum -= 90;
            } else if (curNum >= 50){
                roman += "L";
                curNum -= 50;
            } else if (curNum >= 40){
                roman += "XL";
                curNum -= 40;
            } else if (curNum >= 10){
                roman += "X";
                curNum -= 10;
            } else if (curNum >= 9){
                roman += "IX";
                curNum -= 9;
            } else if (curNum >= 5){
                roman += "V";
                curNum -= 5;
            } else if (curNum >= 4){
                roman += "IV";
                curNum -= 4;
            } else if (curNum >= 1){
                roman += "I";
                curNum -= 1;
            }
        }
        return roman;
    }
}