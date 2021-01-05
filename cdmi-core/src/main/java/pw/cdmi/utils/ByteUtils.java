package pw.cdmi.utils;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ByteUtils {
    /**
     * 将时间日期转换为指定字节长度的16进制字符串
     * @param date      要转换的日期时间
     * @param length    最后日期时间转换后的字节长度，字节长度将会限制其表现精度
     * @param split     是否将时间日期按照年，月，日，时，分，秒分别计算其16进制字符串
     * @return 精确到秒
     */
    public static String toHexString(Date date, int length, boolean split)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long ts = date.getTime()/1000;//获取时间的时间戳,精度：秒
        return Long.toHexString(ts);//十六进制
    }

    //byte类型转换为16进制字符串

    /**
     * 将byte类型数值转换为指定长度的16进制字符串
     * @param b
     * @return
     */
    public static String toHexString(byte[] b) {
        int v;
        if (b.length == 1) {
            v = b[0] & 0xFF;
            return toHexString(v).toUpperCase();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                v = b[i] & 0xFF;
                sb.append(toHexString(v).toUpperCase() + " ");
            }
            return sb.toString();
        }

    }

    /**
     * 将长整数类型数值转换为16进制字符串
     * @param i
     * @return
     */
    public static String toHexString(long i) {
        String result = Long.toHexString(i);
        return result.length() % 2 == 1 ? "0".concat(result) : result;
    }

    /**
     * 将整数类型数值转换为16进制字符串
     * @param i
     * @return
     */
    public static String toHexString(int i) {
        String result = Integer.toHexString(i);
        return result.length() % 2 == 1 ? "0".concat(result) : result;
    }

    /**
     * 将16进制数转化为int类型
     * @param b
     * @return
     * @throws Exception
     */
    public static int hexToInt(byte[] b) throws Exception{
        if (b.length > 4) {
            throw new Exception("传入字节数超过int字节数");
        }
        int result = 0;
        for (int i = b.length - 1, j = 0; i >= 0; i--, j++) {
            result = result | ((b[j] & 0xff) << (8 * i));
        }
        return result;
    }


    //16进制数转化为float类型
    public static float hexToFloat(byte[] b) throws Exception {
        return (float) hexToInt(b);
    }

    //int类型转化为二进制
    public static byte[] toBytes(int num) {
        byte[] bytes = new byte[4];
        for (int i = 3, j = 0; i >= 0; i--, j++) {
            bytes[j] = (byte) ((num >> i * 8) & 0xff);
        }
        return bytes;
    }
    //short类型转化为二进制
    public static byte[] toBytes(short num) {
        byte[] bytes = new byte[2];
        for (int i = 2, j = 0; i >= 0; i--, j++) {
            bytes[j] = (byte) ((num >> i * 8) & 0xff);
        }
        return bytes;
    }

    //byte类型转化为二进制
    public static byte[] toBits(byte b) {
        byte[] bits = new byte[8];
        for (int i = 7; i >= 0; i--) {
            if (b % 2 == 0) {
                bits[i] = 0;
            } else {
                bits[i] = 1;
            }
            b = (byte) (b >> 1);
        }
        return bits;
    }

    //多段16进制字符串转化为16进制数
    public static byte[] stringToHexes(String hexStr) {
        char[] chars = hexStr.toCharArray();
        byte[] result = new byte[chars.length / 2];
        int num;
        for (int i = 0, j = 0; i < chars.length; i += 2, j++) {
            num = Integer.parseInt("" + chars[i] + chars[i + 1], 16);
            result[j] = (byte) num;
        }
        return result;
    }

    //单个16进制字符串转化为16进制数
    public static byte stringToHex(String hexStr) {
        int num = Integer.parseInt(hexStr, 16);
        return (byte) num;
    }

    public class ByteToBinary {
        /**
         * 把byte数组转化成2进制字符串
         * @param bArr
         * @return
         */
        public String getBinaryStrFromByteArr(byte[] bArr){
            String result ="";
            for(byte b:bArr ){
                result += getBinaryStrFromByte(b);
            }
            return result;
        }
        /**
         * 把byte转化成2进制字符串
         * @param b
         * @return
         */
        public String getBinaryStrFromByte(byte b){
            String result ="";
            byte a = b; ;
            for (int i = 0; i < 8; i++){
                byte c=a;
                a=(byte)(a>>1);//每移一位如同将10进制数除以2并去掉余数。
                a=(byte)(a<<1);
                if(a==c){
                    result="0"+result;
                }else{
                    result="1"+result;
                }
                a=(byte)(a>>1);
            }
            return result;
        }

        /**
         * 把byte转化成2进制字符串
         * @param b
         * @return
         */
        public String getBinaryStrFromByte2(byte b){
            String result ="";
            byte a = b; ;
            for (int i = 0; i < 8; i++){
                result = (a % 2) + result;
                a=(byte)(a>>1);
            }
            return result;
        }

        /**
         * 把byte转化成2进制字符串
         * @param b
         * @return
         */
        public String getBinaryStrFromByte3(byte b){
            String result ="";
            byte a = b; ;
            for (int i = 0; i < 8; i++){
                result = (a % 2) + result;
                a = (byte) (a/2);
            }
            return result;
        }
    }

}
