package myPackage;

import java.util.ArrayList;

public class number2String {

    public String main(Long adad) {

        if (adad.toString().length() > 12 || adad < 0) {
            return adad.toString();
        }
        if (adad == 0) {
            return "صفر";
        }
        String[] Yekan = {"يک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه"};
        String[] Dah = {
            "ده",
            "يازده",
            "دوازده",
            "سيزده",
            "چهارده",
            "پانزده",
            "شانزده",
            "هفده",
            "هجده",
            "نوزده"};
        String[] Dahgan = {"بيست", "سي", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};
        String[] Sadgan
                = {"يکصد",
                    "دويست",
                    "سيصد",
                    "چهارصد",
                    "پانصد",
                    "ششصد",
                    "هفتصد",
                    "هشتصد",
                    "نهصد"
                };
        String[] UnitArray = {" هيچ ", " هزار ", " ميليون ", " ميليارد "};
        String And = " و ";
        if (adad < 10) {
            return Yekan[adad.intValue() - 1];
        }
        if (adad.toString().length() == 2) {
            String num1 = (adad.toString().subSequence(0, 1)).toString();
            String num2 = (adad.toString().subSequence(1, 2)).toString();
            if ("1".equals(num1)) {
                return Dah[Integer.parseInt(num2)];
            }
            if ("0".equals(num2)) {
              return Dahgan[Integer.parseInt(num1) - 2];

            } else {
                return Dahgan[Integer.parseInt(num1) - 2] + And + Yekan[Integer.parseInt(num2) - 1];
            }
        }
        if (adad.toString().length() > 2 && adad.toString().length() < 13) {
            int piv = (adad.toString().length()) / 3;
            if (!(Integer.toString(piv) + ".0").equals(Float.toString((adad.toString().length()) / 3f))) {
                piv++;
            }
            String part;
            int besh = 0;
            String num, mum1, mum2, mum3, Digit1, Digit2;
            ArrayList<String> text = new ArrayList<>();
            int Index;
            for (int i = 1; i <= piv; i++) {
                if (i == piv) {
                    Index = (adad.toString().length()) - ((i - 1) * 3);
                    part = (adad.toString().subSequence(0, Index)).toString();
                } else {
                    Index = ((Integer.toString(adad.intValue()).length()) - (i * 3)) + 1;
                    part = (Integer.toString(adad.intValue()).subSequence(Index - 1, Integer.toString(adad.intValue()).length() - besh)).toString();
                    besh += 3;
                }
                for (int x = 1; x <= 3; x++) {
                    num = part.substring(0, 1);
                    if (num.equals("0")) {
                        part = part.substring(1, part.length());
                    } else {
                        break;
                    }
                }
                if (part.length() == 0) {
                    text.add(" ");
                }
                if (part.length() == 3) {
                    mum1 = part.subSequence(0, 1).toString();
                    mum2 = part.subSequence(1, 2).toString();
                    mum3 = part.subSequence(2, 3).toString();
                    Digit1 = Sadgan[Integer.parseInt(mum1) - 1];
                    if (mum2.equals("1")) {
                        Digit2 = Dah[Integer.parseInt(mum3)];
                    } else {
                        if (mum2.equals("0")) {
                            if (mum3.equals("0")) {
//                                Digit2 = Dahgan[Integer.parseInt(mum2) - 2];
                          Digit2="";
                            } else {
                                Digit2 =  (Yekan[Integer.parseInt(mum3) - 1]);
//                                Digit2 = (Dahgan[Integer.parseInt(mum2) - 2]) + And + (Yekan[Integer.parseInt(mum3) - 1]);
                            }

                        } else {
                            if (mum3.equals("0")) {
                                Digit2 = Dahgan[Integer.parseInt(mum2) - 2];
                            } else {
                                Digit2 = (Dahgan[Integer.parseInt(mum2) - 2]) + And + (Yekan[Integer.parseInt(mum3) - 1]);
                            }

//                            if ("0".equals(mum3)) {
//                                Digit2 = "";
//                            } else {
//                                Digit2 = Yekan[Integer.parseInt(mum3) - 1];
//                            }
                        }
                    }
                    if ("".equals(Digit2)) {
                        text.add(Digit1);
                    } else {
                        text.add(Digit1 + And + Digit2);
                    }
                }
                if (part.length() == 2) {
                    mum1 = part.subSequence(0, 1).toString();
                    mum2 = part.subSequence(1, 2).toString();
                    if ("1".equals(mum1)) {
                        text.add(Dah[Integer.parseInt(mum2)]);
                    } else {
                        if ("0".equals(mum2)) {
                            text.add(Dahgan[Integer.parseInt(mum1) - 2]);
                        } else {
                            text.add((Dahgan[Integer.parseInt(mum1) - 2]) + And + (Yekan[Integer.parseInt(mum2) - 1]));
                        }
                    }
                }
                if (part.length() == 1) {
                    mum1 = part.subSequence(0, 1).toString();
                    text.add(Yekan[Integer.parseInt(mum1) - 1]);
                }
            }
            String result = "";
            String unit;
            for (int i = piv; i > 0;) {
                unit = UnitArray[--i];
                if (!"".equals(text.get(i)) && !" ".equals(text.get(i))) {
                    if (i == piv - 1) {
                        result += text.get(i) + unit;
                    } else {
                        result += And + text.get(i) + unit;
                    }
                }
            }
            return result.replace("هيچ", "");
        } else {
            return adad.toString();
        }
    }
}
