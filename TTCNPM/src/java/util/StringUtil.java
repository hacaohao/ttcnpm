package util;

public class StringUtil {
    public static String createCode(String prefix, int index, int length){
        int indexLength = String.valueOf(index).length();
        int prefixLength = prefix.length();
        String code = prefix;
        
        for(int i = 0; i < length - indexLength - prefixLength; i++ ){
            code += "0";
        }
        code += String.valueOf(index);
        
        return code;
    }
    
    public static String newPassword(){
        return EncodeUtil.md5Formatter("123456");
    }
    
}
