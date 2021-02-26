package com.test.myDemo.util;

/**
 * @author liang.gu
 * @date 2021/1/21
 */
public class StringUtilTest {

    public static void main(String[] args) {
//        System.out.println(StringUtilTest.replaceSpecialChar("Hayam wuruk tower lt.19 jl.hayam wuruk no.108 Taman sari Rt04/09 Jakbar\t"," "));

        String a = "1234567890123456789012345678901234567890";
        System.out.println(StringUtilTest.getPartAddress(a,0,39));
        System.out.println(StringUtilTest.getPartAddress(a,39,78));
        System.out.println(StringUtilTest.getPartAddress(a,78,117));

//        System.out.println(StringUtilTest.replaceSpecialChar(StringUtilTest.getFirstName("fir##st a%%%st"),""));
//        System.out.println(StringUtilTest.replaceSpecialChar(StringUtilTest.getMiddleName("fir##st a%%%st"),""));
//        System.out.println(StringUtilTest.replaceSpecialChar(StringUtilTest.getLastName("fir##st a%%%st"),""));
//        System.out.println(StringUtilTest.getWorkPhone("+6221548768"));
//        String phone  = "+6221548768".replace("+62", "0");
//        System.out.println(phone.substring(0, 4));
//        System.out.println(phone.substring(4, phone.length()));
    }


    /**
     * 按照指定 截取字符串
     * @param address
     * @param start
     * @param end
     * @return
     */
    private static String getPartAddress(String address,int start,int end) {

        int length = address.length() ;
        if (length < start) {
            return "";
        }else if(end < length){
            return address.substring(start,end);
        }else if(start <= length && length <= end){
            return address.substring(start,length);
        }
        return "";
    }

    private static String getWorkPhone(String workPhone) {
        if (workPhone.startsWith("+62")) {
            String newPhone = workPhone.replace("+62", "0");
            newPhone = newPhone.substring(3, newPhone.length());
            if (newPhone.length() >= 5 && newPhone.length() <= 9) {
                return newPhone;
            }
        }
        return "548768";
    }

    private static String replaceSpecialChar(String str,String repStr){
        return str.replaceAll("[^a-zA-Z0-9]",repStr);
    }

    private static String getMiddleName(String fullName) {
        if (fullName != null && fullName.contains(" ")) {
            int firstIndex = fullName.indexOf(" ");
            int lastIndex = fullName.lastIndexOf(" ");
            if (firstIndex == lastIndex) {
                return fullName.substring(firstIndex, fullName.length());
            } else {
                return fullName.substring(firstIndex, lastIndex);
            }
        }
        return fullName;
    }

    /**
     * 识别姓名第一个空格前的字符；若无空格，显示全部
     * @param fullName
     * @return
     */
    private static String getFirstName(String fullName) {
        if (fullName != null && fullName.contains(" ")) {
            return fullName.substring(0, fullName.indexOf(" "));
        }
        return fullName;
    }

    /**
     * 识别最后一个空格后的字符；若无空格，显示全部。
     * @param fullName
     * @return
     */
    private static String getLastName(String fullName) {
        if (fullName != null && fullName.contains(" ")) {
            return fullName.substring(fullName.lastIndexOf(" "), fullName.length());
        }
        return fullName;
    }

}
